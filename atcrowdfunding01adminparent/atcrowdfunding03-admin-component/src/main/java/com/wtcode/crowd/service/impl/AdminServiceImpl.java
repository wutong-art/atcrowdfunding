package com.wtcode.crowd.service.impl;

import com.wtcode.crowd.entity.Admin;
import com.wtcode.crowd.entity.AdminExample;
import com.wtcode.crowd.mapper.AdminMapper;
import com.wtcode.crowd.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
