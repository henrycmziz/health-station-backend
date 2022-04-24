package cn.henry.resource.service.impl;

import cn.henry.common.config.BackendConfig;
import cn.henry.common.core.domain.FileInfo;
import cn.henry.common.core.domain.ResponseEnum;
import cn.henry.common.utils.file.FileUploadUtils;
import cn.henry.framework.config.ServerConfig;
import cn.henry.resource.domain.HealthArticle;
import cn.henry.resource.domain.WangEditorResponseBody;
import cn.henry.resource.domain.vo.HealthArticleListVo;
import cn.henry.resource.mapper.HealthArticleMapper;
import cn.henry.resource.service.IHealthArticleService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 健康小知识Service业务层处理
 *
 * @author henry
 * @date 2022-03-04
 */
@Service
public class HealthArticleServiceImpl implements IHealthArticleService {
    @Resource
    private HealthArticleMapper healthArticleMapper;
    @Resource
    private ServerConfig serverConfig;

    @Override
    public WangEditorResponseBody handleUpload(MultipartFile file) {
        FileInfo fileInfo = null;
        if (!file.isEmpty()) {
            // 文件上传
            try {
                fileInfo = FileUploadUtils.upload(BackendConfig.getArticleResourcePath(), file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (fileInfo != null) {
                Map<String, String> data = new HashMap<>(1);
                data.put("url", serverConfig.getUrl() + fileInfo.getPathFileName());
                return WangEditorResponseBody.builder().errno(0).data(data).build();
            }
        }
        return WangEditorResponseBody.builder().errno(1).message(ResponseEnum.ABNORMAL_PICTURE_UPLOAD.getMessage()).build();
    }

    /**
     * 查询健康小知识
     *
     * @param id 健康小知识主键
     * @return 健康小知识
     */
    @Override
    public HealthArticle selectHealthArticleById(Long id) {
        healthArticleMapper.updateClicks(id);
        return healthArticleMapper.selectHealthArticleById(id);
    }

    /**
     * 查询健康小知识列表
     *
     * @param healthArticle 健康小知识
     * @return 健康小知识列表
     */
    @Override
    public List<HealthArticle> selectHealthArticleList(HealthArticle healthArticle) {
        return healthArticleMapper.selectHealthArticleList(healthArticle);
    }

    /**
     * app-查询健康小知识列表
     *
     * @param healthArticle 健康小知识
     * @return 健康小知识列表
     */
    @Override
    public List<HealthArticleListVo> selectAppHealthArticleList(HealthArticle healthArticle) {
        return healthArticleMapper.selectAppHealthArticleList(healthArticle);
    }

    /**
     * 新增健康小知识
     *
     * @param healthArticle 健康小知识
     * @return 结果
     */
    @Override
    public int insertHealthArticle(HealthArticle healthArticle) {
        return healthArticleMapper.insertHealthArticle(healthArticle);
    }

    /**
     * 修改健康小知识
     *
     * @param healthArticle 健康小知识
     * @return 结果
     */
    @Override
    public int updateHealthArticle(HealthArticle healthArticle) {
        return healthArticleMapper.updateHealthArticle(healthArticle);
    }

    /**
     * 批量删除健康小知识
     *
     * @param ids 需要删除的健康小知识主键
     * @return 结果
     */
    @Override
    public int deleteHealthArticleByIds(Long[] ids) {
        return healthArticleMapper.deleteHealthArticleByIds(ids);
    }

    /**
     * 删除健康小知识信息
     *
     * @param id 健康小知识主键
     * @return 结果
     */
    @Override
    public int deleteHealthArticleById(Long id) {
        return healthArticleMapper.deleteHealthArticleById(id);
    }
}
