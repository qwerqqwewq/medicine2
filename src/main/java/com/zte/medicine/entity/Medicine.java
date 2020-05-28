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
@Table(name = "t_medicine", schema = "medicine", catalog = "")
public class Medicine {
    private String medicineCode;
    private String medicineName;
    private String kindCode;
    private String listPrice;
    private String price;
    private Integer stock;
    private String firmCode;
    private Timestamp firstDate;
    private Timestamp usefullDate;
    private Kind kindByKindCode;
    private Kind kindByKindCode_0;
    private Firm firmByFirmCode;
    private Firm firmByFirmCode_0;
    private Collection<SaleComment> saleCommentsByMedicineCode;
    private Collection<StockComment> stockCommentsByMedicineCode;

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
    @Column(name = "KindCode", nullable = true, length = 20)
    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
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
    @Column(name = "FirmCode", nullable = true, length = 10)
    public String getFirmCode() {
        return firmCode;
    }

    public void setFirmCode(String firmCode) {
        this.firmCode = firmCode;
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
                Objects.equals(kindCode, medicine.kindCode) &&
                Objects.equals(listPrice, medicine.listPrice) &&
                Objects.equals(price, medicine.price) &&
                Objects.equals(stock, medicine.stock) &&
                Objects.equals(firmCode, medicine.firmCode) &&
                Objects.equals(firstDate, medicine.firstDate) &&
                Objects.equals(usefullDate, medicine.usefullDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicineCode, medicineName, kindCode, listPrice, price, stock, firmCode, firstDate, usefullDate);
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
    @JoinColumn(name = "KindCode", referencedColumnName = "KindCode")
    public Kind getKindByKindCode_0() {
        return kindByKindCode_0;
    }

    public void setKindByKindCode_0(Kind kindByKindCode_0) {
        this.kindByKindCode_0 = kindByKindCode_0;
    }

    @ManyToOne
    @JoinColumn(name = "FirmCode", referencedColumnName = "FirmCode")
    public Firm getFirmByFirmCode() {
        return firmByFirmCode;
    }

    public void setFirmByFirmCode(Firm firmByFirmCode) {
        this.firmByFirmCode = firmByFirmCode;
    }

    @ManyToOne
    @JoinColumn(name = "FirmCode", referencedColumnName = "FirmCode")
    public Firm getFirmByFirmCode_0() {
        return firmByFirmCode_0;
    }

    public void setFirmByFirmCode_0(Firm firmByFirmCode_0) {
        this.firmByFirmCode_0 = firmByFirmCode_0;
    }

    @OneToMany(mappedBy = "tMedicineByMedicineCode")
    public Collection<SaleComment> getSaleCommentsByMedicineCode() {
        return saleCommentsByMedicineCode;
    }

    public void setSaleCommentsByMedicineCode(Collection<SaleComment> saleCommentsByMedicineCode) {
        this.saleCommentsByMedicineCode = saleCommentsByMedicineCode;
    }

    @OneToMany(mappedBy = "tMedicineByMedicineCode")
    public Collection<StockComment> getStockCommentsByMedicineCode() {
        return stockCommentsByMedicineCode;
    }

    public void setStockCommentsByMedicineCode(Collection<StockComment> stockCommentsByMedicineCode) {
        this.stockCommentsByMedicineCode = stockCommentsByMedicineCode;
    }
}
