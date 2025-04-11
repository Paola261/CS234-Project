/**
 * The entry point for the Movie Theater Management System.
 * Handles user login and role-based menu navigation for manager, cashiers
 * and engineers
 * 
 * @author paolapereda
 * @author Taryn Davis
 */
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

    static ArrayList<Customer> customers = new ArrayList<>();
    /**
     * The main method that runs the movie theater system
     * @param args 
     */
    public static void main(String [] args)
    {
        System.out.println("-----Welcome our Theatre Management System!-----");

        Scanner scanner = new Scanner(System.in);   
         // Sample User
        // @ taryn need to add more
        Credential managerCred = new Credential("Lil.Ben", "PastelDream9");
        Manager manager = new Manager("Lily Bennett", 40, 1001, 1, "Manager", managerCred);

        //Customers in system already for Customer Class
        customers.add(new Customer("Darian Lopez", 100, (byte)16)); //customerID is???
        customers.add(new Customer("Sophia Smith", 200, (byte)14));
        customers.add(new Customer("Amber Zul", 300, (byte)21));
        customers.add(new Customer("Nicholas Shaffer", 400, (byte)18));
        customers.add(new Customer("Corey Shaffer", 500, (byte)61)); 
        
        //FoodBeverage Class
        
       
        
        Credential cashierCred = new Credential("Mic.Car", "Treehouse2");
        Cashier cashier = new Cashier("Michael Carter", 28, 1002, 2, "Cashier", cashierCred, 101);

        Credential engineerCred = new Credential("Dan.Fos", "Mountain44");
        Engineer engineer = new Engineer("Daniel Foster", 34, 1003, 3, "Engineer", engineerCred);
        
        //Service Classes
        ScheduleManager scheduleManager = new ScheduleManager();
        StaffManager staffManager = new StaffManager();
        MaintenanceManager maintenanceManager = new MaintenanceManager();
        
        boolean running = true;
        while (running) {
            System.out.println("\n Welcome to the Movie Theater System");
            System.out.println("1. Manager Login");
            System.out.println("2. Cashier Login");
            System.out.println("3. Engineer Login");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (authenticate(scanner, manager)) {
                        managerMenu(scanner, manager, scheduleManager, staffManager, maintenanceManager);
                    }
                    break;
                case "2":
                    if (authenticate(scanner, cashier)) {
                        cashierMenu(scanner, cashier);
                    }
                    break;
                case "3":
                    if (authenticate(scanner, engineer)) {
                        engineerMenu(scanner, engineer, maintenanceManager);
                    }
                    break;
                case "4":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
        
        Menu();
    
    }
    
    /**
     * Authenticates a staff member based on username and password input
     * @param scanner the Scanner object reads input
     * @param staff the staff member attempting to log in
     * @return true if authentication succeeds, false otherwise
     */
    private static boolean authenticate(Scanner scanner, Staff staff) {
        System.out.print("Username: ");
        String user = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();
        return staff.login(user, pass);
    }
    
    /**
     * Displays and handles the managers menu options
     * 
     * @param scanner the Scanner object to read input
     * @param manager the logged-in Manager
     * @param scheduleManager handles movie-to-screen assignments
     * @param staffManager handles staff role updates
     * @param maintenanceManager handles maintenance issue logging
     */
    private static void managerMenu(Scanner scanner, Manager manager,
                                    ScheduleManager scheduleManager,
                                    StaffManager staffManager,
                                    MaintenanceManager maintenanceManager) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\nManager Menu:");
            System.out.println("1. Assign movie to screen");
            System.out.println("2. Reset screen seats");
            System.out.println("3. Assign staff role");
            System.out.println("4. Log maintenance issue");
            System.out.println("5. View maintenance issues");
            System.out.println("6. Logout");

            System.out.print("Choice: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Movie ID: ");
                    int movieID = Integer.parseInt(scanner.nextLine());
                    System.out.print("Screen ID: ");
                    int screenID = Integer.parseInt(scanner.nextLine());
                    scheduleManager.assignMovieToScreen(movieID, screenID, LocalDate.now(), LocalTime.now());
                    break;
                case "2":
                    System.out.print("Enter Screen ID to reset seats: ");
                    int resetID = Integer.parseInt(scanner.nextLine());
                    scheduleManager.resetSeats(resetID);
                    break;
                case "3":
                    System.out.print("Enter Staff ID: ");
                    int staffID = Integer.parseInt(scanner.nextLine());
                    Staff staff = staffManager.getStaffByID(staffID);
                    if (staff != null) {
                        System.out.print("Enter new role: ");
                        String newRole = scanner.nextLine();
                        staffManager.assignRole(staff, newRole);
                    } else {
                        System.out.println("Staff not found.");
                    }
                    break;
                case "4":
                    System.out.print("Enter issue description: ");
                    String issue = scanner.nextLine();
                    maintenanceManager.logIssue(issue);
                    break;
                case "5":
                    System.out.println("Pending Maintenance Issues:");
                    for (String i : maintenanceManager.getPendingIssues()) {
                        System.out.println("- " + i);
                    }
                    break;
                case "6":
                    loggedIn = false;
                    manager.logout();
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }

    /**
     * Displays and handles the cashier's menu options.
     * 
     * @param scanner
     * @param cashier
     * @param concessionProcessor 
     * @param ticketSeller
     */
    private static void cashierMenu(Scanner scanner, Cashier cashier, 
            ConcessionProcessor concessionProcessor, TicketSeller ticketSeller) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\nCashier Menu:");
            System.out.println("1. Start Shift");
            System.out.println("2. Customer List");

            // NEED TO ADD CONCESSION PROCESSOR AND TICKET MANAGER!
            System.out.println("3. Sell Concession Item");
            System.out.println("4. Sell Movie Ticket");
            System.out.println("5. End Shift");
            
            System.out.print("Enter you choice: ");
            int choice = scanner.nextInt();
            
            switch(choice){
                case 1: 
                    cashier.startShift();
                    System.out.println("Your shift has started.");
                    break;
                case 2: 
                    MenuCustomer();
                case 3: 
                    System.out.print("Enter Customer ID: ");
                    int customerID = scanner.nextInt();
                    System.out.print("Enter Item ID: ");
                    int itemID = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    
                    boolean success = concessionProcessor.sellItem(customerID, itemID, quantity);
                    if(success){
                        System.out.print("Item sold");
                    } else{
                        System.out.print("Item not sold. Could not be found.");
                    }
                    break;

                case 4: 
                    System.out.print("Enter Customer ID: ");
                    int cID = scanner.nextInt();
                    System.out.print("Enter Showtime ID: ");
                    int showtimeID = scanner.nextInt();
                    System.out.print("Enter Seat ID: ");
                    int seatID = scanner.nextInt();
                    
                    boolean ticketsell = ticketSeller.sellTicket(cID, showtimeID, seatID);
                    if(ticketsell){
                        System.out.println("Ticket Sold.");
                    } else{
                        System.out.println("Ticket not Sold.");
                    }
                    break;
                case 5: 
                    cashier.endShift();
                    System.out.println("Your shift has ended.");
                    loggedIn = false;
                    break;
                default: 
                    System.out.println("Invalid input.");
                    break;
                 
            }
           

            }
        }

        /**
         * Displays and handles the engineer's menu options
         * 
         * @param scanner the Scanner object to read input
         * @param engineer the logged-in Engineer
         * @param maintenanceManager service to log and resolve issues
         */
    private static void engineerMenu(Scanner scanner, Engineer engineer, 
            MaintenanceManager maintenanceManager) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\nEngineer Menu:");
            System.out.println("1. View Pending Issues");
            System.out.println("2. Mark Issue as Resolved");
            System.out.println("3. Logout");

            System.out.print("Choice: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("Pending Maintenance Issues:");
                    List<String> issues = maintenanceManager.getPendingIssues();
                    engineer.viewPendingIssues(issues);
                    break;
                case "2":
                    System.out.print("Enter issue description to resolve: ");
                    String issueID = scanner.nextLine();
                    if (maintenanceManager.resolveIssue(issueID)) {
                        engineer.markIssueAsResolved(issueID);
                    } else {
                        System.out.println("Issue not found.");
                    }
                    break;
                case "3":
                    loggedIn = false;
                    engineer.logout();
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }    
    
    /**
     * The sub menu for the Customer List
     * Shows another menu for options of viewing, adding or removing customers
     */
    public static void MenuCustomer(){
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("\nCustomer Menu:");
            System.out.println("1. View Customers");
            System.out.println("2. Add Customer");
            System.out.println("3. Remove Customer");
            System.out.println("Back to Main Menu");
            System.out.print("Enter your choice: ");
            String choice = in.next();
            
            switch(choice){
                case "1":
                    viewCustomers();
                    break;
                case "2":
                    addCustomer();
                case "3":
                    removeCustomer();
                    break;
                case "4":
                    Menu();
                default: 
                    System.out.println("Invalid choice. Please try again.");
                    MenuCustomer();
            }
            MenuCustomer();
        }         
        
    }
    
    /**
     * Option to view the Customers
     */
    public static void viewCustomers(){
        for(Customer c : customers){
            System.out.println(c.getCustomerInfo());
        }
    }
    
    /**
     * Option to add Customers
     */
    public static void addCustomer(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String name = in.nextLine();
        System.out.print("Enter customer ID: ");
        int id = in.nextInt();
        System.out.print("Enter customer age: ");
        byte age = in.nextByte();
        
        Customer newCustomer = new Customer(name, id, age);
        
        System.out.println("Customer added.");
    }
    
    /**
     * Option to remove Customers
     */
    public static void removeCustomer(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Customer ID to remove: ");
        int id = in.nextInt();
        
        
        for(Customer c: customers){
            if(c.getCustomerID == id){
                customers.remove(c);
                System.out.println("Customer removed");
                break;
            }
            if(c.getCustomerID != id){
                System.out.println("Customer not found.");
                break;
                
            }
        }
    }
           

}

