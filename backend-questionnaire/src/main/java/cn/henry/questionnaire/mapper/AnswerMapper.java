package cn.henry.questionnaire.mapper;

import cn.henry.questionnaire.domain.Answer;

import java.util.List;

/**
 * 问卷答案Mapper接口
 *
 * @author henry
 * @date 2022-03-28
 */
public interface AnswerMapper {
    /**
     * 查询问卷答案
     *
     * @param answerId 问卷答案主键
     * @return 问卷答案
     */
    Answer selectAnswerByAnswerId(Long answerId);

    /**
     * 查询问卷答案列表
     *
     * @param answer 问卷答案
     * @return 问卷答案集合
     */
    List<Answer> selectAnswerList(Answer answer);

    /**
     * 新增问卷答案
     *
     * @param answer 问卷答案
     * @return 结果
     */
    int insertAnswer(Answer answer);

    /**
     * 修改问卷答案
     *
     * @param answer 问卷答案
     * @return 结果
     */
    int updateAnswer(Answer answer);

    /**
     * 删除问卷答案
     *
     * @param answerId 问卷答案主键
     * @return 结果
     */
    int deleteAnswerByAnswerId(Long answerId);

    /**
     * 批量删除问卷答案
     *
     * @param answerIds 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAnswerByAnswerIds(Long[] answerIds);
}
