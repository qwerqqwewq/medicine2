package com.zte.medicine.service;

import com.zte.medicine.entity.Stock;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author:helloboy
 * Date:2020-02-07 17:14
 * Description:<描述>
 */
public interface StockService {
    /**
     * 添加库存信息
     * @param stock
     * @return
     */
    public void addStock(Stock stock);

    /**
     * 显示全部库存信息（略）
     * @return
     */
    public List<Stock> selectAll();

    /**
     * 根据操作编码查询
     * @param num
     * @return
     */
    public Stock findStockByNum(Integer num);

    /**
     * 根据操作员编码查询
     * @param id
     * @return
     */
    public Stock findStockById(Integer id);

    /**
     * 根据操作类型查询库存信息
     * @param type
     * @return
     */
    public Stock findStockByType(String type);

    /**
     * 根据操作时间查询
     * @param date
     * @return
     */
    public Stock findStockByDate(Timestamp date);
}
