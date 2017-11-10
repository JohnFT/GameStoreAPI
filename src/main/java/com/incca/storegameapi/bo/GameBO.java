/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.storegameapi.bo;

import com.incca.storegameapi.dao.GameDAO;
import com.incca.storegameapi.dto.Game;
import com.incca.storegameapi.dto.Result;
import java.util.List;

/**
 *
 * @author Home
 */
public class GameBO {

    private final GameDAO gameDAO;

    public GameBO() {
        gameDAO = new GameDAO();
    }

    public Result<Boolean> add(Game g) {
        Result<Boolean> r = new Result<>();
        Boolean create = gameDAO.add(g);
        if (create != null) {
            r.setStatus(200);
            r.setData(create);
            r.setMessage("se agrego el juego");

        } else {
            r.setStatus(500);
            r.setMessage("Services add game error");
        }
        return r;
    }

    public Result<List<Game>> get() {
        Result<List<Game>> r = new Result<>();
        List<Game> games = gameDAO.get();
        if (games != null) {
            r.setStatus(200);
            r.setData(games);
        } else {
            r.setStatus(500);
            r.setMessage("Services add game error");
        }
        return r;
    }
}
