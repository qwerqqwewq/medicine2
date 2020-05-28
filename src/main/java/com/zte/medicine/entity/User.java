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
@Table(name = "t_user", schema = "medicine", catalog = "")
public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private int powerId;
    private String position;
    private Collection<Sale> salesById;
    private Collection<Stock> stocksById;
    private Power powerByPowerId;
    private Power powerByPowerId_0;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 64)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "powerId", nullable = false)
    public int getPowerId() {
        return powerId;
    }

    public void setPowerId(int powerId) {
        this.powerId = powerId;
    }

    @Basic
    @Column(name = "position", nullable = true, length = 64)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                powerId == user.powerId &&
                Objects.equals(name, user.name) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(position, user.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, password, powerId, position);
    }

    @OneToMany(mappedBy = "tUserByUserId")
    public Collection<Sale> getSalesById() {
        return salesById;
    }

    public void setSalesById(Collection<Sale> salesById) {
        this.salesById = salesById;
    }

    @OneToMany(mappedBy = "tUserByUserId")
    public Collection<Stock> getStocksById() {
        return stocksById;
    }

    public void setStocksById(Collection<Stock> stocksById) {
        this.stocksById = stocksById;
    }

    @ManyToOne
    @JoinColumn(name = "powerId", referencedColumnName = "id", nullable = false)
    public Power getPowerByPowerId() {
        return powerByPowerId;
    }

    public void setPowerByPowerId(Power powerByPowerId) {
        this.powerByPowerId = powerByPowerId;
    }

    @ManyToOne
    @JoinColumn(name = "powerId", referencedColumnName = "id", nullable = false)
    public Power getPowerByPowerId_0() {
        return powerByPowerId_0;
    }

    public void setPowerByPowerId_0(Power powerByPowerId_0) {
        this.powerByPowerId_0 = powerByPowerId_0;
    }
}
