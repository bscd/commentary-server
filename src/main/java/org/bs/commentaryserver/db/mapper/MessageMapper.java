package org.bs.commentaryserver.db.mapper;

import org.bs.commentaryserver.db.model.Message;

public interface MessageMapper
{
    int deleteByPrimaryKey(Integer messageId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}