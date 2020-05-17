package com.zte.medicine.dao.impl;

import com.zte.medicine.dao.SaleDao;
import com.zte.medicine.entity.Sale;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

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
    public List<Sale> selectSale(Integer saleNum, Integer userId, String customerCode, Timestamp saleDate, Double amount1, String amount2) {
        String hql="select * from t_sale;";

        if (saleNum != null) {
            String hql1 = "select * from t_sale where SaleNum=" + saleNum + ";";
            hql = hql+"intersect"+hql1;
        }

        if (userId != null) {
            String hql2 = "select * from t_sale where UserId=" + userId + ";";
            hql = hql+"intersect"+hql2;
        }

        if (customerCode != null) {
            String hql3 = "select * from t_sale where CustomerCode=" + customerCode + ";";
            hql = hql+"intersect"+hql3;
        }

        if (saleDate != null) {
            String hql4 = "select * from t_sale where SaleDate =" + saleDate + ";";
            hql = hql+"intersect"+hql4;
        }

        if (amount1 != null) {
            String hql5 = "select * from t_sale where Amount>=" + amount1 + ";";
            hql = hql+"intersect"+hql5;
        }

        if (amount2 != null) {
            String hql6 = "select * from t_sale where Amount<=" + amount2 + ";";
            hql = hql+"intersect"+hql6;
        }

        return (List<Sale>)sessionFactory.getCurrentSession().createSQLQuery(hql).list();
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
