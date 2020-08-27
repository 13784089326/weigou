package com.rcm.commons.base;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author : RenChunMing
 * @Date : 2020/6/13 20:06.
 * 抽象类提供基本实现
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T>{
    /**
     * 注入mapper，但是注入那个mapper都不合适，所以抽取出BaseDao出来
     * */
    public abstract IBaseDao<T> getBaseDao();
    public int deleteByPrimaryKey(Long id) {
        return getBaseDao().deleteByPrimaryKey(id);
    }

    public int insert(T t) {
        return getBaseDao().insert(t);
    }

    public int insertSelective(T t) {
        return getBaseDao().insertSelective(t);
    }

    public T selectByPrimaryKey(Long id) {
        return getBaseDao().selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(T t) {
        return getBaseDao().updateByPrimaryKeySelective(t);
    }

    public int updateByPrimaryKeyWithBLOBs(T t) {
        return getBaseDao().updateByPrimaryKeyWithBLOBs(t);
    }

    public int updateByPrimaryKey(T t) {
        return getBaseDao().updateByPrimaryKey(t);
    }
    public List<T> list() {
        return getBaseDao().list();
    }
    public PageInfo<T> page(Integer pageIndex, Integer pageSize) {
        //配置分页信息
        PageHelper.startPage(pageIndex,pageSize);
        //获取集合信息
        List<T> list = this.list();
        //返回分页对象
        PageInfo<T>pageInfo=new PageInfo<T>(list,3);
        return pageInfo;
    }
}
