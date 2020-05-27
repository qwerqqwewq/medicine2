package com.zte.medicine.dao.impl;

import com.zte.medicine.dao.FirmDao;
import com.zte.medicine.entity.Firm;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:helloboy
 * Date:2020-03-13 8:50
 * Description:<描述>
 */
@Transactional(rollbackFor = Exception.class)
@Repository("FirmDao")
public class FirmDaoImpl implements FirmDao {

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void insertFirm(Firm firm) {
        sessionFactory.getCurrentSession().save(firm);
    }

    @Override
    public List<Firm> selectAll(){
        return (List<Firm>) sessionFactory.getCurrentSession().createQuery("from Firm where 1=1").list();
    }

    @Override
    public List<Firm> selectFirmByCode(String code) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Firm where FirmCode = :FirmCode");
        query.setParameter("FirmCode", code);
        return query.list();

        //return (List<Firm>)sessionFactory.getCurrentSession().createSQLQuery("select * from t_firm where FirmCode="+code+";").list();
    }

    @Override
    public List<Firm> selectFirmByName(String firmName) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Firm where FirmName = :FirmName");
        query.setParameter("FirmName", firmName);
        return query.list();
    }

    @Override
    public List<Firm> selectFirm(String code,String name){

        String hql = "from Firm where 1=1";
        Map<String, Object> map = new HashMap<>();

        if (code.length()!=0) {
            hql = hql + " and firmCode = :FirmCode";
            map.put("FirmCode", code);
        }

        if (name.length()!=0) {
            hql = hql + " and firmName = :FirmName";
            map.put("FirmName", name);
        }

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setProperties(map);
        return query.list();


    }

    @Override
    public void updateFirm(Firm firm) {
        sessionFactory.getCurrentSession().update(firm);
    }

    @Override
    public void deleteFirmByCode(String code) {
        sessionFactory.getCurrentSession().delete(selectFirmByCode(code));
    }
}
