package cn.henry.resource.mapper;

import cn.henry.resource.domain.Video;

import java.util.List;

/**
 * 视频信息Mapper接口
 *
 * @author henry
 * @date 2022-02-20
 */
public interface VideoMapper
{
    /**
     * 查询视频信息
     *
     * @param id 视频信息主键
     * @return 视频信息
     */
    Video selectVideoLibById(Long id);

    /**
     * 查询视频信息列表
     *
     * @param video 视频信息
     * @return 视频信息集合
     */
    List<Video> selectVideoLibList(Video video);

    /**
     * 新增视频信息
     *
     * @param video 视频信息
     * @return 结果
     */
    int insertVideoLib(Video video);

    /**
     * 修改视频信息
     *
     * @param video 视频信息
     * @return 结果
     */
    int updateVideoLib(Video video);

    /**
     * 删除视频信息
     *
     * @param id 视频信息主键
     * @return 结果
     */
    int deleteVideoLibById(Long id);

    /**
     * 批量删除视频信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteVideoLibByIds(Long[] ids);
}
