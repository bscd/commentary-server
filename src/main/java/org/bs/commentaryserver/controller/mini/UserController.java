package org.bs.commentaryserver.controller.mini;


import org.bs.commentaryserver.db.model.User;
import org.bs.commentaryserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping(value = "/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/add",
                    produces = {"application/json;charset=UTF-8"})
    public int addUser(User user)
    {
        return userService.addUser(user);
    }

    @RequestMapping(value = "/all/{pageNum}/{pageSize}",
                    produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize)
    {
        return userService.findAllUser(pageNum, pageSize);
    }
}
