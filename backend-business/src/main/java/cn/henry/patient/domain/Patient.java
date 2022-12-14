package cn.henry.patient.domain;

import cn.henry.common.core.domain.entity.SysUser;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

/**
 * 患者对象 sys_user + biz_patient_expand
 *
 * @author henry
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Patient extends SysUser {
    /**
     * 拓展ID
     */
    private Long expandId;

    /**
     * 用户主表ID
     */
    private Long mainUserId;

    /**
     * 患者类型
     */
    private PatientType type;

    /**
     * 类型ID
     */
    private Long typeId;

    /**
     * 诊断意见
     */
    private String diagnosis;

    /**
     * 是否有打卡任务(默认0：无，1：有)
     */
    private Byte isClockIn;

    /**
     * 是否激活(默认0：未激活，1：激活)
     */
    private Byte isActive;

    /**
     * 激活时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activeTime;
}
