package com.rcm.commons.base;


import java.util.List;

/**
 * @Author : RenChunMing
 * @Date : 2020/6/13 20:08.
 *
 */
public interface IBaseDao<T> {
    int deleteByPrimaryKey(Long id);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKeyWithBLOBs(T t);

    int updateByPrimaryKey(T t);

    List<T> list();
}
