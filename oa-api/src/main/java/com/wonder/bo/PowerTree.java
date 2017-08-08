package com.wonder.bo;

import com.wonder.entity.Module;
import com.wonder.exception.DBException;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Guozhijie on 2017/2/23.
 */
public class PowerTree {
    private int size = 0;
    private Module root;

    public PowerTree(Collection<Module> modules) {
        TreeSet<Module> treeSet = new TreeSet<Module>();
        treeSet.addAll(modules);
        //循环排成树状
        Iterator<Module> iterator = treeSet.iterator();
        if (iterator.hasNext()) {
            this.root = iterator.next();
            //判断是否为根
            if (!(this.root.getModuleType() == (byte) 1)) {
                throw DBException.DB_GET_ERROR;
            }
        }
        while(iterator.hasNext()){
            Module module=(Module) iterator.next();
            if(this.root.isAncestorModule(module)){
                this.root.addSubModule(module);
            }

        }
    }

    /**
     * 复制
     *
     * @param module
     * @return
     */
    private Module copySimpleModule(Module module) {
        Module m = new Module();
        m.setParent(module.getParent());
        m.setAppId(module.getAppId());
        m.setModuleFather(module.getModuleFather());
        m.setUri(module.getUri());
        m.setModuleId(module.getModuleId());
        m.setDisplayMenu(module.getDisplayMenu());
        m.setStatus(module.getStatus());
        m.setModuleType(module.getModuleType());
        return m;
    }

    /**
     * 获取祖先模块
     *
     * @param rootModule
     * @param userTree
     * @return
     */
    private Collection<Module> getAncestors(Module rootModule, Module userTree) {
        Collection<Module> ancestors = new TreeSet<>();
        if (rootModule.isAncestorModule(userTree)) {
            ancestors.add(copySimpleModule(rootModule));
            if (rootModule.getSubModules() != null) {
                for (Module rootSub : rootModule.getSubModules()) {
                    if (rootSub.isAncestorModule(userTree)) {
                        ancestors.addAll(getAncestors(rootSub, userTree));
                        break;
                    }
                }
            }
        }
        return ancestors;
    }

    /**
     * 获取父模块
     */
    public PowerTree getPartTree(Collection<Module> partModules) {
        PowerTree powerTree = null;
        TreeSet treeSet = new TreeSet();
        treeSet.addAll(partModules);
        ;
        if (this.root.equals(treeSet.first())) {
            powerTree = this;
        } else {
            TreeSet partSet = new TreeSet();
            Iterator iterator = treeSet.iterator();
            while (iterator.hasNext()) {
                Module module = (Module) iterator.next();
                partSet.addAll(getAncestors(this.root, module));
            }
            if (partSet.size() != 0) {
                powerTree = new PowerTree(partSet);
            }
        }
        return powerTree;
    }

    /**
     * 获取根模块
     */
    public  Module getRootModule(){
        return this.root;
    }
}
