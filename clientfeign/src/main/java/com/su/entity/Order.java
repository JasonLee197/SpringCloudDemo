package com.su.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Order {
    private long id;
    private User user;
    private Menu menu;
    private Admin admin;
    private Date date;
    private int state;
}
