package bs.org.commentaryserver.service;

import bs.org.commentaryserver.db.model.User;

import java.util.List;

/**
 *
 */
public interface UserService
{
    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);
}
