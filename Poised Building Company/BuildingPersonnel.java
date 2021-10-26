
public class BuildingPersonnel {
    //Attributes
    String typeOfPersonnel;
    String firstname;
    String lastname;
    String telephoneNumber;
    String email;
    String address;



    // Methods
    public BuildingPersonnel(String typeOfPersonnel, String firstname, String lastname, String telephoneNumber,
                             String email, String address) {

        this.typeOfPersonnel = typeOfPersonnel;

        this.firstname = firstname;

        this.lastname = lastname;

        this.telephoneNumber = telephoneNumber;

        this.email = email;

        this.address = address;
    }


    //Call each attribute using the get function to be used in future

    public String getTypeOfPersonnel() {

        return typeOfPersonnel;
    }

    public String getName() {
        String nameOutput = firstname + ", " + lastname;
        return nameOutput;
    }

    public String getTelephoneNumber() {

        return telephoneNumber;
    }

    public String getEmail(){

        return email;
    }
    public String getAddress(){

        return address;
    }

    // to string method to display details
    public String toString() {
        String output = "Type of work: " + typeOfPersonnel;
        output += "\nName:" + getName();
        output += "\nTelephone Number:" + telephoneNumber;
        output += "\nEmail address:" + email;
        output += "\nAddress:" + address.replace("; ", " \n\t\t");


        return output;
    }

}

