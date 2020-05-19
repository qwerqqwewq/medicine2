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
@Table(name = "t_stock", schema = "medicine", catalog = "")
public class Stock {
    private Integer stockNum;
    private Integer userId;
    private String workType;
    private Timestamp workDate;

    @Id
    @Column(name = "StockNum", nullable = false)
    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
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
    @Column(name = "WorkType", nullable = false, length = 64)
    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    @Basic
    @Column(name = "WorkDate", nullable = false)
    public Timestamp getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Timestamp workDate) {
        this.workDate = workDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return stockNum == stock.stockNum &&
                userId == stock.userId &&
                Objects.equals(workType, stock.workType) &&
                Objects.equals(workDate, stock.workDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockNum, userId, workType, workDate);
    }
}
