package com.zte.medicine.service;

import com.zte.medicine.entity.SaleComment;

import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-07 17:15
 * Description:<描述>
 */
public interface SaleCommentService {
    /**
     * 添加销售信息
     * @param saleComment
     * @return
     */
    public void addSaleComment(SaleComment saleComment);

    /**
     * 查询所有的销售信息（具体）
     * @return
     */
    public List<SaleComment> findSaleCommentAll();

    /**
     * 根据销售编码查询信息
     * @param num
     * @return
     */
    public List<SaleComment> findSaleCommentByNum(String num);

    /**
     * 根据药品名称查询销售信息
     * @param code
     * @return
     */
    public List<SaleComment> findSaleCommentByCode(String code);
}
