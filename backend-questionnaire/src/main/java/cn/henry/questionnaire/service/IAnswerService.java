package cn.henry.questionnaire.service;

import cn.henry.questionnaire.domain.Answer;
import cn.henry.questionnaire.domain.dto.SubmitAnswerDto;

import java.util.List;
import java.util.Map;

/**
 * 问卷答案Service接口
 *
 * @author henry
 * @date 2022-03-28
 */
public interface IAnswerService {
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
     * 批量删除问卷答案
     *
     * @param answerIds 需要删除的问卷答案主键集合
     * @return 结果
     */
    int deleteAnswerByAnswerIds(Long[] answerIds);

    /**
     * 删除问卷答案信息
     *
     * @param answerId 问卷答案主键
     * @return 结果
     */
    int deleteAnswerByAnswerId(Long answerId);

    /**
     * 提交答案
     *
     * @param dto 提交内容
     * @return 结果
     */
    int submitAnswer(SubmitAnswerDto dto);

    /**
     * 问卷分析
     *
     * @param answer 条件
     * @return 结果
     */
    Map<String, String> analysis(Answer answer);
}
