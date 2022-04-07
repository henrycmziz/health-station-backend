package cn.henry.questionnaire.mapper.mapstruct;

import cn.henry.questionnaire.domain.Answer;
import cn.henry.questionnaire.domain.dto.AnswerDto;
import cn.henry.questionnaire.utils.TypeConversionWorker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author Henry
 * @date 2022-02-28 12:17
 **/
@Mapper(imports = {TypeConversionWorker.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerConvertMapper {
    AnswerConvertMapper INSTANCE = Mappers.getMapper(AnswerConvertMapper.class);

    /**
     * AnswerDto 转 Answer
     *
     * @param dto dto
     * @return Answer
     */
    @Mapping(target = "writeValue", expression = "java(TypeConversionWorker.genWriteValue(dto))")
    Answer answerDtoToAnswer(AnswerDto dto);

    ///**
    // * question 转 QuestionVo
    // *
    // * @param question 问题
    // * @return QuestionVo
    // */
    //@Mapping(target = "details", source = "details", qualifiedByName = "strToJsonObj")
    //QuestionVo questionToQuestionVo(Question question);
    //
    ///**
    // * questionList 转 QuestionVoList
    // *
    // * @param questionList 问题列表
    // * @return QuestionVo List
    // */
    //List<QuestionVo> questionToQuestionVo(List<Question> questionList);
}
