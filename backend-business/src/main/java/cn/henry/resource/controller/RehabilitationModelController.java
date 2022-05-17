package cn.henry.resource.controller;

import cn.henry.common.annotation.Log;
import cn.henry.common.core.controller.BaseController;
import cn.henry.common.core.domain.Response;
import cn.henry.common.core.page.ResponsePageInfo;
import cn.henry.common.enums.BusinessType;
import cn.henry.common.utils.poi.ExcelUtil;
import cn.henry.resource.domain.RehabilitationModel;
import cn.henry.resource.service.IRehabilitationModelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 患者康复模型Controller
 *
 * @author henry
 * @date 2022-04-25
 */
@Api(tags = "患者康复模型")
@RestController
@RequestMapping("/resource/model")
public class RehabilitationModelController extends BaseController {
    @Resource
    private IRehabilitationModelService rehabilitationModelService;

    /**
     * 查询患者康复模型列表
     */
    @ApiOperation(value = "列表")
    @PreAuthorize("@ss.hasPermi('resource:model:list')")
    @GetMapping("/list")
    public ResponsePageInfo<RehabilitationModel> list(RehabilitationModel rehabilitationModel) {
        startPage();
        List<RehabilitationModel> list = rehabilitationModelService.selectRehabilitationModelList(rehabilitationModel);
        return toResponsePageInfo(list);
    }

    /**
     * 导出患者康复模型列表
     */
    @ApiOperation(value = "导出列表")
    @PreAuthorize("@ss.hasPermi('resource:model:export')")
    @Log(title = "患者康复模型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RehabilitationModel rehabilitationModel) {
        List<RehabilitationModel> list = rehabilitationModelService.selectRehabilitationModelList(rehabilitationModel);
        ExcelUtil<RehabilitationModel> util = new ExcelUtil<RehabilitationModel>(RehabilitationModel.class);
        util.exportExcel(response, list, "患者康复模型数据");
    }

    /**
     * 获取患者康复模型详细信息
     */
    @ApiOperation(value = "详细信息")
    @PreAuthorize("@ss.hasPermi('resource:model:query')")
    @GetMapping(value = "/{id}")
    public Response<RehabilitationModel> getInfo(@PathVariable("id") Long id) {
        return Response.success(rehabilitationModelService.selectRehabilitationModelById(id));
    }

    /**
     * 新增患者康复模型
     */
    @ApiOperation(value = "新增")
    @PreAuthorize("@ss.hasPermi('resource:model:add')")
    @Log(title = "患者康复模型", businessType = BusinessType.INSERT)
    @PostMapping
    public Response<Integer> add(@RequestBody RehabilitationModel rehabilitationModel) {
        rehabilitationModel.setCreateBy(getUsername());
        return toResponse(rehabilitationModelService.insertRehabilitationModel(rehabilitationModel));
    }

    /**
     * 修改患者康复模型
     */
    @ApiOperation(value = "修改")
    @PreAuthorize("@ss.hasPermi('resource:model:edit')")
    @Log(title = "患者康复模型", businessType = BusinessType.UPDATE)
    @PutMapping
    public Response<Integer> edit(@RequestBody RehabilitationModel rehabilitationModel) {
        rehabilitationModel.setUpdateBy(getUsername());
        return toResponse(rehabilitationModelService.updateRehabilitationModel(rehabilitationModel));
    }

    /**
     * 状态修改
     */
    @PreAuthorize("@ss.hasPermi('resource:model:edit')")
    @Log(title = "健康小知识", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public Response<Integer> changeStatus(@RequestBody RehabilitationModel rehabilitationModel) {
        rehabilitationModel.setUpdateBy(getUsername());
        return toResponse(rehabilitationModelService.updateRehabilitationModel(rehabilitationModel));
    }

    /**
     * 删除患者康复模型
     */
    @ApiOperation(value = "删除")
    @PreAuthorize("@ss.hasPermi('resource:model:remove')")
    @Log(title = "患者康复模型", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public Response<Integer> remove(@PathVariable Long[] ids) {
        return toResponse(rehabilitationModelService.deleteRehabilitationModelByIds(ids));
    }
}
