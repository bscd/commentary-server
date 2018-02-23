package org.bs.commentaryserver.Responser;

import lombok.Data;

@Data
public class CommonRspMsg
{
    Object data;
    private String code;
    private String desc;
}
