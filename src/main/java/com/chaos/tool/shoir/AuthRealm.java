package com.chaos.tool.shoir;

import com.chaos.tool.entity.Module;
import com.chaos.tool.entity.RoleInfo;
import com.chaos.tool.entity.UserInfo;
import com.chaos.tool.service.impl.userService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private userService userService;

    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        UserInfo user = userService.findByUserCode(username);
        return new SimpleAuthenticationInfo(user, user.getPassWord(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        UserInfo user=(UserInfo) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        List<String> permissions=new ArrayList<>();
        Set<RoleInfo> roles = user.getRoleInfoSet();
        if(roles.size()>0) {
            for(RoleInfo role : roles) {
                Set<Module> modules = role.getModuleSet();
                if(modules.size()>0) {
                    for(Module module : modules) {
                        permissions.add(module.getModuleName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);//将权限放入shiro中.
        return info;
    }

}