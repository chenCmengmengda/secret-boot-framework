package cn.chenc.framework.core.model.request;


import cn.chenc.framework.core.util.IpUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2018/4/18 11:48
 * @since 1.0
 */
public class RequestUtil {

    /**
     * 获取所有参数键值拼接的字符串(例如："&a=1&b=2")
     * @return String
     */
    public static String getParameters() {
        HttpServletRequest request = RequestHolder.getRequest();
        if (null == request) {
            return null;
        }
        Enumeration<String> paraNames = request.getParameterNames();
        if (paraNames == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (paraNames.hasMoreElements()) {
            String paraName = paraNames.nextElement();
            sb.append("&").append(paraName).append("=").append(request.getParameter(paraName));
        }
        return sb.toString();
    }

    /**
     * 获取所有参数键值Map对象
     * @return
     */
    public static Map<String, String[]> getParametersMap() {
        HttpServletRequest request = RequestHolder.getRequest();
        if (null == request) {
            return new HashMap<>();
        }
        return request.getParameterMap();
    }

    /**
     * 获取request请求头中的值
     * @param headerName 请求头名称
     * @return
     */
    public static String getHeader(String headerName) {
        HttpServletRequest request = RequestHolder.getRequest();
        if (null == request) {
            return null;
        }
        return request.getHeader(headerName);
    }

    /**
     * 获取request请求头中的Referer
     * @return
     */
    public static String getReferer() {
        return getHeader("Referer");
    }

    /**
     * 获取request请求头中的User-Agent
     * @return
     */
    public static String getUa() {
        return getHeader("User-Agent");
    }

    /**
     * 获取IP
     * @return
     */
    public static String getIp() {
        HttpServletRequest request = RequestHolder.getRequest();
        if (null == request) {
            return null;
        }
        return IpUtil.getRealIp(request);
    }

    /**
     * 获取请求Url
     * @return
     */
    public static String getRequestUrl() {
        HttpServletRequest request = RequestHolder.getRequest();
        if (null == request) {
            return null;
        }
        return request.getRequestURL().toString();
    }

    /**
     * 获取请求方法
     * @return
     */
    public static String getMethod() {
        HttpServletRequest request = RequestHolder.getRequest();
        if (null == request) {
            return null;
        }
        return request.getMethod();
    }

    /**
     * 判断是否为ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request) {
        if (null == request) {
            request = RequestHolder.getRequest();
        }
        if (null == request) {
            return false;
        }
        return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))
                || request.getParameter("ajax") != null;

    }

}
