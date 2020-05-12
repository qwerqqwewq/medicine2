package com.zte.medicine.service.impl;

import com.zte.medicine.dao.SaleDao;
import com.zte.medicine.entity.Sale;
import com.zte.medicine.service.SaleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * @Author:helloboy
 * Date:2020-02-07 17:25
 * Description:<描述>
 */
@Service("SaleService")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class SaleServiceImpl implements SaleService {

    public SaleDao getSaleDao() {
        return saleDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    private SaleDao saleDao;

    @Override
    public void addSale(Sale sale) {
        saleDao.insertSale(sale);
    }

    @Override
    public Sale findSaleByNum(Integer num) {
        return saleDao.selectSaleByNum(num);
    }

    @Override
    public Sale findSaleById(Integer id) {
        return saleDao.selectSaleById(id);
    }

    @Override
    public Sale findSaleByCode(String code) {
        return saleDao.selectSaleByCode(code);
    }

    @Override
    public Sale findSaleByDate(Timestamp date) {
        return saleDao.selectSaleByDate(date);
    }

    @Override
    public Sale findSaleByAmount(double amount) {
        return saleDao.selectSaleByAmount(amount);
    }

    @Override
    public void modifySaleByNum(Sale sale) {
        saleDao.updateSaleByNum(sale);
    }

    @Override
    public Sale findSale(Integer saleNum, Integer userId, String customerCode, Timestamp saleDate, Double amount1, String amount2) {
        return saleDao.selectSale(saleNum,userId,customerCode,saleDate,amount1,amount2);
    }

    @Override
    public Sale findAll() {
        return saleDao.selectAll();
    }
}
