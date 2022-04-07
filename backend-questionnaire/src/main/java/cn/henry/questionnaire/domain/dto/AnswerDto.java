package cn.henry.questionnaire.domain.dto;

import cn.henry.questionnaire.enums.QuestionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 问卷答案DTO
 *
 * @author henry
 * @date 2022-03-28
 */
@Data
@ApiModel(value = "AnswerDto", description = "问卷答案DTO")
public class AnswerDto {
    /**
     * 问题ID
     */
    @ApiModelProperty(value = "问题ID")
    private Long questionId;

    /**
     * 问题类型
     */
    @ApiModelProperty(value = "问题类型")
    private QuestionType questionType;

    /**
     * 问卷ID
     */
    @ApiModelProperty(value = "问卷ID")
    private Long questionnaireId;

    /**
     * 答题人ID
     */
    @ApiModelProperty(value = "答题人ID", hidden = true)
    private Long userId;

    /**
     * 单选答案
     */
    @ApiModelProperty(value = "单选答案")
    private String answerSingleCheck;

    /**
     * 多选答案
     */
    @ApiModelProperty(value = "多选答案")
    private String[] answerMultiCheck;

    /**
     * 文字答案
     */
    @ApiModelProperty(value = "文字答案")
    private String answerText;

    /**
     * 数字答案
     */
    @ApiModelProperty(value = "数字答案")
    private Long answerNumber;

    /**
     * 评分答案
     */
    @ApiModelProperty(value = "评分答案")
    private Byte answerGrade;

    /**
     * 日期答案
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "日期答案")
    private Date answerDate;

    /**
     * 填充时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "填充时间")
    private Date fillTime;
}
