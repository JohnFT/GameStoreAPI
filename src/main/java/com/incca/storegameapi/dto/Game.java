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
public class Game {

    private Long gam_code;
    private String gam_name;
    private Long gam_price;
    private String game_detail;
    private Integer game_unity;

    public Long getGam_code() {
        return gam_code;
    }

    public void setGam_code(Long gam_code) {
        this.gam_code = gam_code;
    }

    public String getGam_name() {
        return gam_name;
    }

    public void setGam_name(String gam_name) {
        this.gam_name = gam_name;
    }

    public Long getGam_price() {
        return gam_price;
    }

    public void setGam_price(Long gam_price) {
        this.gam_price = gam_price;
    }

    public String getGame_detail() {
        return game_detail;
    }

    public void setGame_detail(String game_detail) {
        this.game_detail = game_detail;
    }

    public Integer getGame_unity() {
        return game_unity;
    }

    public void setGame_unity(Integer game_unity) {
        this.game_unity = game_unity;
    }

}
