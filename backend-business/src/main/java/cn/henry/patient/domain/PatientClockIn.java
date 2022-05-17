package cn.henry.patient.domain;

import cn.henry.common.annotation.Excel;
import cn.henry.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * 患者打卡计划对象 biz_patient_clock_in
 *
 * @author henry
 * @date 2022-04-25
 */
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel(value = "PatientClockIn", description = "患者打卡计划")
public class PatientClockIn extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 患者主表ID
     */
    @Excel(name = "患者主表ID")
    @ApiModelProperty(value = "患者主表ID")
    private Long patientId;

    /**
     * 康复模型ID
     */
    @Excel(name = "康复模型ID")
    @ApiModelProperty(value = "康复模型ID")
    private Long modelId;

    /**
     * 开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty(value = "开始日期")
    private Date startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    /**
     * 患者打卡详情信息
     */
    private List<PatientClockInDetail> patientClockInDetailList;
}
