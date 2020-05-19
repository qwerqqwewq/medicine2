package com.zte.medicine.dao.impl;

import com.zte.medicine.dao.SaleDao;
import com.zte.medicine.entity.Sale;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:helloboy
 * Date:2020-03-13 9:18
 * Description:<描述>
 */
@Transactional(rollbackFor = Exception.class)
@Repository("SaleDao")
public class SaleDaoImpl implements SaleDao {

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void insertSale(Sale sale) {
        sessionFactory.getCurrentSession().save(sale);
    }

    @Override
    public List<Sale> selectSale(Integer saleNum, Integer userId, String customerCode, Timestamp saleDate,Timestamp saleDate2, Double amount1, Double amount2) {
        String hql="from Sale where 1=1";
        Map<String, Object> map = new HashMap<String, Object>();

        if (saleNum != null) {
            String hql1 = " and SaleNum = :saleNum";
            hql = hql+hql1;
            map.put("saleNum", saleNum);
        }

        if (userId != null) {
            String hql2 = " and UserId = :userId ";
            hql = hql+hql2;
            map.put("userId", userId);
        }

        if (customerCode.length()!=0) {
            String hql3 = " and CustomerCode= :customerCode";
            hql = hql+hql3;
            map.put("customerCode", customerCode);
        }

        if (saleDate != null) {
            String hql4 = " and SaleDate >= :saleDate";
            hql = hql+hql4;
            map.put("saleDate", saleDate);
        }

        if (saleDate2 != null) {
            String hql5 = " and SaleDate2 <= :saleDate2";
            hql = hql+hql5;
            map.put("saleDate2", saleDate2);
        }

        if (amount1 != null) {
            String hql6 = " and Amount >= :amount1";
            hql = hql+hql6;
            map.put("amount1", amount1);
        }

        if (amount2 != null) {
            String hql7 = " and Amount <= :amount2";
            hql = hql+hql7;
            map.put("amount2", amount2);
        }

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setProperties(map);

        return query.list();
    }

    @Override
    public List<Sale> selectSaleByNum(Integer num) {
        return (List<Sale>)sessionFactory.getCurrentSession().get(Sale.class,num);
    }

    @Override
    public List<Sale> selectSaleById(Integer id) {
        return (List<Sale>)sessionFactory.getCurrentSession().createSQLQuery("select * from t_sale where UserId="+id+";").list();
    }

    @Override
    public List<Sale> selectSaleByCode(String code) {
        return (List<Sale>)sessionFactory.getCurrentSession().createSQLQuery("select * from t_sale where CustomerCode="+code+";").list();
    }

    @Override
    public List<Sale> selectSaleByDate(Timestamp date) {
        return (List<Sale>)sessionFactory.getCurrentSession().createSQLQuery("select * from t_sale where SaleDate="+date+";").list();
    }

    @Override
    public List<Sale> selectSaleByAmount(double amount) {
        return (List<Sale>)sessionFactory.getCurrentSession().createSQLQuery("select * from t_sale where Amount="+amount+";").list();
    }

    @Override
    public void updateSaleByNum(Sale sale) {
        sessionFactory.getCurrentSession().update(sale);
    }

    @Override
    public List<Sale> selectAll() {
        return (List<Sale>)sessionFactory.getCurrentSession().createSQLQuery("select * from t_sale;").list();
    }
}
