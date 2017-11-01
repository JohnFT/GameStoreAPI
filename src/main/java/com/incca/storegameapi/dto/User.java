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
public class User {

    private Long use_code;
    private String use_name;
    private String use_pass;
    private String use_firstname;
    private String use_lastname;

    public Long getUse_code() {
        return use_code;
    }

    public void setUse_code(Long use_code) {
        this.use_code = use_code;
    }

    public String getUse_name() {
        return use_name;
    }

    public void setUse_name(String use_name) {
        this.use_name = use_name;
    }

    public String getUse_pass() {
        return use_pass;
    }

    public void setUse_pass(String use_pass) {
        this.use_pass = use_pass;
    }

    public String getUse_firstname() {
        return use_firstname;
    }

    public void setUse_firstname(String use_firstname) {
        this.use_firstname = use_firstname;
    }

    public String getUse_lastname() {
        return use_lastname;
    }

    public void setUse_lastname(String use_lastname) {
        this.use_lastname = use_lastname;
    }

}
