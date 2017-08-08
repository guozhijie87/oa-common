package com.wonder.controller;

import com.github.pagehelper.PageInfo;
import com.wonder.api.AcService;
import com.wonder.api.FeeService;
import com.wonder.entity.Fee;
import com.wonder.entity.Module;
import com.wonder.entity.User;
import com.wonder.util.RESTfulMessage;
import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Guozhijie on 2017/2/16.
 */
@Controller
@RequestMapping("oa/fee")
public class FeeController {
    @Autowired
    FeeService feeService;
    @Autowired
    AcService acService;

    @RequestMapping("list")
    public ResponseEntity<RESTfulMessage> getList() {
        PageInfo<Fee> list = feeService.selectFeeByPage(2, 6);
        return ResponseEntity.ok(RESTfulMessage.success().data(list).build());
    }

    @RequestMapping("menu")
    public ResponseEntity<RESTfulMessage> getMenu() {
        User user = new User();
        user.setId((long) 18);
        Module module = acService.getUserModule(user);
        return ResponseEntity.ok(RESTfulMessage.success().data(module).build());
    }
}
