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
    private String pay_tarjet;
    private Long pay_price;

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

    public String getPay_tarjet() {
        return pay_tarjet;
    }

    public void setPay_tarjet(String pay_tarjet) {
        this.pay_tarjet = pay_tarjet;
    }

    public Long getPay_price() {
        return pay_price;
    }

    public void setPay_price(Long pay_price) {
        this.pay_price = pay_price;
    }
}
