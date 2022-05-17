package cn.henry.resource.controller;

import cn.henry.common.annotation.Log;
import cn.henry.common.core.controller.BaseController;
import cn.henry.common.core.domain.Response;
import cn.henry.common.core.page.ResponsePageInfo;
import cn.henry.common.enums.BusinessType;
import cn.henry.resource.domain.dto.VideoDto;
import cn.henry.resource.domain.dto.VideoEditDto;
import cn.henry.resource.domain.vo.VideoListVo;
import cn.henry.resource.domain.vo.VideoVo;
import cn.henry.resource.service.IVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ws.schild.jave.EncoderException;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * 视频管理Controller
 *
 * @author henry
 * @date 2022-02-20
 */
@Api(tags = "视频管理")
@RestController
@RequestMapping("/resource/video")
public class VideoLibController extends BaseController {
    @Resource
    private IVideoService videoService;

    /**
     * 视频上传
     *
     * @return Response
     */
    @ApiOperation(value = "视频上传")
    @PreAuthorize("@ss.hasPermi('resource:video:add')")
    @Log(title = "视频上传", businessType = BusinessType.INSERT)
    @PostMapping("/upload")
    public Response upload(MultipartFile file) throws EncoderException, IOException {
        return videoService.handleVideoUpload(file);
    }

    /**
     * 获取视频列表
     */
    @ApiOperation(value = "获取视频列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", dataTypeClass = Integer.class, paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页数据量", dataTypeClass = Integer.class, paramType = "query", required = true),})
    @PreAuthorize("@ss.hasPermi('resource:video:list')")
    @GetMapping("/list")
    public ResponsePageInfo<VideoListVo> list(VideoDto videoDTO) {
        startPage();
        List<VideoListVo> list = videoService.selectVideoList(videoDTO);
        return toResponsePageInfo(list);
    }

    /**
     * 获取视频信息详细信息
     */
    @ApiOperation(value = "获取视频信息")
    @PreAuthorize("@ss.hasPermi('resource:video:query')")
    @GetMapping(value = "/{id}")
    public Response<VideoVo> getInfo(@PathVariable("id") Long id) {
        return Response.success(videoService.selectVideoById(id));
    }

    /**
     * 获取视频信息详细信息
     */
    @ApiOperation(value = "获取视频信息")
    @PreAuthorize("@ss.hasPermi('resource:video:query')")
    @GetMapping(value = "/infos/{ids}")
    public Response<List<VideoListVo>> getInfoByIds(@PathVariable Long[] ids) {
        return Response.success(videoService.selectVideoByIds(ids));
    }

    /**
     * 修改视频信息
     *
     * @param videoEditDto 视频信息
     */
    @ApiOperation(value = "修改视频信息")
    @PreAuthorize("@ss.hasPermi('resource:video:edit')")
    @Log(title = "视频信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public Response<Integer> edit(@RequestBody VideoEditDto videoEditDto) {
        return toResponse(videoService.updateVideo(videoEditDto));
    }

    /**
     * 删除视频
     */
    @ApiOperation(value = "删除视频信息")
    @PreAuthorize("@ss.hasPermi('resource:video:remove')")
    @Log(title = "视频信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public Response<Integer> remove(@PathVariable Long id) {
        return toResponse(videoService.deleteVideoById(id));
    }
}
