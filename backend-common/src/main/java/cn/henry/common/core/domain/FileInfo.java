package cn.henry.common.core.domain;

import lombok.Builder;
import lombok.Data;

/**
 * 文件上传后的基本信息
 *
 * @author Henry
 * @date 2022-02-20 19:32
 **/
@Builder
@Data
public class FileInfo {
    /**
     * 文件名（web端显示）
     */
    private String showFileName;
    /**
     * 文件类型
     */
    private String extendType;
    /**
     * 编码文件名（中间自定义目录 + 真实文件名）
     */
    private String extractFileName;
    /**
     * 相对应用的基目录 + 中间自定义目录 + 真实文件名
     */
    private String pathFileName;
}
