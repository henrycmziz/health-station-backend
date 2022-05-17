package cn.henry.patient.domain.vo;

import cn.henry.resource.domain.Video;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 患者打卡计划详细VO
 *
 * @author henry
 * @date 2022-04-25
 */
@Data
@ApiModel(value = "PatientClockInPlanVo", description = "患者打卡计划详细VO")
public class PatientClockInPlanVo {
    /**
     * 该次打卡记录ID
     */
    @ApiModelProperty(value = "该次打卡记录ID")
    private String clockInDetailId;

    /**
     * 打卡说明
     */
    @ApiModelProperty(value = "打卡说明")
    private String remark;

    /**
     * 模型包含视频id集合，eg: 1,2,3
     */
    @ApiModelProperty(value = "模型包含视频id集合，eg: 1,2,3")
    private String modelVideoIds;

    /**
     * 模型包含视频id集合，eg: 1,2,3
     */
    @ApiModelProperty(value = "模型包含视频id集合，eg: 1,2,3")
    private List<Video> videoInfos;
}
