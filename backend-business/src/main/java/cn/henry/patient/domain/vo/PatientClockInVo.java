package cn.henry.patient.domain.vo;

import cn.henry.patient.domain.PatientClockInDetail;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 患者打卡历史VO
 *
 * @author henry
 * @date 2022-04-25
 */
@Data
@ApiModel(value = "PatientClockInVo", description = "患者打卡历史VO")
public class PatientClockInVo {
    /**
     * 模型名称
     */
    @ApiModelProperty(value = "模型名称")
    private String modelName;

    /**
     * 开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "开始日期")
    private Date startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    /**
     * 打卡说明
     */
    @ApiModelProperty(value = "打卡说明")
    private String remark;

    /**
     * 完成率
     */
    @ApiModelProperty(value = "完成率")
    private String completionRate;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createBy;

    /**
     * 打卡详情列表
     */
    @ApiModelProperty(value = "打卡详情列表")
    private List<PatientClockInDetail> clockInDetails;
}
