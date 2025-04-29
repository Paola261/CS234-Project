/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * The ConcessionOrder class represents an order made by a Customer from the FoodBeverage class
 * @author paolapereda
 */
import java.util.ArrayList;

public class ConcessionOrder   { 
    private Customer customer;
    private FoodBeverage item;
    private int quantity;

    /**
     * Constructor for a new concession order for a specified customer
     * @param customer
     * @param item
     * @param quantity 
     */
    public ConcessionOrder(Customer customer, FoodBeverage item, int quantity)
    {
        this.customer = customer;
        this.item = item;
        this.quantity = quantity;

    }
}
