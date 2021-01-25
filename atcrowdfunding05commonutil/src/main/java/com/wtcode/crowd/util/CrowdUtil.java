package com.wtcode.crowd.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wtcode
 * @date 2021/1/25 - 15:14
 */
public class CrowdUtil {

    /**
     * 判断当前请求是否为Ajax请求
     * @param request
     * @return
     * true:当前请求是Ajax请求
     * false:当前请求不是Ajax请求
     */
    public static boolean judgeRequestType(HttpServletRequest request){
        //1.获取请求消息头
        String acceptHeader = request.getHeader("Accept");
        String xRequestHeader = request.getHeader("X-Requested-With");
        //2.判断
        return (acceptHeader != null && acceptHeader.contains("application/json"))
                ||(xRequestHeader !=null && xRequestHeader.equals("XMLHttpRequest"));
    }
}
