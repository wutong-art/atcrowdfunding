package com.wtcode.crowd.mvc.config;

import com.wtcode.crowd.constant.CrowdConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wtcode
 * @date 2021/2/26 - 17:34
 */
// 表示当前类是一个配置类
@Configuration
// 启用Web环境下权限控制功能
@EnableWebSecurity
// 启用全局方法权限控制功能，并且设置prePostEnabled = true,保证@PreAuthority、@PreFilter、@PostFilter生效
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CrowdfundingSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        //builder.inMemoryAuthentication().withUser("tom").password("123123").roles("ADMIN");
        // 正式功能中使用基于数据库的认证
        builder
                .userDetailsService(userDetailsService)
                .passwordEncoder(getPasswordEncoder())
                ;
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.authorizeRequests()    // 对请求进行授权
                .antMatchers("/admin/to/login/page.html")   // 针对登录页进行设置
                .permitAll()            // 无条件访问
                .antMatchers("/bootstrap/**")       // 针对静态资源进行设置，无条件访问
                .permitAll()
                .antMatchers("/crowd/**")
                .permitAll()
                .antMatchers("/css/**")
                .permitAll()
                .antMatchers("/fonts/**")
                .permitAll()
                .antMatchers("/img/**")
                .permitAll()
                .antMatchers("/jquery/**")
                .permitAll()
                .antMatchers("/layer/**")
                .permitAll()
                .antMatchers("/script/**")
                .permitAll()
                .antMatchers("/WEB-INF/**")
                .permitAll()
                .antMatchers("/ztree/**")
                .permitAll()
                .antMatchers("/admin/get/page.html")    // 针对分页显示Admin数据设定访问控制
                //.hasRole("经理")                             // 要求具备经理的角色
                .access("hasRole('经理') or hasAuthority('user:get')")   // 要求具备“经理”角色和“user:get”权限之一
                .anyRequest()                               // 其他任意的请求
                .authenticated()                            // 认证后访问
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new AccessDeniedHandler() {
                    @Override
                    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                        httpServletRequest.setAttribute("exception",new Exception(CrowdConstant.MESSAGE_ACCESS_DENIED));
                        httpServletRequest.getRequestDispatcher("/WEB-INF/system-error.jsp").forward(httpServletRequest,httpServletResponse);
                    }
                })
                .and()
                .csrf()                                     // 访跨站请求伪造功能
                .disable()                                  // 禁用
                .formLogin()        // 开启表单登录功能
                .loginPage("/admin/to/login/page.html")     // 指定登录页面
                .loginProcessingUrl("/security/do/login.html")  // 指定处理登录请求的地址
                .defaultSuccessUrl("/admin/to/main/page.html")  // 指定登录成功后前往的地址
                .usernameParameter("loginAcct")                 // 账号的请求参数名称
                .passwordParameter("userPswd")                  // 密码的请求参数名称
                .and()
                .logout()                                       // 开启退出登录功能
                .logoutUrl("/security/do/logout.html")          // 指定退出登录功能
                .logoutSuccessUrl("/admin/to/login/page.html")  // 指定退出成功以后前往的地址
                ;
    }
}
