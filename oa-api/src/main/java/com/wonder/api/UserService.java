package com.wonder.api;

import com.wonder.entity.TUser;

/**
 * Created by Guozhijie on 2017/4/12.
 */
public interface UserService {

    TUser getTUser(String userName,String pwd);
}
