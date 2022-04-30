package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.UmsAdmin;
import com.macro.mall.tiny.mbg.model.UmsPermission;
import com.macro.mall.tiny.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Slience
 * @version 1.0
 */
@Api(tags = "UserAdminController",description = "用户管理")
@Controller
@RequestMapping(value ="/admin")
public class UserAdminController {

    @Autowired
    private UmsAdminService umsAdminService;

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    @ResponseBody
    public CommonResult register(@RequestBody UmsAdmin umsAdminParam, BindingResult result){
        UmsAdmin umsAdmin = umsAdminService.register(umsAdminParam);
        if(umsAdmin == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login")
    @ResponseBody
    public CommonResult login(@RequestBody UmsAdmin umsAdminParam, BindingResult result){
        String token = umsAdminService.login(umsAdminParam.getUsername(), umsAdminParam.getPassword());
        if(token == null){
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String,String> tokenMap = new HashMap<String,String>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead","Bearer");
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "获取用户所有权限")
    @GetMapping(value = "/permission/{adminId}")
    @ResponseBody
    public CommonResult<List<UmsPermission>> getPermissionsList(@PathVariable Long adminId){
        List<UmsPermission> permissionsList = umsAdminService.getPermissionsList(adminId);
        return CommonResult.success(permissionsList);
    }
}
