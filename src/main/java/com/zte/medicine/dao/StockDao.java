package com.zte.medicine.dao;

import com.zte.medicine.entity.Stock;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-28 10:48
 * Description:<描述>
 */
public interface StockDao {

    /**
     * 添加库存信息
     * @param stock
     * @return
     */
    public void insertStock(Stock stock);

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
    public List<Stock> selectStockByNum(Integer num);

    /**
     * 根据操作员编码查询
     * @param id
     * @return
     */
    public List<Stock> selectStockById(Integer id);

    /**
     * 根据操作类型查询库存信息
     * @param type
     * @return
     */
    public List<Stock> selectStockByType(String type);

    /**
     * 根据操作时间查询
     * @param date
     * @return
     */
    public List<Stock> selectStockByDate(Timestamp date);
}
