package com.zte.medicine.dao.impl;

import com.zte.medicine.dao.StockCommentDao;
import com.zte.medicine.entity.StockComment;
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
@Repository("StockCommentDao")
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
        return (List<StockComment>)sessionFactory.getCurrentSession().createSQLQuery("select * from t_stock_comment;");
    }

    @Override
    public StockComment selectStockCommentByNum(Integer num) {
        return (StockComment)sessionFactory.getCurrentSession().createSQLQuery("select * from t_stock_comment where StockNum="+num+";");
    }

    @Override
    public StockComment selectStockCommentByCode(String code) {
        return (StockComment)sessionFactory.getCurrentSession().createSQLQuery("select * from t_stock_comment where MedicineCode="+code+";");
    }
}
