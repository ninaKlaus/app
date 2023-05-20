package com.app.base.validate;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.app.base.exception.ValidateException;

import java.util.List;
import java.util.Map;

/**
 * @author ninak
 */
public class CommonValidateUtils {

    public static void isBlank(String str, String message) {
        if (StrUtil.isBlank(str)) {
            throw new ValidateException(message);
        }
    }

    public static void isNull(Object o, String message) {
        if (o == null) {
            throw new ValidateException(message);
        }

        if (o instanceof String) {
            isBlank(o.toString(), message);
        }
    }

    public static void isNotNull(Object o, String message) {
        if (o != null) {
            throw new ValidateException(message);
        }
    }

    public static void isEmpty(List list, String message) {
        if (CollUtil.isEmpty(list)) {
            throw new ValidateException(message);
        }
    }

    public static void isEmpty(Map map, String message) {
        if (CollUtil.isEmpty(map)) {
            throw new ValidateException(message);
        }
    }

    public static void isNotEmpty(List list, String message) {
        if (CollUtil.isNotEmpty(list)) {
            throw new ValidateException(message);
        }
    }


    public static void isFalse(boolean flag, String message) {
        if (!flag) {
            throw new ValidateException(message);
        }
    }

    public static void isTrue(boolean flag, String message) {
        if (flag) {
            throw new ValidateException(message);
        }
    }

}
