package com.zte.medicine.service.impl;

import com.zte.medicine.dao.SaleCommentDao;
import com.zte.medicine.entity.SaleComment;
import com.zte.medicine.service.SaleCommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-07 17:25
 * Description:<描述>
 */
@Service("SaleCommentService")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class SaleCommentServiceImpl implements SaleCommentService {


    @Resource
    private SaleCommentDao saleCommentDao;

    @Override
    public void addSaleComment(SaleComment saleComment) {
        saleCommentDao.insertSaleComment(saleComment);
    }

    @Override
    public List<SaleComment> findSaleCommentAll() {
        return saleCommentDao.selectSaleCommentAll();
    }

    @Override
    public List<SaleComment> findSaleCommentByCode(String code) {
        return saleCommentDao.selectSaleCommentByCode(code);
    }

    @Override
    public List<SaleComment> findSaleCommentByNum(String num) {
        return saleCommentDao.selectSaleCommentByNum(num);
    }
}
