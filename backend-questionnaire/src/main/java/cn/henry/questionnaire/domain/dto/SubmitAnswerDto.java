package cn.henry.questionnaire.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 提交答案DTO
 *
 * @author Henry
 * @date 2022-04-03 16:06
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "SubmitAnswerDto", description = "提交答案DTO")
public class SubmitAnswerDto {
    /**
     * 填写人ID
     */
    @ApiModelProperty(value = "填写人ID")
    private Long uid;

    /**
     * 问卷ID
     */
    @ApiModelProperty(value = "问卷ID")
    private Long questionnaireId;

    /**
     * 问卷ID
     */
    @ApiModelProperty(value = "问卷ID")
    private AnswerDto[] answerList;
}
