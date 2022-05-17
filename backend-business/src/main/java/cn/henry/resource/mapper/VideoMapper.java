package cn.henry.resource.mapper;

import cn.henry.resource.domain.Video;
import cn.henry.resource.domain.dto.VideoDto;
import cn.henry.resource.domain.dto.VideoEditDto;

import java.util.List;

/**
 * 视频信息Mapper接口
 *
 * @author henry
 * @date 2022-02-20
 */
public interface VideoMapper {
    /**
     * 查询视频信息
     *
     * @param id 视频主键
     * @return 视频信息
     */
    Video selectVideoById(Long id);

    /**
     * 查询多个视频信息
     *
     * @param ids 视频信息主键数组
     * @return 视频信息列表
     */
    List<Video> selectVideoByIds(Long[] ids);

    /**
     * 查询视频信息列表
     *
     * @param videoDTO 视频信息
     * @return 视频信息集合
     */
    List<Video> selectVideoList(VideoDto videoDTO);

    /**
     * 新增视频信息
     *
     * @param video 视频信息
     * @return 结果
     */
    int insertVideo(Video video);

    /**
     * 修改视频信息
     *
     * @param videoEditDto 视频信息
     * @return 结果
     */
    int updateVideo(VideoEditDto videoEditDto);

    /**
     * 删除视频信息
     *
     * @param id 视频信息主键
     * @return 结果
     */
    int deleteVideoById(Long id);
}
