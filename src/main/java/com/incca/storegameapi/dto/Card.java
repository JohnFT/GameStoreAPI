/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.storegameapi.dto;

import java.util.Date;

/**
 *
 * @author Home
 */
public class Card {

    private long car_code;
    private long car_number;
    private Date car_dateend;
    private int car_security;
    private Date car_date;
    private long car_money;

    public long getCar_code() {
        return car_code;
    }

    public void setCar_code(long car_code) {
        this.car_code = car_code;
    }

    public long getCar_number() {
        return car_number;
    }

    public void setCar_number(long car_number) {
        this.car_number = car_number;
    }

    public Date getCar_dateend() {
        return car_dateend;
    }

    public void setCar_dateend(Date car_dateend) {
        this.car_dateend = car_dateend;
    }

    public int getCar_security() {
        return car_security;
    }

    public void setCar_security(int car_security) {
        this.car_security = car_security;
    }

    public Date getCar_date() {
        return car_date;
    }

    public void setCar_date(Date car_date) {
        this.car_date = car_date;
    }

    public long getCar_money() {
        return car_money;
    }

    public void setCar_money(long car_money) {
        this.car_money = car_money;
    }
    
    
}
