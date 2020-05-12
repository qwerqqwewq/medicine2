package com.zte.medicine.service.impl;

import com.zte.medicine.dao.StockCommentDao;
import com.zte.medicine.entity.StockComment;
import com.zte.medicine.service.StockCommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-07 17:24
 * Description:<描述>
 */
@Service("StockCommentService")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class StockCommentServiceImpl implements StockCommentService {

    public StockCommentDao getStockCommentDao() {
        return stockCommentDao;
    }

    public void setStockCommentDao(StockCommentDao stockCommentDao) {
        this.stockCommentDao = stockCommentDao;
    }

    private StockCommentDao stockCommentDao;

    @Override
    public void addStockComment(StockComment stockComment) {
        stockCommentDao.insertStockComment(stockComment);
    }

    @Override
    public List<StockComment> findStockCommentAll() {
        return stockCommentDao.selectStockCommentAll();
    }

    @Override
    public StockComment findStockCommentByNum(Integer num) {
        return stockCommentDao.selectStockCommentByNum(num);
    }

    @Override
    public StockComment findStockCommentByCode(String code) {
        return stockCommentDao.selectStockCommentByCode(code);
    }
}
