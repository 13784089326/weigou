package com.rcm.api;

import com.github.pagehelper.PageInfo;
import com.rcm.commons.base.IBaseService;
import com.rcm.entity.WProduct;
import com.rcm.vo.ProductVO;

import java.util.List;

/**
 * @Author : RenChunMing
 * @Date : 2020/6/11 21:15.
 */
public interface IProductService extends IBaseService<WProduct> {
   //public PageInfo<WProduct> page(Integer pageIndex, Integer pageSize);
    public Long add(ProductVO productVO);//返回主键
}
