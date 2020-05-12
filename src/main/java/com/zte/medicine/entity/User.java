package com.zte.medicine.entity;

import javax.persistence.*;

/**
 * @Author:helloboy
 * Date:2020-03-12 23:23
 * Description:<描述>
 */
@Entity
@Table(name = "t_user", schema = "medicine", catalog = "user_conf")
public class User {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String position;
    private Power PowerByPowerId;

    Power power;

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

        User that = (User) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "powerId", referencedColumnName = "id", nullable = false)
    public Power getPowerByPowerId() {
        return PowerByPowerId;
    }

    public void setPowerByPowerId(Power PowerByPowerId) {
        this.PowerByPowerId = PowerByPowerId;
    }
}
