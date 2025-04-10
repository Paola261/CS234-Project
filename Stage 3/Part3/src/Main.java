/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author paolapereda
 */
import java.util.Scanner;

public class Main {
    public static void main(String [] args)
    {
        
        
    }
    
    public static void Menu() 
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Main Menu:");
        System.out.println("Report Sales");
        System.out.println("Employee List");
        System.out.println("Customer list");
        System.out.println("Showtimes");
        System.out.println("Inventory");
        System.out.println("Exit");
        String choice = in.next();

        switch(choice){
            case "1":
                MenuSales();
                break;
            case "2":
                MenuEmployee();
                break;
            case "3":
                MenuCustomer;
                break;
            case "4":
                MenuShowtimes();
                break;
            case "5":
                MenuInventory();
                break;
            case "6":
                System.out.println("Exiting the program. Goodbye!");
                break;    
            default:
                System.out.println("Invalid Choice. Please try again!");
                Menu();
    }  
    }
}

    

