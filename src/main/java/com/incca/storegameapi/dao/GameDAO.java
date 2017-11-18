package com.incca.storegameapi.dao;

import com.incca.storegameapi.dto.Game;
import com.incca.storegameapi.helper.ConnectionDB;
import com.incca.storegameapi.interfaces.IGenerical;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Home
 */
public class GameDAO implements IGenerical<Game> {

    private Connection conn;
    private final static String ADDSQL = " INSERT INTO game"
            + " ( gam_name, gam_price, game_detail, game_unity, game_image)"
            + " VALUES ( ?, ?, ?, ?, ?);";
    private final static String GETSQL = "SELECT gam_code, gam_name, gam_price, "
            + "game_detail, game_unity, game_image FROM game WHERE game_unity > 0;";
    private final static String FINDSQL = "SELECT gam_code, gam_name, gam_price, "
            + "game_detail, game_unity, game_image FROM game WHERE gam_code = ?;";
    private final static String UPDATESQL = "UPDATE game SET  game_unity = ? WHERE gam_code = ?;";

    @Override
    public List<Game> get() {
        try {
            List<Game> games = new ArrayList<>();
            conn = new ConnectionDB().getConnection();
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(GETSQL);
            while (r.next()) {
                games.add(mapGame(r));
            }
            return games;
        } catch (SQLException ex) {
            Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Game find(Long Id) {
        try {
            Game game = new Game();
            conn = new ConnectionDB().getConnection();
            PreparedStatement s = conn.prepareStatement(FINDSQL);
            s.setLong(1, Id);
            ResultSet r = s.executeQuery();
            if (r.next()) {
                game = mapGame(r);
            }
            return game;
        } catch (SQLException ex) {
            Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Boolean remove(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean update(Game e) {
        try {
            conn = new ConnectionDB().getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATESQL);
            ps.setInt(1, e.getGame_unity() - 1);
            ps.setLong(2, e.getGam_code());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Boolean add(Game e) {
        try {
            conn = new ConnectionDB().getConnection();
            PreparedStatement ps = conn.prepareStatement(ADDSQL);
            ps.setString(1, e.getGam_name());
            ps.setLong(2, e.getGam_price());
            ps.setString(3, e.getGame_detail());
            ps.setInt(4, e.getGame_unity());
            ps.setBytes(5, e.getGame_image().getBytes());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private Game mapGame(ResultSet r) throws SQLException {

        Game g = new Game();
        g.setGam_code(r.getLong("gam_code"));
        g.setGam_name(r.getString("gam_name"));
        g.setGam_price(r.getLong("gam_price"));
        g.setGame_detail(r.getString("game_detail"));
        g.setGame_unity(r.getInt("game_unity"));
        g.setGame_image(new String(r.getBytes("game_image")));
        return g;
    }

}
