package com.macro.mall.malltinymybatis.controller;

import com.macro.mall.malltinymybatis.common.api.CommonResult;
import com.macro.mall.malltinymybatis.mbg.model.PmsBrand;
import com.macro.mall.malltinymybatis.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌管理controller
 *
 * @author Slience
 */
@Controller
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @GetMapping(value = "listAll")
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(this.pmsBrandService.listAllBrand());
    }

    @PostMapping(value = "/create")
    @ResponseBody
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        int count = pmsBrandService.createBrand(pmsBrand);
        if(count == 1){
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("createBrand success:{}",pmsBrand);
        } else{
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createBrand failed:{}",pmsBrand);
        }
        return commonResult;
    }

    /**
     * update
     * @param id id
     * @param pmsBrand 品牌信息
     * @param bindingResult 传参校验
     * @return 更新结果
     */
    @PostMapping(value = "/update/{id}")
    @ResponseBody
    public CommonResult updateBrand(@PathVariable Long id, @RequestBody PmsBrand pmsBrand, BindingResult bindingResult){
        CommonResult commonResult;
        int count = pmsBrandService.updateBrand(id, pmsBrand);
        if(count == 1){
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("updateBrand success:{}",pmsBrand);
        } else{
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updateBrand failed:{}",pmsBrand);
        }
        return commonResult;
    }

















}
