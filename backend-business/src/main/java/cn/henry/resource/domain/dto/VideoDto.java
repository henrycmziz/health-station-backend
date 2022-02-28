package cn.henry.resource.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 视频DTO
 *
 * @author Henry
 * @date 2022-02-28 10:19
 **/
@Data
@ApiModel(value = "VideoDTO", description ="视频DTO")
public class VideoDto {
    /**
     * 文件名称
     */
    @ApiModelProperty(value = "文件名称")
    private String fileName;
    /**
     * 视频状态(默认0:正常，1:停用)
     */
    @ApiModelProperty(value = "视频状态(默认0:正常，1:停用)")
    private String status;
}
