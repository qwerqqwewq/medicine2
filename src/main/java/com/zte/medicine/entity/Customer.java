package com.zte.medicine.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Author:helloboy
 * Date:2020-05-19 22:24
 * Description:<描述>
 */
@Entity
@Table(name = "t_customer", schema = "medicine", catalog = "")
public class Customer {
    private String customerCode;
    private String customerName;
    private Integer customerTel;
    private String city;

    @Id
    @Column(name = "CustomerCode", nullable = false, length = 64)
    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    @Basic
    @Column(name = "CustomerName", nullable = false, length = 64)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "CustomerTel", nullable = true)
    public Integer getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(Integer customerTel) {
        this.customerTel = customerTel;
    }

    @Basic
    @Column(name = "City", nullable = true, length = 64)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerCode, customer.customerCode) &&
                Objects.equals(customerName, customer.customerName) &&
                Objects.equals(customerTel, customer.customerTel) &&
                Objects.equals(city, customer.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerCode, customerName, customerTel, city);
    }
}
