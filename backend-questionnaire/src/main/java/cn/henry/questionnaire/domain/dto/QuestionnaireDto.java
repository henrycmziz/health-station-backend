package cn.henry.questionnaire.domain.dto;

import cn.henry.questionnaire.domain.Questionnaire;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 问卷DTO
 *
 * @author henry
 * @date 2022-03-28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "QuestionnaireDto", description = "问卷DTO")
public class QuestionnaireDto {
    /**
     * 问卷概要
     */
    @ApiModelProperty(value = "问卷概要")
    private Questionnaire questionnaire;

    /**
     * 题目
     */
    @ApiModelProperty(value = "题目")
    private QuestionDto[] questionList;
}
