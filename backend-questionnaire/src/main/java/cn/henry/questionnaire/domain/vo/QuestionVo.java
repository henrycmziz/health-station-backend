package cn.henry.questionnaire.domain.vo;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 问卷问题VO
 *
 * @author henry
 * @date 2022-03-28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "QuestionVo", description = "问卷问题 VO")
public class QuestionVo {
    /**
     * 问题id
     */
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
     * 问题标题
     */
    @ApiModelProperty(value = "问题标题")
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
}
