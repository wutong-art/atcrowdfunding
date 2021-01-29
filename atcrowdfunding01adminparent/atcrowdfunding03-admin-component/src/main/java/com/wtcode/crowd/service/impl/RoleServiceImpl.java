package com.wtcode.crowd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wtcode.crowd.entity.Role;
import com.wtcode.crowd.mapper.RoleMapper;
import com.wtcode.crowd.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wtcode
 * @date 2021/1/29 - 11:01
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize, String keyword) {
        // 1.开启分页功能
        PageHelper.startPage(pageNum,pageSize);

        // 2.执行查询
        List<Role> roleList = roleMapper.selectRoleByKeyWord(keyword);

        return new PageInfo<>(roleList);
    }
}