package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.mbg.mapper.PmsBrandMapper;
import com.macro.mall.tiny.mbg.model.PmsBrand;
import com.macro.mall.tiny.mbg.model.PmsBrandExample;
import com.macro.mall.tiny.service.PmsBrandService;
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

    @Override
    public int deleteBrand(Long id) {
        return this.pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return this.pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return this.pmsBrandMapper.selectByPrimaryKey(id);
    }
}
