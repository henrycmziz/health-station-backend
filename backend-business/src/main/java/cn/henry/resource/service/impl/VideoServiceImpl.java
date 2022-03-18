package cn.henry.resource.service.impl;

import cn.henry.common.config.BackendConfig;
import cn.henry.common.core.domain.FileInfo;
import cn.henry.common.core.domain.Response;
import cn.henry.common.core.domain.ResponseEnum;
import cn.henry.common.utils.file.FileUploadUtils;
import cn.henry.common.utils.file.FileUtils;
import cn.henry.common.utils.file.VideoJave2Utils;
import cn.henry.resource.domain.Video;
import cn.henry.resource.domain.dto.VideoDto;
import cn.henry.resource.domain.dto.VideoEditDto;
import cn.henry.resource.domain.vo.VideoListVo;
import cn.henry.resource.domain.vo.VideoVo;
import cn.henry.resource.mapper.VideoMapper;
import cn.henry.resource.mapper.mapstruct.VideoConvertMapper;
import cn.henry.resource.service.IVideoService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ws.schild.jave.EncoderException;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

import static cn.henry.common.utils.SecurityUtils.getUsername;

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

    @Override
    public Response handleVideoUpload(MultipartFile file) throws EncoderException, IOException {
        if (!file.isEmpty() && VideoJave2Utils.checkIsVideo(file.getOriginalFilename())) {
            // 视频上传
            FileInfo fileInfo = FileUploadUtils.upload(BackendConfig.getVideoPath(), file);
            // 生成缩略图
            String videoThumbnailUrl = VideoJave2Utils.generateVideoScreenImage(FileUtils.pathFileNameToRealPath(fileInfo.getPathFileName()));
            // 获取时长
            String duration = VideoJave2Utils.getVideoDuration(FileUtils.pathFileNameToRealPath(fileInfo.getPathFileName()));
            Video video = Video.builder()
                    .videoUrl(fileInfo.getPathFileName())
                    .extendType(fileInfo.getExtendType())
                    .fileName(fileInfo.getShowFileName())
                    .videoThumbnailUrl(FileUtils.realPathToPathFileName(videoThumbnailUrl))
                    .videoDuration(duration)
                    .build();
            video.setCreateBy(getUsername());
            if (insertVideo(video)) {
                return Response.success();
            }
        }
        return Response.error(ResponseEnum.ABNORMAL_VIDEO_UPLOAD);
    }

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
