
/**
 *
 * @author Taryn Davis
 */
public class MaintenanceIssue {
    private int id;
    private String description;
    private String reportedBy;
    private String dateReported;
    private String status;
    private String resolveNote;
    
    public MaintenanceIssue(int id, String description, String reportedBy, String dateReported, String status, String resolveNote) { 
        this.id = id;
        this.description = description;
        this.reportedBy = reportedBy;
        this.dateReported = dateReported;
        this.status = status;
        this.resolveNote = "";
    }
    
    public MaintenanceIssue(int id, String description, String reportedBy, String dateReported, String status) {
        this(id, description, reportedBy, dateReported, status, "");
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public void setResolveNote(String resolveNote) {
        this.resolveNote = resolveNote;
    }
    
    public int getID() {
        return id;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getReportedBy() {
        return reportedBy;
    }
    
    public String getDateReported() {
        return dateReported;
    }
    
    public String getStatus() {
        return status;
    }
    
    public String getResolutionNote() {
        return resolveNote;
    }
            
    @Override
    public String toString() {
         return id + "," + description + "," + reportedBy + "," + dateReported + "," + status + "," + (resolveNote != null ? resolveNote : "");
    }
}
