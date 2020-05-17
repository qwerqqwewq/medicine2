package com.zte.medicine.dao;

import com.zte.medicine.entity.Firm;

import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-28 10:46
 * Description:<描述>
 */
public interface FirmDao {

    /**
     * 添加供应商
     * @param firm
     * @return
     */
    public void insertFirm(Firm firm);

    /**
     * 根据供应商编码查询信息
     * @param code
     * @return
     */
    public List<Firm> selectFirmByCode(String code);

    /**
     * 根据供应商姓名查询信息
     * @param name
     * @return
     */
    public List<Firm> selectFirmByName(String name);

    /**
     * 修改供应商信息
     * @param firm
     * @return
     */
    public void updateFirm(Firm firm);

    /**
     * 根据供应商编码删除信息
     * @param code
     * @return
     */
    public void deleteFirmByCode(String code);
}
