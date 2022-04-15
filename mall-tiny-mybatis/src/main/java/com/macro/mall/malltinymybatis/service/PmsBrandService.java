package com.macro.mall.malltinymybatis.service;

import com.macro.mall.malltinymybatis.mbg.model.PmsBrand;

import java.util.List;

/**
 * @author Slience
 * @version 1.0
 */

public interface PmsBrandService {
    /**
     * 查询所有品牌列表
     * @return 查询所有品牌集合
     */
    List<PmsBrand> listAllBrand();

    /**
     * 添加新的品牌
     * @param pmsBrand 品牌数据
     * @return 添加结果
     */
    int createBrand(PmsBrand pmsBrand);

    /**
     * 更新品牌
     * @param id id
     * @param pmsBrand 品牌信息
     * @return 更新结果
     */
    int updateBrand(Long id,PmsBrand pmsBrand);

    /**
     * 删除指定id的品牌信息
     * @param id 品牌标识
     * @return 删除结果
     */
    int deleteBrand(Long id);

    /**
     * 分页查询
     * @param pageNum 页数
     * @param pageSize 页面数据量
     * @return 分页查询结果
     */
    List<PmsBrand> listBrand(Integer pageNum,Integer pageSize);

    /**
     * 根据品牌标识查询品牌具体信息
     * @param id 标识id
     * @return 品牌信息
     */
    PmsBrand getBrand(Long id);

}
