package com.edev.emall.utils;

import com.edev.support.exception.ValidException;

public class ValidUtils {
    public static void isNull(Object value, String desc) {
        if(value==null) throw new ValidException("Null of %s!", desc);
    }

    public static void isNotExists(Long value, ValidFunc func, String desc) {
        isNull(value, desc);
        if(!func.apply(value)) throw new ValidException("Not exists %s", desc);
    }

    public static void isExists(Long value, ValidFunc func, String desc) {
        isNull(value, desc);
        if(func.apply(value)) throw new ValidException("Exists %s", desc);
    }
    @FunctionalInterface
    public interface ValidFunc {
        boolean apply(Long id);
    }
}
