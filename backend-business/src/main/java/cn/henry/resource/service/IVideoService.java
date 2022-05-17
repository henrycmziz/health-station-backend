package cn.henry.resource.service;

import cn.henry.common.core.domain.Response;
import cn.henry.resource.domain.Video;
import cn.henry.resource.domain.dto.VideoDto;
import cn.henry.resource.domain.dto.VideoEditDto;
import cn.henry.resource.domain.vo.VideoListVo;
import cn.henry.resource.domain.vo.VideoVo;
import org.springframework.web.multipart.MultipartFile;
import ws.schild.jave.EncoderException;

import java.io.IOException;
import java.util.List;

/**
 * 视频信息Service接口
 *
 * @author henry
 * @date 2022-02-20
 */
public interface IVideoService {
    /**
     * 视频上传处理
     *
     * @param file 文件
     * @return Response
     * @throws EncoderException 编码器异常
     * @throws IOException      IO 异常
     */
    Response handleVideoUpload(MultipartFile file) throws EncoderException, IOException;

    /**
     * 查询视频信息
     *
     * @param id 视频信息主键
     * @return 视频信息
     */
    VideoVo selectVideoById(Long id);

    /**
     * 查询多个视频信息
     *
     * @param ids 视频信息主键数组
     * @return 视频信息列表
     */
    List<VideoListVo> selectVideoByIds(Long[] ids);

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
