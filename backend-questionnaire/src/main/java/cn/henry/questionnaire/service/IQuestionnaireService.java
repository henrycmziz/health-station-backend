package cn.henry.questionnaire.service;

import cn.henry.questionnaire.domain.Questionnaire;
import cn.henry.questionnaire.domain.dto.QuestionnaireDto;

import java.util.List;

/**
 * 问卷Service接口
 *
 * @author henry
 * @date 2022-03-28
 */
public interface IQuestionnaireService {
    /**
     * 查询问卷
     *
     * @param questionnaireId 问卷主键
     * @return 问卷
     */
    Questionnaire selectQuestionnaireByQuestionnaireId(Long questionnaireId);

    /**
     * 查询问卷列表
     *
     * @param questionnaire 问卷
     * @return 问卷集合
     */
    List<Questionnaire> selectQuestionnaireList(Questionnaire questionnaire);

    /**
     * 新增问卷
     *
     * @param createBy 创建人用户名
     * @return 结果
     */
    Long insertQuestionnaire(String createBy);

    /**
     * 修改问卷
     *
     * @param questionnaire 问卷
     * @return 结果
     */
    int updateQuestionnaire(Questionnaire questionnaire);

    /**
     * 删除问卷信息
     *
     * @param questionnaireId 问卷主键
     * @return 结果
     */
    int deleteQuestionnaireByQuestionnaireId(Long questionnaireId);

    /**
     * 批量删除问卷
     *
     * @param questionnaireIds 需要删除的问卷主键集合
     * @return 结果
     */
    int deleteQuestionnaireByQuestionnaireIds(Long[] questionnaireIds);

    /**
     * 保存问卷
     *
     * @param dto dto
     * @return 结果
     */
    int saveQuestionnaire(QuestionnaireDto dto);
}
