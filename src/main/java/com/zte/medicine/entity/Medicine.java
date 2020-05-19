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
@Table(name = "t_medicine", schema = "medicine", catalog = "")
public class Medicine {
    private String medicineCode;
    private String medicineName;
    private String listPrice;
    private String price;
    private Integer stock;
    private Timestamp firstDate;
    private Timestamp usefullDate;
    private Kind kindByKindCode;
    private Firm firmByFirmCode;

    @Id
    @Column(name = "MedicineCode", nullable = false, length = 6)
    public String getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(String medicineCode) {
        this.medicineCode = medicineCode;
    }

    @Basic
    @Column(name = "MedicineName", nullable = false, length = 32)
    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    @Basic
    @Column(name = "ListPrice", nullable = true, length = 20)
    public String getListPrice() {
        return listPrice;
    }

    public void setListPrice(String listPrice) {
        this.listPrice = listPrice;
    }

    @Basic
    @Column(name = "Price", nullable = true, length = 20)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Stock", nullable = true)
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Basic
    @Column(name = "FirstDate", nullable = true)
    public Timestamp getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Timestamp firstDate) {
        this.firstDate = firstDate;
    }

    @Basic
    @Column(name = "UsefullDate", nullable = true)
    public Timestamp getUsefullDate() {
        return usefullDate;
    }

    public void setUsefullDate(Timestamp usefullDate) {
        this.usefullDate = usefullDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(medicineCode, medicine.medicineCode) &&
                Objects.equals(medicineName, medicine.medicineName) &&
                Objects.equals(listPrice, medicine.listPrice) &&
                Objects.equals(price, medicine.price) &&
                Objects.equals(stock, medicine.stock) &&
                Objects.equals(firstDate, medicine.firstDate) &&
                Objects.equals(usefullDate, medicine.usefullDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicineCode, medicineName, listPrice, price, stock, firstDate, usefullDate);
    }

    @ManyToOne
    @JoinColumn(name = "KindCode", referencedColumnName = "KindCode")
    public Kind getKindByKindCode() {
        return kindByKindCode;
    }

    public void setKindByKindCode(Kind kindByKindCode) {
        this.kindByKindCode = kindByKindCode;
    }

    @ManyToOne
    @JoinColumn(name = "FirmCode", referencedColumnName = "FirmCode")
    public Firm getFirmByFirmCode() {
        return firmByFirmCode;
    }

    public void setFirmByFirmCode(Firm firmByFirmCode) {
        this.firmByFirmCode = firmByFirmCode;
    }
}
