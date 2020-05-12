package com.zte.medicine.dao.impl;

import com.zte.medicine.dao.SaleCommentDao;
import com.zte.medicine.entity.SaleComment;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-03-13 9:18
 * Description:<描述>
 */
@Transactional(rollbackFor = Exception.class)
@Repository("SaleCommentDao")
public class SaleCommentDaoImpl implements SaleCommentDao {

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void insertSaleComment(SaleComment saleComment) {
        sessionFactory.getCurrentSession().save(saleComment);
    }

    @Override
    public List<SaleComment> selectSaleCommentAll() {
        return (List<SaleComment>) sessionFactory.getCurrentSession().createSQLQuery("select * from t_sale_comment");
    }

    @Override
    public SaleComment selectSaleCommentByNum(String num) {
        return (SaleComment)sessionFactory.getCurrentSession().createSQLQuery("select * from t_sale_comment where SaleNum="+num+";");
    }

    @Override
    public SaleComment selectSaleCommentByCode(String code) {
        return (SaleComment)sessionFactory.getCurrentSession().createSQLQuery("select * from t_sale_comment where MedicineCode="+code+";");
    }
}
