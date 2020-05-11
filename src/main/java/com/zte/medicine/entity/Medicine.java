package com.zte.medicine.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Author:helloboy
 * Date:2020-03-12 23:23
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
    private Kind tKindByKindCode;
    private Firm tFirmByFirmCode;

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

        Medicine that = (Medicine) o;

        if (medicineCode != null ? !medicineCode.equals(that.medicineCode) : that.medicineCode != null) return false;
        if (medicineName != null ? !medicineName.equals(that.medicineName) : that.medicineName != null) return false;
        if (listPrice != null ? !listPrice.equals(that.listPrice) : that.listPrice != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (stock != null ? !stock.equals(that.stock) : that.stock != null) return false;
        if (firstDate != null ? !firstDate.equals(that.firstDate) : that.firstDate != null) return false;
        if (usefullDate != null ? !usefullDate.equals(that.usefullDate) : that.usefullDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = medicineCode != null ? medicineCode.hashCode() : 0;
        result = 31 * result + (medicineName != null ? medicineName.hashCode() : 0);
        result = 31 * result + (listPrice != null ? listPrice.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        result = 31 * result + (firstDate != null ? firstDate.hashCode() : 0);
        result = 31 * result + (usefullDate != null ? usefullDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "KindCode", referencedColumnName = "KindCode")
    public Kind gettKindByKindCode() {
        return tKindByKindCode;
    }

    public void settKindByKindCode(Kind tKindByKindCode) {
        this.tKindByKindCode = tKindByKindCode;
    }

    @ManyToOne
    @JoinColumn(name = "FirmCode", referencedColumnName = "FirmCode")
    public Firm gettFirmByFirmCode() {
        return tFirmByFirmCode;
    }

    public void settFirmByFirmCode(Firm tFirmByFirmCode) {
        this.tFirmByFirmCode = tFirmByFirmCode;
    }
}
