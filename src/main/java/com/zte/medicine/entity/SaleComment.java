package com.zte.medicine.entity;

import javax.persistence.*;

/**
 * @Author:helloboy
 * Date:2020-03-12 23:23
 * Description:<描述>
 */
@Entity
@Table(name = "t_sale_comment", schema = "medicine", catalog = "")
public class SaleComment {
    private Integer id;
    private String medicineCode;
    private String price;
    private Integer number;
    private Double amount;
    private Sale tSaleBySaleNum;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (medicineCode != null ? !medicineCode.equals(that.medicineCode) : that.medicineCode != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (medicineCode != null ? medicineCode.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "SaleNum", referencedColumnName = "SaleNum", nullable = false)
    public Sale gettSaleBySaleNum() {
        return tSaleBySaleNum;
    }

    public void settSaleBySaleNum(Sale tSaleBySaleNum) {
        this.tSaleBySaleNum = tSaleBySaleNum;
    }
}
