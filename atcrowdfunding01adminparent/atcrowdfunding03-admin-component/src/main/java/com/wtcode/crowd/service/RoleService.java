package com.wtcode.crowd.service;

import com.github.pagehelper.PageInfo;
import com.wtcode.crowd.entity.Role;

import java.util.List;

/**
 * @author wtcode
 * @date 2021/1/29 - 11:01
 */
public interface RoleService {

    PageInfo<Role> getPageInfo(Integer pageNum,Integer pageSize,String keyword);


    void saveRole(Role role);

    void updateRole(Role role);

    void removeRole(List<Integer> roleIdList);

    List<Role> getAssignedRole(Integer adminId);

    List<Role> getUnAssignedRole(Integer adminId);
}
