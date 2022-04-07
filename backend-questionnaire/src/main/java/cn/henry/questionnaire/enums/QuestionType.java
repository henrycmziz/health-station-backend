package cn.henry.questionnaire.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/**
 * 问题类型
 *
 * @author Henry
 * @date 2022-04-03 15:19
 **/
@AllArgsConstructor
public enum QuestionType {
    /**
     * 单选
     */
    @JsonProperty("single_check")
    SINGLE_CHECK("single_check"),

    /**
     * 多选
     */
    @JsonProperty("multi_check")
    MULTI_CHECK("multi_check"),

    /**
     * 单行文本
     */
    @JsonProperty("single_line_text")
    SINGLE_LINE_TEXT("single_line_text"),

    /**
     * 多行文本
     */
    @JsonProperty("multi_line_text")
    MULTI_LINE_TEXT("multi_line_text"),

    /**
     * 数字
     */
    @JsonProperty("number")
    NUMBER("number"),

    /**
     * 评分
     */
    @JsonProperty("grade")
    GRADE("grade"),

    /**
     * 日期
     */
    @JsonProperty("date")
    DATE("date"),

    /**
     * 文本描述
     */
    @JsonProperty("text_description")
    TEXT_DESCRIPTION("text_description");

    @Getter
    private final String type;

    private static Map<String, QuestionType> FORMAT_MAP = Stream
            .of(QuestionType.values())
            .collect(toMap(s -> s.type, Function.identity()));

    public static QuestionType fromString(String string) {
        QuestionType questionType = FORMAT_MAP.get(string);
        if (questionType == null) {
            throw new IllegalArgumentException(string + " has no corresponding value");
        }
        return questionType;
    }
}
