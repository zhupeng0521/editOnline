package com.digiwin.bpm.ntko.repository.impl;

import com.digiwin.bpm.ntko.repository.BaseRepository;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
public class BaseRepositoryImpl<T> implements BaseRepository<T> {


    @Autowired
    private SessionFactory sessionFactory;

    protected Class<T> clazz;


    /**
     * 构造方法自动注入真实的对象类型
     */
    public BaseRepositoryImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
    }

    public Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public long add(T t) {
        if (t != null) {
            return (Long) this.getCurrentSession().save(t);
        }
        return 0;
    }


    @Override
    public void update(T t) {
        if (t != null) {
            this.getCurrentSession().update(t);
        }
    }


    @Override
    public int delete(String id) {
//        T t = this.getById(id);
//        this.getCurrentSession().delete(t);
        String hql = "delete " + clazz.getSimpleName() + " where id=" + id;
        return this.getCurrentSession().createQuery(hql).executeUpdate();
    }


    @Override
    public List<T> getAll() {
        String hql = "from " + clazz.getSimpleName();
        return this.getCurrentSession().createQuery(hql).list();
    }


    @Override
    public T getById(String id) {
        return (T) this.getCurrentSession().get(this.clazz,id);
    }


    @Override
    public List<T> getByMap(Map<String, Object> map) {
        Set<String> set = map.keySet();
        if (set.size() > 0) {
            List<String> list = new ArrayList<String>();
            for (String string : set) {
                list.add(string);
            }
            String hql = "from " + clazz.getSimpleName() + " where ";
            for (int i = 0; i <= list.size() - 1; i++) {
                if (i == 0) {
                    hql += list.get(i) + "='" + map.get(list.get(i)) + "'";
                } else {
                    hql += " and " + list.get(i) + "='" + map.get(list.get(i)) + "'";
                }
            }
            return this.getCurrentSession().createQuery(hql).list();
        }
        return null;
    }


    @Override
    public int countBySql(String sql) {
        SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
        return ((BigInteger) q.uniqueResult()).intValue();
    }
    @Override
    public int executeHql(String hql){
        Query q = this.getCurrentSession().createQuery(hql);
        return ((Query) q).executeUpdate();
    }


    @Override
    public int executeSql(String sql){
        SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
        return q.executeUpdate();
    }



    @Override
    public List<Map<String, Object>> getMapListBySql(String sql) {
        SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return(List<Map<String, Object>>) query.list();
    }


}