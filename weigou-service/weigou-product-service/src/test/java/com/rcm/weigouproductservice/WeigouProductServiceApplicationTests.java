package com.rcm.weigouproductservice;

import com.github.pagehelper.PageInfo;
import com.rcm.api.IProductService;
import com.rcm.entity.WProduct;
import com.rcm.vo.ProductVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class WeigouProductServiceApplicationTests {
    @Autowired
    private IProductService productService;
    @Test
    public void contextLoads() {
        WProduct product= productService.selectByPrimaryKey(1L);
        System.out.println(product.getName());
    }
    @Test
    public void listTest(){
        List<WProduct> list=productService.list();
        for (WProduct wProduct : list) {
            System.out.println(wProduct.getName());
        }
        Assert.notNull(list);
    }
    @Test
    public void pageTest(){
        PageInfo<WProduct> page = productService.page(1, 1);
        System.out.println(page.getList().size());
    }
    @Test
    public void addTest(){
        WProduct product=new WProduct();
        product.setName("360手机");
        product.setPrice(2999L);
        product.setSalePoint("杀毒");
        product.setSalePrice(1900L);
        product.setImages("123");
        product.setTypeId(2);
        product.setTypeName("电子数码");
        ProductVO vo=new ProductVO();
        vo.setProduct(product);
        vo.setProductDesc("杀毒能力非常强悍！");
        System.out.println(productService.add(vo));
    }
}
