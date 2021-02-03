package com.tse.cost.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liangw
 * @date 2020/8/11 13:11
 */
public class BaseEntity implements Serializable {

    /**
     * 删除状态 (0:未删除，1:已删除)
     */
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDeleted;
    /**
     * 乐观锁
     */
    @Version
    private Integer revision;
    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 更新人
     */
    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

}
