package com.digiwin.bpm.ntko.repository;

import java.util.List;
import java.util.Map;

/**
 * @author：zhupeng
 * @Date：2020/8/18 23:57
 * @Desc：TODO
 */
public interface BaseRepository<T> {

    /*
     * 持久化对象的方法
     */
    public long add(T t);

    /*
     * 修改对象
     */
    public void update(T t);

    /*
     *  删除对象
     */
    public int delete(String id);

    /*
     *  查找所有对象的方法
     */
    public List<T> getAll();


    /*
     * 根据id查找对象
     */
    public T getById(String id);

    /*
     * 根据map条件查找对象
     */
    public List<T> getByMap(Map<String,Object> map);


    /*
     * 查询条数
     */
    public int countBySql(String sql);

    /*
     * 执行hql语句
     */
    public int executeHql(String hql);

    /*
     * 执行sql语句
     */
    public int executeSql(String sql);


    /*
     *根据sql语句查询map集合
     */
    public List<Map<String,Object>> getMapListBySql(String sql);
}
