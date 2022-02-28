package cn.henry.resource.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 视频列表VO
 *
 * @author Henry
 * @date 2022-02-28 10:29
 **/
@Data
@ApiModel(value = "VideoListVo", description = "视频列表VO")
public class VideoListVo {
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
}
