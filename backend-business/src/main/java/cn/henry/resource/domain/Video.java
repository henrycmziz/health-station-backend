package cn.henry.resource.domain;

import cn.henry.common.core.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 视频信息对象 hs_video_lib
 *
 * @author henry
 * @date 2022-02-20
 */
@Getter
@Setter
@NoArgsConstructor
public class Video extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 视频url
     */
    private String videoUrl;

    /**
     * 文件拓展名
     */
    private String extendType;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 视频缩略图url
     */
    private String videoThumbnailUrl;

    /**
     * 视频时长
     */
    private String videoDuration;

    /**
     * 视频状态(默认1:正常，0:停用)
     */
    private Byte status;

    public Video(String videoUrl, String extendType, String fileName, String videoThumbnailUrl, String videoDuration, String createBy) {
        this.videoUrl = videoUrl;
        this.extendType = extendType;
        this.fileName = fileName;
        this.videoThumbnailUrl = videoThumbnailUrl;
        this.videoDuration = videoDuration;
        setCreateBy(createBy);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("id", getId())
                .append("videoUrl", getVideoUrl())
                .append("extendType", getExtendType())
                .append("fileName", getFileName())
                .append("videoThumbnailUrl", getVideoThumbnailUrl())
                .append("videoDuration", getVideoDuration())
                .append("remark", getRemark())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
