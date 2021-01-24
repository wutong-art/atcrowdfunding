package com.wtcode.crowd.mvc.handler;

import com.wtcode.crowd.entity.Admin;
import com.wtcode.crowd.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wtcode
 * @date 2021/1/21 - 10:29
 */
@Controller
public class TestHandler {

    @Autowired
    private AdminService adminService;

    @ResponseBody
    @RequestMapping("/send/array.html")
    public String testReceiveArrayOne(@RequestParam("array[]") List<Integer> array){
        for (Integer number : array) {
            System.out.println("number=" + number);
        }
        return "success";
    }

    @RequestMapping("/test/ssm.html")
    public String testSsm(ModelMap modelMap){
        List<Admin> adminList = adminService.getAll();
        modelMap.addAttribute("adminList",adminList);
        return "target";
    }

}
