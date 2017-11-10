/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.storegameapi.dao;

import com.incca.storegameapi.dto.Card;
import com.incca.storegameapi.dto.Pay;
import com.incca.storegameapi.helper.ConnectionDB;
import com.incca.storegameapi.interfaces.IGenerical;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home
 */
public class CardDAO implements IGenerical<Card> {

    private final static String SQLFILTER = "SELECT car_code, car_number, "
            + "car_dateend, car_security, car_date, car_money "
            + "FROM cards WHERE car_number = ? AND car_security = ? AND car_dateend = ?";
    private Connection conn;
    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    public CardDAO() {
        conn = new ConnectionDB().getConnection();
    }

    @Override
    public List<Card> get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Card find(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean remove(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean update(Card e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean add(Card e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Card filter(Pay e) {
        try {
            Card card = new Card();
            PreparedStatement ps = conn.prepareStatement(SQLFILTER);
            ps.setLong(1, e.getPay_card());
            ps.setInt(2, e.getPay_security());
            String date = sdf.format(e.getPay_dateend());
            ps.setDate(3, new Date(sdf.parse(date).getTime()));
            ResultSet r = ps.executeQuery();
            if (r.next()) {
                card.setCar_code(r.getLong("car_code"));
                card.setCar_dateend(r.getDate("car_dateend"));
                card.setCar_money(r.getLong("car_money"));
                card.setCar_number(r.getLong("car_number"));
                card.setCar_security(r.getInt("car_security"));
            }
            return card;
        } catch (SQLException ex) {
            Logger.getLogger(CardDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(CardDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CardDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
