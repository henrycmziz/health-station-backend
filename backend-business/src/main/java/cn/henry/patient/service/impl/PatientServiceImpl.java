package cn.henry.patient.service.impl;

import cn.henry.common.constant.UserConstants;
import cn.henry.common.core.domain.AjaxResult;
import cn.henry.common.utils.StringUtils;
import cn.henry.patient.domain.CheckPatientUniqueResult;
import cn.henry.patient.domain.Patient;
import cn.henry.patient.mapper.PatientMapper;
import cn.henry.patient.service.PatientService;
import cn.henry.system.mapper.SysUserRoleMapper;
import cn.henry.system.service.ISysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 患者 业务层处理
 *
 * @author henry
 */
@Service
public class PatientServiceImpl implements PatientService {
    @Resource
    private PatientMapper patientMapper;

    @Resource
    private ISysUserService userService;

    @Resource
    private SysUserRoleMapper userRoleMapper;

    /**
     * 根据条件分页查询患者列表
     *
     * @param patient 患者信息
     * @return 患者信息集合信息
     */
    @Override
    //@DataScope(deptAlias = "d", userAlias = "u")
    public List<Patient> selectPatientList(Patient patient) {
        return patientMapper.selectPatientList(patient);
    }

    /**
     * 通过患者ID查询患者
     *
     * @param patientId 患者ID
     * @return 患者对象信息
     */
    @Override
    public Patient selectPatientById(Long patientId) {
        return patientMapper.selectPatientById(patientId);
    }

    /**
     * 新增保存患者信息
     *
     * @param patient 患者信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertPatient(Patient patient) {
        Long[] roleIds = new Long[]{100L};
        patient.setUserType("11");
        patient.setRoleIds(roleIds);
        // 新增患者信息
        int rows = userService.insertUser(patient);
        // 新增患者拓展信息
        patientMapper.insertPatientExpand(patient);
        return rows;
    }

    /**
     * 注册患者信息
     *
     * @param patient 患者信息
     * @return 结果
     */
    @Override
    public boolean registerPatient(Patient patient) {
        return patientMapper.insertPatient(patient) > 0;
    }

    /**
     * 修改保存患者信息
     *
     * @param patient 患者信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updatePatient(Patient patient) {
        patientMapper.updatePatientExpand(patient);
        return patientMapper.updatePatient(patient);
    }

    /**
     * 修改拓展表
     *
     * @param patient 患者信息
     * @return 结果
     */
    @Override
    public int updatePatientExpand(Patient patient) {
        return patientMapper.updatePatientExpand(patient);
    }

    /**
     * 检查患者是否唯一
     *
     * @param operate 操作类型
     * @param patient 患者信息
     * @return AjaxResult
     */
    @Override
    public CheckPatientUniqueResult checkPatientUnique(String operate, Patient patient) {
        if ("添加患者 '".equals(operate) && UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(patient.getUserName()))) {
            return CheckPatientUniqueResult.builder().isTrue(false)
                    .ajaxResult(AjaxResult.error(operate + patient.getNickName() + "'失败，账号已存在，请修改患者登录账号")).build();
        } else if (StringUtils.isNotEmpty(patient.getPhonenumber()) && UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(patient))) {
            return CheckPatientUniqueResult.builder().isTrue(false)
                    .ajaxResult(AjaxResult.error(operate + patient.getNickName() + "'失败，手机号码已存在")).build();
        } else if (StringUtils.isNotEmpty(patient.getEmail()) && UserConstants.NOT_UNIQUE.equals(userService.checkEmailUnique(patient))) {
            return CheckPatientUniqueResult.builder().isTrue(false)
                    .ajaxResult(AjaxResult.error(operate + patient.getNickName() + "'失败，邮箱账号已存在")).build();
        }
        return CheckPatientUniqueResult.builder().isTrue(true).build();
    }

    /**
     * 修改患者基本信息
     *
     * @param patient 患者信息
     * @return 结果
     */
    @Override
    public int updatePatientProfile(Patient patient) {
        return patientMapper.updatePatient(patient);
    }

    /**
     * 通过患者ID删除患者
     *
     * @param patientId 患者ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deletePatientById(Long patientId) {
        // 删除患者与角色关联
        //patientRoleMapper.deletePatientRoleByPatientId(patientId);
        // 删除患者与岗位表
        //patientPostMapper.deletePatientPostByPatientId(patientId);
        return patientMapper.deletePatientById(patientId);
    }

    /**
     * 批量删除患者信息
     *
     * @param patientIds 需要删除的患者ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deletePatientByIds(Long[] patientIds) {
        //删除患者与角色关联
        userRoleMapper.deleteUserRole(patientIds);
        //patientMapper.deletePatientExpandByIds(patientIds);
        return patientMapper.deletePatientByIds(patientIds);
    }

    ///**
    // * 导入患者数据
    // *
    // * @param patientList     患者数据列表
    // * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
    // * @param createBy        操作患者
    // * @return 结果
    // */
    //@Override
    //public String importPatient(List<Patient> patientList, Boolean isUpdateSupport, String createBy) {
    //    if (StringUtils.isNull(patientList) || patientList.isEmpty()) {
    //        throw new ServiceException("导入患者数据不能为空！");
    //    }
    //    int successNum = 0;
    //    int failureNum = 0;
    //    StringBuilder successMsg = new StringBuilder();
    //    StringBuilder failureMsg = new StringBuilder();
    //    String password = configService.selectConfigByKey("sys.patient.initPassword");
    //    for (Patient patient : patientList) {
    //        try {
    //            // 验证是否存在这个患者
    //            Patient u = patientMapper.selectPatientByPatientName(patient.getPatientName());
    //            if (StringUtils.isNull(u)) {
    //                patient.setPassword(SecurityUtils.encryptPassword(password));
    //                patient.setCreateBy(createBy);
    //                this.insertPatient(patient);
    //                successNum++;
    //                successMsg.append(MSG_PREFIX).append(successNum).append(MSG_MIDDLE).append(patient.getPatientName()).append(" 导入成功");
    //            } else if (Boolean.TRUE.equals(isUpdateSupport)) {
    //                patient.setUpdateBy(createBy);
    //                this.updatePatient(patient);
    //                successNum++;
    //                successMsg.append(MSG_PREFIX).append(successNum).append(MSG_MIDDLE).append(patient.getPatientName()).append(" 更新成功");
    //            } else {
    //                failureNum++;
    //                failureMsg.append(MSG_PREFIX).append(failureNum).append(MSG_MIDDLE).append(patient.getPatientName()).append(" 已存在");
    //            }
    //        } catch (Exception e) {
    //            failureNum++;
    //            String msg = MSG_PREFIX + failureNum + MSG_MIDDLE + patient.getPatientName() + " 导入失败：";
    //            failureMsg.append(msg).append(e.getMessage());
    //            log.error(msg, e);
    //        }
    //    }
    //    if (failureNum > 0) {
    //        failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
    //        throw new ServiceException(failureMsg.toString());
    //    } else {
    //        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
    //    }
    //    return successMsg.toString();
    //}
}
