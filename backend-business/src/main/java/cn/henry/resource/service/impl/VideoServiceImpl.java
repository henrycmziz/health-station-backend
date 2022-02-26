package cn.henry.resource.service.impl;

import cn.henry.common.utils.DateUtils;
import cn.henry.common.utils.file.FileUtils;
import cn.henry.resource.domain.Video;
import cn.henry.resource.mapper.VideoMapper;
import cn.henry.resource.service.IVideoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 视频信息Service业务层处理
 *
 * @author henry
 * @date 2022-02-20
 */
@Service
public class VideoServiceImpl implements IVideoService {
    @Resource
    private VideoMapper videoMapper;

    /**
     * 查询视频信息
     *
     * @param id 视频信息主键
     * @return 视频信息
     */
    @Override
    public Video selectVideoLibById(Long id) {
        return videoMapper.selectVideoLibById(id);
    }

    /**
     * 查询视频信息列表
     *
     * @param video 视频信息
     * @return 视频信息
     */
    @Override
    public List<Video> selectVideoLibList(Video video) {
        return videoMapper.selectVideoLibList(video);
    }

    /**
     * 新增视频信息
     *
     * @param video 视频信息
     * @return 结果
     */
    @Override
    public boolean insertVideoLib(Video video) {
        video.setCreateTime(DateUtils.getNowDate());
        return videoMapper.insertVideoLib(video) > 0;
    }

    /**
     * 修改视频信息
     *
     * @param video 视频信息
     * @return 结果
     */
    @Override
    public int updateVideoLib(Video video) {
        video.setUpdateTime(DateUtils.getNowDate());
        return videoMapper.updateVideoLib(video);
    }

    /**
     * 批量删除视频信息
     *
     * @param ids 需要删除的视频信息主键
     * @return 结果
     */
    @Override
    public int deleteVideoLibByIds(Long[] ids) {
        return videoMapper.deleteVideoLibByIds(ids);
    }

    /**
     * 删除视频信息信息
     *
     * @param id 视频信息主键
     * @return 结果
     */
    @Override
    public int deleteVideoLibById(Long id) {
        Video video = selectVideoLibById(id);
        FileUtils.deleteFile(video.getVideoUrl());
        FileUtils.deleteFile(video.getVideoThumbnailUrl());
        return videoMapper.deleteVideoLibById(id);
    }
}
