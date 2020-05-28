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
@Table(name = "t_stock", schema = "medicine", catalog = "")
public class Stock {
    private int stockNum;
    private int userId;
    private String workType;
    private Timestamp workDate;
    private User userByUserId;
    private Collection<StockComment> stockCommentsByStockNum;

    @Id
    @Column(name = "StockNum", nullable = false)
    public int getStockNum() {
        return stockNum;
    }

    public void setStockNum(int stockNum) {
        this.stockNum = stockNum;
    }

    @Basic
    @Column(name = "UserId", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "tStockByStockNum")
    public Collection<StockComment> getStockCommentsByStockNum() {
        return stockCommentsByStockNum;
    }

    public void setStockCommentsByStockNum(Collection<StockComment> stockCommentsByStockNum) {
        this.stockCommentsByStockNum = stockCommentsByStockNum;
    }
}
