package cn.henry.resource.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * WangEditor response body
 *
 * @author Henry
 * @date 2022-03-15 21:56
 **/
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WangEditorResponseBody {
    /**
     * 错误代码，0 成功； 其他 错误
     */
    private Integer errno;

    /**
     * 上传失败信息
     */
    private String message;

    /**
     * "data": {
     * "url": "xxx", // 图片 src ，必须
     * "alt": "yyy", // 图片描述文字，非必须
     * "href": "zzz" // 图片的链接，非必须
     * }
     */
    private Map<String, String> data;
}
