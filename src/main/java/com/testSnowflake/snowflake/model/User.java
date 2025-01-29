package com.testSnowflake.snowflake.model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;

@Entity
public class User {
    @Id
    private long id;
    private String name;
    private String email;

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
