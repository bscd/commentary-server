package org.bs.commentaryserver.service;

import org.bs.commentaryserver.db.model.User;

import java.util.List;

/**
 *
 */
public interface UserService
{
    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);
}
