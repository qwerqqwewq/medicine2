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

    private StockDao stockDao;

    @Override
    public void addStock(Stock stock) {
        stockDao.insertStock(stock);
    }

    @Override
    public List<Stock> selectAll() {
        return stockDao.selectAll();
    }

    @Override
    public Stock findStockByNum(Integer num) {
        return stockDao.selectStockByNum(num);
    }

    @Override
    public Stock findStockById(Integer id) {
        return stockDao.selectStockById(id);
    }

    @Override
    public Stock findStockByType(String type) {
        return stockDao.selectStockByType(type);
    }

    @Override
    public Stock findStockByDate(Timestamp date) {
        return stockDao.selectStockByDate(date);
    }
}
