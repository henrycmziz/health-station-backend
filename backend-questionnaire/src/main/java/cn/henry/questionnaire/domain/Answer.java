package cn.henry.questionnaire.domain;

import cn.henry.common.annotation.Excel;
import cn.henry.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 问卷答案对象 biz_wj_answer
 *
 * @author henry
 * @date 2022-03-28
 */
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel(value = "Answer", description = "问卷答案")
public class Answer extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 答案ID
     */
    private Long answerId;

    /**
     * 问题ID
     */
    @Excel(name = "问题ID")
    @ApiModelProperty(value = "问题ID")
    private Long questionId;

    /**
     * 问题类型
     */
    @Excel(name = "问题类型")
    @ApiModelProperty(value = "问题类型")
    private String questionType;

    /**
     * 问卷ID
     */
    @Excel(name = "问卷ID")
    @ApiModelProperty(value = "问卷ID")
    private Long questionnaireId;

    /**
     * 答题人ID
     */
    @Excel(name = "答题人ID")
    @ApiModelProperty(value = "答题人ID")
    private Long userId;

    /**
     * 答案值
     */
    @Excel(name = "答案值")
    @ApiModelProperty(value = "答案值")
    private String writeValue;

    /**
     * 填充时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "填充时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "填充时间")
    private Date fillTime;
}
