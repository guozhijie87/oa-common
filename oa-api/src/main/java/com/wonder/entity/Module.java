package com.wonder.entity;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.io.Serializable;
import java.util.Collection;
import java.util.TreeSet;

public class Module implements Serializable,Comparable<Module>{
    private String moduleId;

    private String moduleName;

    private String moduleFather;

    private Byte status;

    private String uri;

    private Byte moduleType;

    private Byte displayMenu;

    private Byte appId;

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId == null ? null : moduleId.trim();
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public String getModuleFather() {
        return moduleFather;
    }

    public void setModuleFather(String moduleFather) {
        this.moduleFather = moduleFather == null ? null : moduleFather.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public Byte getModuleType() {
        return moduleType;
    }

    public void setModuleType(Byte moduleType) {
        this.moduleType = moduleType;
    }

    public Byte getDisplayMenu() {
        return displayMenu;
    }

    public void setDisplayMenu(Byte displayMenu) {
        this.displayMenu = displayMenu;
    }

    public Byte getAppId() {
        return appId;
    }

    public void setAppId(Byte appId) {
        this.appId = appId;
    }

    /**
     * 子模块
     */
    private Collection<Module> subModules;

    /**
     * 父模块
     */
    private Module parent;

    public Collection<Module> getSubModules() {
        return subModules;
    }

    public void setSubModules(Collection<Module> subModules) {
        this.subModules = subModules;
    }

    public Module getParent() {
        return parent;
    }

    public void setParent(Module parent) {
        this.parent = parent;
    }

    /**
     * 获取层级
     * @return
     */
    public int getLevel(){
        return (moduleId.length()/2 -1);
    }

    public  Boolean isParent(Module module){
          boolean result=isAncestorModule(module);
        if(result){
           if(module.getLevel()- getLevel()==1){
               result= true;
           }else{
               result= false;
           }
        }
        return result;
    }
    public Boolean isAncestorModule(Module module){
        Boolean result=false;
        if(this.appId==module.appId){
           String t=module.getModuleId();
            result= t.startsWith(this.moduleId);
        }
        return result;
    }

    /***
     * 添加子模块
     */
    public void addSubModule(Module module){
        if(this.subModules==null){
            this.subModules=new TreeSet();
        }
        if(isParent(module)){
            module.setParent(this);
            this.subModules.add(module);;
        }else{
            for(Module module1:this.subModules){
                if(module1.isAncestorModule(module)){
                    module1.addSubModule(module);
                    return ;
                }
            }
        }
    }



    public  int compareTo(Module o){
        int result=this.getLevel()-o.getLevel();
        if(result==0){
            result=this.getModuleId().compareTo(o.getModuleId());
        }
        return result;
    }


}