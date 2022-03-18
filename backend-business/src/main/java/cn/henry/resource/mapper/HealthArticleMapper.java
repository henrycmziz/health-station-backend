package cn.henry.resource.mapper;

import cn.henry.resource.domain.HealthArticle;

import java.util.List;

/**
 * 健康小知识Mapper接口
 *
 * @author henry
 * @date 2022-03-04
 */
public interface HealthArticleMapper {
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
     * @return 健康小知识集合
     */
    List<HealthArticle> selectHealthArticleList(HealthArticle healthArticle);

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
     * 删除健康小知识
     *
     * @param id 健康小知识主键
     * @return 结果
     */
    int deleteHealthArticleById(Long id);

    /**
     * 批量删除健康小知识
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteHealthArticleByIds(Long[] ids);
}
