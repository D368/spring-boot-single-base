package com.tse.cost.common.constant;

/**
 * 异常枚举类
 * @author liangw
 * @date 2020/8/28 9:31
 */
public enum ResCode {


    //========================系统（1000）=======================
    TOKEN_NULL(403, "未授权"),
    ACCOUNT_NOT_FOUND(1001, "账号不存在"),
    PASSWORD_FAIL(1002, "账号或密码不正确"),
    INSUFFICIENT_PERMISSIONS(1003, "暂无权限"),
    NAME_EXISTS(1004, "账号或用户名重复"),
    FILE_INVALID(1005, "文件无效"),

    //====================业务异常(20000)===========================
    //====================业务异常(用户)(20100)===========================
    ACCOUNT_IS_EXISTS(20101,"登录账号已存在"),
    PHONE_NOT_EMPTY(20102,"手机号码不能为空"),
    VERIFY_GET_FREQUENTLY(20103,"验证码获取频繁，请稍后再试"),
    VERIFY_IS_NOT_EXISTS(20104,"验证码不存在或已失效"),
    VERIFY_IS_ERROR(20105,"验证码错误"),
    PHONE_IS_REGISTER(20106,"手机号码已注册，请登录"),

    //====================业务异常(权限)(20200)===========================
    ROLE_NAME_EXISTS(20201,"角色名称已存在"),
    ROLE_NOT_EXISTS(20202,"角色不存在"),

    //====================业务异常(基础信息)(20300)===========================
    HOUSE_TYPE_NAME_EXISTS(20301,"户型名称已存在"),

    //====================业务异常(商品)(20400)===========================
    GOODS_IS_INVALID(20401,"商品已下架或失效"),

    //====================业务异常(购物车)(20500)===========================
    CERT_NOT_EXISTS_GOODS(20501,"购物车中不存在该商品"),

    //====================业务异常(订单)(20600)===========================
    ORDER_NOT_EXISTS_GOODS(20601,"订单中不存在商品"),
    ORDER_GOODS_INSUFFICIENT_INVENTORY(20602,"库存不足"),
    REMIND_MESSAGE_SEND_FREQUENTLY(20603,"提醒短信每天只能发送一次，请明天再试"),



    /**
     * 500 失败
     */
    FAILED(500, "请求失败"),

    /**
     * 200请求成功
     */
    OK(200, "请求成功");
    /**
     * 返回状态码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    ResCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
