package com.zte.medicine.dao.impl;

import com.zte.medicine.dao.KindDao;
import com.zte.medicine.entity.Kind;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author:helloboy
 * Date:2020-03-13 9:01
 * Description:<描述>
 */
@Transactional(rollbackFor = Exception.class)
@Repository("KindDao")
public class KindDaoImpl implements KindDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public Kind selectKindByCode(String code) {
        return (Kind)sessionFactory.getCurrentSession().get(Kind.class,code);
    }

    @Override
    public void insertKind(Kind kind) {
        sessionFactory.getCurrentSession().save(kind);
    }

    @Override
    public void updateKind(Kind kind) {
        sessionFactory.getCurrentSession().update(kind);
    }

    @Override
    public void deleteKindByCode(String code) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(Kind.class,code));
    }
}
