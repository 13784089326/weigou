package com.rcm.weigouproductservice.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rcm.api.IProductService;
import com.rcm.commons.base.BaseServiceImpl;
import com.rcm.commons.base.IBaseDao;
import com.rcm.entity.WProduct;
import com.rcm.entity.WProductDesc;
import com.rcm.mapper.WProductDescMapper;
import com.rcm.mapper.WProductMapper;
import com.rcm.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @Author : RenChunMing
 * @Date : 2020/6/13 11:12.
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<WProduct> implements IProductService {
    @Autowired
    private WProductMapper productMapper;
    @Autowired
    private WProductDescMapper productDescMapper;

    @Override
    public IBaseDao<WProduct> getBaseDao() {
        return productMapper;
    }



    @Override
    @Transactional//事务控制
    public Long add(ProductVO productVO) {
        //添加商品基本信息
        productMapper.insertSelective(productVO.getProduct());
        //添加商品描述
        WProductDesc productDesc = new WProductDesc();
        productDesc.setProductId(productVO.getProduct().getId());
        productDesc.setProductDesc(productVO.getProductDesc());
        productDescMapper.insertSelective(productDesc);
        return productVO.getProduct().getId();
    }
}
