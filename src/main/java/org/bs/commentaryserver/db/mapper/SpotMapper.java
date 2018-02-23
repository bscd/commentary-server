package org.bs.commentaryserver.db.mapper;

import org.apache.ibatis.annotations.Param;
import org.bs.commentaryserver.db.model.Spot;

import java.util.List;

public interface SpotMapper
{
    int deleteByPrimaryKey(Integer spotId);

    int insert(Spot record);

    int insertSelective(Spot record);

    Spot selectByPrimaryKey(Integer spotId);

    int updateByPrimaryKeySelective(Spot record);

    int updateByPrimaryKeyWithBLOBs(Spot record);

    int updateByPrimaryKey(Spot record);

    List<Spot> selectByCity(@Param("p_province") String province, @Param("p_city") String city);
}