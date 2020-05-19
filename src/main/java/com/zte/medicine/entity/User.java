package com.zte.medicine.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Author:helloboy
 * Date:2020-05-19 22:24
 * Description:<描述>
 */
@Entity
@Table(name = "t_user", schema = "medicine", catalog = "")
public class User {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String position;
    private Power powerByPowerId;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
                Objects.equals(name, user.name) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(position, user.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, password, position);
    }

    @ManyToOne
    @JoinColumn(name = "powerId", referencedColumnName = "id", nullable = false)
    public Power getPowerByPowerId() {
        return powerByPowerId;
    }

    public void setPowerByPowerId(Power powerByPowerId) {
        this.powerByPowerId = powerByPowerId;
    }
}
