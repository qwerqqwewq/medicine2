package com.zte.medicine.entity;

import javax.persistence.*;

/**
 * @Author:helloboy
 * Date:2020-03-12 23:23
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

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (stockNum != null ? !stockNum.equals(that.stockNum) : that.stockNum != null) return false;
        if (medicineCode != null ? !medicineCode.equals(that.medicineCode) : that.medicineCode != null) return false;
        if (workNum != null ? !workNum.equals(that.workNum) : that.workNum != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (stockNum != null ? stockNum.hashCode() : 0);
        result = 31 * result + (medicineCode != null ? medicineCode.hashCode() : 0);
        result = 31 * result + (workNum != null ? workNum.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
