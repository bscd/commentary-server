package org.bs.commentaryserver.db.mapper;

import org.bs.commentaryserver.db.model.User;

import java.util.List;

public interface UserMapper
{

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAllUser();

}