package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.UmsAdmin;
import com.macro.mall.tiny.mbg.model.UmsPermission;

import java.util.List;

/**
 * 后台管理员service
 * @author Slience
 * @version 1.0
 */
public interface UmsAdminService {
    /**
     * 根据用户名称获取用户信息
     * @param username 名称
     * @return 用户信息
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册用户
     * @param umsAdminParam 注册用户信息
     * @return 注册信息
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名称
     * @param password 密码
     * @return 登录状态
     */
    String login(String username,String password);

    /**
     * 根据id获取对应的权限列表
     * @param adminId id
     * @return 权限列表
     */
    List<UmsPermission> getPermissionsList(Long adminId);

}
