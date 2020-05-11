package com.zte.medicine.service;

import com.zte.medicine.entity.StockComment;

import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-07 17:16
 * Description:<描述>
 */
public interface StockCommentService {

    /**
     * 添加库存信息
     * @param stockComment
     * @return
     */
    public void addStockComment(StockComment stockComment);

    /**
     * 查询所有的库存信息
     * @return
     */
    public List<StockComment> findStockCommentAll();

    /**
     * 根据操作编码查询
     * @param num
     * @return
     */
    public StockComment findStockCommentByNum(Integer num);

    /**
     * 根据药品编码查询
     * @param code
     * @return
     */
    public StockComment findStockCommentByCode(String code);
}
