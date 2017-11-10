package com.incca.storegameapi.dao;

import com.incca.storegameapi.dto.Credentials;
import com.incca.storegameapi.dto.User;
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
public class UserDAO implements IGenerical<User> {

    private final String GETSQL = "SELECT * FROM users";
    private final String FINDSQL = "SELECT * FROM users WHERE USE_CODE = ?";
    private final String FINDBYCREDENTIALSQL = "SELECT * FROM users WHERE USE_NAME = ? AND USE_PASS = ?";
    private final String FINDBYUSERNAMESQL = "SELECT * FROM users WHERE USE_NAME = ?";
    private final String REMOVEDSQL = "DELET FROM users WHERE USE_CODE = ?";
    private final String UPDATESQL = "UPDATE users  SET USE_NAME = ?, USE_PASS = ?, "
            + "USE_FIRSTNAME = ?, USE_LASTNAME=? WHERE USE_CODE = ?";
    private final String ADDSQL = "INSERT INTO users "
            + "( use_name, use_pass, use_firstname, use_lastname) VALUES ( ?, ?, ?, ?)";
    private Connection conn;

    @Override
    public List<User> get() {
        List<User> users = new ArrayList<>();
        try {
            conn = new ConnectionDB().getConnection();
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(GETSQL);
            while (r.next()) {
                users.add(mapUser(r));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return users;

    }

    public User signIn(Credentials c) {
        User user = new User();
        try {
            conn = new ConnectionDB().getConnection();
            PreparedStatement ps = conn.prepareStatement(FINDBYCREDENTIALSQL);
            ps.setString(1, c.getUsername());
            ps.setString(2, c.getPassword());
            ResultSet r = ps.executeQuery();
            if (r.next()) {
                user = mapUser(r);
            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public User find(Long Id) {
        User user = null;
        try {
            conn = new ConnectionDB().getConnection();
            PreparedStatement ps = conn.prepareStatement(FINDSQL);
            ps.setLong(1, Id);
            ResultSet r = ps.executeQuery();
            if (r.next()) {
                user = new User();
                user.setUse_code(r.getLong("USE_CODE"));
                user.setUse_name(r.getString("USE_NAME"));
                user.setUse_firstname(r.getString("USE_FIRSTNAME"));
                user.setUse_lastname(r.getString("USE_LASTNAME"));
                user.setUse_pass(r.getString("USE_PASS"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return user;

    }

    @Override
    public Boolean remove(Long Id) {
        try {
            conn = new ConnectionDB().getConnection();
            PreparedStatement ps = conn.prepareStatement(REMOVEDSQL);
            ps.setLong(1, Id);
            return ps.executeUpdate() > 1;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Boolean update(User e) {
        try {
            conn = new ConnectionDB().getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATESQL);
            ps.setString(1, e.getUse_name());
            ps.setString(2, e.getUse_pass());
            ps.setString(3, e.getUse_firstname());
            ps.setString(4, e.getUse_lastname());
            ps.setLong(5, e.getUse_code());
            return ps.executeUpdate() > 1;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Boolean add(User e) {
        try {
            conn = new ConnectionDB().getConnection();
            if (validUserName(e)) {
                PreparedStatement ps = conn.prepareStatement(ADDSQL);
                ps.setString(1, e.getUse_name());
                ps.setString(2, e.getUse_pass());
                ps.setString(3, e.getUse_firstname());
                ps.setString(4, e.getUse_lastname());
                int res = ps.executeUpdate();
                return res > 0;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public User mapUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUse_code(rs.getLong("USE_CODE"));
        user.setUse_name(rs.getString("USE_NAME"));
        user.setUse_firstname(rs.getString("USE_FIRSTNAME"));
        user.setUse_lastname(rs.getString("USE_LASTNAME"));
        user.setUse_pass(rs.getString("USE_PASS"));
        return user;
    }

    private boolean validUserName(User u) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(FINDBYUSERNAMESQL);
        ps.setString(1, u.getUse_name());
        ResultSet r = ps.executeQuery();
        return !r.next();
    }
}
