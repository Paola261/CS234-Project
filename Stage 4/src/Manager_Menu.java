/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Taryn
 */
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Map;
import javax.swing.JTextArea;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import java.awt.Dimension;


public class Manager_Menu extends javax.swing.JFrame {

    private Manager currentManager;
    private StaffManager staffManager;
    private ScheduleManager scheduleManager;
    private AppController controller = AppController.getInstance();
    private InventoryManager inventoryManager;
    private MaintenanceManager maintenanceManager;
    
    
    /**
     * Creates new form Manager_Menu
     */
    public Manager_Menu(Manager manager, StaffManager staffManagerParam, ScheduleManager scheduleManager) {
        initComponents();
        this.currentManager = manager;        
        this.staffManager = staffManagerParam;
        this.scheduleManager = scheduleManager;
        this.inventoryManager = controller.getInventory();
        this.maintenanceManager = controller.getMaintenance();
        
        
        lblManagerName.setText(manager.getName());         
   
        loadStaffTable();
        loadMovieTable();
        loadInventoryTable();       
        refreshMaintenanceTables();
        
    }
    
    
    
    private void loadStaffTable() {
        String[] columns = {"Name", "Age", "Staff ID", "Role"};
        
        java.util.List<Staff> staffList = staffManager.getAllStaff();
        String[][] data = new String[staffList.size()][4];
        
        for (int i = 0; i < staffList.size(); i++) {
            Staff s = staffList.get(i);
            data[i][0] = s.getName();
            data[i][1] = String.valueOf(s.getAge());
            data[i][2] = String.valueOf(s.getStaffID());
            data[i][3] = s.getRole();            
        }
        
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, columns);
        tblStaff.setModel(model);
    }
    
    private void loadMovieTable() {
        Map<Integer, Showtime> showtimes = scheduleManager.getShowtimes();
        String[] columns = {"Title", "Time", "Date", "Rating", "Runtime", "Screen"};
        String[][] data = new String[showtimes.size()][6];
        
        int i = 0;
        for (Showtime s : showtimes.values()) {
            data[i][0] = s.getMovieTitle();
            data[i][1] = s.getAvailableTimes();
            data[i][2] = s.getMovieDate();
            data[i][3] = s.getRating();
            data[i][4] = s.getRunTime();
            data[i][5] = String.valueOf(s.getSID());            
            i++;
        }
        
        DefaultTableModel model = new DefaultTableModel(data, columns);
        tblMovies.setModel(model);
    }
    
    private void loadInventoryTable() {
        String[] columns = {"Item Name", "Quantity", "Price"};
        ArrayList<Items> itemList = controller.getInventory().getItems();
        String[][] data = new String[itemList.size()][3];
        
        for (int i = 0; i < itemList.size(); i++) {
            Items item = itemList.get(i);
            data[i][0] = item.getName();
            data[i][1] = String.valueOf(item.getQuantity());
            data[i][2] = String.format("$%.2f", item.getPrice());
        }
        
        tblInventory.setModel(new DefaultTableModel(data, columns));
    }
    
    private void refreshMaintenanceTables() {
        String[] columns = {"ID", "Description", "Reported By", "Date"};
        List<MaintenanceIssue> pending = maintenanceManager.getOpenIssues();
        List<MaintenanceIssue> resolved = maintenanceManager.getResolvedIssues();

        String[][] pendingData = new String[pending.size()][4];
        String[][] resolvedData = new String[resolved.size()][4];
        
        for (int i = 0; i < pending.size(); i++) {
            MaintenanceIssue m = pending.get(i);
            pendingData[i][0] = String.valueOf(m.getID());
            pendingData[i][1] = m.getDescription();
            pendingData[i][2] = m.getReportedBy();
            pendingData[i][3] = m.getDateReported();
        }
        
        for (int i = 0; i < resolved.size(); i++) {
            MaintenanceIssue m = resolved.get(i);
            resolvedData[i][0] = String.valueOf(m.getID());
            resolvedData[i][1] = m.getDescription();
            resolvedData[i][2] = m.getReportedBy();
            resolvedData[i][3] = m.getDateReported();
        }
        
        tblPendingIssues.setModel(new javax.swing.table.DefaultTableModel(pendingData, columns));
        tblResolvedIssues.setModel(new javax.swing.table.DefaultTableModel(resolvedData, columns));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        jOptionPane1 = new javax.swing.JOptionPane();
        lblManagerName1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        tabAccountPane = new javax.swing.JTabbedPane();
        jAccountPanel = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        lblManagerName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnChangePassword = new javax.swing.JButton();
        jStaffPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStaff = new javax.swing.JTable();
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtRole = new javax.swing.JTextField();
        btnAddStaffMember = new javax.swing.JButton();
        btnRemoveStaffMember = new javax.swing.JButton();
        btnChangeStaffRole = new javax.swing.JButton();
        btnViewMoreDetails = new javax.swing.JButton();
        btnViewStaffLog = new javax.swing.JButton();
        panelCustomerMenu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtRuntime = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtRating = new javax.swing.JTextField();
        btnAssignMovie = new javax.swing.JButton();
        btnViewDetails = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMovies = new javax.swing.JTable();
        txtDate = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtScreen = new javax.swing.JTextField();
        btnRemoveMovie = new javax.swing.JButton();
        btnViewSoldSeats = new javax.swing.JButton();
        btnEditDetails = new javax.swing.JButton();
        panelInventory = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblInventory = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtItemName = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtItemQuantity = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtItemPrice = new javax.swing.JTextField();
        btnAddItem = new javax.swing.JButton();
        btnOrderMore = new javax.swing.JButton();
        btnRemoveItem = new javax.swing.JButton();
        panelMaintenanceMenu = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblResolvedIssues = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblPendingIssues = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnLogNewIssue = new javax.swing.JButton();
        btnResolveIssue = new javax.swing.JButton();
        btnViewIssueDetails = new javax.swing.JButton();
        btnViewResolvedDetails = new javax.swing.JButton();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        lblManagerName1.setText("Manager Name");

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jAccountPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWelcome.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(3, 4, 94));
        lblWelcome.setText("Welcome!");
        jAccountPanel.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        lblManagerName.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblManagerName.setText("Manager Name");
        jAccountPanel.add(lblManagerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 140, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setText("__________");
        jAccountPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 200, 90));

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jAccountPanel.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 90, 30));
        jAccountPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));

        btnChangePassword.setText("Reset Password");
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });
        jAccountPanel.add(btnChangePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 160, 30));

        tabAccountPane.addTab("Account Menu", jAccountPanel);

        jStaffPanel.setLayout(null);

        jLabel1.setText("Name:");
        jStaffPanel.add(jLabel1);
        jLabel1.setBounds(20, 30, 37, 16);

        jLabel5.setText("Age:");
        jStaffPanel.add(jLabel5);
        jLabel5.setBounds(20, 90, 37, 16);

        jLabel6.setText("ID:");
        jStaffPanel.add(jLabel6);
        jLabel6.setBounds(20, 150, 60, 16);

        jLabel7.setText("Role: ");
        jStaffPanel.add(jLabel7);
        jLabel7.setBounds(20, 210, 120, 16);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("Staff");
        jStaffPanel.add(jLabel8);
        jLabel8.setBounds(430, 10, 60, 60);

        tblStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStaff);

        jStaffPanel.add(jScrollPane1);
        jScrollPane1.setBounds(220, 60, 480, 170);

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jStaffPanel.add(txtName);
        txtName.setBounds(20, 50, 180, 30);
        jStaffPanel.add(txtAge);
        txtAge.setBounds(20, 110, 180, 30);
        jStaffPanel.add(txtID);
        txtID.setBounds(20, 170, 180, 30);
        jStaffPanel.add(txtRole);
        txtRole.setBounds(20, 230, 180, 30);

        btnAddStaffMember.setText("Add Staff Member");
        btnAddStaffMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStaffMemberActionPerformed(evt);
            }
        });
        jStaffPanel.add(btnAddStaffMember);
        btnAddStaffMember.setBounds(20, 280, 180, 23);

        btnRemoveStaffMember.setText("Remove Staff Member");
        btnRemoveStaffMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveStaffMemberActionPerformed(evt);
            }
        });
        jStaffPanel.add(btnRemoveStaffMember);
        btnRemoveStaffMember.setBounds(520, 260, 180, 23);

        btnChangeStaffRole.setText("Change Staff Role");
        btnChangeStaffRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeStaffRoleActionPerformed(evt);
            }
        });
        jStaffPanel.add(btnChangeStaffRole);
        btnChangeStaffRole.setBounds(520, 300, 180, 23);

        btnViewMoreDetails.setText("View More Details");
        btnViewMoreDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewMoreDetailsActionPerformed(evt);
            }
        });
        jStaffPanel.add(btnViewMoreDetails);
        btnViewMoreDetails.setBounds(520, 340, 180, 23);

        btnViewStaffLog.setText("View Staff Log Details");
        btnViewStaffLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewStaffLogActionPerformed(evt);
            }
        });
        jStaffPanel.add(btnViewStaffLog);
        btnViewStaffLog.setBounds(520, 380, 180, 23);

        tabAccountPane.addTab("Staff Menu", jStaffPanel);

        panelCustomerMenu.setLayout(null);
        tabAccountPane.addTab("Customer Menu", panelCustomerMenu);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("Movie Title:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 20));

        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });
        jPanel4.add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 270, -1));

        jLabel10.setText("Date:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 70, 20));

        jLabel11.setText("Runtime:");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));
        jPanel4.add(txtRuntime, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 150, -1));

        jLabel12.setText("Time:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, 20));
        jPanel4.add(txtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 180, -1));

        jLabel13.setText("Rating:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, -1, 20));
        jPanel4.add(txtRating, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 180, -1));

        btnAssignMovie.setText("Assign Movie");
        btnAssignMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignMovieActionPerformed(evt);
            }
        });
        jPanel4.add(btnAssignMovie, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 140, -1));

        btnViewDetails.setText("View Details");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });
        jPanel4.add(btnViewDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 150, -1));

        tblMovies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblMovies);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 670, 200));
        jPanel4.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 150, -1));

        jLabel14.setText("Screen:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, -1, -1));
        jPanel4.add(txtScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 180, -1));

        btnRemoveMovie.setText("Remove Movie");
        btnRemoveMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveMovieActionPerformed(evt);
            }
        });
        jPanel4.add(btnRemoveMovie, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 140, -1));

        btnViewSoldSeats.setText("View Sold Seats");
        btnViewSoldSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSoldSeatsActionPerformed(evt);
            }
        });
        jPanel4.add(btnViewSoldSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 150, -1));

        btnEditDetails.setText("Edit Details");
        btnEditDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDetailsActionPerformed(evt);
            }
        });
        jPanel4.add(btnEditDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 140, -1));

        tabAccountPane.addTab("Movie Menu", jPanel4);

        tblInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblInventory);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Add New Concession Item:");

        jLabel16.setText("Name:");

        txtItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemNameActionPerformed(evt);
            }
        });

        jLabel17.setText("Quantity:");

        jLabel18.setText("Price:");

        txtItemPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemPriceActionPerformed(evt);
            }
        });

        btnAddItem.setText("Add Item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        btnOrderMore.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnOrderMore.setText("Order");
        btnOrderMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderMoreActionPerformed(evt);
            }
        });

        btnRemoveItem.setText("Remove Item");
        btnRemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInventoryLayout = new javax.swing.GroupLayout(panelInventory);
        panelInventory.setLayout(panelInventoryLayout);
        panelInventoryLayout.setHorizontalGroup(
            panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(panelInventoryLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInventoryLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(30, 30, 30)
                        .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInventoryLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(99, 99, 99)
                        .addComponent(btnRemoveItem, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInventoryLayout.createSequentialGroup()
                        .addGroup(panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelInventoryLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(txtItemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel18)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(338, Short.MAX_VALUE))
            .addGroup(panelInventoryLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOrderMore, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        panelInventoryLayout.setVerticalGroup(
            panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(btnOrderMore, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtItemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btnAddItem)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        tabAccountPane.addTab("Inventory Menu", panelInventory);

        panelMaintenanceMenu.setLayout(null);

        tblResolvedIssues.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tblResolvedIssues);

        panelMaintenanceMenu.add(jScrollPane5);
        jScrollPane5.setBounds(310, 60, 310, 410);

        tblPendingIssues.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tblPendingIssues);

        panelMaintenanceMenu.add(jScrollPane6);
        jScrollPane6.setBounds(20, 60, 280, 410);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Pending Issues:");
        panelMaintenanceMenu.add(jLabel19);
        jLabel19.setBounds(20, 30, 216, 25);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Resolved Issues:");
        panelMaintenanceMenu.add(jLabel20);
        jLabel20.setBounds(310, 20, 150, 40);

        btnLogNewIssue.setText("Log New Issue");
        btnLogNewIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogNewIssueActionPerformed(evt);
            }
        });
        panelMaintenanceMenu.add(btnLogNewIssue);
        btnLogNewIssue.setBounds(630, 190, 179, 23);

        btnResolveIssue.setText("Resolve Issue");
        btnResolveIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolveIssueActionPerformed(evt);
            }
        });
        panelMaintenanceMenu.add(btnResolveIssue);
        btnResolveIssue.setBounds(630, 230, 179, 23);

        btnViewIssueDetails.setText("View Issue Details");
        btnViewIssueDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewIssueDetailsActionPerformed(evt);
            }
        });
        panelMaintenanceMenu.add(btnViewIssueDetails);
        btnViewIssueDetails.setBounds(170, 30, 130, 23);

        btnViewResolvedDetails.setText("View Resolved Details");
        btnViewResolvedDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewResolvedDetailsActionPerformed(evt);
            }
        });
        panelMaintenanceMenu.add(btnViewResolvedDetails);
        btnViewResolvedDetails.setBounds(460, 30, 160, 23);

        tabAccountPane.addTab("Maintenance Menu", panelMaintenanceMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabAccountPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(tabAccountPane, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewMoreDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewMoreDetailsActionPerformed
        int selectedRow = tblStaff.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a staff member.");
            return;
        }
        
        int id = Integer.parseInt(tblStaff.getValueAt(selectedRow, 2).toString());
        Staff s = staffManager.getStaffByID(id);
        if (s != null) {
            String details = "Name: " + s.getName()
                    + "\nAge: " + s.getAge()
                    + "\nID: " + s.getStaffID()
                    + "\nRole: " + s.getRole()
                    + "\nUsername: " + s.getCredential().getUsername()
                    + "\nPassword: " + s.getCredential().getPasswordHash();
            JOptionPane.showMessageDialog(this, details, "Staff Details", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnViewMoreDetailsActionPerformed

    private void btnAddStaffMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStaffMemberActionPerformed
        String name = txtName.getText();
        String ageStr = txtAge.getText();
        String idStr = txtID.getText();
        String role = txtRole.getText();
        
        if (name.isEmpty() || ageStr.isEmpty() || idStr.isEmpty() || role.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }
        
        try {
            int age = Integer.parseInt(ageStr);
            int id = Integer.parseInt(idStr);
            
            String normalizedRole = role.toLowerCase();
            if (!normalizedRole.equals("cashier") && !normalizedRole.equals("manager") && !normalizedRole.equals("engineer")) {
                JOptionPane.showMessageDialog(this, "Role must be either: Cashier, Manager or Engineer");
                return;
            }
            
            for (Staff s : staffManager.getAllStaff()) {
                if (s.getStaffID() == id) {
                    JOptionPane.showMessageDialog(this, "Staff ID already exists.");
                    return;
                }
                if (s.getName().equalsIgnoreCase(name)) {
                    JOptionPane.showMessageDialog(this, "Staff name already exists.");
                    return;
                }
            }
            
            String username = JOptionPane.showInputDialog(this, "Create Username");
            String password = JOptionPane.showInputDialog(this, "Create Password");
            if (username == null || password == null) return;
            
            for (Staff s: staffManager.getAllStaff()) {
                if (s.getCredential().getUsername().equalsIgnoreCase(username)) {
                    JOptionPane.showMessageDialog(this, "Username already exists. Choose another.");
                    return;
                }
            }
            
            Credential cred = new Credential(username, password);
            Staff newStaff = new Staff(name, age, id, id, role, cred);
            staffManager.addStaff(newStaff);
            loadStaffTable();
            
            txtName.setText("");
            txtAge.setText("");
            txtID.setText("");
            txtRole.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age and ID must be numbers");
        }
    }//GEN-LAST:event_btnAddStaffMemberActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        controller.saveAllData();
        new Login_Application().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnRemoveStaffMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveStaffMemberActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblStaff.getSelectedRow();
        if  (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a Staff Member to Remove");
            return;
        }
        
        String staffIDStr = tblStaff.getValueAt(selectedRow, 2).toString();
        String name = tblStaff.getValueAt(selectedRow, 0).toString(); 
        String idStr = tblStaff.getValueAt(selectedRow, 2).toString();
        
        int staffID = Integer.parseInt(staffIDStr);
        
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove \"" + name + "\"?", "Confirm Removal", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            boolean removed = staffManager.removeStaffByID(staffID);
            if (removed) {
                loadStaffTable();
                JOptionPane.showMessageDialog(this, "Staff member removed");
            } else {
                JOptionPane.showMessageDialog(this, "Staff not found");
            }
        }
    }//GEN-LAST:event_btnRemoveStaffMemberActionPerformed

    private void btnChangeStaffRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeStaffRoleActionPerformed
        int selectedRow = tblStaff.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a staff member.");
            return;
        }
        
        String idStr = tblStaff.getValueAt(selectedRow, 2).toString();
        int id = Integer.parseInt(idStr);
        Staff staff = staffManager.getStaffByID(id);
        
        if (staff != null) {
            String newRole = txtRole.getText();
            if (newRole.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter a new role.");
                return;
            }
            
            staff.setRole(newRole);
            loadStaffTable();
            JOptionPane.showMessageDialog(this, "Role Updated.");
        } else {
            JOptionPane.showMessageDialog(this, "Staff not found.");
        }
    }//GEN-LAST:event_btnChangeStaffRoleActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        String newPass = JOptionPane.showInputDialog(this, "Enter new Password:");
        if (newPass == null || newPass.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Passowrd not changed.");
            return;
        }
        currentManager.getCredential().updatePassword(newPass);
        JOptionPane.showMessageDialog(this, "Password Updated!");
    }//GEN-LAST:event_btnChangePasswordActionPerformed

    private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitleActionPerformed

    private void btnAssignMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignMovieActionPerformed
        // TODO add your handling code here:
        String title = txtTitle.getText().trim();
        String time = txtTime.getText().trim();
        String date = txtDate.getText().trim();
        String rating = txtRating.getText().trim();
        String runtime = txtRuntime.getText().trim();
        
        if (title.isEmpty() || time.isEmpty() || date.isEmpty() || rating.isEmpty() || runtime.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }
        
        scheduleManager.assignMovieToScreen(title, time, date, rating, runtime);
        loadMovieTable();
        JOptionPane.showMessageDialog(this, "Movie assigned successful.");
    }//GEN-LAST:event_btnAssignMovieActionPerformed

    private void btnRemoveMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveMovieActionPerformed
        int selectedRow = tblMovies.getSelectedRow();
        if(selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a movie to remove.");
            return;
        }
        
        String title = tblMovies.getValueAt(selectedRow, 0).toString();
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove \"" + title + "\"?", "Confirm Removal.", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            boolean removed = scheduleManager.removeShowtimeByTItle(title);
            if(removed) {
                loadMovieTable();
                JOptionPane.showMessageDialog(this, "Movie Removed.");
            } else {
                JOptionPane.showMessageDialog(this, "Movie not found");
            }
        }
    }//GEN-LAST:event_btnRemoveMovieActionPerformed

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
        int selectedRow = tblMovies.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a movie to view details.");
            return;
        }
        
        String title = tblMovies.getValueAt(selectedRow, 0).toString();
        int screenID = Integer.parseInt(tblMovies.getValueAt(selectedRow, 5).toString());
        Showtime show = scheduleManager.getShowtimes().get(screenID);
        
        if (show != null) {
            String details = "Title: " + show.getMovieTitle()
                    + "\nTime: " + show.getAvailableTimes()
                    + "\nDate: " + show.getMovieDate()
                    + "\nRating: " + show.getRating()
                    + "\nRuntime: " + show.getRunTime()
                    + "\nScreen: " + show.getSID();
            JOptionPane.showMessageDialog(this, details, "Movie Details", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnViewDetailsActionPerformed

    private void btnViewSoldSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSoldSeatsActionPerformed
        int selectedRow = tblMovies.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a movie to view sold seats.");
            return;
        }
        
        int screenID = Integer.parseInt(tblMovies.getValueAt(selectedRow, 5).toString());
        Showtime show = scheduleManager.getShowtimes().get(screenID);
        
        if (show != null) {
            String layout = Showtime.getSeatLayoutDisplay(show);
            JTextArea textArea = new JTextArea(layout);
            textArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
            textArea.setEditable(false);
            JOptionPane.showMessageDialog(this, textArea, "Seat Layout for " + show.getMovieTitle(), JOptionPane.INFORMATION_MESSAGE);            
        } else {
            JOptionPane.showMessageDialog(this, "Showtime not found");
        }
    }//GEN-LAST:event_btnViewSoldSeatsActionPerformed

    private void btnEditDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDetailsActionPerformed
        int selectedRow = tblMovies.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a movie to view sold seats.");
            return;
        }
        
        String oldTitle = tblMovies.getValueAt(selectedRow, 0).toString();
        int screenID = Integer.parseInt(tblMovies.getValueAt(selectedRow, 5).toString());
        
        Showtime showtime = scheduleManager.getShowtimes().get(screenID);
        if (showtime == null) {
            JOptionPane.showMessageDialog(this, "Error finding selected movie.");
            return;
        }
        
        String newTitle = txtTitle.getText().trim();
        String newTime = txtTime.getText().trim();
        String newDate = txtDate.getText().trim();
        String newRating = txtRating.getText().trim();
        String newRuntime = txtRuntime.getText().trim();
        String newScreen = txtScreen.getText().trim();
        
        if (newTitle.isEmpty() || newTime.isEmpty() || newDate.isEmpty() || newRating.isEmpty() || newRuntime.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }
        
        for (Showtime other : scheduleManager.getShowtimes().values()) {
            if (other.getSID() != showtime.getSID() && other.getAvailableTimes().equalsIgnoreCase(newTime) && other.getSID() == screenID) {
                JOptionPane.showMessageDialog(this, "Another movie is already scheduled at this time");
                return;
            }
        }
        
        showtime.setMovieTitle(newTitle);
        showtime.setAvailableTimes(newTime);
        showtime.setMovieDate(newDate);
        showtime.setRating(newRating);
        showtime.setRunTime(newRuntime);
        
        
        loadMovieTable();
        JOptionPane.showMessageDialog(this, "Movie details updated!");
    }//GEN-LAST:event_btnEditDetailsActionPerformed

    private void txtItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemNameActionPerformed

    private void txtItemPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemPriceActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed

        String name = txtItemName.getText();
        int qty = Integer.parseInt(txtItemQuantity.getText());
        double price = Double.parseDouble(txtItemPrice.getText());
        
        for (Items item : inventoryManager.getItems()) {
            if(item.getName().equalsIgnoreCase(name)) {
                JOptionPane.showMessageDialog(this, "Item already exists. Please use a different name.");
                return;
            }
        }
        Concession newItem = new Concession(name, qty, price);
        inventoryManager.addItem(newItem);
        loadInventoryTable();
        
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void btnOrderMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderMoreActionPerformed
        int selectedRow = tblInventory.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a row to order more items.");
            return;
        }       
        
        String itemName = tblInventory.getValueAt(selectedRow, 0).toString();
        int qtyToAdd = Integer.parseInt(JOptionPane.showInputDialog("How many to add?"));
        
        for (Items item : inventoryManager.getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                if(item instanceof Concession c) {
                    c.sell(-qtyToAdd);
                }
            }
        }
        loadInventoryTable();
    }//GEN-LAST:event_btnOrderMoreActionPerformed

    private void btnRemoveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveItemActionPerformed
        int selectedRow = tblInventory.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select and item to remvoe.");
            return;
        }
        
        String itemName = tblInventory.getValueAt(selectedRow, 0).toString();
        
        Items itemToRemove = null;
        for (Items item : inventoryManager.getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemToRemove = item;
                break;
            }
        }
        
        if (itemToRemove != null) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove " + itemName + "?", "Confirm Remove", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                inventoryManager.removeItem(itemToRemove);
                loadInventoryTable();
                JOptionPane.showMessageDialog(this, "Item Removed Successfully");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Item not found.");
        }
    }//GEN-LAST:event_btnRemoveItemActionPerformed

    private void btnLogNewIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogNewIssueActionPerformed
        String description = JOptionPane.showInputDialog(this, "Enter Issue Description:");
        if (description == null || description.isEmpty()) return;
        
        String reporter = currentManager.getName();
        String date = java.time.LocalDate.now().toString();
        int id = maintenanceManager.getOpenIssues().size() + maintenanceManager.getResolvedIssues().size() + 1;
        
        MaintenanceIssue issue = new MaintenanceIssue(id, description, reporter, date, "Open", "");
        maintenanceManager.logIssue(issue);
        refreshMaintenanceTables();
    }//GEN-LAST:event_btnLogNewIssueActionPerformed

    private void btnResolveIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolveIssueActionPerformed
        int row = tblPendingIssues.getSelectedRow();
        if(row == -1) {
            JOptionPane.showMessageDialog(this, "Select an issue to resolve.");
            return;
        }
        
        String idString = tblPendingIssues.getValueAt(row, 0).toString();
        int issueID = Integer.parseInt(idString);
        String note = JOptionPane.showInputDialog(this, "Enter resolution note:");
        
        MaintenanceIssue selectedIssue = null;
        for (MaintenanceIssue issue : maintenanceManager.getOpenIssues()) {
            if (issue.getID() == issueID) {
                selectedIssue = issue;
                break;
            }
        }
        if (selectedIssue != null && note != null) {
            boolean success = maintenanceManager.resolveIssue(selectedIssue, note);
            if (success) {
                JOptionPane.showMessageDialog(this, "Issue Resolved!");
                refreshMaintenanceTables();
            } else {
                JOptionPane.showMessageDialog(this, "Unable to resolve Issue.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Issue not found or invalid input.");
        }    
    }//GEN-LAST:event_btnResolveIssueActionPerformed

    private void btnViewIssueDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewIssueDetailsActionPerformed
        int row = tblPendingIssues.getSelectedRow();
        if(row == -1) {
            JOptionPane.showMessageDialog(this, "Select an issue to view.");
            return;
        }
        
        int issueID = Integer.parseInt(tblPendingIssues.getValueAt(row, 0).toString());
        for (MaintenanceIssue m : maintenanceManager.getOpenIssues()) {
            if (m.getID() == issueID) {
                String details = "Issue #" + m.getID() + "\nDescription: " + m.getDescription()
                        + "\nReported By: " + m.getReportedBy()
                        + "\nDate: " + m.getDateReported()
                        + "\nStatus: " + m.getStatus();
                JOptionPane.showMessageDialog(this, details, "Pending Issue Details", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
    }//GEN-LAST:event_btnViewIssueDetailsActionPerformed

    private void btnViewResolvedDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewResolvedDetailsActionPerformed
        int row = tblResolvedIssues.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a resolved issue to view.");
            return;
        }

        int issueID = Integer.parseInt(tblResolvedIssues.getValueAt(row, 0).toString());
        for (MaintenanceIssue m : maintenanceManager.getResolvedIssues()) {
            if (m.getID() == issueID) {
                String details = "Issue #" + m.getID() + "\nDescription: " + m.getDescription()
                        + "\nReported By: " + m.getReportedBy()
                        + "\nDate: " + m.getDateReported()
                        + "\nStatus: " + m.getStatus()
                        + "\nResolution Note: " + m.getResolutionNote();
                JOptionPane.showMessageDialog(this, details, "Resolved Issue Details", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
    }//GEN-LAST:event_btnViewResolvedDetailsActionPerformed

    private void btnViewStaffLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewStaffLogActionPerformed
               
        int selectedRow = tblStaff.getSelectedRow();
        if (selectedRow != -1) {
            String staffName = tblStaff.getValueAt(selectedRow, 0).toString(); // Adjust index as needed
            String report = ClockHandler.getFullClockReport(staffName);

            JTextArea textArea = new JTextArea(report);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));

            JOptionPane.showMessageDialog(this, scrollPane, "Clock Log Report", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnViewStaffLogActionPerformed

    /**
     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Manager_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Manager_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Manager_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Manager_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Manager_Menu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnAddStaffMember;
    private javax.swing.JButton btnAssignMovie;
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnChangeStaffRole;
    private javax.swing.JButton btnEditDetails;
    private javax.swing.JButton btnLogNewIssue;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnOrderMore;
    private javax.swing.JButton btnRemoveItem;
    private javax.swing.JButton btnRemoveMovie;
    private javax.swing.JButton btnRemoveStaffMember;
    private javax.swing.JButton btnResolveIssue;
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JButton btnViewIssueDetails;
    private javax.swing.JButton btnViewMoreDetails;
    private javax.swing.JButton btnViewResolvedDetails;
    private javax.swing.JButton btnViewSoldSeats;
    private javax.swing.JButton btnViewStaffLog;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jAccountPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel jStaffPanel;
    private javax.swing.JLabel lblManagerName;
    private javax.swing.JLabel lblManagerName1;
    private javax.swing.JLabel lblWelcome;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private javax.swing.JPanel panelCustomerMenu;
    private javax.swing.JPanel panelInventory;
    private javax.swing.JPanel panelMaintenanceMenu;
    private javax.swing.JTabbedPane tabAccountPane;
    private javax.swing.JTable tblInventory;
    private javax.swing.JTable tblMovies;
    private javax.swing.JTable tblPendingIssues;
    private javax.swing.JTable tblResolvedIssues;
    private javax.swing.JTable tblStaff;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtItemPrice;
    private javax.swing.JTextField txtItemQuantity;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtRating;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtRuntime;
    private javax.swing.JTextField txtScreen;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
