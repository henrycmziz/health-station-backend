package cn.henry.resource.domain;

import cn.henry.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 健康小知识对象 biz_health_article
 *
 * @author henry
 * @date 2022-03-04
 */
@Getter
@Setter
@ApiModel(value = "HealthArticle", description = "健康小知识")
public class HealthArticle extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 来源; 默认0:自建, 1:网络
     */
    @ApiModelProperty(value = "来源; 默认0:自建, 1:网络")
    private Byte articleFrom;

    /**
     * article_from=0时, 正文
     */
    @ApiModelProperty(value = "article_from=0时, 正文")
    private String article;

    /**
     * article_from=1时, 小知识url
     */
    @ApiModelProperty(value = "article_from=1时, 小知识url")
    private String articleUrl;

    /**
     * 缩略图
     */
    @ApiModelProperty(value = "缩略图")
    private String thumbnail;

    /**
     * 阅读量
     */
    @ApiModelProperty(value = "阅读量")
    private Long clicks;

    /**
     * 状态; 1:启用, 0:停用
     */
    @ApiModelProperty(value = "状态; 1:启用, 0:停用")
    private Byte status;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("articleFrom", getArticleFrom())
                .append("article", getArticle())
                .append("articleUrl", getArticleUrl())
                .append("thumbnail", getThumbnail())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
