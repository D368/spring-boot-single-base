package com.tse.cost.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.tse.cost.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 用户表(User)表实体类
 *
 * @author liangw
 * @since 2021-02-03 13:45:27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
@ApiModel(value = "用户表")
public class SysUser extends BaseEntity {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id", name = "id")
    private Long id;
    /**
     * 用户登录名
     */
    @ApiModelProperty(value = "用户登录名", name = "account")
    private String account;
    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名称", name = "name")
    private String name;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", name = "phone")
    private String phone;
    /**
     * 0:综合用户，1:前台用户，2:后台用户
     */
    @ApiModelProperty(value = "0:综合用户，1:前台用户，2:后台用户", name = "userType")
    private Integer userType;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", name = "password")
    private String password;
    /**
     * 角色
     */
    @ApiModelProperty(value = "角色", name = "role")
    private String role;

}
