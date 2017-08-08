package com.wonder.mapper;

import com.wonder.api.BaseMapper;
import com.wonder.entity.Module;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModuleMapper extends BaseMapper<Module> {
    /**
     * 查询拥有的模块权限
     *
     * @param userId
     * @return
     */
    List<String> getUserHasModule(Long userId);

    /**
     * 查询父模块和子模块id
     *
     * @param moduleId
     * @return
     */
    String getUserChildModules(String moduleId);

    Module getModuleById(String id);

}