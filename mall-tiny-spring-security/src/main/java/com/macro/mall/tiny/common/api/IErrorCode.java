package com.macro.mall.tiny.common.api;

/**
 * @author Slience
 * @version 1.0
 */
public interface IErrorCode {
    /**
     *
     * @return 操作码
     */
    long getCode();

    /**
     *
     * @return 操作码对应的与原因
     */
    String getMessage();
}
