package cn.henry.patient.service;


import cn.henry.patient.domain.CheckPatientUniqueResult;
import cn.henry.patient.domain.Patient;

import java.util.List;

/**
 * 患者 业务层
 *
 * @author henry
 */
public interface PatientService {
    /**
     * 根据条件分页查询患者列表
     *
     * @param patient 患者信息
     * @return 患者信息集合信息
     */
    List<Patient> selectPatientList(Patient patient);

    /**
     * 根据条件分页查询已分配患者角色列表
     *
     * @param patient 患者信息
     * @return 患者信息集合信息
     */
    //List<Patient> selectAllocatedList(Patient patient);

    /**
     * 根据条件分页查询未分配患者角色列表
     *
     * @param patient 患者信息
     * @return 患者信息集合信息
     */
    //List<Patient> selectUnallocatedList(Patient patient);

    /**
     * 通过患者名查询患者
     *
     * @param patientName 患者名
     * @return 患者对象信息
     */
    //Patient selectPatientByPatientName(String patientName);

    /**
     * 通过患者ID查询患者
     *
     * @param patientId 患者ID
     * @return 患者对象信息
     */
    Patient selectPatientById(Long patientId);

    /**
     * 根据患者ID查询患者所属角色组
     *
     * @param patientName 患者名
     * @return 结果
     */
    //String selectPatientRoleGroup(String patientName);

    /**
     * 根据患者ID查询患者所属岗位组
     *
     * @param patientName 患者名
     * @return 结果
     */
    //String selectPatientPostGroup(String patientName);

    /**
     * 校验患者名称是否唯一
     *
     * @param patientName 患者名称
     * @return 结果
     */
    //String checkPatientNameUnique(String patientName);

    /**
     * 校验手机号码是否唯一
     *
     * @param patient 患者信息
     * @return 结果
     */
    //String checkPhoneUnique(Patient patient);

    ///**
    // * 校验email是否唯一
    // *
    // * @param patient 患者信息
    // * @return 结果
    // */
    //String checkEmailUnique(Patient patient);

    /**
     * 校验患者是否允许操作
     *
     * @param patient 患者信息
     */
    //void checkPatientAllowed(Patient patient);

    /**
     * 校验患者是否有数据权限
     *
     * @param patientId 患者id
     */
    //void checkPatientDataScope(Long patientId);

    /**
     * 新增患者信息
     *
     * @param patient 患者信息
     * @return 结果
     */
    int insertPatient(Patient patient);

    /**
     * 注册患者信息
     *
     * @param patient 患者信息
     * @return 结果
     */
    boolean registerPatient(Patient patient);

    /**
     * 修改患者信息
     *
     * @param patient 患者信息
     * @return 结果
     */
    int updatePatient(Patient patient);

    /**
     * 患者授权角色
     *
     * @param patientId 患者ID
     * @param roleIds   角色组
     */
    //void insertPatientAuth(Long patientId, Long[] roleIds);

    /**
     * 修改患者状态
     *
     * @param patient 患者信息
     * @return 结果
     */
    //int updatePatientStatus(Patient patient);

    /**
     * 修改患者基本信息
     *
     * @param patient 患者信息
     * @return 结果
     */
    int updatePatientProfile(Patient patient);

    /**
     * 修改患者头像
     *
     * @param patientName 患者名
     * @param avatar      头像地址
     * @return 结果
     */
    //boolean updatePatientAvatar(String patientName, String avatar);

    /**
     * 重置患者密码
     *
     * @param patient 患者信息
     * @return 结果
     */
    //int resetPwd(Patient patient);

    /**
     * 重置患者密码
     *
     * @param patientName 患者名
     * @param password    密码
     * @return 结果
     */
    //int resetPatientPwd(String patientName, String password);

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
     * 修改拓展表
     *
     * @param patient 患者信息
     * @return 结果
     */
    int updatePatientExpand(Patient patient);

    /**
     * 检查患者是否唯一
     * @param operate 操作类型
     * @param patient 患者信息
     * @return AjaxResult
     */
    CheckPatientUniqueResult checkPatientUnique(String operate, Patient patient);

    /**
     * 导入患者数据
     *
     * @param patientList     患者数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作患者
     * @return 结果
     */
    //String importPatient(List<Patient> patientList, Boolean isUpdateSupport, String operName);
}
