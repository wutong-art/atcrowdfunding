package com.wtcode.crowd.mvc.config;

import com.wtcode.crowd.entity.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

/**
 * @author wtcode
 * @date 2021/2/27 - 11:04
 * 考虑到User对象中仅仅包含账号和密码，为了获取到原始的Admin对象，专门创建这个类对User类进行扩展
 */
public class SecurityAdmin extends User {

    private static final long serialVersionUID = 1L;

    // 原始Admin对象，包含Admin对象的全部属性
    private Admin originalAdmin;

    public SecurityAdmin(Admin originalAdmin , List<GrantedAuthority> authorities){
        // 调用父类构造器
        super(originalAdmin.getLoginAcct(),originalAdmin.getUserPswd(),authorities);

        // 给本类的this.originalAdmin赋值
        this.originalAdmin = originalAdmin;

        // 将原始Admin对象中的密码擦除
        this.originalAdmin.setUserPswd(null);
    }

    // 对外提供获取原始Admin对象的getXXX方法
    public Admin getOriginalAdmin() {
        return originalAdmin;
    }
}
