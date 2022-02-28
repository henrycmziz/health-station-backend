package cn.henry.framework.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Henry
 * @date 2022-02-28 19:38
 **/
@Aspect
@Component
public class WebLogAspect {
    /**
     * 保证每个线程都有一个单独的实例
     */
    private final ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    private static final Logger log = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(* cn.henry..controller.*.*(..)) || execution(* cn.henry..controller..*.*(..))")
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        threadLocal.set(System.currentTimeMillis());

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        log.info("\nrequest-url: {}, request-method: {}, ip: {}\nclass-method: {}.{}, request-param: {}",
                request.getRequestURL(), request.getMethod(), request.getRemoteAddr(),
                joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @AfterReturning(returning = "ret", pointcut = "logPointCut()")
    public void doAfterReturning(Object ret) {
        log.info("\ntime-cost: {} ms, return: {}", System.currentTimeMillis() - threadLocal.get(), ret);
        threadLocal.remove();
    }
}
