package com.digiwin.bpm.ntko.service.impl;

import com.digiwin.bpm.ntko.repository.BaseRepository;
import com.digiwin.bpm.ntko.service.BaseService;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author：zhupeng
 * @Date：2020/8/19 00:02
 * @Desc：TODO
 */
@Transactional(rollbackFor = RuntimeException.class)
public class BaseServiceImpl<T> implements BaseService<T> {


    @Autowired
    private BaseRepository baseRepository;

    @Override
    public long add(T t) {
        return baseRepository.add(t);
    }

    @Override
    public void update(T t) {
        baseRepository.update(t);
    }

    @Override
    public int delete(String id) {
        return this.baseRepository.delete(id);
    }

    @Override
    public List<T> getAll() {
        return this.baseRepository.getAll();
    }

    @Override
    public T getById(String id) {
        return (T) this.baseRepository.getById(id);
    }

    @Override
    public List<T> getByMap(Map<String, Object> map) {
        return this.baseRepository.getByMap(map);
    }

    @Override
    public int countBySql(String sql) {
        return this.baseRepository.countBySql(sql);
    }

    @Override
    public int executeHql(String hql) {
        return this.baseRepository.executeHql(hql);
    }

    @Override
    public int executeSql(String sql) {
        return this.baseRepository.countBySql(sql);
    }

    @Override
    public List<Map<String, Object>> getMapListBySql(String sql) {
        return this.baseRepository.getMapListBySql(sql);
    }

}