package com.wonder.provider;

import com.wonder.api.UserService;
import com.wonder.entity.TUser;
import com.wonder.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Guozhijie on 2017/4/12.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    TUserMapper tUserMapper;

  public   TUser getTUser(String userName, String pwd){
      Map map=new HashMap();
      map.put("userName",userName);;
      map.put("userPwd",pwd);
      return  tUserMapper.selectByMap(map);
  }
}
