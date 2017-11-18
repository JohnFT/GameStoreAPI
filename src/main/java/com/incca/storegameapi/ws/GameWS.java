/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.storegameapi.ws;

import com.incca.storegameapi.bo.GameBO;
import com.incca.storegameapi.dto.Game;
import com.incca.storegameapi.dto.Result;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Home
 */
@Path("game")
public class GameWS {

    private final GameBO gameBO;

    public GameWS() {
        gameBO = new GameBO();
    }

    @GET
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Result<List<Game>> get() {
        return gameBO.get();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Result<Boolean> addGame(Game g) {
        return gameBO.add(g);
    }
    
}
