package cn.henry.resource.service;

import cn.henry.resource.domain.Video;
import cn.henry.resource.domain.dto.VideoDto;
import cn.henry.resource.domain.dto.VideoEditDto;
import cn.henry.resource.domain.vo.VideoListVo;
import cn.henry.resource.domain.vo.VideoVo;

import java.util.List;

/**
 * 视频信息Service接口
 *
 * @author henry
 * @date 2022-02-20
 */
public interface IVideoService
{
    /**
     * 查询视频信息
     *
     * @param id 视频信息主键
     * @return 视频信息
     */
    VideoVo selectVideoById(Long id);

    /**
     * 查询视频信息列表
     *
     * @param videoDTO 视频信息
     * @return 视频信息集合
     */
    List<VideoListVo> selectVideoList(VideoDto videoDTO);

    /**
     * 新增视频信息
     *
     * @param video 视频信息
     * @return 结果
     */
    boolean insertVideo(Video video);

    /**
     * 修改视频信息
     *
     * @param videoEditDto 视频信息
     * @return 结果
     */
    int updateVideo(VideoEditDto videoEditDto);

    /**
     * 删除视频信息信息
     *
     * @param id 视频信息主键
     * @return 结果
     */
    int deleteVideoById(Long id);
}
