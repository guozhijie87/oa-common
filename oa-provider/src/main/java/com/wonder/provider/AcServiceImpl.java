package com.wonder.provider;

import com.github.pagehelper.StringUtil;
import com.wonder.api.AcService;
import com.wonder.bo.PowerTree;
import com.wonder.entity.Module;
import com.wonder.entity.Power;
import com.wonder.entity.User;
import com.wonder.mapper.ModuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by Guozhijie on 2017/2/23.
 */
@Service
public class AcServiceImpl implements AcService {
    @Autowired
    ModuleMapper moduleMapper;

    public Module getUserModule(User user) {
        HashMap map = new HashMap();
        //获取所有菜单
        Collection<Module> modules = moduleMapper.selectListByMap(map);
        TreeSet<Module> treeSet = new TreeSet<>();
        treeSet.addAll(modules);
//获取整个菜单树
        PowerTree powerTree = new PowerTree(treeSet);
//获取自己的权限
        Collection<Module> power = getUserPower(user);
        //根据自己的权限 来获取自己的菜单树
        Module module = powerTree.getPartTree(power).getRootModule();
        return module;

    }

    public Collection<Module> getUserPower(User user) {
        Collection<Module> collection = new TreeSet<>();
        List<String> list = moduleMapper.getUserHasModule(user.getId());
        if (list != null && list.size() > 0) {
            for (String moduleId : list) {
                String modules = moduleMapper.getUserChildModules(moduleId);
                if (!StringUtils.isEmpty(modules)) {
                    List<String> arrayList = Arrays.asList(modules.split(","));
                    for (String id : arrayList) {
                        Module module = moduleMapper.getModuleById(id);
                        collection.add(module);
                    }
                }

            }
        }
        return collection;
    }
}
