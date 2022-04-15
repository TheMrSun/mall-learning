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
}
