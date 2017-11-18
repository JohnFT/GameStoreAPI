/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.storegameapi.dao;

import com.incca.storegameapi.dto.Pay;
import com.incca.storegameapi.helper.ConnectionDB;
import com.incca.storegameapi.interfaces.IGenerical;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home
 */
public class PayDAO implements IGenerical<Pay> {

    final static String ADDSQL = "INSERT INTO public.pay(pay_code, pay_card, pay_price, use_code, pay_dateend,"
            + "pay_security, pay_game)VALUES ( ?,?, ?, ?, ?, ?, ?)";
    final static String FINDSQL = "SELECT * FROM public.pay WHERE pay_code = ?";

    Connection conn;

    @Override
    public List<Pay> get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pay find(Long Id) {
        try {
            Pay pay = new Pay();
            conn = new ConnectionDB().getConnection();
            PreparedStatement p = conn.prepareStatement(FINDSQL);
            p.setLong(1, Id);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                pay.setPay_code(r.getLong("pay_code"));
            }
            return pay;
        } catch (SQLException ex) {
            Logger.getLogger(PayDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Boolean remove(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean update(Pay e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean add(Pay e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Pay buy(Pay e) {
        try {
            conn = new ConnectionDB().getConnection();
            PreparedStatement ps = conn.prepareStatement(ADDSQL);
            Long id = next();
            ps.setLong(1, id);
            ps.setLong(2, e.getPay_card());
            ps.setLong(3, e.getPay_price());
            ps.setLong(4, e.getUse_code());
            ps.setDate(5, new Date(e.getPay_dateend().getTime()));
            ps.setInt(6, e.getPay_security());
            ps.setLong(7, e.getPay_game());
            if(ps.executeUpdate() > 0){
                return find(id);
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(PayDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Long next() {
        try {
            conn = new ConnectionDB().getConnection();
            Statement ps = conn.createStatement();
            ResultSet r = ps.executeQuery("SELECT nextval('pay_pay_code_seq') id");
            if (r.next()) {
                return r.getLong("id");
            }
            return 0L;
        } catch (SQLException ex) {
            Logger.getLogger(PayDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0L;
        }

    }

}
