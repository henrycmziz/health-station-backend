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
@ApiModel(value = "VideoEditDto", description = "视频修改DTO")
public class VideoEditDto {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

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

    /**
     * 视频说明
     */
    @ApiModelProperty(value = "视频说明")
    private String remark;
}
