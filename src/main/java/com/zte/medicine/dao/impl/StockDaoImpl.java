package com.zte.medicine.dao.impl;

import com.zte.medicine.dao.StockDao;
import com.zte.medicine.entity.Stock;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-03-13 9:19
 * Description:<描述>
 */
@Transactional(rollbackFor = Exception.class)
@Repository("StockDao")
public class StockDaoImpl implements StockDao {

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void insertStock(Stock stock) {
        sessionFactory.getCurrentSession().save(stock);
    }

    @Override
    public List<Stock> selectAll() {
        return (List<Stock>)sessionFactory.getCurrentSession().createSQLQuery("select * from t_stock;").list();
    }

    @Override
    public List<Stock> selectStockByNum(Integer num) {
        return (List<Stock>)sessionFactory.getCurrentSession().get(Stock.class,num);
    }

    @Override
    public List<Stock> selectStockById(Integer id) {
        return (List<Stock>)sessionFactory.getCurrentSession().createSQLQuery("select * from t_stock where UserId="+ id +";").list();
    }

    @Override
    public List<Stock> selectStockByType(String type) {
        return (List<Stock>)sessionFactory.getCurrentSession().createSQLQuery("select * from t_stock where WorkType="+ type +";").list();
    }

    @Override
    public List<Stock> selectStockByDate(Timestamp date) {
        return (List<Stock>)sessionFactory.getCurrentSession().createSQLQuery("select * from t_stock where WorkDate="+date+";").list();
    }
}
