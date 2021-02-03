package com.tse.cost.common.result;

import com.tse.cost.common.constant.ResCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liangw
 * @date 2020/8/28 9:15
 */
@Data
@ApiModel("响应参数")
public class ResResult<T> {

    /**
     * 状态码
     */
    @ApiModelProperty("状态码")
    private Integer code;
    /**
     * 消息
     */
    @ApiModelProperty("消息")
    private String message;
    /**
     * 数据
     */
    @ApiModelProperty("数据")
    private T data;

    public ResResult() {
    }

    public ResResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResResult(ResCode resCode) {
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
    }

    public ResResult(ResCode resCode, T data) {
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
        this.data = data;
    }

    public static<T> ResResult<T> success(T data){
        return new ResResult<T>(ResCode.OK,data);
    }

    public static <T> ResResult<T> success(String message) {
        return new ResResult<T>(ResCode.OK.getCode(),message);
    }

    public static <T> ResResult<T> success() {
        return new ResResult<T>(ResCode.OK);
    }


    public static <T> ResResult<T> fail() {
        return new ResResult<T>(ResCode.FAILED);
    }

    public static <T> ResResult<T> fail(ResCode resCode) {
        return new ResResult<T>(resCode);
    }

    public static <T> ResResult<T> fail(String message) {
        return new ResResult<T>(ResCode.FAILED.getCode(),message);
    }

    public static <T> ResResult<T> fail(Integer code,String message) {
        return new ResResult<T>(code,message);
    }
}
