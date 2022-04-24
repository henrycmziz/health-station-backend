package cn.henry.patient.domain;

import cn.henry.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * 患者类型表
 *
 * @author henry
 * @TableName biz_patient_type
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PatientType extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 类型id
     */
    private Long typeId;

    /**
     * 父类型id
     */
    private Long parentId;

    /**
     * 祖级列表
     */
    private String ancestors;

    /**
     * 类型名称
     */
    @NotBlank(message = "类型名称不能为空")
    @Size(max = 30, message = "类型名称长度不能超过30个字符")
    private String typeName;

    /**
     * 类型描述
     */
    private String typeDescribe;

    /**
     * 显示顺序
     */
    @NotNull(message = "显示顺序不能为空")
    private Integer orderNum;

    /**
     * 负责人
     */
    private String leader;

    /**
     * 联系电话
     */
    @Size(max = 11, message = "联系电话长度不能超过11个字符")
    private String phone;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确")
    @Size(max = 50, message = "邮箱长度不能超过50个字符")
    private String email;

    /**
     * 类型状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 父部门名称
     */
    private String parentName;

    /**
     * 子部门
     */
    private List<PatientType> children = new ArrayList<>();
}
