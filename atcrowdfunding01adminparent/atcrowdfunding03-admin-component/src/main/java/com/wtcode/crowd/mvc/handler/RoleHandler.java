package com.wtcode.crowd.mvc.handler;

import com.github.pagehelper.PageInfo;
import com.wtcode.crowd.entity.Role;
import com.wtcode.crowd.service.RoleService;
import com.wtcode.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wtcode
 * @date 2021/1/29 - 11:03
 */

@RestController
public class RoleHandler {

    @Autowired
    private RoleService roleService;

    @RequestMapping("role/remove/by/role/id/array.json")
    public ResultEntity<String> removeByRoleIdArray(@RequestBody List<Integer> roleIdList){

        roleService.removeRole(roleIdList);

        return ResultEntity.successWithoutData();

    }

    @RequestMapping("role/save.json")
    public ResultEntity<String> saveRole(Role role){

        roleService.saveRole(role);

        return ResultEntity.successWithoutData();
    }

    @RequestMapping("role/update.json")
    public ResultEntity<String> updateRole(Role role){

        roleService.updateRole(role);

        return ResultEntity.successWithoutData();

    }

    @PreAuthorize("hasRole('部长')")
    @RequestMapping("role/get/page/info.json")
    public ResultEntity<PageInfo<Role>> getPageInfo(
            @RequestParam(value = "keyword",defaultValue = "") String keyword,
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize

    ){
        // 调用service方法获取分页数据
        PageInfo<Role> pageInfo = roleService.getPageInfo(pageNum, pageSize, keyword);
        // 封装到ResultEntity对象中返回
        return ResultEntity.successWithData(pageInfo);
    }



}
