package com.tse.cost.interceptor;

import cn.hutool.core.util.StrUtil;
import com.tse.cost.common.constant.ResCode;
import com.tse.cost.common.constant.UserConstants;
import com.tse.cost.entity.SysUser;
import com.tse.cost.exception.ExceptionCast;
import com.tse.cost.util.UserUtil;
import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liangw
 * @date 2020/8/28 14:10
 */
@Component
public class CustomInterceptor implements HandlerInterceptor {




    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //TODO 待开启登录拦截
        String token = request.getHeader(UserConstants.TOKEN_KEY);
        if (StrUtil.isBlank(token)){
            System.out.println(request.getRequestURI());
            ExceptionCast.cast(ResCode.TOKEN_NULL);
            response.setStatus(Response.SC_FORBIDDEN);
        }
        SysUser user = UserUtil.getUser();
        if (null == user){
            ExceptionCast.cast(ResCode.TOKEN_NULL);
        }
        return true;
    }
}
