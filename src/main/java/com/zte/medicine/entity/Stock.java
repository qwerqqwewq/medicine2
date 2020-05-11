package com.zte.medicine.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Author:helloboy
 * Date:2020-03-12 23:23
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

        Stock that = (Stock) o;

        if (stockNum != null ? !stockNum.equals(that.stockNum) : that.stockNum != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (workType != null ? !workType.equals(that.workType) : that.workType != null) return false;
        if (workDate != null ? !workDate.equals(that.workDate) : that.workDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockNum != null ? stockNum.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (workType != null ? workType.hashCode() : 0);
        result = 31 * result + (workDate != null ? workDate.hashCode() : 0);
        return result;
    }
}
