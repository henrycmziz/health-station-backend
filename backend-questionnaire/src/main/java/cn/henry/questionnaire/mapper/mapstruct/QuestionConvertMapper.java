package cn.henry.questionnaire.mapper.mapstruct;

import cn.henry.questionnaire.domain.Question;
import cn.henry.questionnaire.domain.dto.QuestionDto;
import cn.henry.questionnaire.domain.vo.QuestionVo;
import cn.henry.questionnaire.utils.TypeConversionWorker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Henry
 * @date 2022-02-28 12:17
 **/
@Mapper(uses = {TypeConversionWorker.class})
public interface QuestionConvertMapper {
    QuestionConvertMapper INSTANCE = Mappers.getMapper(QuestionConvertMapper.class);

    /**
     * questionDto 转 Question
     *
     * @param dto dto
     * @return Question
     */
    @Mapping(target = "questionId", expression = "java(TypeConversionWorker.genQuestionId(dto.getQuestionnaireId(),dto.getQuestionIndex()))")
    @Mapping(target = "details", source = "details", qualifiedByName = "jsonObjToStr")
    Question questionDtoToQuestion(QuestionDto dto);

    /**
     * question 转 QuestionVo
     *
     * @param question 问题
     * @return QuestionVo
     */
    @Mapping(target = "details", source = "details", qualifiedByName = "strToJsonObj")
    QuestionVo questionToQuestionVo(Question question);

    /**
     * questionList 转 QuestionVoList
     *
     * @param questionList 问题列表
     * @return QuestionVo List
     */
    List<QuestionVo> questionToQuestionVo(List<Question> questionList);
}
