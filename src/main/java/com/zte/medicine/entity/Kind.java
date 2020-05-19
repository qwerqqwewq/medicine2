package com.zte.medicine.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Author:helloboy
 * Date:2020-05-19 22:24
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
        Kind kind = (Kind) o;
        return Objects.equals(kindCode, kind.kindCode) &&
                Objects.equals(kindRemark, kind.kindRemark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kindCode, kindRemark);
    }
}
