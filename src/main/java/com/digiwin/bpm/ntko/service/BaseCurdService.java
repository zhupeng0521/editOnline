package com.digiwin.bpm.ntko.service;

import java.util.List;
import java.util.Map;

/**
 * @author：zhupeng
 * @Date：2020/8/18 23:57
 * @Desc：TODO
 */
public interface BaseCurdService<T> {

    /**
     * 持久化对象的方法
     *
     * @param t
     * @return
     */
    public long add(T t);

    /**
     * 修改对象
     *
     * @param t
     */
    public void update(T t);

    /**
     * 删除对象
     *
     * @param id
     * @return
     */
    public int delete(String id);

    /**
     * 查找所有对象的方法
     *
     * @return
     */
    public List<T> getAll();


    /**
     * 根据id查找对象
     *
     * @param id
     * @return
     */
    public T getById(String id);

    /**
     * 根据map条件查找对象
     *
     * @param map
     * @return
     */
    public List<T> getByMap(Map<String, Object> map);

    /**
     * 查询条数
     *
     * @param sql
     * @return
     */
    public int countBySql(String sql);

    /**
     * 执行hql语句
     *
     * @param hql
     * @return
     */
    public int executeHql(String hql);

    /**
     * 执行sql语句
     *
     * @param sql
     * @return
     */
    public int executeSql(String sql);


    /**
     * 根据sql语句查询map集合
     *
     * @param sql
     * @return
     */
    public List<Map<String, Object>> getMapListBySql(String sql);
}
