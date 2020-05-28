package com.zte.medicine.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

/**
 * Author:helloboy
 * Date:2020-05-28 19:36
 * Description:<描述>
 */
@Entity
@Table(name = "t_sale", schema = "medicine", catalog = "")
public class Sale {
    private int saleNum;
    private String customerCode;
    private Timestamp saleDate;
    private double amount;
    private User userByUserId;
    private Customer customerByCustomerCode;
    private Collection<SaleComment> saleCommentsBySaleNum;
    private Collection<SaleComment> saleCommentsBySaleNum_0;

    @Id
    @Column(name = "SaleNum", nullable = false)
    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
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
                Double.compare(sale.amount, amount) == 0 &&
                Objects.equals(customerCode, sale.customerCode) &&
                Objects.equals(saleDate, sale.saleDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleNum, customerCode, saleDate, amount);
    }

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "CustomerCode", referencedColumnName = "CustomerCode", nullable = false)
    public Customer getCustomerByCustomerCode() {
        return customerByCustomerCode;
    }

    public void setCustomerByCustomerCode(Customer customerByCustomerCode) {
        this.customerByCustomerCode = customerByCustomerCode;
    }

    @OneToMany(mappedBy = "tSaleBySaleNum")
    public Collection<SaleComment> getSaleCommentsBySaleNum() {
        return saleCommentsBySaleNum;
    }

    public void setSaleCommentsBySaleNum(Collection<SaleComment> saleCommentsBySaleNum) {
        this.saleCommentsBySaleNum = saleCommentsBySaleNum;
    }

    @OneToMany(mappedBy = "tSaleBySaleNum_0")
    public Collection<SaleComment> getSaleCommentsBySaleNum_0() {
        return saleCommentsBySaleNum_0;
    }

    public void setSaleCommentsBySaleNum_0(Collection<SaleComment> saleCommentsBySaleNum_0) {
        this.saleCommentsBySaleNum_0 = saleCommentsBySaleNum_0;
    }
}
