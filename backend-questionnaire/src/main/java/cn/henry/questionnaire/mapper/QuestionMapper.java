package cn.henry.questionnaire.mapper;

import cn.henry.questionnaire.domain.Question;

import java.util.List;

/**
 * 问卷问题Mapper接口
 *
 * @author henry
 * @date 2022-03-28
 */
public interface QuestionMapper {
    /**
     * 查询问卷问题
     *
     * @param questionId 问卷问题主键
     * @return 问卷问题
     */
    Question selectQuestionByQuestionId(Long questionId);

    /**
     * 查询问卷问题列表
     *
     * @param question 问卷问题
     * @return 问卷问题集合
     */
    List<Question> selectQuestionList(Question question);

    /**
     * 新增问卷问题
     *
     * @param question 问卷问题
     * @return 结果
     */
    int saveQuestion(Question question);

    /**
     * 修改问卷问题
     *
     * @param question 问卷问题
     * @return 结果
     */
    int updateQuestion(Question question);

    /**
     * 删除问卷问题
     *
     * @param questionId 问卷问题主键
     * @return 结果
     */
    int deleteQuestionByQuestionId(Long questionId);

    /**
     * 批量删除问卷问题
     *
     * @param questionIds 需要删除的数据主键集合
     * @return 结果
     */
    int deleteQuestionByQuestionIds(Long[] questionIds);

    /**
     * 删除某问卷下的所有问题
     *
     * @param questionnaireId 问卷id
     */
    void deleteQuestionByQuestionnaireId(Long questionnaireId);
}
