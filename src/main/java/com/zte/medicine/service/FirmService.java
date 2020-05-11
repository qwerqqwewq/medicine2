package com.zte.medicine.service;

import com.zte.medicine.entity.Firm;

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
    public Firm findFirmByCode(String code);

    /**
     * 根据供应商姓名查询信息
     * @param name
     * @return
     */
    public Firm findFirmByName(String name);

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
