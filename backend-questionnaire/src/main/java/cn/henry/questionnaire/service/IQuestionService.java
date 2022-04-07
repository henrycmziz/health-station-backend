package cn.henry.questionnaire.service;

import cn.henry.questionnaire.domain.Question;
import cn.henry.questionnaire.domain.dto.QuestionDto;
import cn.henry.questionnaire.domain.vo.QuestionVo;

import java.util.List;

/**
 * 问卷问题Service接口
 *
 * @author henry
 * @date 2022-03-28
 */
public interface IQuestionService {
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
     * @param questionnaireId 问卷id
     * @return 问卷问题集合
     */
    List<QuestionVo> selectQuestionList(Long questionnaireId);

    /**
     * 新增/更新 问卷问题
     *
     * @param dto 问卷问题
     * @return 结果
     */
    int saveQuestion(QuestionDto dto);

    /**
     * 修改问卷问题
     *
     * @param question 问卷问题
     * @return 结果
     */
    int updateQuestion(Question question);

    /**
     * 批量删除问卷问题
     *
     * @param questionIds 需要删除的问卷问题主键集合
     * @return 结果
     */
    int deleteQuestionByQuestionIds(Long[] questionIds);

    /**
     * 删除问卷问题信息
     *
     * @param questionId 问卷问题主键
     * @return 结果
     */
    int deleteQuestionByQuestionId(Long questionId);
}
