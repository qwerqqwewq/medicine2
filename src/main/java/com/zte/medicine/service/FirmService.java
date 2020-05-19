package com.zte.medicine.service;

import com.zte.medicine.entity.Firm;

import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-07 17:15
 * Description:<描述>
 */
public interface FirmService {
    /**
     * 添加供应商
     * @param firm
     * @return
     */
    public void addFirm(Firm firm);

    /**
     * 根据供应商编码查询信息
     * @param code
     * @return
     */
    public List<Firm> findFirmByCode(String code);

    /**
     * 根据供应商姓名查询信息
     * @param name
     * @return
     */
    public List<Firm> findFirmByName(String name);


    public List<Firm> findAll();


    public List<Firm> findFirm(String code, String name);

    /**
     * 修改供应商信息
     * @param firm
     * @return
     */
    public void modifyFirm(Firm firm);

    /**
     * 根据供应商编码删除信息
     * @param code
     * @return
     */
    public void removeFirmByCode(String code);
}
