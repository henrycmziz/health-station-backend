package cn.henry.common.core.domain;

/**
 * 文件上传后的基本信息
 *
 * @author Henry
 * @date 2022-02-20 19:32
 **/
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

    public FileInfo(String showFileName, String extendType, String extractFileName, String pathFileName) {
        this.showFileName = showFileName;
        this.extendType = extendType;
        this.extractFileName = extractFileName;
        this.pathFileName = pathFileName;
    }

    public String getShowFileName() {
        return showFileName;
    }

    public void setShowFileName(String showFileName) {
        this.showFileName = showFileName;
    }

    public String getExtendType() {
        return extendType;
    }

    public void setExtendType(String extendType) {
        this.extendType = extendType;
    }

    public String getExtractFileName() {
        return extractFileName;
    }

    public void setExtractFileName(String extractFileName) {
        this.extractFileName = extractFileName;
    }

    public String getPathFileName() {
        return pathFileName;
    }

    public void setPathFileName(String pathFileName) {
        this.pathFileName = pathFileName;
    }
}
