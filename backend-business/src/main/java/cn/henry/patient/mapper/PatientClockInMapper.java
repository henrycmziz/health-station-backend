package cn.henry.patient.mapper;

import cn.henry.patient.domain.PatientClockIn;
import cn.henry.patient.domain.PatientClockInDetail;
import cn.henry.patient.domain.vo.PatientClockInPlanVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 患者打卡计划Mapper接口
 *
 * @author henry
 * @date 2022-04-25
 */
public interface PatientClockInMapper {
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
     * @return map<日期, 该日期打卡详情>
     */
    List<PatientClockInDetail> selectDetailListByPatientId(Long patientId);

    /**
     * 查询患者打卡计划
     *
     * @param id 患者打卡计划主键
     * @return 患者打卡计划
     */
    PatientClockIn selectPatientClockInWithDetailById(String id);

    /**
     * app-查询患者打卡计划
     *
     * @param id          打卡计划ID
     * @param clockInTime 打卡日期
     * @return 患者打卡计划
     */
    PatientClockInPlanVo selectPatientClockInById(@Param("id") String id, @Param("clockInTime") String clockInTime);

    /**
     * app-打卡
     *
     * @param detail detail
     * @return 结果
     */
    int finishClockInTask(PatientClockInDetail detail);


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
     * 删除患者打卡计划
     *
     * @param id 患者打卡计划主键
     * @return 结果
     */
    int deletePatientClockInById(String id);

    /**
     * 批量删除患者打卡计划
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deletePatientClockInByIds(String[] ids);

    /**
     * 批量删除患者打卡详情
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deletePatientClockInDetailByClockInIds(String[] ids);

    /**
     * 批量新增患者打卡详情
     *
     * @param patientClockInDetailList 患者打卡详情列表
     * @return 结果
     */
    int batchPatientClockInDetail(List<PatientClockInDetail> patientClockInDetailList);

    /**
     * 通过患者打卡计划主键删除患者打卡详情信息
     *
     * @param id 患者打卡计划ID
     * @return 结果
     */
    int deletePatientClockInDetailByClockInId(String id);

    /**
     * 查看患者是否还需打卡
     *
     * @param pid 患者ID
     * @return 记录数
     */
    int selectIsHaveMoreClockInTask(Long pid);
}
