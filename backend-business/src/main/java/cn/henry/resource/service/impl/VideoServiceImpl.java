package cn.henry.resource.service.impl;

import cn.henry.common.utils.file.FileUtils;
import cn.henry.resource.domain.Video;
import cn.henry.resource.domain.dto.VideoDto;
import cn.henry.resource.domain.dto.VideoEditDto;
import cn.henry.resource.domain.vo.VideoListVo;
import cn.henry.resource.domain.vo.VideoVo;
import cn.henry.resource.mapper.VideoMapper;
import cn.henry.resource.mapper.mapstruct.VideoConvertMapper;
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
    public VideoVo selectVideoById(Long id) {
        return VideoConvertMapper.INSTANCE.videoToVideoVo(videoMapper.selectVideoById(id));
    }

    /**
     * 查询视频信息列表
     *
     * @param videoDTO 视频信息
     * @return 视频信息
     */
    @Override
    public List<VideoListVo> selectVideoList(VideoDto videoDTO) {
        return VideoConvertMapper.INSTANCE.videoToVideoListVo(videoMapper.selectVideoList(videoDTO));
    }

    /**
     * 新增视频信息
     *
     * @param video 视频信息
     * @return 结果
     */
    @Override
    public boolean insertVideo(Video video) {
        return videoMapper.insertVideo(video) > 0;
    }

    /**
     * 修改视频信息
     *
     * @param videoEditDto 视频信息
     * @return 结果
     */
    @Override
    public int updateVideo(VideoEditDto videoEditDto) {
        return videoMapper.updateVideo(videoEditDto);
    }

    /**
     * 删除视频信息信息
     *
     * @param id 视频信息主键
     * @return 结果
     */
    @Override
    public int deleteVideoById(Long id) {
        VideoVo video = selectVideoById(id);
        FileUtils.deleteFile(video.getVideoUrl());
        FileUtils.deleteFile(video.getVideoThumbnailUrl());
        return videoMapper.deleteVideoById(id);
    }
}
