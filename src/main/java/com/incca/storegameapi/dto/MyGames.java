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
public class MyGames {

    private Long pay_code;
    private Game game;

    public Long getPay_code() {
        return pay_code;
    }

    public void setPay_code(Long pay_code) {
        this.pay_code = pay_code;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
