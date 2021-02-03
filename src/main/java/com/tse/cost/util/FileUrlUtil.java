package com.tse.cost.util;

import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangw
 * @since 2021/1/19 10:22
 */
public class FileUrlUtil {

    private static final String ATTACHMENT_URI = "/api/v1/attachment/download/";

    public static List<String> convertToList(String fileIds) {
        List<String> uriList = new ArrayList<>();
        if (StrUtil.isNotBlank(fileIds)) {

            String[] uriArr = fileIds.split(",");
            for (String uri : uriArr) {
                uriList.add(ATTACHMENT_URI+uri);
            }
        }
        return uriList;

    }

    public static String convertToStr(String fileId) {
        if (StrUtil.isNotBlank(fileId)) {
                return ATTACHMENT_URI+fileId;
        }
        return "";

    }
}
