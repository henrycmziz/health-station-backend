package cn.henry.questionnaire.service.impl;

import cn.henry.questionnaire.domain.Answer;
import cn.henry.questionnaire.domain.Question;
import cn.henry.questionnaire.domain.dto.AnswerDto;
import cn.henry.questionnaire.domain.dto.SubmitAnswerDto;
import cn.henry.questionnaire.enums.QuestionType;
import cn.henry.questionnaire.mapper.AnswerMapper;
import cn.henry.questionnaire.mapper.QuestionMapper;
import cn.henry.questionnaire.mapper.QuestionnaireMapper;
import cn.henry.questionnaire.mapper.mapstruct.AnswerConvertMapper;
import cn.henry.questionnaire.service.IAnswerService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 问卷答案Service业务层处理
 *
 * @author henry
 * @date 2022-03-28
 */
@Slf4j
@Service
public class AnswerServiceImpl implements IAnswerService {
    @Resource
    private AnswerMapper answerMapper;

    @Resource
    private QuestionnaireMapper questionnaireMapper;

    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private Gson gson;

    private static final String QUESTION_OPTIONS = "questionOptions";
    private static final String MAX_VALUE = "最大值";
    private static final String MIN_VALUE = "最小值";
    private static final String AVERAGE_VALUE = "平均值";
    private static final String MEDIAN = "中位数";

    /**
     * 查询问卷答案
     *
     * @param answerId 问卷答案主键
     * @return 问卷答案
     */
    @Override
    public Answer selectAnswerByAnswerId(Long answerId) {
        return answerMapper.selectAnswerByAnswerId(answerId);
    }

    /**
     * 查询问卷答案列表
     *
     * @param answer 问卷答案
     * @return 问卷答案
     */
    @Override
    public List<Answer> selectAnswerList(Answer answer) {
        return answerMapper.selectAnswerList(answer);
    }

    /**
     * 新增问卷答案
     *
     * @param answer 问卷答案
     * @return 结果
     */
    @Override
    public int insertAnswer(Answer answer) {
        return answerMapper.insertAnswer(answer);
    }

    /**
     * 修改问卷答案
     *
     * @param answer 问卷答案
     * @return 结果
     */
    @Override
    public int updateAnswer(Answer answer) {
        return answerMapper.updateAnswer(answer);
    }

    /**
     * 批量删除问卷答案
     *
     * @param answerIds 需要删除的问卷答案主键
     * @return 结果
     */
    @Override
    public int deleteAnswerByAnswerIds(Long[] answerIds) {
        return answerMapper.deleteAnswerByAnswerIds(answerIds);
    }

    /**
     * 删除问卷答案信息
     *
     * @param answerId 问卷答案主键
     * @return 结果
     */
    @Override
    public int deleteAnswerByAnswerId(Long answerId) {
        return answerMapper.deleteAnswerByAnswerId(answerId);
    }

    /**
     * 提交答案
     *
     * @param dto 提交内容
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int submitAnswer(SubmitAnswerDto dto) {
        Date fillTime = new Date();
        for (AnswerDto answerDto : dto.getAnswerList()) {
            //answerDto.setUserId(SecurityUtils.getUserId());
            answerDto.setUserId(dto.getUid());
            answerDto.setFillTime(fillTime);
            answerMapper.insertAnswer(AnswerConvertMapper.INSTANCE.answerDtoToAnswer(answerDto));
        }
        return questionnaireMapper.addFillCount(dto.getQuestionnaireId());
    }

    /**
     * 问卷分析
     *
     * @param answer 条件
     * @return 结果
     */
    @Override
    public Map<String, String> analysis(Answer answer) {
        List<Answer> answerList = answerMapper.selectAnswerList(answer);
        Question question = questionMapper.selectQuestionByQuestionId(answer.getQuestionId());

        switch (QuestionType.fromString(question.getQuestionType())) {
            case SINGLE_CHECK:
                Map<String, String> resValueMap = genResValueMap(question.getDetails());
                for (Answer oneAnswer : answerList) {
                    String value = oneAnswer.getWriteValue();
                    int oldCount = Integer.parseInt(resValueMap.get(value));
                    resValueMap.put(value, String.valueOf(oldCount + 1));
                }
                return resValueMap;
            case MULTI_CHECK:
                Map<String, String> resValueMap1 = genResValueMap(question.getDetails());
                for (Answer oneAnswer : answerList) {
                    JsonArray valueList = gson.fromJson(oneAnswer.getWriteValue(), JsonArray.class);
                    for (JsonElement value : valueList) {
                        int oldCount = Integer.parseInt(resValueMap1.get(value.getAsString()));
                        resValueMap1.put(value.getAsString(), String.valueOf(oldCount + 1));
                    }
                }
                return resValueMap1;
            case NUMBER:
            case GRADE:
                Map<String, String> resDoubleValueMap = new HashMap<>(4);
                List<Double> valueList = new ArrayList<>();
                Double sum = 0.0;
                for (Answer oneAnswer : answerList) {
                    Double value = gson.fromJson(oneAnswer.getWriteValue(), Double.class);
                    valueList.add(value);
                    sum += value;
                }
                valueList.sort((a, b) -> (int) (a - b));

                if (valueList.isEmpty()) {
                    resDoubleValueMap.put(MAX_VALUE, "0.0");
                    resDoubleValueMap.put(MIN_VALUE, "0.0");
                    resDoubleValueMap.put(AVERAGE_VALUE, "0.0");
                    resDoubleValueMap.put(MEDIAN, "0.0");
                } else {
                    resDoubleValueMap.put(MAX_VALUE, String.valueOf(valueList.get(valueList.size() - 1)));
                    resDoubleValueMap.put(MIN_VALUE, String.valueOf(valueList.get(0)));
                    resDoubleValueMap.put(AVERAGE_VALUE, String.format("%.2f", sum / valueList.size()));
                    resDoubleValueMap.put(MEDIAN, String.valueOf(valueList.get(valueList.size() / 2)));
                }
                return resDoubleValueMap;
            default:
                return new HashMap<>(0);
        }
    }

    private Map<String, String> genResValueMap(String details) {
        JSONObject detailObj = JSON.parseObject(details);
        String[] questionOptions = detailObj.getObject(QUESTION_OPTIONS, String[].class);
        Map<String, String> resValueMap = new HashMap<>(questionOptions.length);
        for (String questionOption : questionOptions) {
            resValueMap.put(questionOption, String.valueOf(0));
        }
        return resValueMap;
    }
}
