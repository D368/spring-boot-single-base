package com.tse.cost.exception;


import com.tse.cost.common.constant.ResCode;

/**
 * 自定义异常抛出
 * @author liangw
 * @date 2020/8/28 14:37
 */
public class ExceptionCast {

    public static void cast(ResCode resCode){
        throw new ServiceException(resCode);
    }

    public static void cast(String msg){
        throw new ServiceException( msg);
    }
}
