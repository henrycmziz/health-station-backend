package cn.henry.questionnaire.domain;

import cn.henry.common.annotation.Excel;
import cn.henry.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 问卷问题对象 biz_wj_question
 *
 * @author henry
 * @date 2022-03-28
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Question", description = "问卷问题")
public class Question extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 问题id
     */
    private Long questionId;

    /**
     * 所属问卷ID
     */
    @Excel(name = "所属问卷ID")
    @ApiModelProperty(value = "所属问卷ID")
    private Long questionnaireId;

    /**
     * 问题索引
     */
    @ApiModelProperty(value = "问题索引")
    private Integer questionIndex;

    /**
     * 问题标题
     */
    @Excel(name = "问题标题")
    @ApiModelProperty(value = "问题标题")
    private String questionTitle;

    /**
     * 问题描述
     */
    @Excel(name = "问题描述")
    @ApiModelProperty(value = "问题描述")
    private String questionDescription;

    /**
     * 问题类型
     */
    @Excel(name = "问题类型")
    @ApiModelProperty(value = "问题类型")
    private String questionType;

    /**
     * 是否可空(默认1:可空, 0:不可空)
     */
    @Excel(name = "是否可空(默认1:可空, 0:不可空)")
    @ApiModelProperty(value = "是否可空(默认1:可空, 0:不可空)")
    private Boolean questionNullable;

    /**
     * 问题详细
     */
    @Excel(name = "问题详细")
    @ApiModelProperty(value = "问题详细")
    private String details;
}
