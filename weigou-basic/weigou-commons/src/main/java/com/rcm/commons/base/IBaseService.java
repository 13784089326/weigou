package com.rcm.commons.base;


import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author : RenChunMing
 * @Date : 2020/6/13 20:02.
 * 抽取出共性方法
 * 接口：定义好规范
 */
public interface IBaseService<T> {

    int deleteByPrimaryKey(Long id);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKeyWithBLOBs(T t);

    int updateByPrimaryKey(T t);

    public List<T> list();

    public PageInfo<T> page(Integer pageIndex, Integer pageSize);
}
