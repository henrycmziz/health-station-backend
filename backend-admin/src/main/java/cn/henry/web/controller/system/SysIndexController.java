package cn.henry.web.controller.system;

import cn.henry.common.config.BackendConfig;
import cn.henry.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页
 *
 * @author ruoyi
 */
@RestController
public class SysIndexController {
    /**
     * 系统基础配置
     */
    @Autowired
    private BackendConfig backendConfig;

    /**
     * 访问首页，提示语
     */
    @RequestMapping("/")
    public String index() {
        return StringUtils.format("<h1 style=\"text-align:center;margin-top: 66px;\">\n" +
                "        <span style=\"color: chocolate;\">Health Station Backend</span> service started...\n" +
                "        <br /><br />\n" +
                "        Current version: <span style=\"color: chocolate;\">1.0.0</span>.\n" +
                "        Please access through the front-end address\n" +
                "    </h1>", backendConfig.getName(), backendConfig.getVersion());
    }
}
