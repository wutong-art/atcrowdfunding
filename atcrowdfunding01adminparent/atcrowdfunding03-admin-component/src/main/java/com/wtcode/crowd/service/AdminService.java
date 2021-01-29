package com.wtcode.crowd.service;

import com.github.pagehelper.PageInfo;
import com.wtcode.crowd.entity.Admin;

import java.util.List;

/**
 * @author wtcode
 * @date 2021/1/19 - 9:53
 */
public interface AdminService {

    void saveAdmin(Admin admin);

    List<Admin> getAll();

    Admin getAdminByLoginAcct(String loginAcct, String userPswd);

    PageInfo<Admin> getPageInfo(String keyword , Integer pageNum , Integer pageSize);

    void remove(Integer adminId);

    Admin getAdminById(Integer adminId);

    void update(Admin admin);
}
