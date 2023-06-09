package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.DecimalFormat;


/**
 * The Order class that allows the user to add, remove, and edit pizzas for an order
 *
 * @author Tommy Cho
 */
public class Order {

    protected ObservableList<Pizza> pizzas;
    String phoneNumber;
    double orderTotal;

    /**
     * A default constructor for an order
     */
    public Order(){
        this.pizzas = FXCollections.observableArrayList();
        this.phoneNumber = "";
        this.orderTotal = 0;
    }

    /**
     * A method that calculates the order's total
     *
     * @return total price of the order
     */
    private double getOrderTotal() {
        double orderTotal = 0.0;
        for (int i = 0; i < pizzas.size(); i++) {
            orderTotal = orderTotal + pizzas.get(i).price();
        }
        return orderTotal;
    }

    /**
     * A method that calculates the order's tax
     *
     * @return tax of the order
     */
    private double getTax() {
        return this.getOrderTotal() * 0.0625;
    }

    public double getGrandTotal() {
        return (this.getOrderTotal() + this.getTax());
    }

    /**
     * Method to print the complete details of an order.
     *
     * @return order in String form
     */
    public String printOrder() {
        DecimalFormat dec = new DecimalFormat("#0.00");
        dec.setGroupingUsed(true);
        dec.setGroupingSize(3);
        int indexFixer = 1;
        StringBuilder str = new StringBuilder();
        str.append("Order for " + phoneNumber + ".\n");
        str.append("Number of pizzas in this order: " + pizzas.size() + "\n");
        for (int i = 0; i < pizzas.size(); i++) {
            str.append(i + indexFixer + ". " + pizzas.get(i) + "\n");
        }
        str.append("Tax: $" + dec.format(this.getTax()) + "\n");
        str.append("Order Total: $" + dec.format(this.getGrandTotal()) + "\n");
        return str.toString();
    }
}
