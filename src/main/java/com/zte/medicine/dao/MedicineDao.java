package com.zte.medicine.dao;

import com.zte.medicine.entity.Medicine;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-28 10:47
 * Description:<描述>
 */
public interface MedicineDao {

    /**
     * 添加药品信息
     * @param medicine
     */
    public void insertMedicine(Medicine medicine);

    /**
     * 修改药品信息
     * @param medicine
     */
    public void updateMedicine(Medicine medicine);

    /**
     * 高级检索 （该函数参数以编码为主，实际情况可从名称查询代码）
     * @param code1 药品编码
     * @param name  药品名称
     * @param code2 药品类别代码
     * @param stock1 库存最小值（范围）
     * @param stock2 库存最大值
     * @param code3 供应商编码
     * @param date1 生产日期
     * @param date2 有效期
     * @return
     */
    public List<Medicine> advancedSearch(String code1, String name, String code2, Integer stock1, String stock2, String code3, Timestamp date1, Timestamp date2);

    /**
     * 根据药品编码查询
     * @param code
     * @return
     */
    public Medicine selectMedicineByCode(String code);

    /**
     * 根据药品名称查询
     * @param name
     * @return
     */
    public List<Medicine> selectMedicineByName(String name);

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
    public void deleteMedicine(Medicine medicine);






}
