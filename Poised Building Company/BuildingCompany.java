import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class BuildingCompany {
    public static void main(String args[]) {
        //initialize scanner
        Scanner userInput = new Scanner(System.in);
        userInput.useDelimiter("\n");
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");
        String[] CapturedProjects = new String[8];
        String[] CapturedPersonnel = new String[6];
        String[] CustomerDetails = new String[5];
        MathContext BD = new MathContext(2);

        // use a while loop for menu selection for program
        while (true) {
            System.out.println("1-Create a new project");
            System.out.println("2-Change due date of an existing project");
            System.out.println("3-Pay into an existing project");
            System.out.println("4-Add a contractor or update a contractors details");
            System.out.println("5-Finalise Project & Generate invoice");
            System.out.println("0-Exit");
            System.out.println("Please Select 1 of the above options:");
            int option = userInput.nextInt();

            if (option == 1) {
                // Get Customer details and store in variables
                System.out.println("Below enter customer details");

                System.out.println("\nPlease enter customers First name:");
                String customerFirstName = input.nextLine();
                System.out.println("\nEnter customer Last name:");
                String customerLastName = input.nextLine();
                System.out.println("\nEnter customers telephone number:");
                String customerTelephoneNumber = input.nextLine();
                System.out.println("\nEnter customers email address:");
                String customerEmail = input.nextLine();
                System.out.println("\nEnter customers physical address:");
                String customerAddress = input.nextLine();

                //Store Customer details in an array for later use

                CustomerDetails[0] = customerFirstName;
                CustomerDetails[1] = customerLastName;
                CustomerDetails[2] = customerTelephoneNumber;
                CustomerDetails[3] = customerEmail;
                CustomerDetails[4] = customerAddress;

                //Get Project Details and store in variables
                System.out.println("Below enter project details:");

                System.out.println("\nEnter project number:");
                String projectNumber = input.nextLine();
                System.out.println("\nEnter a project name:");
                String projectName = input.nextLine();
                System.out.println("\nEnter type of building:");
                String buildingType = input.nextLine();
                System.out.println("\nPlease enter the physical address of building:");
                String address = input.nextLine();
                System.out.println("\nEnter building ERF number:");
                String ERF = input.nextLine();
                System.out.println("\nEnter deadline for project:");
                String projectDeadline = input.nextLine();
                System.out.println("\nEnter the project Fee:");
                BigDecimal projectFee = input.nextBigDecimal();
                System.out.println("\nEnter how much money has been paid to date:");
                BigDecimal amountPaid = input.nextBigDecimal();
                BigDecimal totalDue = projectFee.subtract(amountPaid);



                //initialize new project
                BuildingProject createProject = new BuildingProject(projectNumber, projectName, buildingType,
                        address, ERF, projectFee, amountPaid, totalDue, projectDeadline);

                //print and finalize new project
                System.out.println("Name:" + CustomerDetails[0]);
                System.out.println("Surname:" + CustomerDetails[1]);
                System.out.println("Telephone number:" + CustomerDetails[2]);
                System.out.println("Email:" + CustomerDetails[3]);
                System.out.println("Physical address:" + CustomerDetails[4]);
                System.out.println(createProject);

                // store the new project captured into an array
                CapturedProjects[0] = projectNumber;
                CapturedProjects[1] = projectName;
                CapturedProjects[2] = ERF;
                CapturedProjects[3] = buildingType;
                CapturedProjects[4] = address;
                CapturedProjects[5] = String.valueOf(projectFee);
                CapturedProjects[6] = String.valueOf(amountPaid);
                CapturedProjects[7] = projectDeadline;

                System.out.println("\nProject Successfully Created & Finalised\n.");

            }
            else if (option == 2) {
                //below I get user input to check project number
                System.out.println("\nEnter Project number:");
                String CheckProjectNumber = input.next();

                // below I use a while loop with conditionals  to check that the project number exist
                //if project number does not exist it loops until user inputs a valid input
                while(!CheckProjectNumber.equals(CapturedProjects[0])) {
                    System.out.println("\nProject number entered does not exist try again:");
                    CheckProjectNumber = input.next();
                }

                    // if input is in the array it allows user to change deadline of project
                    if (CheckProjectNumber.equals(CapturedProjects[0])) {
                        System.out.println("Enter new due date for Project:");
                        String projectDeadline = input.nextLine();
                        CapturedProjects[7] = projectDeadline;
                        System.out.println("New due date successfully added.");


                    }

            }
             else if (option == 3) {
                 //below I get user input to check that the project number is in the array
                System.out.println("\nEnter Project number:");
                String CheckProjectNumber = input.next();
                // below I use a while loop with conditionals  to check that the project number exist
                //if project number does not exist it loops until user inputs a valid input
                while(!CheckProjectNumber.equals(CapturedProjects[0])) {
                    System.out.println("\nProject number entered does not exist try again:");
                    CheckProjectNumber = input.next();
                }

                    //if user input is valid it allows user to enter a payment to the account
                    // I use string value of as the initial amount was stored as a string
                    if (CheckProjectNumber.equals(CapturedProjects[0])) {
                        System.out.println("Enter the total you are paying into the account:");
                        float payment = input.nextFloat();
                        CapturedProjects[6] = String.valueOf(Float.sum(Float.parseFloat((CapturedProjects[6])), payment));
                        System.out.println("New payment successfully made.");
                        System.out.println("So far you've paid R" + CapturedProjects[6]);

                    }

             }

            else if (option == 4) {
                    //below I create a submenu option to give user the option to add contractor
                    // or update contact details of existing contractor

                    System.out.println("a-add new contractor \nu-update contractors details:");
                    String PersonnelInput = input.next();
                    //i then use conditionals for user input
                    if ((PersonnelInput).equals("a")){

                        //if user selects create new user  the following input questions will be given
                        System.out.println("\nEnter type of building personnel eg. contractor, architect,:");
                        String typeOfPersonnel = input.next();
                        System.out.println("\nEnter First name:");
                        String firstname = input.nextLine();
                        System.out.println("\nEnter last name:");
                        String lastname = input.nextLine();
                        System.out.println("\nEnter Telephone number:");
                        String telephoneNumber = input.nextLine();
                        System.out.println("\nEnter Email address:");
                        String email = input.nextLine();
                        System.out.println("\nEnter physical address:");
                        String address = input.nextLine().replace(", ", "; ");

                        //with the above details a new user is initialized
                        BuildingPersonnel newPersonnel = new BuildingPersonnel(typeOfPersonnel,
                                firstname, lastname, telephoneNumber, email, address);

                        System.out.println(newPersonnel);
                        //i then also store details in an array below
                        CapturedPersonnel[0] = typeOfPersonnel;
                        CapturedPersonnel[1] = firstname;
                        CapturedPersonnel[2] = lastname;
                        CapturedPersonnel[3] = telephoneNumber;
                        CapturedPersonnel[4] = email;
                        CapturedPersonnel[5] = address;

                        System.out.println("New contractor successfully created.");


                    } else if (PersonnelInput.equals("u")){
                        //to update existing contractors details
                        //I get contractor name from user
                        System.out.println("Enter contractor name to change details:");
                        String checkName = input.next();

                        //I then use while to make sure user exists
                        //if user does not exist it loops till valid input is entered

                        while(!checkName.equals(CapturedPersonnel[1])) {
                            System.out.println("Name does not exist.");
                            System.out.println("Enter contractor name to change details:");
                            checkName = input.next();
                        }
                            //If name exists it allows user to enter and update contractors details
                            if (checkName.equals(CapturedPersonnel[1])) {

                                System.out.println("\nEnter Telephone number:");
                                String telephoneNumber = input.next();
                                System.out.println("\nEnter Email address:");
                                String email = input.nextLine();
                                System.out.println("\nEnter physical address:");
                                String address = input.nextLine();
                                //i then store updated details in the array
                                CapturedPersonnel[3] = telephoneNumber;
                                CapturedPersonnel[4] = email;
                                CapturedPersonnel[5] = address;

                                System.out.println("Contractor details successfully added.");

                            }

                        }
                    }


                

            else if (option == 0) {
                System.out.println("Program end, Thank You.");
                userInput.close();
                input.close();


                }
            }


        }
    }

