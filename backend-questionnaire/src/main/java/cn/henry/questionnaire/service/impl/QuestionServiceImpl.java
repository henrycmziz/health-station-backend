package cn.henry.questionnaire.service.impl;

import cn.henry.questionnaire.domain.Question;
import cn.henry.questionnaire.domain.dto.QuestionDto;
import cn.henry.questionnaire.domain.vo.QuestionVo;
import cn.henry.questionnaire.mapper.QuestionMapper;
import cn.henry.questionnaire.mapper.mapstruct.QuestionConvertMapper;
import cn.henry.questionnaire.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 问卷问题Service业务层处理
 *
 * @author henry
 * @date 2022-03-28
 */
@Service
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    /**
     * 查询问卷问题
     *
     * @param questionId 问卷问题主键
     * @return 问卷问题
     */
    @Override
    public Question selectQuestionByQuestionId(Long questionId) {
        return questionMapper.selectQuestionByQuestionId(questionId);
    }

    /**
     * 查询问卷问题列表
     *
     * @param questionnaireId 问卷id
     * @return 问卷问题列表
     */
    @Override
    public List<QuestionVo> selectQuestionList(Long questionnaireId) {
        return QuestionConvertMapper.INSTANCE.questionToQuestionVo(
                questionMapper.selectQuestionList(Question.builder().questionnaireId(questionnaireId).build()));
    }

    /**
     * 新增/更新 问卷问题
     *
     * @param dto 问卷问题
     * @return 结果
     */
    @Override
    public int saveQuestion(QuestionDto dto) {
        return questionMapper.saveQuestion(QuestionConvertMapper.INSTANCE.questionDtoToQuestion(dto));
    }

    /**
     * 修改问卷问题
     *
     * @param question 问卷问题
     * @return 结果
     */
    @Override
    public int updateQuestion(Question question) {
        return questionMapper.updateQuestion(question);
    }

    /**
     * 批量删除问卷问题
     *
     * @param questionIds 需要删除的问卷问题主键
     * @return 结果
     */
    @Override
    public int deleteQuestionByQuestionIds(Long[] questionIds) {
        return questionMapper.deleteQuestionByQuestionIds(questionIds);
    }

    /**
     * 删除问卷问题信息
     *
     * @param questionId 问卷问题主键
     * @return 结果
     */
    @Override
    public int deleteQuestionByQuestionId(Long questionId) {
        return questionMapper.deleteQuestionByQuestionId(questionId);
    }
}
