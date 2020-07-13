package com.company;

import java.util.HashSet;
import java.util.Set;

public class Application {

    //some hardcoded tests
    public static void main(String[] args) {

        Player player1 = new Player("player1");
        Player player2 = new Player("player2");

        Type type = new Type("iron", "some metall", "some icon", 10);

       Material material1 = new Material();
        material1.setType(type);
        material1.setQuantity(6);


        Material material2 = new Material();
        material2.setType(type);
        material2.setQuantity(3);

        Set<Material> set1 = new HashSet<>();
        set1.add(material1);

        Set<Material> set2 = new HashSet<>();
        set1.add(material2);

        WareHouse wareHouse1 = new WareHouse(set1);
        WareHouse wareHouse2 = new WareHouse(set2);

//        player1.getWareHouses().add(new WareHouse(set1));
//        player2.getWareHouses().add(new WareHouse(set2));

        System.out.println(move(wareHouse1, material1, wareHouse2));
    }


    static boolean move(WareHouse wareHouseFrom, Material material, WareHouse wareHouseTo){

//        System.out.println(wareHouseTo.addMaterial(material));
//        System.out.println(wareHouseFrom.removeMaterial(material));

        return wareHouseTo.addMaterial(material) && wareHouseFrom.removeMaterial(material);
    }
}
