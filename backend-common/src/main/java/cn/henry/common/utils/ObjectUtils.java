package cn.henry.common.utils;

import org.apache.commons.lang3.StringUtils;
import cn.henry.common.annotation.RequiredParam;
import cn.henry.common.utils.reflect.ReflectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 对象工具类
 *
 * @author Henry
 * @date 2022-02-12 23:19
 **/
public final class ObjectUtils {
    private static final Logger logger = LoggerFactory.getLogger(ReflectUtils.class);

    private ObjectUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static boolean checkObjFieldIsBlank(Object object) {
        boolean flag = false;
        if (null != object) {
            try {
                for (Field field : object.getClass().getDeclaredFields()) {
                    // 在用反射时访问私有变量（private修饰变量）
                    field.setAccessible(true);
                    RequiredParam annotation = field.getAnnotation(RequiredParam.class);
                    if (annotation != null && annotation.isNotBlank()) {
                        continue;
                    }
                    if (annotation == null) {
                        continue;
                    }
                    if (field.getType().equals(List.class)) {
                        Object o = field.get(object);
                        // 如果有集合，循环调用
                        if (o instanceof List) {
                            int size = ((List<?>) o).size();
                            for (int i = 0; i < size; i++) {
                                Object o1 = ((List<?>) o).get(i);
                                flag = checkObjFieldIsBlank(o1);
                            }
                        }
                    } else {
                        if (field.get(object) == null || StringUtils.isBlank(field.get(object).toString())) {
                            flag = true;
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                logger.error("校验实体类属性失败:{}", e.getMessage());
                throw new RuntimeException();
            }
        }
        return flag;
    }
}
