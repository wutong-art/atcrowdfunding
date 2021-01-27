package com.wtcode.crowd.mvc.interceptor;

import com.wtcode.crowd.constant.CrowdConstant;
import com.wtcode.crowd.entity.Admin;
import com.wtcode.crowd.exception.AccessForbiddenException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author wtcode
 * @date 2021/1/27 - 9:32
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.通过request对象获取Session对象
        HttpSession session = request.getSession();

        // 2.尝试从session域中获取Admin对象
        Admin admin = (Admin) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN);

        // 3.判断Admin对象是否为空
        if(admin == null){
            // 4.抛出异常
            throw new AccessForbiddenException(CrowdConstant.MESSAGE_ACCESS_FOREIGN);

        }
        // 5.如果admin对象不为空，则返回true
        return true;
    }
}
