package com.wtcode.crowd.service.impl;

import com.wtcode.crowd.constant.CrowdConstant;
import com.wtcode.crowd.entity.Admin;
import com.wtcode.crowd.entity.AdminExample;
import com.wtcode.crowd.exception.LoginFailedException;
import com.wtcode.crowd.mapper.AdminMapper;
import com.wtcode.crowd.service.AdminService;
import com.wtcode.crowd.util.CrowdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author wtcode
 * @date 2021/1/19 - 9:53
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    public void saveAdmin(Admin admin) {
        adminMapper.insert(admin);
    }


    public List<Admin> getAll() {
        return adminMapper.selectByExample(new AdminExample());
    }

    public Admin getAdminByLoginAcct(String loginAcct, String userPswd) {
        // 1.根据登录账号查询Admin对象
        //①创建AdminExample对象
        AdminExample adminExample = new AdminExample();
        //②创建Criteria对象
        AdminExample.Criteria criteria = adminExample.createCriteria();
        //③在Criteria中封装查询条件
        criteria.andLoginAcctEqualTo(loginAcct);
        //④调用AdminMapper方法执行查询
        List<Admin> list = adminMapper.selectByExample(adminExample);


        // 2.判断Admin对象是否为空
        if(list == null || list.size() == 0){
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }

        if(list.size() > 1){
            throw new RuntimeException(CrowdConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
        }
        // 3.如果Admin对象为空，则抛出异常
        Admin admin = list.get(0);
        if(admin == null){
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }

        // 4.如果Admin对象不为空则将数据库密码从对象中取出
        String userPswdDB = admin.getUserPswd();

        // 5.将表单提交的明文密码进行加密
        String userPswdForm = CrowdUtil.md5(userPswd);

        // 6.对密码进行比较
        if (!Objects.equals(userPswdDB,userPswdForm)){
            // 7.如果明文不一致则抛出异常
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }

        // 8.如果一致则返回Admin对象
        return admin;
    }
}
