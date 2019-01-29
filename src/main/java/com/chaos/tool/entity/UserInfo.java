package com.chaos.tool.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserInfo implements Serializable {

    private String  userCode;
    private String  userName;
    private String passWord;
    private Set<RoleInfo> roleInfoSet=new HashSet<>();
    private Set<Module> moduleSet=new HashSet<>();

    public String getUserCode() {
        return userCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public Set<RoleInfo> getRoleInfoSet() {
        return roleInfoSet;
    }

    public Set<Module> getModuleSet() {
        return moduleSet;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setRoleInfoSet(Set<RoleInfo> roleInfoSet) {
        this.roleInfoSet = roleInfoSet;
    }

    public void setModuleSetSet(Set<Module> noduleSet) {
        this.moduleSet = noduleSet;
    }
}
