/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.storegameapi.interfaces;

import java.util.List;

/**
 *
 * @author Home
 */
public interface IGenerical<Entity> {

    public List<Entity> get();

    public Entity find(Long Id);

    public Boolean remove(Long Id);

    public Boolean update(Entity e);

    public Boolean add(Entity e);
}
