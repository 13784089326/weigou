package com.rcm.vo;

import com.rcm.entity.WProduct;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author : RenChunMing
 * @Date : 2020/6/14 10:02.
 */
@Data
public class ProductVO implements Serializable {
    private WProduct product;
    private String productDesc;
}
