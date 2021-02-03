package com.tse.cost.util;

import cn.hutool.core.util.StrUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author liangw
 * @since 2021/1/19 10:22
 */
public class StateConvertUtil {



    public static String convertStateToStr(Integer auditState, String text) {
        if (StrUtil.isBlank(text) || auditState==null){
            return "";
        }

        List<String> keyValueArrays = Arrays.asList(text.split(","));
        for (String str : keyValueArrays) {
            String[] key = str.split(":");
            if (String.valueOf(auditState).equals(key[0])){
                return key[1];
            }
        }
        return "";

    }
}
