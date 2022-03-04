package cn.henry.resource.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 视频详情VO
 *
 * @author Henry
 * @date 2022-02-28 10:29
 **/
@Data
@ApiModel(value = "VideoVo", description = "视频详情VO")
public class VideoVo {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 视频url
     */
    @ApiModelProperty(value = "视频url")
    private String videoUrl;

    /**
     * 文件拓展名
     */
    @ApiModelProperty(value = "文件拓展名")
    private String extendType;

    /**
     * 文件名称
     */
    @ApiModelProperty(value = "文件名称")
    private String fileName;

    /**
     * 视频缩略图url
     */
    @ApiModelProperty(value = "视频缩略图url")
    private String videoThumbnailUrl;

    /**
     * 视频时长
     */
    @ApiModelProperty(value = "视频时长")
    private String videoDuration;

    /**
     * 视频状态(默认1:正常, 0:停用)
     */
    @ApiModelProperty(value = "视频状态(默认1:正常, 0:停用)")
    private Byte status;

    /**
     * 视频说明
     */
    @ApiModelProperty(value = "视频说明")
    private String remark;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private String createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private String updateTime;
}
