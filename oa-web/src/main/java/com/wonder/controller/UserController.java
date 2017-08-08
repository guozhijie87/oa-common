package com.wonder.controller;

import com.wonder.api.UserService;
import com.wonder.entity.Module;
import com.wonder.entity.TUser;
import com.wonder.entity.User;
import com.wonder.util.RESTfulMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Guozhijie on 2017/4/12.
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("login")
    public ResponseEntity<RESTfulMessage> login(String userName,String userPwd) {
        TUser user = userService.getTUser(userName,userPwd);
        if(user!=null)
        return ResponseEntity.ok(RESTfulMessage.success().data(user).build());
        else{
            return ResponseEntity.ok(RESTfulMessage.success().message("error").build());
        }
    }
}
