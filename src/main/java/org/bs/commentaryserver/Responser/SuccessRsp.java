package org.bs.commentaryserver.Responser;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

/**
 * 成功响应消息
 *
 * @author bs
 */
@Component
public class SuccessRsp
{
    public String buildMsg(Object data)
    {
        CommonRspMsg commonRspMsg = new CommonRspMsg();
        commonRspMsg.setCode("000");
        commonRspMsg.setDesc("Success");
        commonRspMsg.setData(data);
        String rsp = JSON.toJSONString(commonRspMsg);
        return rsp;
    }
}
