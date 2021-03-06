package com.zte.medicine.dao.impl;

import com.zte.medicine.dao.StockCommentDao;
import com.zte.medicine.entity.StockComment;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-03-13 9:19
 * Description:<描述>
 */
@Transactional(rollbackFor = Exception.class)
@Repository("stockCommentDao")
public class StockCommentDaoImpl implements StockCommentDao {

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void insertStockComment(StockComment stockComment) {
        sessionFactory.getCurrentSession().save(stockComment);
    }

    @Override
    public List<StockComment> selectStockCommentAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from StockComment where 1=1");

        return query.list();
    }

    @Override
    public List<StockComment> selectStockCommentByNum(Integer num) {
        Query query = sessionFactory.getCurrentSession().createQuery("from StockComment where StockNum = :stockNum");
        query.setParameter("stockNum", num);
        return query.list();
    }

    @Override
    public List<StockComment> selectStockCommentByCode(String code) {
        Query query = sessionFactory.getCurrentSession().createQuery("from StockComment where MedicineCode = :MedicineCode");
        query.setParameter("MedicineCode", code);
        return query.list();
    }
}
