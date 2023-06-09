package com.example.demo;

import java.util.ArrayList;

/**
 * The Pizza class that holds all information relevant for all pizzas.
 *
 * @author Tommy Cho
 */
public abstract class Pizza {
    protected ArrayList<Topping> toppings = new ArrayList<Topping>();
    protected Size size;

    //constants for price adjustments
    public static final double sizeIncrement = 2.00;
    public static final double toppingIncrement = 1.49;

    public abstract double price();

    @Override
    public abstract String toString();

    public abstract Pizza copy();

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    public void setSize(Size size){
        this.size = size;
    }
}
