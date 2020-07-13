package com.company;

import java.util.Objects;

public class Material {

    private Type type;
    private int quantity;

    public Type getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(this.getType().getMaxCapacity() > quantity)
            this.quantity = quantity;
        else {
            throw new RuntimeException("Invalid number of quantity. It must be less or equal to " + this.getType().getMaxCapacity() + "!!!");
        }
    }

    /** Equals and hashcode have been overridden to make Set<Materials> in Warehouse work correctly,
     * because Set is a container of a unique elements, and elements are checked whether they are unique or
     * not using hashcode */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Material)) return false;
        final Material material = (Material) o;
        return getType().getName().equalsIgnoreCase(material.getType().getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType().getName());
    }

    public void setType(final Type type) {
        this.type = type;
    }
}
