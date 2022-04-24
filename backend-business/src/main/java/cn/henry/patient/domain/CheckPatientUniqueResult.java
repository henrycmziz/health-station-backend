package cn.henry.patient.domain;

import cn.henry.common.core.domain.AjaxResult;
import lombok.Builder;
import lombok.Data;

/**
 * 检查患者是否唯一 结果
 *
 * @author Henry
 * @date 2022-04-19 22:31
 **/
@Data
@Builder
public class CheckPatientUniqueResult {
    private boolean isTrue;
    private AjaxResult ajaxResult;
}
