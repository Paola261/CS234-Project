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
import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedReader;



public class Manager_Menu extends javax.swing.JFrame {

    private Manager currentManager;
    private StaffManager staffManager;
    private ScheduleManager scheduleManager;
    private AppController controller = AppController.getInstance();
    private InventoryManager inventoryManager;
    private MaintenanceManager maintenanceManager;
    private CustomerManager customerManager; 
    private String customerInfo;
    
    
    /**
     * Creates new form Manager_Menu
     */
    public Manager_Menu(Manager manager, StaffManager staffManagerParam, ScheduleManager scheduleManager, CustomerManager customerManager) {
        initComponents();
        this.currentManager = manager;        
        this.staffManager = staffManagerParam;
        this.scheduleManager = scheduleManager;
        this.inventoryManager = controller.getInventory();
        this.maintenanceManager = controller.getMaintenance();
        
        this.customerManager = customerManager;
        customerInfo = "customer.csv";
        
        
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
        jLabel22 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jStaffPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStaff = new javax.swing.JTable();
        btnRemoveStaffMember = new javax.swing.JButton();
        btnChangeStaffRole = new javax.swing.JButton();
        btnViewMoreDetails = new javax.swing.JButton();
        btnViewStaffLog = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        btnAddStaffMember = new javax.swing.JButton();
        txtRole = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        panelCustomerMenu = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        customerList = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtName2 = new javax.swing.JTextField();
        txtID2 = new javax.swing.JTextField();
        txtAge2 = new javax.swing.JTextField();
        lblName1 = new javax.swing.JLabel();
        lblID1 = new javax.swing.JLabel();
        lblAge1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnDelete1 = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
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
        jLabel25 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnViewDetails = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMovies = new javax.swing.JTable();
        btnRemoveMovie = new javax.swing.JButton();
        btnViewSoldSeats = new javax.swing.JButton();
        btnEditDetails = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnAssignMovie = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtScreen = new javax.swing.JTextField();
        txtTitle = new javax.swing.JTextField();
        txtTime = new javax.swing.JTextField();
        txtRating = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        txtRuntime = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
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
        jLabel26 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();

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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jAccountPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWelcome.setBackground(new java.awt.Color(0, 0, 102));
        lblWelcome.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(0, 0, 102));
        lblWelcome.setText("Welcome!");
        jAccountPanel.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        lblManagerName.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        lblManagerName.setForeground(new java.awt.Color(255, 51, 255));
        lblManagerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblManagerName.setText("Manager Name");
        jAccountPanel.add(lblManagerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 200, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setText("__________");
        jAccountPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 200, 80));

        btnLogout.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jAccountPanel.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 100, 30));
        jAccountPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));

        btnChangePassword.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnChangePassword.setText("Reset Password");
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });
        jAccountPanel.add(btnChangePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 160, 30));
        jAccountPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -180, 820, -1));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screenshot 2025-04-30 230942.png"))); // NOI18N
        jAccountPanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, -1, -1));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI BACKGROUND.png"))); // NOI18N
        jAccountPanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -70, 990, -1));

        tabAccountPane.addTab("Account Menu", jAccountPanel);

        jStaffPanel.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setText("Staff List:");
        jStaffPanel.add(jLabel8);
        jLabel8.setBounds(500, 10, 100, 60);

        tblStaff.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
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
        jScrollPane1.setBounds(310, 70, 480, 230);

        btnRemoveStaffMember.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnRemoveStaffMember.setText("Remove Staff Member");
        btnRemoveStaffMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveStaffMemberActionPerformed(evt);
            }
        });
        jStaffPanel.add(btnRemoveStaffMember);
        btnRemoveStaffMember.setBounds(330, 330, 180, 22);

        btnChangeStaffRole.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnChangeStaffRole.setText("Change Staff Role");
        btnChangeStaffRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeStaffRoleActionPerformed(evt);
            }
        });
        jStaffPanel.add(btnChangeStaffRole);
        btnChangeStaffRole.setBounds(330, 370, 180, 20);

        btnViewMoreDetails.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnViewMoreDetails.setText("View More Details");
        btnViewMoreDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewMoreDetailsActionPerformed(evt);
            }
        });
        jStaffPanel.add(btnViewMoreDetails);
        btnViewMoreDetails.setBounds(590, 330, 180, 22);

        btnViewStaffLog.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnViewStaffLog.setText("View Staff Log Details");
        btnViewStaffLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewStaffLogActionPerformed(evt);
            }
        });
        jStaffPanel.add(btnViewStaffLog);
        btnViewStaffLog.setBounds(590, 370, 180, 22);
        jStaffPanel.add(jSeparator1);
        jSeparator1.setBounds(-10, 0, 0, 3);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Staff Details:");

        btnAddStaffMember.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnAddStaffMember.setText("Add Staff Member");
        btnAddStaffMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStaffMemberActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setText("Role: ");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setText("ID:");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setText("Age:");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setText("Name:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtAge, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 19, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddStaffMember, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddStaffMember)
                .addGap(31, 31, 31))
        );

        jStaffPanel.add(jPanel1);
        jPanel1.setBounds(10, 50, 250, 360);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI BACKGROUND.png"))); // NOI18N
        jStaffPanel.add(jLabel31);
        jLabel31.setBounds(-30, 0, 920, 470);

        tabAccountPane.addTab("Staff Menu", jStaffPanel);

        panelCustomerMenu.setLayout(null);

        customerList.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        customerList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ID", "Age"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerList.setName(""); // NOI18N
        customerList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerListMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(customerList);

        panelCustomerMenu.add(jScrollPane4);
        jScrollPane4.setBounds(380, 70, 430, 380);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel2.setForeground(new java.awt.Color(153, 153, 153));

        txtName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtName2ActionPerformed(evt);
            }
        });

        txtID2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtID2ActionPerformed(evt);
            }
        });

        txtAge2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAge2ActionPerformed(evt);
            }
        });

        lblName1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblName1.setText("Name:");

        lblID1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblID1.setText("ID:");

        lblAge1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblAge1.setText("Age:");

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel23.setText("Customer Details:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblID1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAge1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName2, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(txtID2)
                            .addComponent(txtAge2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel23)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(12, 12, 12)
                .addComponent(lblName1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblID1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAge1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAge2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        panelCustomerMenu.add(jPanel2);
        jPanel2.setBounds(30, 40, 250, 250);

        btnDelete1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnDelete1.setText("Delete");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });
        panelCustomerMenu.add(btnDelete1);
        btnDelete1.setBounds(200, 310, 72, 22);

        lblName.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("Customer List:");
        panelCustomerMenu.add(lblName);
        lblName.setBounds(510, 30, 170, 31);

        btnUpdate.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        panelCustomerMenu.add(btnUpdate);
        btnUpdate.setBounds(30, 350, 72, 22);

        btnAdd.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        panelCustomerMenu.add(btnAdd);
        btnAdd.setBounds(30, 310, 72, 22);

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelCustomerMenu.add(jButton1);
        jButton1.setBounds(200, 350, 72, 22);

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI BACKGROUND.png"))); // NOI18N
        panelCustomerMenu.add(jLabel32);
        jLabel32.setBounds(0, 0, 880, 470);

        tabAccountPane.addTab("Customer Menu", panelCustomerMenu);

        panelMaintenanceMenu.setLayout(null);

        tblResolvedIssues.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
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
        jScrollPane5.setBounds(310, 60, 310, 400);

        tblPendingIssues.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
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
        jScrollPane6.setBounds(20, 60, 280, 400);

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel19.setText("Pending Issues:");
        panelMaintenanceMenu.add(jLabel19);
        jLabel19.setBounds(20, 30, 216, 23);

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel20.setText("Resolved Issues:");
        panelMaintenanceMenu.add(jLabel20);
        jLabel20.setBounds(310, 20, 150, 40);

        btnLogNewIssue.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnLogNewIssue.setText("Log New Issue");
        btnLogNewIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogNewIssueActionPerformed(evt);
            }
        });
        panelMaintenanceMenu.add(btnLogNewIssue);
        btnLogNewIssue.setBounds(640, 190, 179, 22);

        btnResolveIssue.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnResolveIssue.setText("Resolve Issue");
        btnResolveIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolveIssueActionPerformed(evt);
            }
        });
        panelMaintenanceMenu.add(btnResolveIssue);
        btnResolveIssue.setBounds(640, 230, 179, 22);

        btnViewIssueDetails.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnViewIssueDetails.setText("View Issue Details");
        btnViewIssueDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewIssueDetailsActionPerformed(evt);
            }
        });
        panelMaintenanceMenu.add(btnViewIssueDetails);
        btnViewIssueDetails.setBounds(170, 30, 130, 22);

        btnViewResolvedDetails.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnViewResolvedDetails.setText("View Resolved Details");
        btnViewResolvedDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewResolvedDetailsActionPerformed(evt);
            }
        });
        panelMaintenanceMenu.add(btnViewResolvedDetails);
        btnViewResolvedDetails.setBounds(460, 30, 160, 22);
        panelMaintenanceMenu.add(jLabel25);
        jLabel25.setBounds(-80, -220, 0, 0);

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI BACKGROUND.png"))); // NOI18N
        panelMaintenanceMenu.add(jLabel35);
        jLabel35.setBounds(-50, 0, 930, 480);

        tabAccountPane.addTab("Maintenance Menu", panelMaintenanceMenu);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel10.setText("Date:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, 20));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel11.setText("Runtime:");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 100, 20));

        btnViewDetails.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnViewDetails.setText("View Details");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });
        jPanel4.add(btnViewDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 150, -1));

        tblMovies.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
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

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 670, 200));

        btnRemoveMovie.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnRemoveMovie.setText("Remove Movie");
        btnRemoveMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveMovieActionPerformed(evt);
            }
        });
        jPanel4.add(btnRemoveMovie, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 140, -1));

        btnViewSoldSeats.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnViewSoldSeats.setText("View Sold Seats");
        btnViewSoldSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSoldSeatsActionPerformed(evt);
            }
        });
        jPanel4.add(btnViewSoldSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, 150, -1));

        btnEditDetails.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnEditDetails.setText("Edit Details");
        btnEditDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDetailsActionPerformed(evt);
            }
        });
        jPanel4.add(btnEditDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 140, -1));
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -190, 820, -1));

        jLabel28.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel28.setText("Movie List:");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, -1, -1));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel5.setForeground(new java.awt.Color(153, 153, 153));
        jPanel5.setLayout(null);

        btnAssignMovie.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnAssignMovie.setText("Assign Movie");
        btnAssignMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignMovieActionPerformed(evt);
            }
        });
        jPanel5.add(btnAssignMovie);
        btnAssignMovie.setBounds(710, 90, 130, 20);

        jLabel27.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel27.setText("Movie Details:");
        jPanel5.add(jLabel27);
        jLabel27.setBounds(30, 10, 122, 23);

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel12.setText("Time:");
        jPanel5.add(jLabel12);
        jLabel12.setBounds(400, 50, 32, 20);

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel13.setText("Rating:");
        jPanel5.add(jLabel13);
        jLabel13.setBounds(400, 90, 42, 20);

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel14.setText("Screen:");
        jPanel5.add(jLabel14);
        jLabel14.setBounds(400, 130, 45, 20);
        jPanel5.add(txtScreen);
        txtScreen.setBounds(460, 130, 180, 22);

        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });
        jPanel5.add(txtTitle);
        txtTitle.setBounds(100, 50, 270, 22);
        jPanel5.add(txtTime);
        txtTime.setBounds(460, 50, 180, 22);

        txtRating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRatingActionPerformed(evt);
            }
        });
        jPanel5.add(txtRating);
        txtRating.setBounds(460, 90, 180, 22);
        jPanel5.add(txtDate);
        txtDate.setBounds(100, 90, 150, 22);
        jPanel5.add(txtRuntime);
        txtRuntime.setBounds(100, 130, 150, 22);

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel9.setText("Movie Title:");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(30, 50, 90, 20);

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 910, 180));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI BACKGROUND.png"))); // NOI18N
        jPanel4.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, -70, 1020, -1));

        tabAccountPane.addTab("Movie Menu", jPanel4);

        panelInventory.setLayout(null);

        tblInventory.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
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

        panelInventory.add(jScrollPane3);
        jScrollPane3.setBounds(30, 60, 820, 230);

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel15.setText("Add New Concession Item:");
        panelInventory.add(jLabel15);
        jLabel15.setBounds(20, 310, 260, 23);

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel16.setText("Name:");
        panelInventory.add(jLabel16);
        jLabel16.setBounds(20, 350, 50, 16);

        txtItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemNameActionPerformed(evt);
            }
        });
        panelInventory.add(txtItemName);
        txtItemName.setBounds(90, 350, 168, 22);

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel17.setText("Quantity:");
        panelInventory.add(jLabel17);
        jLabel17.setBounds(20, 390, 60, 20);
        panelInventory.add(txtItemQuantity);
        txtItemQuantity.setBounds(90, 390, 81, 22);

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel18.setText("Price:");
        panelInventory.add(jLabel18);
        jLabel18.setBounds(220, 390, 50, 20);

        txtItemPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemPriceActionPerformed(evt);
            }
        });
        panelInventory.add(txtItemPrice);
        txtItemPrice.setBounds(260, 390, 84, 22);

        btnAddItem.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnAddItem.setText("Add Item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });
        panelInventory.add(btnAddItem);
        btnAddItem.setBounds(130, 430, 129, 22);

        btnOrderMore.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnOrderMore.setText("Order");
        btnOrderMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderMoreActionPerformed(evt);
            }
        });
        panelInventory.add(btnOrderMore);
        btnOrderMore.setBounds(690, 300, 100, 40);

        btnRemoveItem.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnRemoveItem.setText("Remove Item");
        btnRemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveItemActionPerformed(evt);
            }
        });
        panelInventory.add(btnRemoveItem);
        btnRemoveItem.setBounds(520, 310, 144, 22);
        panelInventory.add(jLabel26);
        jLabel26.setBounds(-70, -170, 0, 0);

        jLabel33.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel33.setText("Inventory List:");
        panelInventory.add(jLabel33);
        jLabel33.setBounds(350, 10, 160, 40);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel3.setForeground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );

        panelInventory.add(jPanel3);
        jPanel3.setBounds(10, 300, 350, 160);

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI BACKGROUND.png"))); // NOI18N
        panelInventory.add(jLabel34);
        jLabel34.setBounds(-30, -20, 910, 510);

        tabAccountPane.addTab("Inventory Menu", panelInventory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabAccountPane, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabAccountPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 501, Short.MAX_VALUE)
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

    private void customerListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerListMouseClicked
        // TODO add your handling code here:
        System.out.println("You have clicked on the table of Customers");
        int row = customerList.getSelectedRow();
        
        DefaultTableModel model = (DefaultTableModel)customerList.getModel();
        
        String name = model.getValueAt(row,0).toString();
        System.out.println("To update: " + name);
        Customer theCustomer = customerManager.getCustomerByName(name);
        
        txtName.setText(theCustomer.getCustomerName());
        txtID.setText(String.valueOf(theCustomer.getCustomerID()));
        txtAge.setText(String.valueOf(theCustomer.getCustomerAge()));
        
        
        btnUpdate.setEnabled(true);
        btnAdd.setEnabled(false);
    }//GEN-LAST:event_customerListMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(txtName.getText().isEmpty() || txtID.getText().isEmpty() || txtAge.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Enter all fields");
        }
        else
        {
            String[] row = {txtName.getText(), txtID.getText(), txtAge.getText()};
            DefaultTableModel model = (DefaultTableModel)customerList.getModel();
            model.addRow(row);
            
            JOptionPane.showMessageDialog(this, "Information added");
            
            clearFields();
        }          

    }//GEN-LAST:event_btnAddActionPerformed

    private void txtName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtName2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtName2ActionPerformed

    private void txtID2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtID2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtID2ActionPerformed

    private void txtAge2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAge2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAge2ActionPerformed

    private void txtRatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRatingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRatingActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        int row = customerList.getSelectedRow();
        
        if (row<0)
        {
            JOptionPane.showMessageDialog(this, "You need to select a row");
        }
        else
        {
            DefaultTableModel model = (DefaultTableModel)customerList.getModel();
            model.removeRow(row);
            JOptionPane.showMessageDialog(this, "Row deleted");}
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int row = customerList.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)customerList.getModel();
       
       String name = model.getValueAt(row,0).toString();
       System.out.println("To Update: " + name);
       Customer aCustomer = customerManager.getCustomerByName(name);
       
       aCustomer.setName(txtName.getText());
       aCustomer.setID(Integer.valueOf(txtID.getText()));
       aCustomer.setAge(Byte.valueOf(txtAge.getText()));
       
       System.out.println(customerManager.getAllCustomers());
       
       updateTableInfo(model, row, aCustomer);
       
       JOptionPane.showMessageDialog(this, "Customer was updated.");

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clearFields();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        customerInfo = "customer.csv"; // where to I import this ???? 
        
        DefaultTableModel model = (DefaultTableModel)customerList.getModel();
        
        ArrayList<String> tableData = new ArrayList<>();
        
        // Saves the list of the Customers
        for(Customer aCustomer: customerManager.getAllCustomers())
        {
            String name = aCustomer.getCustomerName();
            Integer ID = aCustomer.getCustomerID(); //might have to be String
            Byte age = aCustomer.getCustomerAge(); //might have to be String
            String row = name +"," + ID + "," + age;
            tableData.add(row);
            System.out.println(row);
        }
        
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(customerInfo)); 
            for (String rowData : tableData){
                writer.println(rowData);
            }
            writer.close();
            
            JOptionPane.showMessageDialog(this, "Data Saved!");  
        } catch(Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            ArrayList<String> tableData = new ArrayList<>();
            System.out.println("Reading the data");
            BufferedReader reader = new BufferedReader(new FileReader(customerInfo));
            
            String line;
            
            while((line = reader.readLine()) != null) {
            tableData.add(line);
            }
        
        reader.close();
        
        DefaultTableModel model = (DefaultTableModel) customerList.getModel();
        for (String rowData : tableData){
            String[] row = rowData.split(",");
            
            //Creates an object for Customer
            Customer aCustomer = new Customer(row[0], Integer.valueOf(row[1]), Byte.valueOf(row[2]));
            
            customerManager.addCustomer(aCustomer); 
            
            model.addRow(row);
        }

        JOptionPane.showMessageDialog(this, "Data Loaded");
        
        } catch (Exception e){
               e.printStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

    private void clearFields()
    {
        txtName.setText("");
        txtAge.setText("");
        txtID.setText("");
    }
    
    private void updateTableInfo(DefaultTableModel theModel, int row, Customer aCustomer)
    {
        DefaultTableModel model = theModel;

        model.setValueAt(aCustomer.getCustomerName(), row, 0);
        model.setValueAt(aCustomer.getCustomerID(), row, 1);
        model.setValueAt(aCustomer.getCustomerAge(), row, 2);
        
    }       
        
     
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnAddStaffMember;
    private javax.swing.JButton btnAssignMovie;
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnChangeStaffRole;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnEditDetails;
    private javax.swing.JButton btnLogNewIssue;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnOrderMore;
    private javax.swing.JButton btnRemoveItem;
    private javax.swing.JButton btnRemoveMovie;
    private javax.swing.JButton btnRemoveStaffMember;
    private javax.swing.JButton btnResolveIssue;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JButton btnViewIssueDetails;
    private javax.swing.JButton btnViewMoreDetails;
    private javax.swing.JButton btnViewResolvedDetails;
    private javax.swing.JButton btnViewSoldSeats;
    private javax.swing.JButton btnViewStaffLog;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable customerList;
    private javax.swing.JPanel jAccountPanel;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jStaffPanel;
    private javax.swing.JLabel lblAge1;
    private javax.swing.JLabel lblID1;
    private javax.swing.JLabel lblManagerName;
    private javax.swing.JLabel lblManagerName1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
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
    private javax.swing.JTextField txtAge2;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtID2;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtItemPrice;
    private javax.swing.JTextField txtItemQuantity;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtName2;
    private javax.swing.JTextField txtRating;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtRuntime;
    private javax.swing.JTextField txtScreen;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}


