package com.zte.medicine.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Author:helloboy
 * Date:2020-05-19 22:24
 * Description:<描述>
 */
@Entity
@Table(name = "t_sale", schema = "medicine", catalog = "")
public class Sale {
    private Integer saleNum;
    private Integer userId;
    private String customerCode;
    private Timestamp saleDate;
    private double amount;

    @Id
    @Column(name = "SaleNum", nullable = false)
    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    @Basic
    @Column(name = "UserId", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "CustomerCode", nullable = false, length = 64)
    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    @Basic
    @Column(name = "SaleDate", nullable = false)
    public Timestamp getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Timestamp saleDate) {
        this.saleDate = saleDate;
    }

    @Basic
    @Column(name = "Amount", nullable = false, precision = 0)
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return saleNum == sale.saleNum &&
                userId == sale.userId &&
                Double.compare(sale.amount, amount) == 0 &&
                Objects.equals(customerCode, sale.customerCode) &&
                Objects.equals(saleDate, sale.saleDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleNum, userId, customerCode, saleDate, amount);
    }
}
