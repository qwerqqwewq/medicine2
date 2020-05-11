package com.zte.medicine.dao.impl;

import com.zte.medicine.dao.FirmDao;
import com.zte.medicine.entity.Firm;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author:helloboy
 * Date:2020-03-13 8:50
 * Description:<描述>
 */
@Transactional(rollbackFor = Exception.class)
@Repository("FirmDao")
public class FirmDaoImpl implements FirmDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void insertFirm(Firm firm) {
        sessionFactory.getCurrentSession().save(firm);
    }

    @Override
    public Firm selectFirmByCode(String code) {
        return (Firm)sessionFactory.getCurrentSession().get(Firm.class,code);
    }

    @Override
    public Firm selectFirmByName(String name) {
        return (Firm)sessionFactory.getCurrentSession().createSQLQuery("select * from t_firm where FirmName="+name+";");
    }

    @Override
    public void updateFirm(Firm firm) {
        sessionFactory.getCurrentSession().update(firm);
    }

    @Override
    public void deleteFirmByCode(String code) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(Firm.class,code));
    }
}
