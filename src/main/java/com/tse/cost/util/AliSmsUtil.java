package com.tse.cost.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author liangw
 * @since 2021/1/20 15:02
 */
@Component
public class AliSmsUtil {

    @Value("${custom-param.sms.accessKeyId}")
    private String accessKeyId;
    @Value("${custom-param.sms.accessSecret}")
    private String accessSecret;

    private IAcsClient client;


    /**
     * 验证码短信模板code
     */
    public final static  String VERIFY = "SMS_210095062";
    /**
     * 提醒短信模板code
     */
    public final static  String REMIND = "SMS_210061379";


    /*
    * 	AccessKey Secret: 4emfwpi5JvY0SDfkVKRfRvmNRTpLfS
    *   AccessKey ID: LTAIRPucLM4N5bkp
    *
    */



    /**
     * 发送验证码短信
     * @param phone 手机号码
     * @param code 验证码或其他标识码
     * @return 结果ID
     */
    public  String sendVerifySms(String phone,String code) throws ClientException {
        //构建profile 和 client

        CommonRequest request = getCommonRequest();
        // 接收短信的手机号码
        request.putQueryParameter("PhoneNumbers", phone);
        // 短信签名名称。请在控制台签名管理页面签名名称一列查看（必须是已添加、并通过审核的短信签名）。
        // 短信模板ID
        request.putQueryParameter("TemplateCode", VERIFY);
        // 短信模板变量对应的实际值，JSON格式。
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        CommonResponse commonResponse = client.getCommonResponse(request);
        String data = commonResponse.getData();
        String sData = data.replaceAll("'\'", "");
        Gson gson = new Gson();
        Map map = gson.fromJson(sData, Map.class);
        System.out.println(map);
        Object bizId = map.get("BizId");
        return bizId.toString();
    }

    /**
     * 发送提醒短信
     * @param phone 手机号码
     * @param code 预约单号
     * @param name 水工姓名
     * @return 结果ID
     * @throws ClientException
     */
    public String sendRemindSms(String phone,String name,String userPhone,String code) throws ClientException {

        CommonRequest request = getCommonRequest();
        // 接收短信的手机号码
        request.putQueryParameter("PhoneNumbers", phone);
        // 短信签名名称。请在控制台签名管理页面签名名称一列查看（必须是已添加、并通过审核的短信签名）。
        // 短信模板ID
        request.putQueryParameter("TemplateCode", REMIND);
        // 短信模板变量对应的实际值，JSON格式。
        request.putQueryParameter("TemplateParam",
                "{\"code\":\""+code+"\",\"name\":\""+name+"\",\"phone\":\""+userPhone+"\"}");
        CommonResponse commonResponse = client.getCommonResponse(request);
        String data = commonResponse.getData();
        String sData = data.replaceAll("'\'", "");
        Gson gson = new Gson();
        Map map = gson.fromJson(sData, Map.class);
        System.out.println(map);
        Object bizId = map.get("BizId");
        return bizId.toString();
    }

    private void constructDefault(){
        this.client = new DefaultAcsClient(DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret));
    }

    private CommonRequest getCommonRequest() {
        constructDefault();
        CommonRequest request = new CommonRequest();
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("SignName", "西德雄狮");
        return request;
    }

}
