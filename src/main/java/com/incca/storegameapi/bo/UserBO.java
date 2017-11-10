/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.storegameapi.bo;

import com.incca.storegameapi.dao.UserDAO;
import com.incca.storegameapi.dto.Credentials;
import com.incca.storegameapi.dto.Result;
import com.incca.storegameapi.dto.User;
import java.util.List;

/**
 *
 * @author Home
 */
public class UserBO {

    private final UserDAO userDAO;

    public UserBO() {
        userDAO = new UserDAO();
    }

    public Result<List<User>> get() {
        Result<List<User>> r = new Result<>();
        List<User> users = userDAO.get();
        if (users != null) {
            r.setStatus(200);
            r.setData(users);
        } else {
            r.setStatus(500);
            r.setMessage("Services GET USER error");
        }
        return r;
    }

    public Result<User> signIn(Credentials c) {
        Result<User> r = new Result<>();
        User user = userDAO.signIn(c);
        if (user != null) {
            if (user.getUse_code() == null) {
                r.setStatus(400);
                r.setMessage("usuario o contraseña invalidos");
            } else {
                r.setStatus(200);
                r.setData(user);
            }
        } else {
            r.setStatus(500);
            r.setMessage("Services  error");
        }
        return r;
    }

    public Result<Boolean> add(User u) {
        Result<Boolean> r = new Result<>();
        Boolean create = userDAO.add(u);
        if (create != null) {
            if (!create) {
                r.setStatus(400);
                r.setMessage("El nombre de usuario ya existe");
            } else {
                r.setStatus(200);
                r.setData(create);
                r.setMessage("Usuario creado");
            }
        } else {
            r.setStatus(500);
            r.setMessage("Services add User error");
        }
        return r;
    }
}
