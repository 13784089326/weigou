package com.rcm.weigoucenter.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.rcm.api.IProductService;
import com.rcm.entity.WProduct;
import com.rcm.vo.ProductVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author : RenChunMing
 * @Date : 2020/6/13 17:53.
 */
@Controller
@RequestMapping("product")
public class ProductController {
    /**
     * 启动时检查机制
     */
    @Reference(check = false)
    private IProductService productService;
    @RequestMapping("get/{id}")
    @ResponseBody
    public WProduct getById(@PathVariable("id") Long id){
        return productService.selectByPrimaryKey(id);
    }
    @RequestMapping("list")
    public String list(Model model){
        List<WProduct> list=productService.list();
        model.addAttribute("list",list);
        return "product/list";
    }
    @RequestMapping("page/{pageIndex}/{pageSize}")
    public String page(Model model,@PathVariable("pageIndex") Integer pageIndex,@PathVariable("pageSize")Integer pageSize){
        PageInfo<WProduct> page = productService.page(pageIndex, pageSize);
        model.addAttribute("page",page);
        return "product/list";
    }
    @RequestMapping("add")
    public String add(ProductVO vo){
        Long newId=productService.add(vo);
        //跳转回第一页
        return "redirect:/product/page/1/1";
    }
}
