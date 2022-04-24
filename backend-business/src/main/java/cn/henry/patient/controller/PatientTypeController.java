package cn.henry.patient.controller;

import cn.henry.common.annotation.Log;
import cn.henry.common.constant.UserConstants;
import cn.henry.common.core.controller.BaseController;
import cn.henry.common.core.domain.AjaxResult;
import cn.henry.common.enums.BusinessType;
import cn.henry.common.utils.StringUtils;
import cn.henry.patient.domain.PatientType;
import cn.henry.patient.service.PatientTypeService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 患者类型信息
 *
 * @author henry
 */
@RestController
@RequestMapping("/patient/type")
public class PatientTypeController extends BaseController {
    @Resource
    private PatientTypeService typeService;

    /**
     * 获取患者类型列表
     */
    @PreAuthorize("@ss.hasPermi('patient:type:list')")
    @GetMapping("/list")
    public AjaxResult list(PatientType type) {
        List<PatientType> types = typeService.selectTypeList(type);
        return AjaxResult.success(types);
    }

    /**
     * 查询患者类型列表（排除节点）
     */
    @PreAuthorize("@ss.hasPermi('patient:type:list')")
    @GetMapping("/list/exclude/{typeId}")
    public AjaxResult excludeChild(@PathVariable(value = "typeId", required = false) Long typeId) {
        List<PatientType> types = typeService.selectTypeList(new PatientType());
        types.removeIf(d -> d.getTypeId().intValue() == typeId
                || ArrayUtils.contains(StringUtils.split(d.getAncestors(), ","), typeId + ""));
        return AjaxResult.success(types);
    }

    /**
     * 根据患者类型编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('patient:type:query')")
    @GetMapping(value = "/{typeId}")
    public AjaxResult getInfo(@PathVariable Long typeId) {
        typeService.checkTypeDataScope(typeId);
        return AjaxResult.success(typeService.selectTypeById(typeId));
    }

    /**
     * 获取患者类型下拉树列表
     */
    @GetMapping("/treeselect")
    public AjaxResult treeselect(PatientType type) {
        List<PatientType> types = typeService.selectTypeList(type);
        return AjaxResult.success(typeService.buildTypeTreeSelect(types));
    }

    /**
     * 加载对应角色患者类型列表树
     */
    @GetMapping(value = "/roleTypeTreeselect/{roleId}")
    public AjaxResult roleTypeTreeselect(@PathVariable("roleId") Long roleId) {
        List<PatientType> types = typeService.selectTypeList(new PatientType());
        AjaxResult ajax = AjaxResult.success();
        ajax.put("checkedKeys", typeService.selectTypeListByRoleId(roleId));
        ajax.put("types", typeService.buildTypeTreeSelect(types));
        return ajax;
    }

    /**
     * 新增患者类型
     */
    @PreAuthorize("@ss.hasPermi('patient:type:add')")
    @Log(title = "患者类型管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody PatientType type) {
        if (UserConstants.NOT_UNIQUE.equals(typeService.checkTypeNameUnique(type))) {
            return AjaxResult.error("新增患者类型'" + type.getTypeName() + "'失败，患者类型名称已存在");
        }
        type.setCreateBy(getUsername());
        return toAjax(typeService.insertType(type));
    }

    /**
     * 修改患者类型
     */
    @PreAuthorize("@ss.hasPermi('patient:type:edit')")
    @Log(title = "患者类型管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody PatientType type) {
        if (UserConstants.NOT_UNIQUE.equals(typeService.checkTypeNameUnique(type))) {
            return AjaxResult.error("修改患者类型'" + type.getTypeName() + "'失败，患者类型名称已存在");
        } else if (type.getParentId().equals(type.getTypeId())) {
            return AjaxResult.error("修改患者类型'" + type.getTypeName() + "'失败，上级患者类型不能是自己");
        } else if (StringUtils.equals(UserConstants.DEPT_DISABLE, type.getStatus())
                && typeService.selectNormalChildrenTypeById(type.getTypeId()) > 0) {
            return AjaxResult.error("该患者类型包含未停用的子患者类型！");
        }
        type.setUpdateBy(getUsername());
        return toAjax(typeService.updateType(type));
    }

    /**
     * 删除患者类型
     */
    @PreAuthorize("@ss.hasPermi('patient:type:remove')")
    @Log(title = "患者类型管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{typeId}")
    public AjaxResult remove(@PathVariable Long typeId) {
        if (typeService.hasChildByTypeId(typeId)) {
            return AjaxResult.error("存在下级患者类型,不允许删除");
        }
        if (typeService.checkTypeExistUser(typeId)) {
            return AjaxResult.error("患者类型存在用户,不允许删除");
        }
        return toAjax(typeService.deleteTypeById(typeId));
    }
}
