package com.zte.medicine.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Author:helloboy
 * Date:2020-05-19 22:24
 * Description:<描述>
 */
@Entity
@Table(name = "t_stock_comment", schema = "medicine", catalog = "")
public class StockComment {
    private Integer id;
    private Integer stockNum;
    private String medicineCode;
    private Integer workNum;
    private Integer number;
    private Double amount;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "StockNum", nullable = false)
    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    @Basic
    @Column(name = "MedicineCode", nullable = false, length = 64)
    public String getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(String medicineCode) {
        this.medicineCode = medicineCode;
    }

    @Basic
    @Column(name = "WorkNum", nullable = true)
    public Integer getWorkNum() {
        return workNum;
    }

    public void setWorkNum(Integer workNum) {
        this.workNum = workNum;
    }

    @Basic
    @Column(name = "Number", nullable = true)
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(name = "Amount", nullable = true, precision = 0)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockComment that = (StockComment) o;
        return id == that.id &&
                stockNum == that.stockNum &&
                Objects.equals(medicineCode, that.medicineCode) &&
                Objects.equals(workNum, that.workNum) &&
                Objects.equals(number, that.number) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stockNum, medicineCode, workNum, number, amount);
    }
}
