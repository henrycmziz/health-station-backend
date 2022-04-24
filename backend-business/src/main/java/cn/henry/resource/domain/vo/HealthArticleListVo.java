package cn.henry.resource.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 健康小知识列表Vo
 *
 * @author henry
 * @date 2022-03-04
 */
@Data
@ApiModel(value = "HealthArticleListVo", description = "健康小知识列表Vo")
public class HealthArticleListVo {
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
     * article_from=1时, 小知识url
     */
    @ApiModelProperty(value = "article_from=1时, 小知识url")
    private String articleUrl;

    /**
     * 阅读量
     */
    @ApiModelProperty(value = "阅读量")
    private Long clicks;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
