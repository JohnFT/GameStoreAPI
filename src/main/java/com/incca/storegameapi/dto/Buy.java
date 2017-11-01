/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.storegameapi.dto;

/**
 *
 * @author Home
 */
public class Buy {

    private Long buy_code;
    private Long pay_code;
    private Long gam_code;

    public Long getBuy_code() {
        return buy_code;
    }

    public void setBuy_code(Long buy_code) {
        this.buy_code = buy_code;
    }

    public Long getPay_code() {
        return pay_code;
    }

    public void setPay_code(Long pay_code) {
        this.pay_code = pay_code;
    }

    public Long getGam_code() {
        return gam_code;
    }

    public void setGam_code(Long gam_code) {
        this.gam_code = gam_code;
    }
}
