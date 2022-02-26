package cn.henry.web.core.config;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Henry
 * @date 2022-02-22 19:27
 **/
@Slf4j
@Aspect
@Component
public class LogConfig {

    @Autowired
    private Environment env;

    private static boolean isDoBefore = false;
    private static boolean isDoAfter = false;
    private static boolean isDoReturning = false;
    private static boolean isDoThrowing = false;

    /**
     * 保证每个线程都有一个单独的实例
     */
    private ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    private static final String[] PARAMS;

    static {
        PARAMS = new String[]{"aspect.logger.spring-application-name", "aspect.logger.request-url", "aspect.logger.request-uri",
                "aspect.logger.request-desc", "aspect.logger.session", "aspect.logger.cookie",
                "aspect.logger.content-type", "aspect.logger.request-method", "aspect.logger.request-ip",
                "aspect.logger.request-user-agent", "aspect.logger.class-method", "aspect.logger.request-param"};
    }

    @PostConstruct
    public void init() {
        isDoBefore = env.getProperty("aspect.do-before") != null && Boolean.TRUE.equals(env.getProperty("aspect.do-before", Boolean.class));
        isDoAfter = env.getProperty("aspect.do-after") != null && Boolean.TRUE.equals(env.getProperty("aspect.do-after", Boolean.class));
        isDoReturning = env.getProperty("aspect.do-returning") != null && Boolean.TRUE.equals(env.getProperty("aspect.do-returning", Boolean.class));
        isDoThrowing = env.getProperty("aspect.do-throwing") != null && Boolean.TRUE.equals(env.getProperty("aspect.do-throwing", Boolean.class));
    }

    @Pointcut("execution(* cn.henry.web.controller..*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        if (!isDoBefore) {
            return;
        }
        threadLocal.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        StringBuilder stringBuilder = new StringBuilder().append("\n=== doBefore ===\n");

        // 记录请求的内容
        this.logHandle(joinPoint, PARAMS, request, stringBuilder);
        log.info(stringBuilder.toString());
    }

    @After("pointcut()")
    public void doAfter(JoinPoint joinPoint) {
        if (!isDoAfter) {
            return;
        }
        log.info("\n=== doAfter ===\n" + joinPoint.toString());
    }

    /**
     * 返回值信息
     *
     * @param ret ret
     */
    @AfterReturning(returning = "ret", pointcut = "pointcut()")
    public void doAfterReturning(Object ret) {
        if (!isDoReturning) {
            return;
        }
        log.info("\n=== afterReturning ===" + (ret == null ? "" : "\n" + String.valueOf(ret)));
        log.info("\n=== time cost {} ms ===", System.currentTimeMillis() - threadLocal.get());
    }

    @AfterThrowing(throwing = "ex", pointcut = "pointcut()")
    public void doThrowing(Throwable ex) {
        if (!isDoThrowing) {
            return;
        }
        log.error("\n=== doThrowing ===\n" + ex);
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception Exception
     */
    private String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    Object temp = method.getAnnotation(ApiOperation.class);
                    if (temp != null) {
                        description = method.getAnnotation(ApiOperation.class).value();
                    }
                    break;
                }
            }
        }
        return description;
    }

    /**
     * 处理请求参数输出
     *
     * @param joinPoint     joinPoint
     * @param requestParams requestParams
     * @param request       request
     * @param stringBuilder stringBuilder
     * @throws Exception Exception
     */
    public void logHandle(JoinPoint joinPoint, String[] requestParams, HttpServletRequest request, StringBuilder stringBuilder) throws Exception {
        Map<String, Object> paramMap = new HashMap<>(16);
        String contentType = request.getContentType();
        paramMap.put("session", request.getSession());
        paramMap.put("cookie", request.getCookies());
        paramMap.put("spring-application-name", env.getProperty("spring.application.name"));
        paramMap.put("request-url", request.getRequestURL());
        paramMap.put("request-uri", request.getRequestURI());
        paramMap.put("request-desc", getControllerMethodDescription(joinPoint));
        paramMap.put("request-method", request.getMethod());
        paramMap.put("content-type", contentType);
        paramMap.put("class-method", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        paramMap.put("request-ip", request.getRemoteAddr());
        paramMap.put("request-user-agent", request.getHeader("User-Agent"));

        String reqParam = null;
        Object[] o = joinPoint.getArgs();
        if (contentType != null && contentType.contains("multipart/form-data")) {
            MultipartFile file = (MultipartFile) o[0];
            reqParam = file.getOriginalFilename();
        } else {
            if (o != null && o.length > 0) {
                reqParam = o[0] == null ? "" : o[0].toString();
            }
        }
        paramMap.put("aspect.logger.request-param", reqParam);

        // 按配置输出
        for (String param : requestParams) {
            Boolean property = env.getProperty(param, Boolean.class);
            String p = param.replace("aspect.logger.", "");
            if (property != null && property && paramMap.containsKey(p)) {
                stringBuilder.append(p).append(":").append(paramMap.get(p)).append("\t");
            }
        }
    }
}

