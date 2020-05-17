package com.zte.medicine.service.impl;

import com.zte.medicine.dao.StockDao;
import com.zte.medicine.entity.Stock;
import com.zte.medicine.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-07 17:24
 * Description:<描述>
 */
@Service("StockDao")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class StockServiceImpl implements StockService {

    public StockDao getStockDao() {
        return stockDao;
    }

    public void setStockDao(StockDao stockDao) {
        this.stockDao = stockDao;
    }

    private StockDao stockDao;

    @Override
    public void addStock(Stock stock) {
        stockDao.insertStock(stock);
    }

    @Override
    public List<Stock> findAll() {
        return stockDao.selectAll();
    }

    @Override
    public List<Stock> findStockByNum(Integer num) {
        return stockDao.selectStockByNum(num);
    }

    @Override
    public List<Stock> findStockById(Integer id) {
        return stockDao.selectStockById(id);
    }

    @Override
    public List<Stock> findStockByType(String type) {
        return stockDao.selectStockByType(type);
    }

    @Override
    public List<Stock> findStockByDate(Timestamp date) {
        return stockDao.selectStockByDate(date);
    }
}
