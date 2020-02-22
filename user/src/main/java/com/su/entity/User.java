package com.su.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class User {
    private long id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    private Date registerDate;
    private String address;
}
