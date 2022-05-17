package cn.henry.patient.service;

import cn.henry.patient.domain.PatientClockIn;
import cn.henry.patient.domain.PatientClockInDetail;
import cn.henry.patient.domain.vo.PatientClockInPlanVo;

import java.util.List;

/**
 * 患者打卡计划Service接口
 *
 * @author henry
 * @date 2022-04-25
 */
public interface IPatientClockInService {
    /**
     * 新增患者打卡计划
     *
     * @param patientClockIn 患者打卡计划
     * @return 结果
     */
    int addPatientClockIn(PatientClockIn patientClockIn);

    /**
     * 查询患者打卡计划与详情列表
     *
     * @param patientId 患者ID
     * @return 列表
     */
    List<PatientClockIn> selectPatientClockInListByPatientId(Long patientId);

    /**
     * app-查询患者打卡详情列表
     *
     * @param patientId 患者ID
     * @return List<PatientClockInDetail>
     */
    List<PatientClockInDetail> selectDetailListByPatientId(Long patientId);

    /**
     * app-查询患者打卡计划
     *
     * @param id          打卡计划ID
     * @param clockInTime 打卡日期
     * @return 患者打卡计划
     */
    PatientClockInPlanVo selectPatientClockInById(String id, String clockInTime);

    /**
     * app-打卡
     *
     * @param pid 患者ID
     * @param detail detail
     * @return 结果
     */
    int finishClockInTask(Long pid, PatientClockInDetail detail);


    /**
     * 查询患者打卡计划
     *
     * @param id 患者打卡计划主键
     * @return 患者打卡计划
     */
    PatientClockIn selectPatientClockInWithDetailById(String id);

    /**
     * 查询患者打卡计划列表
     *
     * @param patientClockIn 患者打卡计划
     * @return 患者打卡计划集合
     */
    List<PatientClockIn> selectPatientClockInList(PatientClockIn patientClockIn);

    /**
     * 新增患者打卡计划
     *
     * @param patientClockIn 患者打卡计划
     * @return 结果
     */
    int insertPatientClockIn(PatientClockIn patientClockIn);

    /**
     * 修改患者打卡计划
     *
     * @param patientClockIn 患者打卡计划
     * @return 结果
     */
    int updatePatientClockIn(PatientClockIn patientClockIn);

    /**
     * 批量删除患者打卡计划
     *
     * @param ids 需要删除的患者打卡计划主键集合
     * @return 结果
     */
    int deletePatientClockInByIds(String[] ids);

    /**
     * 删除患者打卡计划信息
     *
     * @param id 患者打卡计划主键
     * @return 结果
     */
    int deletePatientClockInById(String id);
}
