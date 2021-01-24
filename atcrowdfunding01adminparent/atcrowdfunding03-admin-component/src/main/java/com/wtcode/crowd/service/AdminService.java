package com.wtcode.crowd.service;

import com.wtcode.crowd.entity.Admin;

import java.util.List;

/**
 * @author wtcode
 * @date 2021/1/19 - 9:53
 */
public interface AdminService {

    void saveAdmin(Admin admin);

    List<Admin> getAll();

}
