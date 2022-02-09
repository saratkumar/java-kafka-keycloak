package com.example.samplespringboot.payroll.entities;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class UserEntity {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    @NotNull
    private Date created;

    @NotNull
    private  Date last_updated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    @NotNull
    public Date getCreated() {
        return created;
    }

    public void setCreated(@NotNull Date created) {
        this.created = created;
    }

    @NotNull
    public Date getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(@NotNull Date last_updated) {
        this.last_updated = last_updated;
    }
}
