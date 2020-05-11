package com.zte.medicine.dao;

import com.zte.medicine.entity.SaleComment;

import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-28 10:47
 * Description:<描述>
 */
public interface SaleCommentDao {

    /**
     * 添加销售信息
     * @param saleComment
     * @return
     */
    public void insertSaleComment(SaleComment saleComment);

    /**
     * 查询所有的销售信息（具体）
     * @return
     */
    public List<SaleComment> selectSaleCommentAll();

    /**
     * 根据销售编码查询信息
     * @param num
     * @return
     */
    public SaleComment selectSaleCommentByNum(String num);

    /**
     * 根据药品编码查询销售信息
     * @param code
     * @return
     */
    public SaleComment selectSaleCommentByCode(String code);
}
