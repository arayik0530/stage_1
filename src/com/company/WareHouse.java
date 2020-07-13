package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WareHouse {

    private Set<Material> materials;

    /** This method works like JPA's @Transactional
     * and returns true if the transaction has been successfully, otherwise false*/
    public boolean addMaterial(Material material) {
        //some flag which checks whether the type of adding material is present in our warehouse or not
        boolean contains = false;

        Material materialToBeCahnged = new Material();

        for (Material materiall : materials) {
            if (materiall.equals(material)) {
                materialToBeCahnged = materiall;
                contains = true;
                break;
            }
        }
        if (contains){
            int count = materialToBeCahnged.getQuantity() + material.getQuantity();
            if(count > material.getType().getMaxCapacity()){
                return false;
            }
            else{
                materialToBeCahnged.setQuantity(count);
                return true;
            }

        }
        else{
            this.materials.add(material);
            return true;
        }

    }

    /** returns true if the transaction is successful*/
    public boolean removeMaterial(Material material){
        boolean contains = false;

        Material materialToBeRemoved = new Material();

        for(Material materiall: this.materials){
            if(materiall.equals(material)){
                contains = true;
                materialToBeRemoved = materiall;
                break;
            }
        }

        if(contains){
            int count = materialToBeRemoved.getQuantity()-material.getQuantity();
            if(count == 0){
                materials.remove(materialToBeRemoved);
                return true;
            }
            else if(count > 0){
                materialToBeRemoved.setQuantity(count);
                return true;
            }
            else{
                return false;
            }
        }

        return false;
    }

    public WareHouse(Set<Material> materials) {
        this.materials = materials;
    }

    public Set<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(final Set<Material> materials) {
        this.materials = materials;
    }
}