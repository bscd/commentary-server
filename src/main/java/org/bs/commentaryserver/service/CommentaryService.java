package org.bs.commentaryserver.service;


import org.bs.commentaryserver.db.model.Spot;

import java.util.List;

/**
 * @author bs
 */
public interface CommentaryService
{
    List<Spot> querySpotsByCity(String province, String city);
}
