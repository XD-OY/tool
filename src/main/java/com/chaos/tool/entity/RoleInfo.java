package com.chaos.tool.entity;

import java.util.HashSet;
import java.util.Set;

public class RoleInfo {
    private String roleCode;
    private String roleName;
    private Set<UserInfo> userSet=new HashSet<>();
    private Set<Module> moduleSet=new HashSet<>();


    public String getRoleCode() {
        return roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public Set<UserInfo> getUserSet() {
        return userSet;
    }

    public Set<Module> getModuleSet() {
        return moduleSet;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setUserSet(Set<UserInfo> userSet) {
        this.userSet = userSet;
    }

    public void setModuleSet(Set<Module> moduleSet) {
        this.moduleSet = moduleSet;
    }
}
