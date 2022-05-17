package cn.henry.patient.domain;

import cn.henry.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 患者打卡详情对象 biz_patient_clock_in_detail
 *
 * @author henry
 * @date 2022-04-25
 */
@Data
@NoArgsConstructor
@ApiModel(value = "PatientClockInDetail", description = "患者打卡详情")
public class PatientClockInDetail {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 打卡计划ID
     */
    @Excel(name = "打卡计划ID")
    @ApiModelProperty(value = "打卡计划ID")
    private String clockInId;

    /**
     * 应打卡日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "应打卡日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty(value = "应打卡日期")
    private Date clockInTime;

    /**
     * 是否已经打卡; 0:否，1:是
     */
    @Excel(name = "是否已经打卡; 0:否，1:是")
    @ApiModelProperty(value = "是否已经打卡; 0:否，1:是")
    private Byte isClockedIn;

    /**
     * 提交时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "提交时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "提交时间")
    private Date submitTime;

    /**
     * 打卡评论
     */
    @Excel(name = "打卡评论")
    @ApiModelProperty(value = "打卡评论")
    private String comment;

    public PatientClockInDetail(String id, String clockInId, Date clockInTime) {
        this.id = id;
        this.clockInId = clockInId;
        this.clockInTime = clockInTime;
    }
}
