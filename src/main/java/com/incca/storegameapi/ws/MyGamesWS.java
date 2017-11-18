/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.storegameapi.ws;

import com.incca.storegameapi.bo.MyGamesBO;
import com.incca.storegameapi.dto.MyGames;
import com.incca.storegameapi.dto.Result;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Home
 */
@Path("my-games")
public class MyGamesWS {

    @Context
    private UriInfo context;
    private final MyGamesBO myGamesBO;

    public MyGamesWS() {
        myGamesBO = new MyGamesBO();
    }

    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{usecode}")
    public Result<List<MyGames>> get(@PathParam("usecode") Long usecode){
        return myGamesBO.get(usecode);
    }
}
