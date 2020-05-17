package com.zte.medicine.dao;

import com.zte.medicine.entity.StockComment;

import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-28 10:48
 * Description:<描述>
 */
public interface StockCommentDao {

    /**
     * 添加库存信息
     * @param stockComment
     * @return
     */
    public void insertStockComment(StockComment stockComment);

    /**
     * 查询所有的库存信息
     * @return
     */
    public List<StockComment> selectStockCommentAll();

    /**
     * 根据操作编码查询
     * @param num
     * @return
     */
    public List<StockComment> selectStockCommentByNum(Integer num);

    /**
     * 根据药品编码查询
     * @param code
     * @return
     */
    public List<StockComment> selectStockCommentByCode(String code);
}
