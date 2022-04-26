package com.macro.mall.tiny.service;

import com.macro.mall.tiny.common.api.CommonResult;

/**
 * @author Slience
 * @version 1.0
 */
public interface UmsMemberService {
    /**
     * 生成验证码
     * @param telephone 注册或者登录的手机
     * @return 返回结果
     */
    CommonResult generateAuthCode(String telephone);
}
