package com.edev.emall.utils;

import com.edev.support.utils.DateUtils;

import java.util.Date;

public class EMallUtils {
    public static Date getBirthdateFromIdentification(String identification) {
        if(identification != null) {
            String str = identification.substring(6, 14);
            String format = "yyyyMMdd";
            return DateUtils.getDate(str, format);
        }
        return null;
    }
}
