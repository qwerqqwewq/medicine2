package com.zte.medicine.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * Author:helloboy
 * Date:2020-05-28 19:36
 * Description:<描述>
 */
@Entity
@Table(name = "t_kind", schema = "medicine", catalog = "")
public class Kind {
    private String kindCode;
    private String kindRemark;
    private Collection<Medicine> medicinesByKindCode;
    private Collection<Medicine> medicinesByKindCode_0;

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

    @OneToMany(mappedBy = "tKindByKindCode")
    public Collection<Medicine> getMedicinesByKindCode() {
        return medicinesByKindCode;
    }

    public void setMedicinesByKindCode(Collection<Medicine> medicinesByKindCode) {
        this.medicinesByKindCode = medicinesByKindCode;
    }

    @OneToMany(mappedBy = "tKindByKindCode_0")
    public Collection<Medicine> getMedicinesByKindCode_0() {
        return medicinesByKindCode_0;
    }

    public void setMedicinesByKindCode_0(Collection<Medicine> medicinesByKindCode_0) {
        this.medicinesByKindCode_0 = medicinesByKindCode_0;
    }
}
