package cn.henry.resource.controller;

import cn.henry.common.annotation.Log;
import cn.henry.common.core.controller.BaseController;
import cn.henry.common.core.domain.Response;
import cn.henry.common.core.page.ResponsePageInfo;
import cn.henry.common.enums.BusinessType;
import cn.henry.resource.domain.HealthArticle;
import cn.henry.resource.domain.WangEditorResponseBody;
import cn.henry.resource.domain.vo.HealthArticleListVo;
import cn.henry.resource.service.IHealthArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * 健康小知识Controller
 *
 * @author henry
 * @date 2022-03-04
 */
@Api(tags = "健康小知识管理")
@RestController
@RequestMapping("/resource/article")
public class HealthArticleController extends BaseController {
    @Resource
    private IHealthArticleService healthArticleService;

    /**
     * 图片上传
     *
     * @return Response
     */
    @ApiOperation(value = "视频上传")
    @Log(title = "图片上传", businessType = BusinessType.INSERT)
    @PostMapping("/upload")
    public WangEditorResponseBody upload(MultipartFile file) {
        return healthArticleService.handleUpload(file);
    }

    /**
     * 查询健康小知识列表
     */
    @ApiOperation(value = "列表")
    @PreAuthorize("@ss.hasPermi('resource:article:list')")
    @GetMapping("/list")
    public ResponsePageInfo<HealthArticle> list(HealthArticle healthArticle) {
        startPage();
        List<HealthArticle> list = healthArticleService.selectHealthArticleList(healthArticle);
        return toResponsePageInfo(list);
    }

    /**
     * app-查询健康小知识列表
     */
    @ApiOperation(value = "app-列表")
    @PreAuthorize("@ss.hasPermi('resource:article:list')")
    @GetMapping("/app-list")
    public ResponsePageInfo<HealthArticleListVo> appList(HealthArticle healthArticle) {
        startPage();
        List<HealthArticleListVo> list = healthArticleService.selectAppHealthArticleList(healthArticle);
        return toResponsePageInfo(list);
    }

    ///**
    // * 导出健康小知识列表
    // */
    //@PreAuthorize("@ss.hasPermi('resource:article:export')")
    //@Log(title = "健康小知识", businessType = BusinessType.EXPORT)
    //@PostMapping("/export")
    //public void export(HttpServletResponse response, HealthArticle healthArticle) {
    //    List<HealthArticle> list = healthArticleService.selectHealthArticleList(healthArticle);
    //    ExcelUtil<HealthArticle> util = new ExcelUtil<HealthArticle>(HealthArticle.class);
    //    util.exportExcel(response, list, "健康小知识数据");
    //}

    /**
     * 获取健康小知识详细信息
     */
    @PreAuthorize("@ss.hasPermi('resource:article:query')")
    @GetMapping(value = "/{id}")
    public Response<HealthArticle> getInfo(@PathVariable("id") Long id) {
        return Response.success(healthArticleService.selectHealthArticleById(id));
    }

    /**
     * 新增健康小知识
     */
    @PreAuthorize("@ss.hasPermi('resource:article:add')")
    @Log(title = "健康小知识", businessType = BusinessType.INSERT)
    @PostMapping
    public Response<Integer> add(@RequestBody HealthArticle healthArticle) {
        healthArticle.setCreateBy(getUsername());
        return toResponse(healthArticleService.insertHealthArticle(healthArticle));
    }

    /**
     * 修改健康小知识
     */
    @PreAuthorize("@ss.hasPermi('resource:article:edit')")
    @Log(title = "健康小知识", businessType = BusinessType.UPDATE)
    @PutMapping
    public Response<Integer> edit(@RequestBody HealthArticle healthArticle) {
        healthArticle.setUpdateBy(getUsername());
        return toResponse(healthArticleService.updateHealthArticle(healthArticle));
    }

    /**
     * 状态修改
     */
    @PreAuthorize("@ss.hasPermi('resource:article:edit')")
    @Log(title = "健康小知识", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public Response<Integer> changeStatus(@RequestBody HealthArticle healthArticle) {
        healthArticle.setUpdateBy(getUsername());
        return toResponse(healthArticleService.updateHealthArticle(healthArticle));
    }

    /**
     * 删除健康小知识
     */
    @PreAuthorize("@ss.hasPermi('resource:article:remove')")
    @Log(title = "健康小知识", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public Response<Integer> remove(@PathVariable Long[] ids) {
        return toResponse(healthArticleService.deleteHealthArticleByIds(ids));
    }
}
