/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.storegameapi.ws;

import com.incca.storegameapi.bo.PayBO;
import com.incca.storegameapi.dto.Pay;
import com.incca.storegameapi.dto.Result;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Home
 */
@Path("pay")
public class PayWS {

    @Context
    private UriInfo context;
    private PayBO payBO;

    public PayWS() {
        payBO = new PayBO();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Result<Boolean> add(Pay pay) {
        return payBO.add(pay);
    }

}
