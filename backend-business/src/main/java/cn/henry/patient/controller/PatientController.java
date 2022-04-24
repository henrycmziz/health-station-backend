package cn.henry.patient.controller;

import cn.henry.common.annotation.Log;
import cn.henry.common.core.controller.BaseController;
import cn.henry.common.core.domain.AjaxResult;
import cn.henry.common.core.domain.entity.SysUser;
import cn.henry.common.core.page.TableDataInfo;
import cn.henry.common.enums.BusinessType;
import cn.henry.common.utils.SecurityUtils;
import cn.henry.common.utils.StringUtils;
import cn.henry.common.utils.poi.ExcelUtil;
import cn.henry.patient.domain.CheckPatientUniqueResult;
import cn.henry.patient.domain.Patient;
import cn.henry.patient.service.PatientService;
import cn.henry.system.service.ISysUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 患者信息
 *
 * @author henry
 */
@RestController
@RequestMapping("/patient")
public class PatientController extends BaseController {
    @Resource
    private PatientService patientService;

    @Resource
    private ISysUserService userService;

    /**
     * 获取患者列表
     */
    @PreAuthorize("@ss.hasPermi('patient:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(Patient patient) {
        startPage();
        List<Patient> list = patientService.selectPatientList(patient);
        return getDataTable(list);
    }

    @Log(title = "患者管理", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('patient:info:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, Patient patient) {
        List<Patient> list = patientService.selectPatientList(patient);
        ExcelUtil<Patient> util = new ExcelUtil<Patient>(Patient.class);
        util.exportExcel(response, list, "患者数据");
    }

    //@Log(title = "患者管理", businessType = BusinessType.IMPORT)
    //@PreAuthorize("@ss.hasPermi('patient:info:import')")
    //@PostMapping("/importData")
    //public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
    //    ExcelUtil<Patient> util = new ExcelUtil<Patient>(Patient.class);
    //    List<Patient> patientList = util.importExcel(file.getInputStream());
    //    String createBy = getUsername();
    //    String message = patientService.importPatient(patientList, updateSupport, createBy);
    //    return AjaxResult.success(message);
    //}

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) {
        ExcelUtil<Patient> util = new ExcelUtil<Patient>(Patient.class);
        util.importTemplateExcel(response, "患者数据");
    }

    /**
     * 根据患者编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('patient:info:query')")
    @GetMapping(value = {"/", "/{patientId}"})
    public AjaxResult getInfo(@PathVariable(value = "patientId", required = false) Long patientId) {
        AjaxResult ajax = AjaxResult.success();
        if (StringUtils.isNotNull(patientId)) {
            ajax.put(AjaxResult.DATA_TAG, patientService.selectPatientById(patientId));
        }
        return ajax;
    }

    /**
     * 新增患者
     */
    @PreAuthorize("@ss.hasPermi('patient:info:add')")
    @Log(title = "患者管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody Patient patient) {
        CheckPatientUniqueResult checkResult = patientService.checkPatientUnique("添加患者 '", patient);
        if (!checkResult.isTrue()) {
            return checkResult.getAjaxResult();
        }
        patient.setCreateBy(getUsername());
        patient.setPassword(SecurityUtils.encryptPassword(patient.getPassword()));
        return toAjax(patientService.insertPatient(patient));
    }

    /**
     * 修改患者
     */
    @PreAuthorize("@ss.hasPermi('patient:info:edit')")
    @Log(title = "患者管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody Patient patient) {
        CheckPatientUniqueResult checkResult = patientService.checkPatientUnique("修改患者 '", patient);
        if (!checkResult.isTrue()) {
            return checkResult.getAjaxResult();
        }
        patient.setUpdateBy(getUsername());
        return toAjax(patientService.updatePatient(patient));
    }

    /**
     * 删除患者
     */
    @PreAuthorize("@ss.hasPermi('patient:info:remove')")
    @Log(title = "患者管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{patientIds}")
    public AjaxResult remove(@PathVariable Long[] patientIds) {
        return toAjax(patientService.deletePatientByIds(patientIds));
    }

    /**
     * 重置密码
     */
    @PreAuthorize("@ss.hasPermi('patient:info:resetPwd')")
    @Log(title = "患者管理", businessType = BusinessType.UPDATE)
    @PutMapping("/resetPwd")
    public AjaxResult resetPwd(@RequestBody SysUser user) {
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        user.setUpdateBy(getUsername());
        return toAjax(userService.resetPwd(user));
    }

    /**
     * 状态修改
     */
    @PreAuthorize("@ss.hasPermi('patient:info:edit')")
    @Log(title = "患者管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysUser user) {
        user.setUpdateBy(getUsername());
        return toAjax(userService.updateUserStatus(user));
    }
}
