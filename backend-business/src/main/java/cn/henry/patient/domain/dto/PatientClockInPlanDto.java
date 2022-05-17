package cn.henry.patient.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 患者打卡计划DTO
 *
 * @author henry
 * @date 2022-04-25
 */
@Data
@ApiModel(value = "PatientClockInPlanDto", description = "患者打卡计划DTO")
public class PatientClockInPlanDto {
    /**
     * 患者主表ID
     */
    @ApiModelProperty(value = "患者主表ID")
    private Long patientId;

    /**
     * 康复模型ID
     */
    @ApiModelProperty(value = "康复模型ID")
    private Long modelId;

    /**
     * 开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "开始日期")
    private Date startTime;

    /**
     * 结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "结束日期")
    private Date endTime;

    /**
     * 打卡说明
     */
    @ApiModelProperty(value = "打卡说明")
    private String remark;

    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    private String createBy;
}
