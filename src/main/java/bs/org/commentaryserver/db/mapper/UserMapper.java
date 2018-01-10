package bs.org.commentaryserver.db.mapper;

import bs.org.commentaryserver.db.model.User;

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