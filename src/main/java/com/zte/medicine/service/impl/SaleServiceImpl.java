package com.zte.medicine.service.impl;

import com.zte.medicine.dao.SaleDao;
import com.zte.medicine.entity.Sale;
import com.zte.medicine.service.SaleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-07 17:25
 * Description:<描述>
 */
@Service("SaleService")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class SaleServiceImpl implements SaleService {


    @Resource
    private SaleDao saleDao;

    @Override
    public void addSale(Sale sale) {
        saleDao.insertSale(sale);
    }

    @Override
    public List<Sale> findSaleByNum(Integer num) {
        return saleDao.selectSaleByNum(num);
    }

    @Override
    public List<Sale> findSaleById(Integer id) {
        return saleDao.selectSaleById(id);
    }

    @Override
    public List<Sale> findSaleByCode(String code) {
        return saleDao.selectSaleByCode(code);
    }

    @Override
    public List<Sale> findSaleByDate(Timestamp date) {
        return saleDao.selectSaleByDate(date);
    }

    @Override
    public List<Sale> findSaleByAmount(double amount) {
        return saleDao.selectSaleByAmount(amount);
    }

    @Override
    public void modifySaleByNum(Sale sale) {
        saleDao.updateSaleByNum(sale);
    }

    @Override
    public List<Sale> findSale(Integer saleNum, Integer userId, String customerCode, Timestamp saleDate,Timestamp saleDate2, Double amount1, Double amount2) {
        return saleDao.selectSale(saleNum,userId,customerCode,saleDate,saleDate2,amount1,amount2);
    }

    @Override
    public List<Sale> findAll() {
        return saleDao.selectAll();
    }
}
