package com.zte.medicine.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Author:helloboy
 * Date:2020-05-28 19:36
 * Description:<描述>
 */
@Entity
@Table(name = "t_sale_comment", schema = "medicine", catalog = "")
public class SaleComment {
    private int id;
    private int saleNum;
    private String medicineCode;
    private String price;
    private Integer number;
    private Double amount;
    private Sale saleBySaleNum;
    private Sale saleBySaleNum_0;
    private Medicine medicineByMedicineCode;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SaleNum", nullable = false)
    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
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
    @Column(name = "Price", nullable = true, length = 64)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
        SaleComment that = (SaleComment) o;
        return id == that.id &&
                saleNum == that.saleNum &&
                Objects.equals(medicineCode, that.medicineCode) &&
                Objects.equals(price, that.price) &&
                Objects.equals(number, that.number) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, saleNum, medicineCode, price, number, amount);
    }

    @ManyToOne
    @JoinColumn(name = "SaleNum", referencedColumnName = "SaleNum", nullable = false)
    public Sale getSaleBySaleNum() {
        return saleBySaleNum;
    }

    public void setSaleBySaleNum(Sale saleBySaleNum) {
        this.saleBySaleNum = saleBySaleNum;
    }

    @ManyToOne
    @JoinColumn(name = "SaleNum", referencedColumnName = "SaleNum", nullable = false)
    public Sale getSaleBySaleNum_0() {
        return saleBySaleNum_0;
    }

    public void setSaleBySaleNum_0(Sale saleBySaleNum_0) {
        this.saleBySaleNum_0 = saleBySaleNum_0;
    }

    @ManyToOne
    @JoinColumn(name = "MedicineCode", referencedColumnName = "MedicineCode", nullable = false)
    public Medicine getMedicineByMedicineCode() {
        return medicineByMedicineCode;
    }

    public void setMedicineByMedicineCode(Medicine medicineByMedicineCode) {
        this.medicineByMedicineCode = medicineByMedicineCode;
    }
}
