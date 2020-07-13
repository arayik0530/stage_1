package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player {

    //TODO implement add and remove materials from one player to another

    private final String name;

    private List<WareHouse> wareHouses;

    public Player(String name) {
        this.name = name;
        this.wareHouses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<WareHouse> getWareHouses() {
        return wareHouses;
    }

    public void setWareHouses(final List<WareHouse> wareHouses) {
        this.wareHouses = wareHouses;
    }
}
