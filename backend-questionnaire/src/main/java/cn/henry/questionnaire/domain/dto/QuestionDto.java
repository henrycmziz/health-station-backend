package cn.henry.questionnaire.domain.dto;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * 问卷问题 DTO
 *
 * @author henry
 * @date 2022-03-28
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "QuestionDto", description = "问卷问题 DTO")
public class QuestionDto {
    /**
     * 问题id
     */
    @ApiModelProperty(hidden = true)
    private Long questionId;

    /**
     * 问题索引
     */
    @ApiModelProperty(value = "问题索引")
    private Integer questionIndex;

    /**
     * 所属问卷ID
     */
    @ApiModelProperty(value = "所属问卷ID")
    private Long questionnaireId;

    /**
     * 问题题目
     */
    @NotBlank(message = "问题题目不可为空哈")
    @ApiModelProperty(value = "问题题目")
    private String questionTitle;

    /**
     * 问题描述
     */
    @ApiModelProperty(value = "问题描述")
    private String questionDescription;

    /**
     * 问题类型
     */
    @ApiModelProperty(value = "问题类型")
    private String questionType;

    /**
     * 是否可空(默认1:可空, 0:不可空)
     */
    @ApiModelProperty(value = "是否可空(默认1:可空, 0:不可空)")
    private Boolean questionNullable;

    /**
     * 问题详细
     */
    @ApiModelProperty(value = "问题详细")
    private JSONObject details;

    /**
     * 创建者
     */
    @ApiModelProperty(hidden = true)
    private String createBy;

    /**
     * 更新者
     */
    @ApiModelProperty(hidden = true)
    private String updateBy;
}
