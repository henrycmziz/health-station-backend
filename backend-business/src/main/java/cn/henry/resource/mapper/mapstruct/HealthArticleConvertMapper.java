package cn.henry.resource.mapper.mapstruct;

import cn.henry.resource.domain.Video;
import cn.henry.resource.domain.vo.VideoListVo;
import cn.henry.resource.domain.vo.VideoVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Henry
 * @date 2022-02-28 12:17
 **/
@Mapper
public interface HealthArticleConvertMapper {
    HealthArticleConvertMapper INSTANCE = Mappers.getMapper(HealthArticleConvertMapper.class);

    /**
     * video 转 videoVo
     *
     * @param video video
     * @return VideoVo
     */
    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    VideoVo videoToVideoVo(Video video);

    /**
     * List<video> 转 List<videoVo>
     *
     * @param videoList videoList
     * @return List<VideoVo>
     */
    List<VideoListVo> videoToVideoListVo(List<Video> videoList);
}
