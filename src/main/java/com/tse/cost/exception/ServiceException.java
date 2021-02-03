package com.tse.cost.exception;

import com.tse.cost.common.constant.ResCode;
import lombok.Getter;

/**
 * @author liangw
 * @date 2020/8/28 14:34
 */
@Getter
public class ServiceException extends BaseException {
    ResCode resCode;


    public ServiceException(ResCode resCode){
        super(resCode.getMessage());
        this.resCode = resCode;
    }

    public ServiceException(String msg){
        super(msg);
        this.resCode = ResCode.FAILED;
    }


}
