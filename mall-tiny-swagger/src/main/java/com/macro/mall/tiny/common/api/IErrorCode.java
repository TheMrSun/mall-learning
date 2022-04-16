package com.macro.mall.tiny.common.api;

/**
 * 封装API错误码
 * @author Slience
 * @version 1.0
 */
public interface IErrorCode {
    /**
     * 获取状态码
     * @return 状态码
     */
    long getCode();

    /**
     * 获取状态码对应信息
     * @return 状态码信息
     */
    String getMessage();
}
