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
@Table(name = "t_power", schema = "medicine", catalog = "")
public class Power {
    private int id;
    private String power;
    private Collection<User> usersById;
    private Collection<User> usersById_0;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "power", nullable = false, length = 20)
    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Power power = (Power) o;
        return id == power.id &&
                Objects.equals(this.power, power.power);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, power);
    }

    @OneToMany(mappedBy = "tPowerByPowerId")
    public Collection<User> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<User> usersById) {
        this.usersById = usersById;
    }

    @OneToMany(mappedBy = "tPowerByPowerId_0")
    public Collection<User> getUsersById_0() {
        return usersById_0;
    }

    public void setUsersById_0(Collection<User> usersById_0) {
        this.usersById_0 = usersById_0;
    }
}
