package com.macro.mall.malltinymybatis.service.impl;

import com.macro.mall.malltinymybatis.mbg.mapper.PmsBrandMapper;
import com.macro.mall.malltinymybatis.mbg.model.PmsBrand;
import com.macro.mall.malltinymybatis.mbg.model.PmsBrandExample;
import com.macro.mall.malltinymybatis.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Slience
 * @version 1.0
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return this.pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand pmsBrand) {
        return this.pmsBrandMapper.insertSelective(pmsBrand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand pmsBrand) {
        pmsBrand.setId(id);
        return this.pmsBrandMapper.updateByPrimaryKeySelective(pmsBrand);
    }
}
