/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.storegameapi.dto;

/**
 *
 * @author Home
 */
public class Result<Entity> {

    private int status;
    private Entity data;
    private String Message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Entity getData() {
        return data;
    }

    public void setData(Entity data) {
        this.data = data;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }
}
