package com.wonder.api;

import com.github.pagehelper.PageInfo;
import com.wonder.entity.Fee;
import com.wonder.exception.DBException;
import com.wonder.exception.ServiceException;

/**
 * Created by Guozhijie on 2017/2/16.
 */
public interface FeeService {
    /**
     * 根据id获取
     *
     * @param id
     * @return
     * @throws DBException
     * @throws ServiceException
     */
    Fee selectById(Long id) throws DBException, ServiceException;

    /**
     * 分页
     *
     * @param pageSize
     * @param pageNum
     * @return
     * @throws DBException
     * @throws ServiceException
     */
    PageInfo<Fee> selectFeeByPage(Integer pageSize, Integer pageNum) throws DBException, ServiceException;

    ;
}
