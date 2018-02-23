package org.bs.commentaryserver.service.impl;

import org.bs.commentaryserver.db.mapper.SpotMapper;
import org.bs.commentaryserver.db.model.Spot;
import org.bs.commentaryserver.service.CommentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author bs
 */
@Component
public class CommentaryServiceImpl implements CommentaryService
{
    @Autowired
    private SpotMapper spotMapper;

    @Override
    public List<Spot> querySpotsByCity(String province, String city)
    {
        return spotMapper.selectByCity(province, city);
    }
}
