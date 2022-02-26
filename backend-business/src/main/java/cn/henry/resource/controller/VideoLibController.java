package cn.henry.resource.controller;

import cn.henry.common.annotation.Log;
import cn.henry.common.config.BackendConfig;
import cn.henry.common.core.controller.BaseController;
import cn.henry.common.core.domain.AjaxResult;
import cn.henry.common.core.domain.FileInfo;
import cn.henry.common.core.page.TableDataInfo;
import cn.henry.common.enums.BusinessType;
import cn.henry.common.utils.file.FileUploadUtils;
import cn.henry.common.utils.file.FileUtils;
import cn.henry.common.utils.file.VideoJave2Utils;
import cn.henry.common.utils.poi.ExcelUtil;
import cn.henry.resource.domain.Video;
import cn.henry.resource.service.IVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ws.schild.jave.EncoderException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 视频信息Controller
 *
 * @author henry
 * @date 2022-02-20
 */
@Api(tags = "视频相关")
@RestController
@RequestMapping("/resource/video")
public class VideoLibController extends BaseController {
    @Autowired
    private IVideoService videoLibService;

    /**
     * 视频上传
     */
    @ApiOperation(value = "视频上传")
    @PreAuthorize("@ss.hasPermi('resource:video:add')")
    @Log(title = "视频上传", businessType = BusinessType.INSERT)
    @PostMapping("/upload")
    public AjaxResult upload(MultipartFile file) throws IOException, EncoderException {
        if (!file.isEmpty() && VideoJave2Utils.checkIsVideo(file.getOriginalFilename())) {
            // 视频上传
            FileInfo fileInfo = FileUploadUtils.upload(BackendConfig.getVideoPath(), file);
            // 生成缩略图
            String videoThumbnailUrl = VideoJave2Utils.generateVideoScreenImage(FileUtils.pathFileNameToRealPath(fileInfo.getPathFileName()));
            // 获取时长
            String duration = VideoJave2Utils.getVideoDuration(FileUtils.pathFileNameToRealPath(fileInfo.getPathFileName()));
            Video video = new Video(fileInfo.getPathFileName(), fileInfo.getExtendType(),
                    fileInfo.getShowFileName(), FileUtils.realPathToPathFileName(videoThumbnailUrl), duration, getUsername());
            if (videoLibService.insertVideoLib(video)) {
                return AjaxResult.success();
            }
        }
        return AjaxResult.error("上传视频异常，请联系管理员");
    }

    /**
     * 查询视频信息列表
     */
    @PreAuthorize("@ss.hasPermi('resource:video:list')")
    @GetMapping("/list")
    public TableDataInfo list(Video video) {
        startPage();
        List<Video> list = videoLibService.selectVideoLibList(video);
        return getDataTable(list);
    }

    /**
     * 导出视频信息列表
     */
    @PreAuthorize("@ss.hasPermi('resource:video:export')")
    @Log(title = "视频信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Video video) {
        List<Video> list = videoLibService.selectVideoLibList(video);
        ExcelUtil<Video> util = new ExcelUtil<>(Video.class);
        util.exportExcel(response, list, "视频信息数据");
    }

    /**
     * 获取视频信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('resource:video:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(videoLibService.selectVideoLibById(id));
    }

    /**
     * 修改视频信息
     */
    @PreAuthorize("@ss.hasPermi('resource:video:edit')")
    @Log(title = "视频信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Video video) {
        return toAjax(videoLibService.updateVideoLib(video));
    }

    /**
     * 删除视频信息
     */
    @PreAuthorize("@ss.hasPermi('resource:video:remove')")
    @Log(title = "视频信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable Long id) {
        return toAjax(videoLibService.deleteVideoLibById(id));
    }
}
