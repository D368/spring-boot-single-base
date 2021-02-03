package com.tse.cost.util.aop;

import com.tse.cost.util.IPUtils;
import com.tse.cost.util.UserUtil;
import com.tse.cost.util.annotation.OperLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 切面处理类，操作日志异常日志记录处理
 *
 * @author wu
 * @date 2019/03/21
 */
@Aspect
@Component
public class OperLogAspect {


    //@Autowired
    //private SysOperateLogService sysOperateLogService;


    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.tse.*)")
    public void operLogPointCut() {
    }


    /**
     * 正常返回通知，拦截用户操作日志，连接点正常执行完成后执行， 如果连接点抛出异常，则不会执行
     *
     * @param joinPoint 切入点
     * @param keys      返回结果
     */
    @AfterReturning(value = "operLogPointCut()", returning = "keys")
    public void saveOperLog(JoinPoint joinPoint, Object keys) {
        /*// 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);

        SysOperateLog operlog = new SysOperateLog();
        try {
            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();
            // 获取操作
            OperLog opLog = method.getAnnotation(OperLog.class);
            // 请求的参数
            Map<String, String> rtnMap = convertMap(request.getParameterMap());

            if (opLog != null) {
                String operModule = opLog.operModule();
                String operType = opLog.operType();
                String operDesc = opLog.operDesc();
                String content = UserUtil.getUserName() +"操作"+
                        operModule+ "-" + operType +"-"+ operDesc;
                operlog.setContent(content);
            }
            operlog.setOperateTime(new Date());
            operlog.setOperateUser(UserUtil.getUserName());
            operlog.setRemoteIp(IPUtils.getIpAddr(request));
            sysOperateLogService.save(operlog);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }


    /**
     * 转换request 请求参数
     *
     * @param paramMap request获取的参数数组
     */
    public Map<String, String> convertMap(Map<String, String[]> paramMap) {
        Map<String, String> rtnMap = new HashMap<String, String>();
        for (String key : paramMap.keySet()) {
            rtnMap.put(key, paramMap.get(key)[0]);
        }
        return rtnMap;
    }


}
