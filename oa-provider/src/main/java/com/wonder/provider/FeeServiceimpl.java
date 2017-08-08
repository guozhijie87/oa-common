package com.wonder.provider;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wonder.api.FeeService;
import com.wonder.entity.Fee;
import com.wonder.exception.DBException;
import com.wonder.exception.ServiceException;
import com.wonder.mapper.FeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

import static com.alibaba.druid.sql.ast.SQLPartitionValue.Operator.List;

/**
 * Created by Guozhijie on 2017/2/16.
 */
@Service
public class FeeServiceimpl implements FeeService {
    @Autowired
    FeeMapper feeMapper;

    public Fee selectById(Long id) throws DBException, ServiceException{
        return feeMapper.selectById(id);
    }

    public PageInfo<Fee> selectFeeByPage(Integer pageSize, Integer pageNum) throws DBException, ServiceException{
        PageHelper.startPage(pageNum,pageSize);
        HashMap map=new HashMap<>();
        List <Fee> list=feeMapper.selectListByMap(map);
        return new PageInfo<>(list);
    }
}
