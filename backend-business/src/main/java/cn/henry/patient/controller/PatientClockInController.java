package cn.henry.patient.controller;

import cn.henry.common.annotation.Log;
import cn.henry.common.core.controller.BaseController;
import cn.henry.common.core.domain.Response;
import cn.henry.common.core.page.ResponsePageInfo;
import cn.henry.common.enums.BusinessType;
import cn.henry.common.utils.poi.ExcelUtil;
import cn.henry.patient.domain.PatientClockIn;
import cn.henry.patient.domain.PatientClockInDetail;
import cn.henry.patient.domain.vo.PatientClockInPlanVo;
import cn.henry.patient.service.IPatientClockInService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 患者打卡计划Controller
 *
 * @author henry
 * @date 2022-04-25
 */
@Api(tags = "患者打卡计划")
@RestController
@RequestMapping("/patient/clock-in")
public class PatientClockInController extends BaseController {
    @Resource
    private IPatientClockInService patientClockInService;

    /**
     * 新增患者打卡计划
     */
    @ApiOperation(value = "新增")
    @PreAuthorize("@ss.hasPermi('patient:clockin:add')")
    @Log(title = "患者打卡计划", businessType = BusinessType.INSERT)
    @PostMapping("/add-plan")
    public Response<Integer> addPlan(@RequestBody PatientClockIn patientClockIn) {
        patientClockIn.setCreateBy(getUsername());
        return toResponse(patientClockInService.addPatientClockIn(patientClockIn));
    }

    /**
     * 查询患者打卡计划与详情列表
     */
    @ApiOperation(value = "列表")
    @PreAuthorize("@ss.hasPermi('patient:clockin:list')")
    @GetMapping("/{pid}/history")
    public Response<List<PatientClockIn>> listByPatientId(@PathVariable("pid") Long patientId) {
        List<PatientClockIn> list = patientClockInService.selectPatientClockInListByPatientId(patientId);
        return Response.success(list);
    }

    /**
     * app-查询患者打卡详情列表
     */
    @ApiOperation(value = "app列表")
    @GetMapping("/{pid}/detail")
    public Response<List<PatientClockInDetail>> detailListByPatientId(@PathVariable("pid") Long patientId) {
        List<PatientClockInDetail> list = patientClockInService.selectDetailListByPatientId(patientId);
        return Response.success(list);
    }

    /**
     * app-获取患者打卡计划详细信息
     */
    @ApiOperation(value = "详细信息")
    @GetMapping(value = "/app")
    public Response<PatientClockInPlanVo> getInfo(@RequestParam("id") String id, @RequestParam("clockInTime") String clockInTime) {
        return Response.success(patientClockInService.selectPatientClockInById(id, clockInTime));
    }

    /**
     * app-打卡
     */
    @ApiOperation(value = "app-打卡")
    @PutMapping("/{pid}/finish")
    public Response<Integer> clockIn(@PathVariable("pid") Long pid, @RequestBody PatientClockInDetail detail) {
        return toResponse(patientClockInService.finishClockInTask(pid, detail));
    }


    /**
     * 查询患者打卡计划列表
     */
    @ApiOperation(value = "列表")
    @PreAuthorize("@ss.hasPermi('patient:clockin:list')")
    @GetMapping("/list")
    public ResponsePageInfo<PatientClockIn> list(PatientClockIn patientClockIn) {
        startPage();
        List<PatientClockIn> list = patientClockInService.selectPatientClockInList(patientClockIn);
        return toResponsePageInfo(list);
    }

    /**
     * 导出患者打卡计划列表
     */
    @ApiOperation(value = "导出列表")
    @PreAuthorize("@ss.hasPermi('patient:clockin:export')")
    @Log(title = "患者打卡计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PatientClockIn patientClockIn) {
        List<PatientClockIn> list = patientClockInService.selectPatientClockInList(patientClockIn);
        ExcelUtil<PatientClockIn> util = new ExcelUtil<PatientClockIn>(PatientClockIn.class);
        util.exportExcel(response, list, "患者打卡计划数据");
    }

    /**
     * 获取患者打卡计划详细信息
     */
    @ApiOperation(value = "详细信息")
    @PreAuthorize("@ss.hasPermi('patient:clockin:query')")
    @GetMapping(value = "/{id}")
    public Response<PatientClockIn> getInfo(@PathVariable("id") String id) {
        return Response.success(patientClockInService.selectPatientClockInWithDetailById(id));
    }

    /**
     * 新增患者打卡计划
     */
    @ApiOperation(value = "新增")
    @PreAuthorize("@ss.hasPermi('patient:clockin:add')")
    @Log(title = "患者打卡计划", businessType = BusinessType.INSERT)
    @PostMapping
    public Response<Integer> add(@RequestBody PatientClockIn patientClockIn) {
        return toResponse(patientClockInService.insertPatientClockIn(patientClockIn));
    }

    /**
     * 修改患者打卡计划
     */
    @ApiOperation(value = "修改")
    @PreAuthorize("@ss.hasPermi('patient:clockin:edit')")
    @Log(title = "患者打卡计划", businessType = BusinessType.UPDATE)
    @PutMapping
    public Response<Integer> edit(@RequestBody PatientClockIn patientClockIn) {
        return toResponse(patientClockInService.updatePatientClockIn(patientClockIn));
    }

    /**
     * 删除患者打卡计划
     */
    @ApiOperation(value = "删除")
    @PreAuthorize("@ss.hasPermi('patient:clockin:remove')")
    @Log(title = "患者打卡计划", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public Response<Integer> remove(@PathVariable String[] ids) {
        return toResponse(patientClockInService.deletePatientClockInByIds(ids));
    }
}
