
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Represents a log in screen GUI for the movie management system
 * @author Taryn Davis
 */
public class Login_Application extends javax.swing.JFrame {        
//        private StaffManager staffManager = new StaffManager();
//        private ScheduleManager scheduleManager = new ScheduleManager();
        private AppController controller = AppController.getInstance();      

    /**
     * Creates new form Login_Application
     */
    public Login_Application() {
        initComponents();
        controller.getScheduleManager().setShowtimes(ShowtimeFileHandler.loadShowtimes());
        controller.getStaffManager().setAllStaff(StaffFileHandler.loadStaff());
        controller.setCustomerManager(new CustomerManager());
        
        CustomerManager cm = new CustomerManager();

        CustomerFileHandler handler = new CustomerFileHandler("customer.csv");
        List<Customer> customers = handler.loadCustomers();
        for (Customer c : customers) {
            cm.addCustomer(c);
}
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtuser = new javax.swing.JTextField();
        blogin = new javax.swing.JButton();
        bexit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jpassword = new javax.swing.JPasswordField();
        jcshow_password = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sign In:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setText("Username");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));
        getContentPane().add(jtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 211, -1));

        blogin.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        blogin.setText("Login");
        blogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        blogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        blogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloginActionPerformed(evt);
            }
        });
        getContentPane().add(blogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, 93, 30));
        blogin.getAccessibleContext().setAccessibleDescription("");

        bexit.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        bexit.setText("Exit");
        bexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bexitActionPerformed(evt);
            }
        });
        getContentPane().add(bexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 55, 20));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Please enter your log-in details below");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        jpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 211, -1));

        jcshow_password.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jcshow_password.setText("Show Password");
        jcshow_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcshow_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(jcshow_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screenshot 2025-05-04 222101.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void bloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloginActionPerformed
        // TODO add your handling code here:        
        String inputUser = jtuser.getText();
        String inputPass = new String(jpassword.getPassword());       

        
        if (jtuser.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill out username");
        }
        else if(jpassword.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill out password");
        }
        else {
            boolean loggedIn = false;           
            
                     
            for (Staff s : controller.getStaffManager().getAllStaff()) {                
    
                if (s.getCredential().getUsername().trim().equals(inputUser.trim()) &&
                    s.getCredential().getPasswordHash().trim().equals(inputPass.trim())) {
                    JOptionPane.showMessageDialog(null, "Logged in as: " + s.getName());

                    if (s instanceof Manager) {
                        Manager_Menu menu = new Manager_Menu((Manager) s, controller.getStaffManager(), controller.getScheduleManager(), controller.getCustomerManager());
                        menu.setVisible(true);
                        this.dispose();
                    }
                    else if (s instanceof Cashier) {
                        Cashier_Menu cashierMenu = new Cashier_Menu((Cashier) s, controller.getInventory(), controller.getScheduleManager());
                        cashierMenu.setVisible(true);
                        this.dispose();
                    }
                    else if (s instanceof Engineer) {
                        Engineer_Menu engineerMenu = new Engineer_Menu((Engineer) s, controller.getMaintenance());
                        engineerMenu.setVisible(true);
                        this.dispose();
                    }
                    // Additional GUI menus can be added for Cashier or Engineer
                    loggedIn = true;
                    break;
                }
            }

            // If no match was found
            if (!loggedIn) {
                JOptionPane.showMessageDialog(null, "Wrong username or password!", "Message", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bloginActionPerformed

    private void jpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpasswordActionPerformed

    private void jcshow_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcshow_passwordActionPerformed
        if (jcshow_password.isSelected()) {
            jpassword.setEchoChar((char)0);
        }
        else {
            jpassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jcshow_passwordActionPerformed

    private void bexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexitActionPerformed
        if (!controller.getScheduleManager().getShowtimes().isEmpty()) {
        ShowtimeFileHandler.saveShowtimes(controller.getScheduleManager().getShowtimes());
    } else {
        System.out.println("Skipped saving showtimes — list was empty!");
    }

    if (!controller.getStaffManager().getAllStaff().isEmpty()) {
        StaffFileHandler.saveStaff(controller.getStaffManager().getAllStaff());
    } else {
        System.out.println("Skipped saving staff — list was empty!");
    }
    
    if (controller.getCustomerManager() != null && !controller.getCustomerManager().getAllCustomers().isEmpty()) {
        CustomerFileHandler handler = new CustomerFileHandler("customer.csv");
        handler.saveCustomers(controller.getCustomerManager().getAllCustomers());
    } else {
        System.out.println("Skipped saving staff — list was empty!");

    System.exit(0);
    }
    }//GEN-LAST:event_bexitActionPerformed

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bexit;
    private javax.swing.JButton blogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JCheckBox jcshow_password;
    private javax.swing.JPasswordField jpassword;
    private javax.swing.JTextField jtuser;
    // End of variables declaration//GEN-END:variables
}
