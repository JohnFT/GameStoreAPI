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
public class Pay {

    private long pay_code;
    private Date pay_date;
    private long pay_card;
    private long pay_price;
    private long use_code;
    private Date pay_dateend;
    private int pay_security;

    public long getPay_code() {
        return pay_code;
    }

    public void setPay_code(long pay_code) {
        this.pay_code = pay_code;
    }

    public Date getPay_date() {
        return pay_date;
    }

    public void setPay_date(Date pay_date) {
        this.pay_date = pay_date;
    }

    public long getPay_card() {
        return pay_card;
    }

    public void setPay_card(long pay_card) {
        this.pay_card = pay_card;
    }

    public long getPay_price() {
        return pay_price;
    }

    public void setPay_price(long pay_price) {
        this.pay_price = pay_price;
    }

    public long getUse_code() {
        return use_code;
    }

    public void setUse_code(long use_code) {
        this.use_code = use_code;
    }

    public Date getPay_dateend() {
        return pay_dateend;
    }

    public void setPay_dateend(Date pay_dateend) {
        this.pay_dateend = pay_dateend;
    }

    public int getPay_security() {
        return pay_security;
    }

    public void setPay_security(int pay_security) {
        this.pay_security = pay_security;
    }

}
