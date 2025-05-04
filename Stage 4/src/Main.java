///**
// * The entry point for the Movie Theater Management System
// * Handles user login and role-based menu navigation for manager, cashiers
// and engineers
// * 
// * @author paolapereda
// * @author Taryn Davis
// * @author Melissa Flores
// */
//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.JFrame;
//
//
//public class Main {
//    static ArrayList<Manager> managers = new ArrayList<>();
//    static ArrayList<Cashier> cashiers = new ArrayList<>();
//    static ArrayList<Engineer> engineers = new ArrayList<>();
//    static ArrayList<Customer> customers = new ArrayList<>();
//    static ConcessionProcessor concessionProcessor;
//    static TicketSeller ticketSeller;
//   
//
//    /**
//     * The main method that runs the movie theater system
//     * @param args 
//     */
//    public static void main(String [] args)
//    {
//
//        System.out.println("-----Welcome our Theatre Management System!-----");
//
//        Scanner scanner = new Scanner(System.in);   
//         
//     
//        // Manager Users
//        Credential managerCred1 = new Credential("Lil.Ben", "PastelDream9");
//        Manager manager1 = new Manager("Lily Bennett", 40, 1001, 1, "Manager", managerCred1);
//        
//        Credential managerCred2 = new Credential("Jas.Wel", "Shadow99");
//        Manager manager2 = new Manager("Jason Wells", 39, 1002, 2, "Manager", managerCred2);
//        
//        managers.add(manager1);
//        managers.add(manager2);
//
//        //Customers in system already for Customer Class
//        Customer cust1 = new Customer("Darian Lopez", 100, (byte)16);
//        Customer cust2 = new Customer("Sophia Smith", 200, (byte)14);
//        Customer cust3 = new Customer("Amber Zul", 300, (byte)21);
//        Customer cust4 = new Customer("Nicholas Geny", 400, (byte)18);
//        Customer cust5 = new Customer("Corey Shaffer", 500, (byte)61); 
//        
//        Showtime s1 = new Showtime("Clueless", "3:15PM", "4/13/25", "PG-13", "1h37m", 23);
//        Showtime s2 = new Showtime("Insidious", "9:45PM", "4/20/25", "R", "1h53m", 24);
//        Showtime s3 = new Showtime("Divergent", "4:45PM", "4/22/25", "PG-13", "2h19m", 25);
//        Showtime s4 = new Showtime("High School Musical", "2:00PM", "4/24/25", "G", "1h38m", 26);
//        Showtime s5 = new Showtime("BigHeroSix", "7:10PM", "4/26/25", "PG", "1h48m", 27);
//        
//        // SEAT
//        Seat st1 = new Seat(104, 1, 'D', (byte)10, true);
//        Seat st2 = new Seat(307, 3, 'D', (byte)5, false);
//        Seat st3 = new Seat(444, 4, 'H', (byte)7, true);
//        Seat st4 = new Seat(217, 2, 'C', (byte)4, true);
//        Seat st5 = new Seat(543, 5, 'G', (byte)6, true);
//        
//        //TicketOrder Class
//        TicketOrder ticketO1 = new TicketOrder(cust1, s1, st1); // NEED SHOWTIME AND SEAT
//        TicketOrder ticketO2 = new TicketOrder(cust2, s2, st2);
//        TicketOrder ticketO3 = new TicketOrder(cust3, s3, st3);
//        TicketOrder ticketO4 = new TicketOrder(cust4, s4, st4);
//        TicketOrder ticketO5 = new TicketOrder(cust5, s5, st5);
//        
//        //ConcessionOrder Class
//        FoodBeverage fB1 = new FoodBeverage("Popcorn", 3.50, "Small", "None", "Water", 123, 1);
//        ConcessionOrder cO1 = new ConcessionOrder(cust1, fB1, 2);
//        
//        FoodBeverage fB2 = new FoodBeverage("Twix", 2.50, "Small", "None", "Coke", 124, 1);
//        ConcessionOrder cO2 = new ConcessionOrder(cust2, fB2, 2);
//                
//        FoodBeverage fB3 = new FoodBeverage("ICEE", 3.50, "Large", "None", "Water", 125, 2);
//        ConcessionOrder cO3 = new ConcessionOrder(cust3, fB3, 2);
//        
//        FoodBeverage fB4 = new FoodBeverage("Popcorn", 7.50, "Medium", "None", "Water", 126, 2);
//        ConcessionOrder cO4 = new ConcessionOrder(cust4, fB4, 2);
//        
//        FoodBeverage fB5 = new FoodBeverage("Popcorn", 3.50, "Small", "None", "Dr.Pepper", 127, 1);
//        ConcessionOrder cO5 = new ConcessionOrder(cust5, fB5, 2);
//        
//        // Add Ticket and Concession Orders to Customers 
//        cust1.addTicketOrder(ticketO1);
//        cust1.addConcessionOrder(cO1);
//        
//        cust2.addTicketOrder(ticketO2);
//        cust2.addConcessionOrder(cO2);
//        
//        cust3.addTicketOrder(ticketO3);
//        cust3.addConcessionOrder(cO3);
//        
//        cust4.addTicketOrder(ticketO4);
//        cust4.addConcessionOrder(cO4);
//        
//        cust3.addTicketOrder(ticketO5);
//        cust3.addConcessionOrder(cO5);
//        
//        //Adds Customers to a list
//        /*ArrayList<Customer> customers = new ArrayList<>();*/
//        customers.add(cust1);
//        customers.add(cust2);
//        customers.add(cust3);
//        customers.add(cust4);
//        customers.add(cust5);     
//       
//        // Cashier 
//        Credential cashierCred1 = new Credential("Mic.Car", "Treehouse2");
//        Cashier cashier1 = new Cashier("Michael Carter", 28, 1003, 3, "Cashier", cashierCred1, 101);        
//        Credential cashierCred2 = new Credential("Emm.Ree", "Sunflower45");
//        Cashier cashier2 = new Cashier("Michael Carter", 25, 1004, 4, "Cashier", cashierCred2, 102);
//        
//        Credential cashierCred3 = new Credential("Rya.Jac", "BlueSky12");
//        Cashier cashier3 = new Cashier("Ryan Jacobs", 18, 1005, 5, "Cashier", cashierCred3, 103);
//        
//        cashiers.add(cashier1);
//        cashiers.add(cashier2);
//        cashiers.add(cashier3);
//
//        // Engineers
//        Credential engineerCred1 = new Credential("Dan.Fos", "Mountain44");
//        Engineer engineer1 = new Engineer("Daniel Foster", 34, 1006, 6, "Engineer", engineerCred1);
//        
//        Credential engineerCred2 = new Credential("Sar.Col", "CoffeeTime8");
//        Engineer engineer2 = new Engineer("Sarah Collins", 33, 1007, 7, "Engineer", engineerCred2);
//        
//        engineers.add(engineer1);
//        engineers.add(engineer2);
//        
//        //Service Classes
//        ScheduleManager scheduleManager = new ScheduleManager();
//        StaffManager staffManager = new StaffManager();
//        MaintenanceManager maintenanceManager = new MaintenanceManager();
//        
//        maintenanceManager.logIssue("Projector malfunction in Screen 2");
//        maintenanceManager.logIssue("Leaky ceiling in concession area");
//        maintenanceManager.logIssue("AC not working in theater lobby");
//       
//        
//        // Customer csv for Frame 
//        Person aPerson = new Person(); //person is abstract, error
//        String customerInfo = "customers.csv";
//        new Customer_GUI(aPerson, customerInfo).setVisible(true);
//       
//        
//        boolean running = true;
//        while (running) {
//            System.out.println("\n Welcome to the Movie Theater System");
//            System.out.println("1. Manager Login");
//            System.out.println("2. Cashier Login");
//            System.out.println("3. Engineer Login");
//            System.out.println("4. Exit");
//            System.out.print("Choice: ");
//            String choice = scanner.nextLine();
//
//            switch (choice) {
//                case "1":
//                    Manager loggedInManager = null;
//                    for (Manager m : managers) {
//                        if(authenticate(scanner, m)) {
//                            loggedInManager = m;
//                            break;
//                        }
//                    }
//                    
//                    if (loggedInManager != null) {
//                        managerMenu(scanner, loggedInManager, scheduleManager, staffManager, maintenanceManager);
//                    } else { 
//                        System.out.println("Login failed for Manager.");
//                    }
//                    break;
//                case "2":
//                    Cashier loggedInCashier = null;
//                    for (Cashier c : cashiers) {
//                        if (authenticate(scanner, c)) {
//                            loggedInCashier = c;
//                            break;
//                        }
//                    }
//                    if (loggedInCashier != null) {
//                        // You’ll need to pass the appropriate services
//                        cashierMenu(scanner, loggedInCashier, concessionProcessor, ticketSeller);
//                    } else {
//                        System.out.println("Login failed for cashier.");
//                    }
//                    break;
//                case "3":
//                    Engineer loggedInEngineer = null;
//                for (Engineer e : engineers) {
//                    if (authenticate(scanner, e)) {
//                        loggedInEngineer = e;
//                        break;
//                    }
//                }
//                if (loggedInEngineer != null) {
//                    engineerMenu(scanner, loggedInEngineer, maintenanceManager);
//                } else {
//                    System.out.println("Login failed for engineer.");
//                }
//                break;
//                case "4":
//                    running = false;
//                    System.out.println("Goodbye!");
//                    break;
//                default:
//                    System.out.println("Invalid option. Please try again.");
//            }
//        }
//        scanner.close();
//    
//    }
//    
//    /**
//     * Authenticates a staff member based on username and password input
//     * @param scanner the Scanner object reads input
//     * @param staff the staff member attempting to log in
//     * @return true if authentication succeeds, false otherwise
//     */
//    private static boolean authenticate(Scanner scanner, Staff staff) {
//        System.out.print("Username: ");
//        String user = scanner.nextLine();
//        System.out.print("Password: ");
//        String pass = scanner.nextLine();
//        return staff.login(user, pass);
//    }
//    
//    /**
//     * Displays and handles the managers menu options
//     * 
//     * @param scanner the Scanner object to read input
//     * @param manager the logged-in Manager
//     * @param scheduleManager handles movie-to-screen assignments
//     * @param staffManager handles staff role updates
//     * @param maintenanceManager handles maintenance issue logging
//     */
//    private static void managerMenu(Scanner scanner, Manager manager,
//                                    ScheduleManager scheduleManager,
//                                    StaffManager staffManager,
//                                    MaintenanceManager maintenanceManager) {
//        boolean loggedIn = true;
//        while (loggedIn) {
//            System.out.println("\nManager Menu:");
//            System.out.println("1. Assign movie to screen");
//            System.out.println("2. Reset screen seats");
//            System.out.println("3. Assign staff role");
//            System.out.println("4. Log maintenance issue");
//            System.out.println("5. View maintenance issues");
//            System.out.println("6. View customer menu");           
//            System.out.println("7. View Staff");
//            System.out.println("8. Add Staff");
//            System.out.println("9. Remove Staff");
//            System.out.println("10. Logout");
//
//            System.out.print("Choice: ");
//            String input = scanner.nextLine();
//
//            switch (input) {
//                case "1":                    
//                    System.out.print("Movie Title: ");
//                    String movieTitle = scanner.nextLine();
//                    System.out.print("Available Time (HH:mm): ");
//                    String availableTime = scanner.nextLine();
//                    System.out.print("Movie Date (YYYY-MM-DD): ");
//                    String movieDate = scanner.nextLine();
//                    System.out.print("Rating (e.g., PG-13): ");
//                    String rating = scanner.nextLine();
//                    System.out.print("Run Time (e.g., 120 min): ");
//                    String runTime = scanner.nextLine();
//
//                    scheduleManager.assignMovieToScreen(movieTitle, availableTime, movieDate, rating, runTime);
//                    break;
//                case "2":
//                    System.out.print("Enter Screen ID to reset seats: ");
//                    int resetID = Integer.parseInt(scanner.nextLine());
//                    scheduleManager.resetSeats(resetID);
//                    break;
//                case "3":
//                    System.out.print("Enter Staff ID: ");
//                    int staffID = Integer.parseInt(scanner.nextLine());
//                    Staff staff = staffManager.getStaffByID(staffID);
//                    if (staff != null) {
//                        System.out.print("Enter new role: ");
//                        String newRole = scanner.nextLine();
//                        staffManager.assignRole(staff, newRole);
//                    } else {
//                        System.out.println("Staff not found.");
//                    }
//                    break;
//                case "4":
//                    System.out.print("Enter issue description: ");
//                    String issue = scanner.nextLine();
//                    maintenanceManager.logIssue(issue);
//                    break;
//                case "5":
//                    System.out.println("Pending Maintenance Issues:");
//                    for (String i : maintenanceManager.getPendingIssues()) {
//                        System.out.println("- " + i);
//                    }
//                    break;
//                case "6":
//                    MenuCustomer();
//                    break;
//                case "7":
//                    for (Staff s : staffManager.getAllStaff()) {
//                        System.out.println(s.getStaffID() + " - " + s.getName() + " (" + s.getRole() + ")");
//                    }
//                    break;
//                case "8":
//                    System.out.print("Enter name: ");
//                    String sName = scanner.nextLine();
//                    System.out.print("Enter age: ");
//                    int sAge = Integer.parseInt(scanner.nextLine());
//                    System.out.print("Enter staff ID: ");
//                    int newSID = Integer.parseInt(scanner.nextLine());
//                    System.out.print("Enter role: ");
//                    String sRole = scanner.nextLine();
//                    Credential  cred = new Credential("defaultUser", "defaultPass");
//                    Staff newStaff = new Staff(sName, sAge, newSID,newSID, sRole, cred);
//                    staffManager.addStaff(newStaff);
//                    System.out.println("Staff added.");
//                    break;
//                case "9":
//                    System.out.print("Enter staff ID to removeL ");
//                    int removeID = Integer.parseInt(scanner.nextLine());
//                    if (staffManager.removeStaffByID(removeID)) {
//                        System.out.println("Staff removed.");
//                    } else {
//                        System.out.println("Staff ID not found");
//                    }
//                    break;   
//                
//                case "10":
//                    loggedIn = false;
//                    manager.logout();
//                    break;
//                default:
//                    System.out.println("Invalid input.");
//            }
//        }
//    }
//
//    /**
//     * Displays and handles the cashier's menu options.
//     * 
//     * @param scanner
//     * @param cashier
//     * @param concessionProcessor 
//     * @param ticketSeller
//     */
//    private static void cashierMenu(Scanner scanner, Cashier cashier, 
//            ConcessionProcessor concessionProcessor, TicketSeller ticketSeller) {
//        boolean loggedIn = true;
//        while (loggedIn) {
//            System.out.println("\nCashier Menu:");
//            System.out.println("1. Start Shift");
//            System.out.println("2. Customer List");
//            System.out.println("3. Sell Concession Item");
//            System.out.println("4. Sell Movie Ticket");
//            System.out.println("5. End Shift");
//            
//            System.out.print("Enter you choice: ");
//            int choice = scanner.nextInt();
//            
//            switch(choice){
//                case 1: 
//                    cashier.startShift();
//                    System.out.println("Your shift has started.");
//                    break;
//                case 2: 
//                    MenuCustomer();
//                case 3: 
//                    System.out.print("Enter Customer ID: ");
//                    int customerID = scanner.nextInt();
//                    System.out.print("Enter Item ID: ");
//                    int itemID = scanner.nextInt();
//                    System.out.print("Enter Quantity: ");
//                    int quantity = scanner.nextInt();
//                    
//                    boolean success = concessionProcessor.sellItem(customerID, itemID, quantity);
//                    if(success){
//                        System.out.print("Item sold");
//                    } else{
//                        System.out.print("Item not sold. Could not be found.");
//                    }
//                    break;
//
//                case 4: 
//                    System.out.print("Enter Customer ID: ");
//                    int cID = scanner.nextInt();
//                    System.out.print("Enter Showtime ID: ");
//                    int showtimeID = scanner.nextInt();
//                    System.out.print("Enter Seat ID: ");
//                    int seatID = scanner.nextInt();
//                    
//                    boolean ticketsell = ticketSeller.sellTicket(cID, showtimeID, seatID);
//                    if(ticketsell){
//                        System.out.println("Ticket Sold.");
//                    } else{
//                        System.out.println("Ticket not Sold.");
//                    }
//                    break;
//                case 5: 
//                    cashier.endShift();
//                    System.out.println("Your shift has ended.");
//                    loggedIn = false;
//                    break;
//                default: 
//                    System.out.println("Invalid input.");
//                    break;
//                 
//            }
//           
//
//            }
//        }
//
//        /**
//         * Displays and handles the engineer's menu options
//         * 
//         * @param scanner the Scanner object to read input
//         * @param engineer the logged-in Engineer
//         * @param maintenanceManager service to log and resolve issues
//         */
//    private static void engineerMenu(Scanner scanner, Engineer engineer, 
//            MaintenanceManager maintenanceManager) {
//        boolean loggedIn = true;
//        while (loggedIn) {
//            System.out.println("\nEngineer Menu:");
//            System.out.println("1. View Pending Issues");
//            System.out.println("2. Mark Issue as Resolved");
//            System.out.println("3. Logout");
//
//            System.out.print("Choice: ");
//            String input = scanner.nextLine();
//
//            switch (input) {
//                case "1":
//                    System.out.println("Pending Maintenance Issues:");
//                    List<String> issues = maintenanceManager.getPendingIssues();
//                    engineer.viewPendingIssues(issues);
//                    break;
//                case "2":
//                    System.out.print("Enter issue description to resolve: ");
//                    String issueID = scanner.nextLine();
//                    if (maintenanceManager.resolveIssue(issueID)) {
//                        engineer.markIssueAsResolved(issueID);
//                    } else {
//                        System.out.println("Issue not found.");
//                    }
//                    break;
//                case "3":
//                    loggedIn = false;
//                    engineer.logout();
//                    break;
//                default:
//                    System.out.println("Invalid input.");
//            }
//        }
//    }    
//    
//    /**
//     * The sub menu for the Customer List
//     * Shows another menu for options of viewing, adding or removing customers
//     */
//    public static void MenuCustomer(){
//        Scanner in = new Scanner(System.in);
//        while(true){
//            System.out.println("\nCustomer Menu:");
//            System.out.println("1. View Customers");
//            System.out.println("2. Add Customer");
//            System.out.println("3. Remove Customer");
//            System.out.println("4. Back to Previous Menu");
//            System.out.print("Enter your choice: ");
//            String choice = in.next();
//            
//            switch(choice){
//                case "1":
//                    viewCustomers();
//                    break;
//                case "2":
//                    addCustomer();
//                    break;
//                case "3":
//                    removeCustomer();
//                    break;
//                case "4": 
//                    return;
//                default: 
//                    System.out.println("Invalid choice. Please try again.");
//                    break;
//            }
//        }         
//        
//    }
//    
//    public static void viewCustomers(){
//        
////        Customer cust1 = new Customer("Darian Lopez", 100, (byte)16);
////        Customer cust2 = new Customer("Sophia Smith", 200, (byte)14);
////        Customer cust3 = new Customer("Amber Zul", 300, (byte)21);
////        Customer cust4 = new Customer("Nicholas Shaffer", 400, (byte)18);
////        Customer cust5 = new Customer("Corey Shaffer", 500, (byte)61);
////        
////        ArrayList<Customer> customers = new ArrayList<>();
////        customers.add(cust1);
////        customers.add(cust2);
////        customers.add(cust3);
////        customers.add(cust4);
////        customers.add(cust5);    
//        
//        for(Customer c : customers) {
//            System.out.println(c.getCustomerInfo());
//        }
//        
//    }
//    
//
//    public static void addCustomer(){
//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter customer name: ");
//        String name = in.nextLine();
//        System.out.print("Enter customer ID: ");
//        int id = in.nextInt();
//        System.out.print("Enter customer age: ");
//        byte age = in.nextByte();
//        
//        Customer newCustomer = new Customer(name, id, age);    
//
//        customers.add(newCustomer);
//        
//        System.out.println("Customer added");
//    }
//    
//    /*public static void removeCustomer(){
//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter Customer ID to remove: ");
//        int id = in.nextInt();
//        
//        boolean removed = false;
//        for(Customer c : customers){
//            if(c.getCustomerID() == id){
//                customers.remove(c);
//                System.out.println("Customer removed.");
//                removed = true;
//                break;
//            }
//        }
//        
//        if(!removed){
//            System.out.print("Customer ID not found.");
//        }
//    }*/
//    
//    public static void removeCustomer() {
//
//    Scanner in = new Scanner(System.in);
//
//    System.out.print("Enter Customer ID to remove: ");
//
//    int id = in.nextInt();
// 
//    boolean removed = false;
//
//    java.util.Iterator<Customer> iterator = customers.iterator();
//
//    while (iterator.hasNext()) {
//
//        Customer c = iterator.next();
//
//        if (c.getCustomerID() == id) {
//
//            iterator.remove(); // this avoids concurrent modification issues
//
//            System.out.println("Customer removed.");
//
//            removed = true;
//
//            break;
//
//        }
//
//    }
// 
//    if (!removed) {
//
//        System.out.println("Customer ID not found.");
//
//    }
//
//}
//
// 
//}
//
