package cn.henry.questionnaire.domain;

import cn.henry.common.annotation.Excel;
import cn.henry.common.core.domain.BaseEntity;
import cn.henry.questionnaire.enums.QuestionnaireStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

/**
 * 问卷概要对象 biz_wj_questionnaire
 *
 * @author henry
 * @date 2022-03-28
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Questionnaire", description = "问卷概要")
public class Questionnaire extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 问卷ID
     */
    private Long questionnaireId;

    /**
     * 问卷标题
     */
    @Excel(name = "问卷标题")
    @ApiModelProperty(value = "问卷标题")
    private String title;

    /**
     * 问卷描述
     */
    @Excel(name = "问卷描述")
    @ApiModelProperty(value = "问卷描述")
    private String description;

    /**
     * 开放时间
     */
    @Excel(name = "开放时间")
    @ApiModelProperty(value = "开放时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 关闭时间
     */
    @Excel(name = "关闭时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "关闭时间")
    private Date endTime;

    /**
     * 填充数字
     */
    @Excel(name = "填充数字")
    @ApiModelProperty(value = "填充数字")
    private Long fillCount;

    /**
     * 状态
     */
    @Excel(name = "状态")
    @ApiModelProperty(value = "状态")
    private QuestionnaireStatus status;
}
