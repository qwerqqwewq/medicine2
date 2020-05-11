package com.zte.medicine.entity;

import javax.persistence.*;

/**
 * @Author:helloboy
 * Date:2020-03-12 23:23
 * Description:<描述>
 */
@Entity
@Table(name = "t_firm", schema = "medicine", catalog = "")
public class Firm {
    private String firmCode;
    private String firmName;
    private String link;
    private Integer linkTel;
    private String city;

    @Id
    @Column(name = "FirmCode", nullable = false, length = 64)
    public String getFirmCode() {
        return firmCode;
    }

    public void setFirmCode(String firmCode) {
        this.firmCode = firmCode;
    }

    @Basic
    @Column(name = "FirmName", nullable = false, length = 64)
    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    @Basic
    @Column(name = "Link", nullable = true, length = 64)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Column(name = "LinkTel", nullable = true)
    public Integer getLinkTel() {
        return linkTel;
    }

    public void setLinkTel(Integer linkTel) {
        this.linkTel = linkTel;
    }

    @Basic
    @Column(name = "City", nullable = true, length = 20)
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

        Firm that = (Firm) o;

        if (firmCode != null ? !firmCode.equals(that.firmCode) : that.firmCode != null) return false;
        if (firmName != null ? !firmName.equals(that.firmName) : that.firmName != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;
        if (linkTel != null ? !linkTel.equals(that.linkTel) : that.linkTel != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firmCode != null ? firmCode.hashCode() : 0;
        result = 31 * result + (firmName != null ? firmName.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (linkTel != null ? linkTel.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
