package com.tse.cost.config;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.tse.cost.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * base字段自动填充
 * @author liangw
 * @date 2020-8-17 13:10:18
 */
@Slf4j
@Component
public class BaseMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        //标注为insertFill的字段自动填充数据
        Date now = new Date();
        this.strictInsertFill(metaObject, "createTime", Date.class, now);
        this.strictInsertFill(metaObject, "createBy", String.class, UserUtil.getUserName()==null?"admin": UserUtil.getUserName());
        this.strictInsertFill(metaObject, "isDeleted", Integer.class, 0);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Date now = new Date();
        //标注为updateFill的字段自动填充数据
        this.strictUpdateFill(metaObject, "updateTime", Date.class, now);
        String userName = null;
        try {
             userName = UserUtil.getUserName();
        } catch (Exception e) {

        }
        if (StrUtil.isBlank(userName)){
            userName = "admin";
        }
        this.strictUpdateFill(metaObject, "updateBy", String.class, userName);
    }
}
