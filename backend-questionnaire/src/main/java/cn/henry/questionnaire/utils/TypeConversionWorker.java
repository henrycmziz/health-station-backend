package cn.henry.questionnaire.utils;

import cn.henry.questionnaire.domain.dto.AnswerDto;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Mapping通用转换
 *
 * @author Henry
 * @date 2022-03-18 16:38
 **/
@Component
@Named("TypeConversionWorker")
public class TypeConversionWorker {
    static final Integer QUESTION_ID_DIGIT = 1000;

    private TypeConversionWorker() {
    }

    //------- Question -------

    /**
     * 生成问题ID
     *
     * @param questionnaireId 问卷ID
     * @param questionIndex   问题索引
     * @return list
     */
    @Named("genQuestionId")
    public static Long genQuestionId(Long questionnaireId, int questionIndex) {
        return questionnaireId * QUESTION_ID_DIGIT + questionIndex;
    }

    /**
     * JSONObject 转 字符串
     *
     * @param object jsonObj
     * @return str
     */
    @Named("jsonObjToStr")
    public static String jsonObjToStr(JSONObject object) {
        return object.toJSONString();
    }

    /**
     * 字符串 转 JSONObject
     *
     * @param str str
     * @return JSONObject
     */
    @Named("strToJsonObj")
    public static JSONObject strToJsonObj(String str) {
        return JSON.parseObject(str);
    }
    //------- Question -------

    //------- Answer -------

    /**
     * 生成问题ID
     *
     * @param dto 答案DTO
     * @return list
     */
    @Named("genWriteValue")
    public static String genWriteValue(AnswerDto dto) {
        switch (dto.getQuestionType()) {
            case SINGLE_CHECK:
                return dto.getAnswerSingleCheck();
            case MULTI_CHECK:
                return Arrays.toString(dto.getAnswerMultiCheck());
            case SINGLE_LINE_TEXT:
            case MULTI_LINE_TEXT:
                return dto.getAnswerText();
            case NUMBER:
                return String.valueOf(dto.getAnswerNumber());
            case GRADE:
                return String.valueOf(dto.getAnswerGrade());
            case DATE:
                return String.valueOf(dto.getAnswerDate());
            default:
                return "";
        }
    }
    //------- Answer -------
}
