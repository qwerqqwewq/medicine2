package com.zte.medicine.dao.impl;

import com.zte.medicine.dao.StockDao;
import com.zte.medicine.entity.Stock;
import org.hibernate.Query;
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
        Query query = sessionFactory.getCurrentSession().createQuery("from Stock where 1=1");
        return query.list();
    }

    @Override
    public List<Stock> selectStockByNum(Integer num) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Stock where StockNum = :StockNum");
        query.setParameter("StockNum", num);
        return query.list();
    }

    @Override
    public List<Stock> selectStockById(Integer id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Stock where UserId = :UserId");
        query.setParameter("UserId", id);
        return query.list();
    }

    @Override
    public List<Stock> selectStockByType(String type) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Stock where WorkType = :WorkType");
        query.setParameter("WorkType", type);
        return query.list();
    }

    @Override
    public List<Stock> selectStockByDate(Timestamp date) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Stock where WorkDate = :WorkDate");
        query.setParameter("WorkDate", date);
        return query.list();
    }
}
