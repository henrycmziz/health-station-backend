package cn.henry.patient.mapper;

import cn.henry.patient.domain.Patient;

import java.util.List;

/**
 * 患者表 数据层
 *
 * @author henry
 */
public interface PatientMapper {
    /**
     * 根据条件分页查询患者列表
     *
     * @param patient 患者信息
     * @return 患者信息集合信息
     */
    List<Patient> selectPatientList(Patient patient);

    /**
     * 通过患者名查询患者
     *
     * @param patientName 患者名
     * @return 患者对象信息
     */
    Patient selectPatientByPatientName(String patientName);

    /**
     * 通过患者ID查询患者
     *
     * @param patientId 患者ID
     * @return 患者对象信息
     */
    Patient selectPatientById(Long patientId);

    /**
     * 新增患者信息
     *
     * @param patient 患者信息
     * @return 结果
     */
    int insertPatient(Patient patient);

    /**
     * 修改患者信息
     *
     * @param patient 患者信息
     * @return 结果
     */
    int updatePatient(Patient patient);

    /**
     * 通过患者ID删除患者
     *
     * @param patientId 患者ID
     * @return 结果
     */
    int deletePatientById(Long patientId);

    /**
     * 批量删除患者信息
     *
     * @param patientIds 需要删除的患者ID
     * @return 结果
     */
    int deletePatientByIds(Long[] patientIds);

    /**
     * 校验患者名称是否唯一
     *
     * @param patientName 患者名称
     * @return 结果
     */
    int checkPatientNameUnique(String patientName);

    /**
     * 校验手机号码是否唯一
     *
     * @param phonenumber 手机号码
     * @return 结果
     */
    Patient checkPhoneUnique(String phonenumber);

    /**
     * 校验email是否唯一
     *
     * @param email 患者邮箱
     * @return 结果
     */
    Patient checkEmailUnique(String email);

    /**
     * 新增患者拓展信息
     *
     * @param patient 患者拓展信息
     * @return 结果
     */
    int insertPatientExpand(Patient patient);

    /**
     * 批量删除患者拓展信息
     *
     * @param patientIds 需要删除的患者ID
     * @return 结果
     */
    int deletePatientExpandByIds(Long[] patientIds);

    /**
     * 更新患者拓展表
     *
     * @param patient 患者拓展信息
     * @return 结果
     */
    int updatePatientExpand(Patient patient);
}
