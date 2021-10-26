import java.math.BigDecimal;

public class BuildingProject {
    //Attributes
    String projectNumber;
    String ERF;
    BigDecimal projectFee;
    BigDecimal amountPaid;
    BigDecimal totalDue;
    String projectName;
    String buildingType;
    String address;
    String projectDeadline;

    // Methods
    //I then use the "this" function to store captured details into the various attributes
    public BuildingProject(String projectNumber, String projectName, String buildingType, String address,
                           String ERF, BigDecimal projectFee, BigDecimal amountPaid,BigDecimal totalDue,
                           String projectDeadline){

        this.projectNumber = projectNumber;
        this.projectName = projectName;
        this.buildingType = buildingType;
        this.address = address;
        this.ERF = ERF;
        this.projectFee = projectFee;
        this.amountPaid = amountPaid;
        this.totalDue = totalDue;
        this.projectDeadline = projectDeadline;

    }
    // method using the get function to return attribute values later
    public String getProjectName() {

        return projectName;
    }

    public String getProjectNumber() {

        return projectNumber;
    }

    public String getBuildingType() {

        return buildingType;
    }

    public String getAddress() {

        return address;
    }

    public String getERF(){

        return ERF;
    }

    public BigDecimal getProjectFee(){

        return projectFee;
    }

    public BigDecimal getAmountPaid(){

        return amountPaid;
    }

    public String getProjectDeadline() {

        return projectDeadline;
    }
    // tostring method to display details in a easy to read format
    public String toString() {
        String output = "Project number: " + projectNumber;
        output += "\nproject name: " + projectName;
        output += "\nBuilding type: " + buildingType;
        output += "\nAddress: " + address;
        output += "\nERF number: " + ERF;
        output += "\nProject Fee: R" + projectFee;
        output += "\nTotal Paid: R" + amountPaid;
        output += "\nTotal due: R" + projectFee.subtract(amountPaid);
        output += "\nProject deadline: " + projectDeadline;

        return output;
    }



}




