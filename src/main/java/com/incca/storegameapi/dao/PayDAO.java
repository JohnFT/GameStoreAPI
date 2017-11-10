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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home
 */
public class PayDAO implements IGenerical<Pay> {

    final static String ADDSQL = "INSERT INTO public.pay(pay_date, pay_card, pay_price, use_code, pay_dateend,"
            + "pay_security)VALUES ( ?, ?, ?, ?, ?, ?)";

    Connection conn;

    @Override
    public List<Pay> get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pay find(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        try {
            conn = new ConnectionDB().getConnection();
            PreparedStatement ps = conn.prepareStatement(ADDSQL);
            ps.setLong(1, e.getPay_card());
            ps.setLong(2, e.getPay_price());
            ps.setLong(3, e.getUse_code());
            ps.setDate(4, Date.valueOf(e.getPay_dateend().toString()));
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PayDAO.class.getName()).log(Level.SEVERE, null, ex);
            return  false;
        }
    }
    
    

}
