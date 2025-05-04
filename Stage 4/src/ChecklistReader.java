import java.io.*;
import java.util.*;
/**
 *
 * @author Taryn Davis
 */
public class ChecklistReader {    
    
    public static List<String> getChecklistForEngineer(String engineerName, String date) {
        List<String> checklist = new ArrayList<>();
        String fileName = "checklist_" + date + ".txt";
        boolean isTargetEngineer = false;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Engineer:")) {
                    isTargetEngineer = line.contains(engineerName);
                } else if (isTargetEngineer) {
                    if (line.trim().isEmpty() || line.startsWith("Engineer:")) {
                        break;
                    } else {
                        checklist.add(line.trim());
                    }
                }
            } 
        } catch (IOException e) {
            System.out.print("Error reading checklist file:" + e.getMessage());
        }
        return checklist;
    
    }
}
