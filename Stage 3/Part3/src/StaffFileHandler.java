import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Taryn
 */
public class StaffFileHandler {    
    private static final String FILE_NAME = "staff.txt";

    public static void saveStaff(List<Staff> staffList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Staff s : staffList) {
                writer.write(String.join(",",
                    s.getRole(),
                    s.getName(),
                    String.valueOf(s.getAge()),
                    String.valueOf(s.getStaffID()),
                    String.valueOf(s.getPersonID()),
                    s.getRole(),
                    s.getCredential().getUsername(),
                    s.getCredential().getPasswordHash()
                ));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Staff> loadStaff() {        
        List<Staff> staffList = new ArrayList<>();     
        
        
        
        
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                
                
                if (parts.length >= 8) {
                    String role = parts[0].trim();
                    String name = parts[1].trim();
                    int age = Integer.parseInt(parts[2].trim());
                    int staffID = Integer.parseInt(parts[3].trim());
                    int personID = Integer.parseInt(parts[4].trim());
                    String roleRepeated = parts[5].trim(); // Could be reused or verified
                    String username = parts[6].trim();
                    String password = parts[7].trim();

                    Credential cred = new Credential(username, password);

                    Staff s = null;
                    switch (role.toLowerCase()) {
                        case "manager":
                            s = new Manager(name, age, staffID, personID, role, cred);
                            break;
                        case "cashier":
                            s = new Cashier(name, age, staffID, personID, role, cred, 0); 
                            break;
                        case "engineer":
                            s = new Engineer(name, age, staffID, personID, role, cred);
                            break;
                    }

                    if (s != null) {
                        staffList.add(s);
                    }
                }
            
        }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return staffList;
        }
    }
