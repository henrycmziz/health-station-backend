package cn.henry.resource.service;

import cn.henry.resource.domain.HealthArticle;
import cn.henry.resource.domain.WangEditorResponseBody;
import cn.henry.resource.domain.vo.HealthArticleListVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 健康小知识Service接口
 *
 * @author henry
 * @date 2022-03-04
 */
public interface IHealthArticleService {
    /**
     * 上传处理
     *
     * @param file 文件
     * @return Response
     */
    WangEditorResponseBody handleUpload(MultipartFile file);

    /**
     * 查询健康小知识
     *
     * @param id 健康小知识主键
     * @return 健康小知识
     */
    HealthArticle selectHealthArticleById(Long id);

    /**
     * 查询健康小知识列表
     *
     * @param healthArticle 健康小知识
     * @return 健康小知识列表
     */
    List<HealthArticle> selectHealthArticleList(HealthArticle healthArticle);

    /**
     * app-查询健康小知识列表
     *
     * @param healthArticle 健康小知识
     * @return 健康小知识列表
     */
    List<HealthArticleListVo> selectAppHealthArticleList(HealthArticle healthArticle);

    /**
     * 新增健康小知识
     *
     * @param healthArticle 健康小知识
     * @return 结果
     */
    int insertHealthArticle(HealthArticle healthArticle);

    /**
     * 修改健康小知识
     *
     * @param healthArticle 健康小知识
     * @return 结果
     */
    int updateHealthArticle(HealthArticle healthArticle);

    /**
     * 批量删除健康小知识
     *
     * @param ids 需要删除的健康小知识主键集合
     * @return 结果
     */
    int deleteHealthArticleByIds(Long[] ids);

    /**
     * 删除健康小知识信息
     *
     * @param id 健康小知识主键
     * @return 结果
     */
    int deleteHealthArticleById(Long id);
}
