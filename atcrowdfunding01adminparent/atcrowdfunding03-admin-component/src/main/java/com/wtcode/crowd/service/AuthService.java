package com.wtcode.crowd.service;

import com.wtcode.crowd.entity.Auth;

import java.util.List;
import java.util.Map;

/**
 * @author wtcode
 * @date 2021/2/22 - 16:29
 */
public interface AuthService {
    List<Auth> getAll();

    List<Integer> getAssignedAuthIdByRoleId(Integer roleId);

    void saveRoleAuthRelationship(Map<String, List<Integer>> map);
}
