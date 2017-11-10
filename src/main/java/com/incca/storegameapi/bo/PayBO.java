/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.storegameapi.bo;

import com.incca.storegameapi.dao.CardDAO;
import com.incca.storegameapi.dao.PayDAO;
import com.incca.storegameapi.dto.Card;
import com.incca.storegameapi.dto.Pay;
import com.incca.storegameapi.dto.Result;

/**
 *
 * @author Home
 */
public class PayBO {

    private PayDAO payDAO;
    private CardDAO cardDAO;

    public PayBO() {
        payDAO = new PayDAO();
        cardDAO = new CardDAO();
    }

    public Result<Boolean> add(Pay pay) {
        Result<Boolean> res = new Result<>();
        Card card = cardDAO.filter(pay);
        if (card.getCar_code() != 0) {
            if (card.getCar_money() - pay.getPay_price() > 0) {
                res.setStatus(200);
                res.setData(payDAO.add(pay));
            } else {
                res.setStatus(300);
                res.setMessage("Saldo insuficiente");
            }
        } else {
            res.setStatus(400);
            res.setMessage("Los datos de la tarjeta son errornes");
        }
        return res;
    }
}
