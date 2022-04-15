package com.macro.mall.malltinymybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Slience
 * @version 1.0
 */

/**
 * mybatis配置类
 */
@Configuration
@MapperScan("com.macro.mall.malltinymybatis.mbg.mapper")
public class MyBatisConfig {

}
