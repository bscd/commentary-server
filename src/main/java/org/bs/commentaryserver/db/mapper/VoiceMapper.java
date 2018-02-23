package org.bs.commentaryserver.db.mapper;

import org.bs.commentaryserver.db.model.Voice;

public interface VoiceMapper
{
    int deleteByPrimaryKey(Integer voiceId);

    int insert(Voice record);

    int insertSelective(Voice record);

    Voice selectByPrimaryKey(Integer voiceId);

    int updateByPrimaryKeySelective(Voice record);

    int updateByPrimaryKey(Voice record);
}