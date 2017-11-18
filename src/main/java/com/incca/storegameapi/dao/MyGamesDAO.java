/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.storegameapi.dao;

import com.incca.storegameapi.dto.Game;
import com.incca.storegameapi.dto.MyGames;
import com.incca.storegameapi.helper.ConnectionDB;
import com.incca.storegameapi.interfaces.IGenerical;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home
 */
public class MyGamesDAO implements IGenerical<MyGames> {

    private Connection conn;
    private final static String SQLGETBYUSER = "SELECT p.pay_code, g.*  FROM pay p "
            + "INNER JOIN users u ON p.use_code = u.use_code "
            + "INNER JOIN game g ON p.pay_game = g.gam_code "
            + "WHERE u.use_code = ?";

    @Override
    public List<MyGames> get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<MyGames> getByUser(Long useCode) {
        try {
            List<MyGames> games = new ArrayList<>();
            conn = new ConnectionDB().getConnection();
            PreparedStatement ps = conn.prepareStatement(SQLGETBYUSER);
            ps.setLong(1, useCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                games.add(mapMyGame(rs));
            }
            return games;
        } catch (SQLException ex) {
            Logger.getLogger(MyGamesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public MyGames find(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean remove(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean update(MyGames e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean add(MyGames e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private MyGames mapMyGame(ResultSet r) throws SQLException {
        MyGames myGame = new MyGames();
        Game g = new Game();
        g.setGam_code(r.getLong("gam_code"));
        g.setGam_name(r.getString("gam_name"));
        g.setGam_price(r.getLong("gam_price"));
        g.setGame_detail(r.getString("game_detail"));
        g.setGame_unity(r.getInt("game_unity"));
        g.setGame_image(new String(r.getBytes("game_image")));
        myGame.setGame(g);
        myGame.setPay_code(r.getLong("pay_code"));
        return myGame;
    }

}
