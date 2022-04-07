package cn.henry.questionnaire.mapper;

import cn.henry.questionnaire.domain.Questionnaire;

import java.util.List;

/**
 * 问卷Mapper接口
 *
 * @author henry
 * @date 2022-03-28
 */
public interface QuestionnaireMapper {
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
     * @param questionnaire 问卷
     * @return 结果
     */
    int insertQuestionnaire(Questionnaire questionnaire);

    /**
     * 修改问卷
     *
     * @param questionnaire 问卷
     * @return 结果
     */
    int updateQuestionnaire(Questionnaire questionnaire);

    /**
     * 删除问卷
     *
     * @param questionnaireId 问卷主键
     * @return 结果
     */
    int deleteQuestionnaireByQuestionnaireId(Long questionnaireId);

    /**
     * 批量删除问卷
     *
     * @param questionnaireIds 需要删除的数据主键集合
     * @return 结果
     */
    int deleteQuestionnaireByQuestionnaireIds(Long[] questionnaireIds);

    /**
     * 问卷填充数+1
     *
     * @param questionnaireId 问卷ID
     * @return 结果
     */
    int addFillCount(Long questionnaireId);
}
