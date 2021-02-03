package com.tse.cost.util;


import com.tse.cost.common.constant.UserConstants;
import com.tse.cost.entity.SysUser;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author liangw
 * @date 2020/8/28 10:50
 */
public class UserUtil {

    public static SysUser getUser() {
        Map<String, Object> userInfoMap = null;
        try {
            userInfoMap = JwtUtil.verifyToken(getToken());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (userInfoMap == null) {
            return null;
        }
        Long userId = Long.valueOf((Integer) userInfoMap.get("userId"));
        SysUser user = new SysUser();
        user.setId(userId);
        user.setName((String) userInfoMap.get("userName"));
        user.setUserType((Integer) userInfoMap.get("userType"));
        if (userInfoMap.get("userRole")!=null){
            //user.setRoleId( ((Integer)userInfoMap.get("userRole")).longValue());
        }
        if (userInfoMap.get("userRoleName")!=null){
            //user.setRoleName((String) userInfoMap.get("userRoleName"));
        }

        if (userInfoMap.get("avatar")!=null){
            //user.setAvatar(((Integer)userInfoMap.get("avatar")).longValue());
        }
        if (userInfoMap.get("phone")!=null){
            user.setPhone((String)userInfoMap.get("phone"));
        }
        return user;
    }

    public static Long getUserId() {
        return getUser()!=null?getUser().getId():null;
    }

    public static Long getUserAvatar() {
        //return getUser()!=null?getUser().getAvatar():null;
        return null;
    }


    public static String getUserPhone() {
        return getUser()!=null?getUser().getPhone():null;
    }


    public static String getUserName() {
        return getUser()!=null?getUser().getName():null;
    }
    public static Long getRoleId() {
        //return getUser()!=null?getUser().getRoleId():null;
        return null;
    }


    private static String getToken() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes==null){
            return null;
        }
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        return request.getHeader(UserConstants.TOKEN_KEY);
    }
}
