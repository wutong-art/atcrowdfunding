package com.wtcode.crowd.service;

import com.github.pagehelper.PageInfo;
import com.wtcode.crowd.entity.Role;

/**
 * @author wtcode
 * @date 2021/1/29 - 11:01
 */
public interface RoleService {

    PageInfo<Role> getPageInfo(Integer pageNum,Integer pageSize,String keyword);


}
