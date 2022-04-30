package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Slience
 * @version 1.0
 */
@Mapper
public interface UmsAdminRoleRelationDao {
    /**
     * 获取用户对应的权限
     * @param adminId 用户id
     * @return 权限集合
     */
    List<UmsPermission> getPermissionsList(@Param("adminId") Long adminId);

}
