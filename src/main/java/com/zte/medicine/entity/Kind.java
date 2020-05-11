package com.zte.medicine.entity;

import javax.persistence.*;

/**
 * @Author:helloboy
 * Date:2020-03-12 23:23
 * Description:<描述>
 */
@Entity
@Table(name = "t_kind", schema = "medicine", catalog = "")
public class Kind {
    private String kindCode;
    private String kindRemark;

    @Id
    @Column(name = "KindCode", nullable = false, length = 20)
    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    @Basic
    @Column(name = "KindRemark", nullable = false, length = 20)
    public String getKindRemark() {
        return kindRemark;
    }

    public void setKindRemark(String kindRemark) {
        this.kindRemark = kindRemark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kind that = (Kind) o;

        if (kindCode != null ? !kindCode.equals(that.kindCode) : that.kindCode != null) return false;
        if (kindRemark != null ? !kindRemark.equals(that.kindRemark) : that.kindRemark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kindCode != null ? kindCode.hashCode() : 0;
        result = 31 * result + (kindRemark != null ? kindRemark.hashCode() : 0);
        return result;
    }
}
