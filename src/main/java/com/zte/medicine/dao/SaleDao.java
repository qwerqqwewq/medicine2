package com.zte.medicine.dao;

import com.zte.medicine.entity.Sale;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-28 10:48
 * Description:<描述>
 */
public interface SaleDao {

    /**
     * 添加销售信息
     * @param sale
     * @return
     */
    public void insertSale(Sale sale);

    /**
     * 高级索引
     * @param saleNum 销售编码
     * @param userId 销售员编码
     * @param customerCode 客户编码
     * @param saleDate 销售日期
     * @param amount1 金额下限
     * @param amount2 金额上限
     * @return
     */
    public List<Sale> selectSale(Integer saleNum, Integer userId, String customerCode, Timestamp saleDate, Double amount1, String amount2);

    /**
     * 根据销售编码查询销售信息
     * @param num
     * @return
     */
    public List<Sale> selectSaleByNum(Integer num);

    /**
     * 根据销售员编号查询销售信息
     * @param id
     * @return
     */
    public List<Sale> selectSaleById(Integer id);

    /**
     * 根据客户编码查询销售信息
     * @param code
     * @return
     */
    public List<Sale> selectSaleByCode(String code);

    /**
     * 根据销售日期查询销售信息
     * @param date
     * @return
     */
    public List<Sale> selectSaleByDate(Timestamp date);

    /**
     * 根据销售的总金额查询
     * @param amount
     * @return
     */
    public List<Sale> selectSaleByAmount(double amount);

    /**
     * 删除销售信息（仅管理员可）
     * @param sale
     * @return
     */
    public void updateSaleByNum(Sale sale);

    /**
     * 显示所有销售信息
     * @return
     */
    public List<Sale> selectAll();
}
