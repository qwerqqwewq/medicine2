package com.zte.medicine.service;

import com.zte.medicine.entity.Medicine;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-07 17:15
 * Description:<描述>
 */
public interface MedicineService {
    /**
     * 添加药品信息
     * @param medicine
     */
    public void addMedicine(Medicine medicine);

    /**
     * 修改药品信息
     * @param medicine
     */
    public void modifyMedicine(Medicine medicine);

    /**
     * 高级检索 （该函数参数以编码为主，实际情况可从名称查询代码）
     * @param name  药品名称
     * @param code2 药品类别代码
     * @param code3 供应商编码
     * @param listPrice 进价最小值
     * @param listPrice2 进价最大值
     * @param price 售价最小值
     * @param price2 售价最大值
     * @param date1 生产日期最小值
     * @param date2 生产日期最大值
     * @param date3 有效期最小值
     * @param date4 有效期最大值
     * @return
     */
    public List<Medicine> advancedSearch(String name, String code2, String code3, String listPrice,String listPrice2,String price,String price2,Timestamp date1, Timestamp date2,Timestamp date3,Timestamp date4);

    /**
     * 根据药品编码查询
     * @param code
     * @return
     */
    public Medicine findMedicineByCode(String code);

    /**
     * 根据药品名称查询
     * @param name
     * @return
     */
    public List<Medicine> findMedicineByName(String name);

    ///**
    // * 根据药品种类代码查询
    // * @param code
    // * @return
    // */
    //public Medicine selectMedicineByKind(String code);
    //
    ///**
    // * 根据供应商编码查询
    // * @param code
    // * @return
    // */
    //public Medicine selectMedicineByFirm(String code);
    //
    ///**
    // * 根据生产日期查询
    // * @param date
    // * @return
    // */
    //public Medicine selectMedicineByDate(Timestamp date);
    //
    ///**
    // * 查询过期药品
    // * @param date
    // * @return
    // */
    //public Medicine selectMedicineByUsefulDate(Timestamp date);

    /**
     * 删除药品
     * @param medicine
     */
    public void removeMedicine(Medicine medicine);

}
