/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.storegameapi.bo;

import com.incca.storegameapi.dao.UserDAO;
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
}
