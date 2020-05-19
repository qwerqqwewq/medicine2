package com.zte.medicine.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Author:helloboy
 * Date:2020-05-19 22:24
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
        Firm firm = (Firm) o;
        return Objects.equals(firmCode, firm.firmCode) &&
                Objects.equals(firmName, firm.firmName) &&
                Objects.equals(link, firm.link) &&
                Objects.equals(linkTel, firm.linkTel) &&
                Objects.equals(city, firm.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firmCode, firmName, link, linkTel, city);
    }
}
