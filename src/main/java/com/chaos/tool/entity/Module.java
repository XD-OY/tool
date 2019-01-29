package com.chaos.tool.entity;

import java.util.HashSet;
import java.util.Set;

public class Module {
    private String moduleCode;
    private String moduleName;
    private Set<RoleInfo> roleSet=new HashSet<>();
    private Set<UserInfo> userSet=new HashSet<>();


    public String getModuleCode() {
        return moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public Set<RoleInfo> getRoleSet() {
        return roleSet;
    }

    public Set<UserInfo> getUserSet() {
        return userSet;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public void setRoleSet(Set<RoleInfo> roleSet) {
        this.roleSet = roleSet;
    }

    public void setUserSet(Set<UserInfo> userSet) {
        this.userSet = userSet;
    }
}
