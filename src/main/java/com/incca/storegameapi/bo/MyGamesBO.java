/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.storegameapi.bo;

import com.incca.storegameapi.dao.MyGamesDAO;
import com.incca.storegameapi.dto.MyGames;
import com.incca.storegameapi.dto.Result;
import java.util.List;

/**
 *
 * @author Home
 */
public class MyGamesBO {
    
    private final MyGamesDAO gamesDAO;

    public MyGamesBO() {
        gamesDAO = new MyGamesDAO();
    }
    
    public Result<List<MyGames>> get(Long usecode) {
        Result<List<MyGames>> mygames = new Result<>();
        List<MyGames> games = gamesDAO.getByUser(usecode);
        if (games != null) {
            mygames.setStatus(200);
            mygames.setData(games);
        } else {
            mygames.setStatus(500);
            mygames.setMessage("Error en el servicio de my games");
        }
        return mygames;
    }
}
