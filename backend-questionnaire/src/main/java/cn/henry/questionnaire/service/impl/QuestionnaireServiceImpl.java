package cn.henry.questionnaire.service.impl;

import cn.henry.common.utils.SecurityUtils;
import cn.henry.questionnaire.domain.Questionnaire;
import cn.henry.questionnaire.domain.dto.QuestionDto;
import cn.henry.questionnaire.domain.dto.QuestionnaireDto;
import cn.henry.questionnaire.enums.QuestionnaireStatus;
import cn.henry.questionnaire.mapper.QuestionMapper;
import cn.henry.questionnaire.mapper.QuestionnaireMapper;
import cn.henry.questionnaire.mapper.mapstruct.QuestionConvertMapper;
import cn.henry.questionnaire.service.IQuestionnaireService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 问卷Service业务层处理
 *
 * @author henry
 * @date 2022-03-28
 */
@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {
    @Resource
    private QuestionnaireMapper questionnaireMapper;
    @Resource
    private QuestionMapper questionMapper;

    /**
     * 查询问卷
     *
     * @param questionnaireId 问卷主键
     * @return 问卷
     */
    @Override
    public Questionnaire selectQuestionnaireByQuestionnaireId(Long questionnaireId) {
        return questionnaireMapper.selectQuestionnaireByQuestionnaireId(questionnaireId);
    }

    /**
     * 查询问卷列表
     *
     * @param questionnaire 问卷
     * @return 问卷
     */
    @Override
    public List<Questionnaire> selectQuestionnaireList(Questionnaire questionnaire) {
        return questionnaireMapper.selectQuestionnaireList(questionnaire);
    }

    /**
     * 新增问卷
     *
     * @param createBy 创建人用户名
     * @return 问卷id
     */
    @Override
    public Long insertQuestionnaire(String createBy) {
        Questionnaire questionnaire = Questionnaire.builder().status(QuestionnaireStatus.EDITING).build();
        questionnaire.setCreateBy(createBy);
        questionnaireMapper.insertQuestionnaire(questionnaire);
        return questionnaire.getQuestionnaireId();
    }

    /**
     * 修改问卷
     *
     * @param questionnaire 问卷
     * @return 结果
     */
    @Override
    public int updateQuestionnaire(Questionnaire questionnaire) {
        questionnaire.setUpdateBy(SecurityUtils.getUsername());
        return questionnaireMapper.updateQuestionnaire(questionnaire);
    }

    /**
     * 删除问卷信息
     *
     * @param questionnaireId 问卷主键
     * @return 结果
     */
    @Override
    public int deleteQuestionnaireByQuestionnaireId(Long questionnaireId) {
        questionMapper.deleteQuestionByQuestionnaireId(questionnaireId);
        return questionnaireMapper.deleteQuestionnaireByQuestionnaireId(questionnaireId);
    }

    /**
     * 批量删除问卷
     *
     * @param questionnaireIds 需要删除的问卷主键
     * @return 结果
     */
    @Override
    public int deleteQuestionnaireByQuestionnaireIds(Long[] questionnaireIds) {
        return questionnaireMapper.deleteQuestionnaireByQuestionnaireIds(questionnaireIds);
    }

    /**
     * 保存问卷
     *
     * @param dto dto
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveQuestionnaire(QuestionnaireDto dto) {
        for (QuestionDto question : dto.getQuestionList()) {
            questionMapper.saveQuestion(QuestionConvertMapper.INSTANCE.questionDtoToQuestion(question));
        }
        return updateQuestionnaire(dto.getQuestionnaire());
    }
}
