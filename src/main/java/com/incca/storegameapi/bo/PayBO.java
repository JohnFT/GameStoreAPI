/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.storegameapi.bo;

import com.incca.storegameapi.dao.CardDAO;
import com.incca.storegameapi.dao.GameDAO;
import com.incca.storegameapi.dao.PayDAO;
import com.incca.storegameapi.dto.Card;
import com.incca.storegameapi.dto.Pay;
import com.incca.storegameapi.dto.Result;
import java.util.Date;

/**
 *
 * @author Home
 */
public class PayBO {

    private PayDAO payDAO;
    private CardDAO cardDAO;
    private GameDAO gameDAO;

    public PayBO() {
        payDAO = new PayDAO();
        cardDAO = new CardDAO();
        gameDAO = new GameDAO();
    }

    public Result<Pay> add(Pay pay) {
        Result<Pay> res = new Result<>();
        Card card = cardDAO.filter(pay);
        if (card.getCar_code() != 0) {
            if (card.getCar_dateend().after(new Date())) {
                if (card.getCar_money() - pay.getPay_price() > 0) {
                    card.setCar_money(card.getCar_money() - pay.getPay_price());
                    if (cardDAO.update(card) && gameDAO.update(gameDAO.find(pay.getPay_game()))) {
                        res.setStatus(200);
                        res.setData(payDAO.buy(pay));
                        res.setMessage("Se ha realizado el pago");
                    } else {
                        res.setStatus(500);
                        res.setMessage("Error al realizar el pago intente de nuevo");
                    }
                } else {
                    res.setStatus(300);
                    res.setMessage("Saldo insuficiente");
                }
            } else {
                res.setStatus(300);
                res.setMessage("La trajeta esta vencida");
            }

        } else {
            res.setStatus(400);
            res.setMessage("Los datos de la tarjeta son errornes");
        }
        return res;
    }
}
