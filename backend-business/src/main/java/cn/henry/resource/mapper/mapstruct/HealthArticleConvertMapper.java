package cn.henry.resource.mapper.mapstruct;

import cn.henry.resource.domain.HealthArticle;
import cn.henry.resource.domain.vo.HealthArticleListVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Henry
 * @date 2022-02-28 12:17
 **/
@Mapper
public interface HealthArticleConvertMapper {
    HealthArticleConvertMapper INSTANCE = Mappers.getMapper(HealthArticleConvertMapper.class);

    /**
     * HealthArticle 转 HealthArticleListVo
     *
     * @param article article
     * @return HealthArticleListVo
     */
    HealthArticleListVo healthArticleToHealthArticleListVo(HealthArticle article);

    /**
     * List<HealthArticle> 转 List<HealthArticleListVo>
     *
     * @param articleList articleList
     * @return List<HealthArticleListVo>
     */
    List<HealthArticleListVo> healthArticleToHealthArticleListVo(List<HealthArticle> articleList);
}
