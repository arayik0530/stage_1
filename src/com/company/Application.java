package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Application {

    //some hardcoded tests
    public static void main(String[] args) {

        Type type = new Type("iron", "some metal", "some icon", 10);

        Material material1 = new Material();
        material1.setType(type);
        material1.setQuantity(6);

        Material material2 = new Material();
        material2.setType(type);
        material2.setQuantity(3);

        Set<Material> set1 = new HashSet<>();
        set1.add(material1);

        Set<Material> set2 = new HashSet<>();
        set2.add(material2);

        WareHouse wareHouse1 = new WareHouse(set1);
        WareHouse wareHouse2 = new WareHouse(set2);

        System.out.println(wareHouse1.getMaterials());
        System.out.println(wareHouse2.getMaterials());

        System.out.println(move(wareHouse1, material1, wareHouse2));
    }


    static boolean move(WareHouse wareHouseFrom, Material material, WareHouse wareHouseTo) {
        if (wareHouseTo.addMaterial(material)) {
            if (wareHouseFrom.removeMaterial(material))
                return true;
        }

        return false;
    }
}
