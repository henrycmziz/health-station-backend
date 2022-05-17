package cn.henry.resource.domain;

import cn.henry.common.annotation.Excel;
import cn.henry.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 患者康复模型对象 biz_rehabilitation_model
 *
 * @author henry
 * @date 2022-04-25
 */
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel(value = "RehabilitationModel", description = "患者康复模型")
public class RehabilitationModel extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 模型名称
     */
    @Excel(name = "模型名称")
    @ApiModelProperty(value = "模型名称")
    private String modelName;

    /**
     * 模型说明
     */
    @Excel(name = "模型说明")
    @ApiModelProperty(value = "模型说明")
    private String modelRemark;

    /**
     * 模型文章id集合，eg: 1,2,3
     */
    @Excel(name = "模型文章id集合，eg: 1,2,3")
    @ApiModelProperty(value = "模型文章id集合，eg: 1,2,3")
    private String modelArticleIds;

    /**
     * 模型包含视频id集合，eg: 1,2,3
     */
    @Excel(name = "模型包含视频id集合，eg: 1,2,3")
    @ApiModelProperty(value = "模型包含视频id集合，eg: 1,2,3")
    private String modelVideoIds;

    /**
     * 模型状态（默认1正常，0停用）
     */
    @Excel(name = "模型状态", readConverterExp = "默认1正常，0停用")
    @ApiModelProperty(value = "模型状态")
    private Byte modelStatus;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;
}
