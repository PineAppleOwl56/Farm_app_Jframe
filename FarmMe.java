
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * This class represents the whole farm where you can perform the given operation with it
 * @author  Daniil Belousov id 2491827
 * @version 1.2, 27.11.22
 */
public class FarmMe {
    Scanner input = new Scanner(System.in);
    public static ArrayList<Animal> AnimalList = new ArrayList<Animal>();
    public static ArrayList<Employee> EmployeeList= new ArrayList<Employee>();
    public static FarmApplicationMenu menu = new FarmApplicationMenu();

    public ArrayList<Animal> returnAnimalList(){
        return AnimalList;
    }




    public void Populate() throws IOException {
        PopulateData.main(AnimalList,EmployeeList);
    }
    public void StoreData() throws IOException {
        StoreData.main(AnimalList,EmployeeList);
    }
    public static void main(String[] args) throws IOException {


        System.exit(2);
        Scanner input = new Scanner(System.in);
        int choice, option1, option2, flag1 = 0, tag,flag2=0,dummy;
        double amount = 0.0;
        String choose;
        char cose;
        FarmMe test = new FarmMe();
/*
        do {
            test.menu();
            try {
                System.out.print("Enter your choice: ");
                choice = input.nextInt();
                System.out.println();
            } catch (Exception InputMismatchException) {
                choose = input.next();
                choice = -1;
            }
            System.out.println();
            flag1 = 0;
            flag2=0;
            switch (choice) {
                case 1:
                    test.addCow();
                    break;
                case 2:
                    try {
                        System.out.print("Please enter the tag no of the cow to be deleted: ");
                        option1 = input.nextInt();
                    } catch (Exception InputMismatchException) {
                        option1 = -1;
                    }
                    test.deleteCow(option1);
                    break;
                case 3:
                    System.out.print("Please enter the tag no of the cow to be listed: ");
                    option1 = input.nextInt();
                    test.getCowDetails(option1);
                    break;
                case 4:
                    test.addVet();
                    break;
                case 5:
                    System.out.print("Please enter the Id no for the vet to be deleted: ");
                    option2 = input.nextInt();
                    test.deleteVet(option2);
                    break;
                case 6:
                    System.out.print("Please enter the Id no for the vet to be displayed: ");
                    try {
                        option2 = input.nextInt();
                    } catch (Exception InputMismatchException) {
                        option2 = -1;
                    }
                    test.getVetDetails(option2);
                    break;
                case 7:
                    try {
                        do {
                            System.out.print("Please enter the tag no of the cow: ");
                            option1 = input.nextInt();
                            if(option1<=0){
                                System.out.println("Incorrect input");
                            }

                        }while(option1<=0);
                        do {
                            System.out.print("Please enter the Id no for the employee: ");
                            option2 = input.nextInt();
                            if (option2 > test.EmployeeList.size() + 1) {
                                System.out.print("Sorry, this employee id does not exist in the employee list\nDo you want to add a new employee?(Yes/No): ");
                                choose = input.next();
                                if (choose.charAt(0)=='Y') {
                                    System.out.println("The new employee will be assigned this ID: " + (Employee.numberOfObjects + 1));
                                    do{
                                        System.out.println("Enter who you want to add, Farm worker or Veterinary ");
                                        cose=input.next().charAt(0);
                                        if(cose!='F'&&cose!='V')
                                            System.out.println("Incorrect input");
                                        else if(cose=='V'){
                                            test.EmployeeList.add(new Veterinary());
                                        }
                                        else if (cose =='F')
                                            test.EmployeeList.add(new FarmWorker());
                                        option2=(Employee.numberOfObjects + 1);
                                    }while(flag2==1);
                                    flag1 = 1;
                                } else if (!choose.equals("No")) {
                                    System.out.println("Incorrect input, please try again");
                                }
                            } else
                                flag1 = 1;
                        } while (flag1 == 0);
                    } catch (Exception InputMismatchException) {
                        option1 = -1;
                        option2 = -1;
                    }
                    test.addTreatment(option2, option1);
                    break;
                case 8:
                    System.out.print("Please enter the tag no of the cow which treatment to be displayed: ");
                    try {
                        option1 = input.nextInt();
                    } catch (Exception InputMismatchException) {
                        option1 = -1;
                    }
                    test.getCowTreatment(option1);
                    break;
                case 9:
                    System.out.print("Please enter the tag no of the cow: ");
                    try {
                        option1 = input.nextInt();
                    } catch (Exception InputMismatchException) {
                        option1 = -1;
                    }
                    GregorianCalendar date = test.checkingDate(2);
                    test.getCowTreatment(option1, date);
                    break;
                case 10:
                    test.listCows();
                    break;
                case 11:
                    test.listSheep();
                    break;
                case 12:
                    test.listVets();
                    break;
                case 13:
                    test.listFarmWorkers();
                    break;
                case 14:
                    do {
                        try {
                            System.out.print("Please specify the animal you want to see the feeding information for: ");
                            tag = input.nextInt();
                        } catch (Exception InputMismatchException) {
                            tag = -1;
                        }
                        if (tag > test.EmployeeList.size())
                            System.out.println("You do not have an animal with this tag number");
                        else if (tag < 0) {
                            System.out.println("Incorrect input\nDo you want to reenter the input?(Yes/no)");
                            do {
                                choice = input.next().charAt(0);
                                if (choice == 'N')
                                    flag1 = 1;
                                else if (choice != 'Y')
                                    System.out.println("Incorrect input, please try again");
                            } while (choice != 'Y' && choice != 'N');
                        } else {
                            test.feedingAnimal(tag);
                            flag1 = 1;
                        }
                    } while (flag1 == 0);
                    break;
                case 15:
                    test.getsalary();
                    break;
                case 16:
                    try {
                        System.out.print("Please enter the tag no of the animal: ");
                        tag = input.nextInt();
                        System.out.println("Please specify the amount of milking: ");
                        amount = input.nextDouble();
                    } catch (Exception InputMismatchException) {
                        tag = -1;
                        amount = -1;
                    }
                    test.addMilkingMeasurement(tag, amount);
                    break;
                case 0:
                    System.out.println("Thank you for using the application\nHave a nice day!");
                    choice = 0;
                    StoreData.main(test);
                    break;
                default:
                    System.out.println("Wrong input, please try again");
                    break;
            }

        } while (choice != 0);
        */

    }
    /*
        /**
         * Basic constructor that initializes the array lists
         *
        FarmMe() {
            FarmApplicationMenu menu = new FarmApplicationMenu();
            AnimalList = new ArrayList<Animal>();
            EmployeeList = new ArrayList<Employee>();
        }
        */
    public static void setvisible(){
        menu.setVisible(true);
    }

    /**
     * Extra function for generating GregorianCalendar date form the string input
     * that works for all dates and displays the needed messages to the user based on the option
     *
     * @param n option selector
     * @return the date
     */
    public static GregorianCalendar checkingDate(int n, String date) {
        int flag = 0;
        String[] check;
        //String date;
        GregorianCalendar datetosend = new GregorianCalendar();
        //date = input.next();
            check = date.split("/");
            try {
                    datetosend.set(Integer.parseInt(check[2]), Integer.parseInt(check[1]), Integer.parseInt(check[0]));
                    flag = 1;
                } catch (Exception InputMismatchException) {
                datetosend.set(1111, 11, 11);                }
        return datetosend;
    }
/*
    /**
     * Adds an existing cow to the array list
     *
     * @param cow cow instance
     */
    public static void addCow(Cow cow) {
        AnimalList.add(cow);
    }

    public static void addSheep(Sheep sheep) {
        AnimalList.add(sheep);
    }

    /**
     * Adds a vet to the array list
     *
     * @param vet vet instance
     */
    public static void addVet(Veterinary vet) {
        EmployeeList.add(vet);
    }

    public  static void addFarmWorker(FarmWorker farmworker) {
        EmployeeList.add(farmworker);
    }

    /**
     * Adds the cow to the array lists but also retrieves all the needed information about the cow form the user
     */
    public static void addCow(String gender, char type,double weight, String date) {
        //String gender;
        //char type;
        boolean typetosend = false;
        //double weight = 0;
        String dummy;
        do {
            System.out.print("Please specify gender, Enter Female or Male: ");
            //gender = input.next();
            if ((gender.charAt(0) != 'F') && (gender.charAt(0) != 'M')) {
                System.out.println("Incorrect input");
            } else if ((gender.charAt(0) == 'F')) gender = "Female";
            else gender = "Male";
        } while ((gender.charAt(0) != 'F') && (gender.charAt(0) != 'M'));
        GregorianCalendar datetosend = checkingDate(1, date);
        do {
            System.out.print("Please specify type, Enter Purchased or Farm-raised: ");
            //type = input.next().charAt(0);
            if (type == 'P') {
                typetosend = true;
            } else if (type != 'F') {
                System.out.println("Incorrect input");
            } else {
                do {
                    try{
                        System.out.print("Please specify weight: ");
                        //weight = input.nextDouble();
                        if (weight <= 0) {
                            System.out.println("Incorrect input");
                        }
                    }
                    catch(Exception InputMismatchException){
                        System.out.println("Sorry, the input you gave is incompatible");
                        weight=0;
                        // dummy=input.next();
                    }
                } while ((weight <= 0));
            }
        } while ((type != 'F') && (type != 'P'));

        Cow newone = new Cow(gender, datetosend, typetosend, weight);

        AnimalList.add(newone);
    }

    /**
     * Deletes the cow with the specific tag form the array and displays an error message if
     * the cow with the specified tag does not exist
     *
     * @param tagNo tag number of the cow
     */
    public static void deleteCow(int tagNo) {
        int flag = 0;
        for (int i = 0; i < AnimalList.size(); i++) {
            if (AnimalList.get(i).getTagNo() == tagNo && (AnimalList.get(i) instanceof Cow)) {
                AnimalList.remove(i);
                flag = 1;
            } else if (AnimalList.get(i).getTagNo() == tagNo && (AnimalList.get(i) instanceof Sheep))
                flag = 2;
        }
        if (flag == 0) {
            System.out.println("No cows with this tag number");
        } else if (flag == 2)
            System.out.println("The tag " + tagNo + "correspond to a sheep\nNo cows with this tag number");
    }

    /**
     * Displays all the main of the cow based on the tag number
     *
     * @param tagNo tag number of the cow
     */
    public void getCowDetails(int tagNo) {
        int flag = 0;
        for (int i = 0; i < AnimalList.size(); i++) {
            if (AnimalList.get(i).getTagNo() == tagNo && (AnimalList.get(i) instanceof Cow)) {
                displayCow((Cow) AnimalList.get(i));
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("No cows with this tag number: " + tagNo);
        }
    }

    /**
     * Adds a vet to the vet list but also retrieves all the information about the vet from the user
     */
    public void addVet(String gender, boolean degree,int level,String date_og_grad,String dob) {
        char deg;


        GregorianCalendar date, dateOfGraduation = null;
        dateOfGraduation = checkingDate(3,date_og_grad);
        date=checkingDate(1,dob);
        /*
        do {
            System.out.print("Please specify gender, Enter Female or Male: ");
            gender = input.next();
            if ((gender.charAt(0) != 'F') && (gender.charAt(0) != 'M')) {
                System.out.println("Incorrect input");
            } else if ((gender.charAt(0) == 'F')) gender = "Female";
            else gender = "Male";
        } while ((gender.charAt(0) != 'F') && (gender.charAt(0) != 'M'));
        do {
            System.out.print("Have the veterinary graduated the university (Y/N): ");
            deg = input.next().charAt(0);
            if ((deg != 'Y') && (deg != 'N')) {
                System.out.println("Incorrect input, please reenter: ");
            } else if ((deg == 'Y')) {

            }
        } while ((deg != 'Y') && (deg != 'N'));
        do {
            try {
                System.out.println("Please specify the level of the veterinary");
                level = input.nextInt();
                if (level < 0)
                    System.out.println("Incorrect input");
                }
                catch(Exception InputMismatchException){
                    System.out.println("Incompatible input");
                    dummy=input.next();
                    level=0;
                }
        } while (level <= 0);
*/
        EmployeeList.add(new Veterinary(gender, date, degree, dateOfGraduation, level));
    }

    /**
     * Deletes the vet with the specific id form the list if such exists
     *
     * @param vetID vets ID
     */
    public void deleteVet(int vetID) {
        int flag = 0;
        for (int i = 0; i < EmployeeList.size(); i++) {
            System.out.println(i);
            System.out.println(EmployeeList.get(i).getGender());
            if (EmployeeList.get(i)!=null && EmployeeList.get(i).getEmpID() == vetID && (EmployeeList.get(i) instanceof Veterinary)) {
                EmployeeList.remove(i);
                flag = 1;
                break;
            } else if (EmployeeList.get(i).getEmpID() == vetID && (EmployeeList.get(i) instanceof FarmWorker))
                flag = 2;
        }
        if (flag == 0) {
            System.out.println("No vets with this Id number: " + vetID);
        } else if (flag == 2)
            System.out.println("You have a Farm worker with this Id number: " + vetID + "\nNo vets with this Id number");
    }

    /**
     * Displays all the details of the vet if such exists
     *
     * @param vetID vet id
     */
    public void getVetDetails(int vetID) {
        int flag = 0;
        for (Employee veterinary : EmployeeList) {
            if (veterinary.getEmpID() == vetID && (veterinary instanceof Veterinary)) {
                displayVet(veterinary);
                flag = 1;
            } else if (veterinary.getEmpID() == vetID && (veterinary instanceof FarmWorker))
                flag = 2;
        }
        if (flag == 0) {
            System.out.println("No cows with this tag number: " + vetID);
        } else if (flag == 2)
            System.out.println("No vets with this Id number, but you have a farm worker with this ID1");

    }

    /**
     * Adds a treatment to the specific cow and with the vet information that provided the treatment
     *
     * @param vetID vet id
     * @param tagNo cows tag
     */
    public void addTreatment(int vetID, int tagNo) {
        int days, treatments, medic, type = -1, check = 0;
        char status='N';
        Animal asd = null;
        Medication med;
        HealthTreatment treat;
        CleaningTreatment treatC;
        GregorianCalendar date1, date2;
        String details, notes;
        Veterinary vet = null;
        FarmWorker farm = null;
        int flag = 0;
        double dosage;
        for (Animal animal : AnimalList) {
            if (animal.getTagNo() == tagNo) {
                asd = animal;
                if (animal instanceof Cow)
                    flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("No cow with this tag no");
            return;
        }
        if (flag == 1)
            System.out.println("How many treatments does the cow have?");
        else
            System.out.println("How many treatments does the sheep have?");
        try{
            treatments = input.nextInt();
        } catch (Exception InputMismatchException) {
            details = input.next();
            System.out.println("Incorrect input");
            return;
        }
        for (Employee veterinary : EmployeeList) {
            if ((veterinary.getEmpID() == vetID) && (veterinary instanceof Veterinary)) {
                vet = (Veterinary) veterinary;
                type = 1;
                check = 1;
            } else if ((veterinary.getEmpID() == vetID) && (veterinary instanceof FarmWorker)) {
                farm = (FarmWorker) veterinary;
                type = 2;
                check = 1;
            }
        }
        for (int i = 0; i < treatments; i++) {
            if (type == 0 && check ==0) {
                System.out.println("Please specify the type of the treatment\nPlease enter 1 for the Health treatment and 2 for the cleaning treatment");
                type = input.nextInt();
            }
            if (type == 1) {
                if (check == 0) {
                    vet = new Veterinary();
                    EmployeeList.add(vet);
                }
                treat = new HealthTreatment();
                treat.setVet(vet);
                //date1 = checkingDate(2);
                //treat.setDateOfTreatment(date1);
                System.out.println("Please specify treatment details");
                details = input.next();
                do {
                    System.out.println("Please specify Emergency status\nPlease enter Yes or No");
                    status=input.next().charAt(0);
                    if(status=='N')
                        treat.setEmergency(false);
                    else if(status=='Y')
                        treat.setEmergency(true);
                    else
                        System.out.println("Incorrect input");
                }while((status!='N')&&(status!='Y'));
                treat.setDetails(details);
                System.out.println("Please specify how many medication this treatment has ");
                medic = input.nextInt();
                for (int k = 0; k < medic; k++) {
                    System.out.println("Please specify medication details");
                    details = input.next();
                    System.out.println("Please specify medication duration in days");
                    days = input.nextInt();
                   // date2 = checkingDate(3);
                    System.out.println("Please specify medication dosage");
                    dosage = input.nextDouble();
                    System.out.println("Please specify medication notes");
                    notes = input.next();
                    //med = new Medication(details, days, date2, dosage, notes);
                    //treat.setMedication(med);
                }
                asd.setTreatment(treat);

            } else if (type == 2) {
                if (check == 0) {
                    farm = new FarmWorker();
                }
                treatC = new CleaningTreatment();
                //date1 = checkingDate(2);
                //treatC.setDateOfTreatment(date1);
                treatC.setWorker(farm);
                System.out.println("Please specify the cleaning materials: ");
                details = input.next();
                treatC.setMaterialsused(details);
                asd.setTreatment(treatC);
            }
        }

    }

    /**
     * Displays all the treatments the cow has
     *
     * @param tagNo cows id
     */
    public void getCowTreatment(int tagNo) {
        ArrayList<Treatment> treat;
        HealthTreatment first = null;
        CleaningTreatment second = null;
        Cow cow = null;
        int flag = 0;
        for (int i = 0; i < AnimalList.size(); i++) {
            if (AnimalList.get(i).getTagNo() == tagNo && (AnimalList.get(i) instanceof Cow)) {
                cow = (Cow) AnimalList.get(i);
                flag = 1;
            }
        }
        if (flag == 1 && cow.getTreatment() == null) {
            System.out.println("This cow has no treatments ");
            flag = 0;
        }
        if (flag == 1) {
            treat = cow.getTreatment();
            for (int k = 0; k < treat.size(); k++) {
                if (treat.get(k) instanceof HealthTreatment) {
                    first = (HealthTreatment) treat.get(k);
                    System.out.print((k + 1) + ") Treatment\n");
                    System.out.println("Date of treatment is: " + cow.getTreatment().get(k).getDateOfTreatment().get(Calendar.DATE) + "/" + cow.getTreatment().get(k).getDateOfTreatment().get(Calendar.MONTH) + "/" + cow.getTreatment().get(k).getDateOfTreatment().get(Calendar.YEAR));
                    System.out.println("Emergency status: "+ first.isEmergency());
                    System.out.println("Details of treatment are: " + first.getDetails());
                    System.out.println("Vet who gave the treatment: " + first.getVet().getEmpID());
                    if (first.getMedication().size() != 0) {
                        System.out.println("Medication details are as follows:");
                        for (int h = 0; h < first.getMedication().size(); h++) {
                            System.out.print((k + 1) + "." + (h + 1) + ") ");
                            System.out.println("Details: " + first.getMedication().get(h).getDetails());
                            System.out.println("Duration: " + first.getMedication().get(h).getDuration());
                            System.out.println("Start Date: " + first.getMedication().get(h).getStartdate().get(Calendar.DATE) + "/" + first.getMedication().get(h).getStartdate().get(Calendar.MONTH) + "/" + first.getMedication().get(h).getStartdate().get(Calendar.YEAR));
                            System.out.println("Dosage: " + first.getMedication().get(h).getDosage());
                            System.out.println("Notes: " + first.getMedication().get(h).getNotes());
                        }
                    }
                } else if (treat.get(k) instanceof CleaningTreatment) {
                    second = (CleaningTreatment) treat.get(k);
                    System.out.print((k + 1) + ") Cleaning Treatment\n");
                    System.out.println("Date of treatment is: " + second.getDateOfTreatment().get(Calendar.DATE) + "/" + second.getDateOfTreatment().get(Calendar.MONTH) + "/" + second.getDateOfTreatment().get(Calendar.YEAR));
                    System.out.println("Materials used are: " + second.getMaterialsused());
                    System.out.println("Given by this farm worker: " + second.getWorker().getEmpID());

                }
            }
        } else {
            System.out.println("No such cow in the list");
        }
    }

    /**
     * Displays the specific treatment the cows has based on the date the treatment was given
     *
     * @param tagNo cows tag
     * @param date1  date of the treatment
     */
    public void getCowTreatment(int tagNo, String date1) {
        GregorianCalendar date = checkingDate(1,date1);
        ArrayList<Treatment> treat;
        Animal cow = null;
        HealthTreatment first = null;
        CleaningTreatment second = null;
        int flag = 0;
        for (int i = 0; i < AnimalList.size(); i++) {
            if (AnimalList.get(i).getTagNo() == tagNo && (AnimalList.get(i) instanceof Cow)) {
                cow = (Cow) AnimalList.get(i);
                flag = 1;
                break;
            }
        }
        if (flag == 0)
            System.out.println("No such cow in the list");
        else if (flag == 1 && cow.getTreatment() == null) {
            System.out.println("No treatment for this date and this cow is specified");
        } else {
            treat = cow.getTreatment();
            for (int l = 0; l < cow.getTreatment().size(); l++) {
                //need to do this big comparison because time the instance in the database will never equal to the time we request to display, as they are not created simultaneously
                if (cow.getTreatment().get(l).getDateOfTreatment().get(Calendar.DATE) == date.get(Calendar.DATE) && cow.getTreatment().get(l).getDateOfTreatment().get(Calendar.MONTH) == date.get(Calendar.MONTH) && cow.getTreatment().get(l).getDateOfTreatment().get(Calendar.YEAR) == date.get(Calendar.YEAR)) {

                    if (treat.get(l) instanceof HealthTreatment) {
                        first = (HealthTreatment) treat.get(l);
                        System.out.print((l + 1) + ") Treatment\n");
                        System.out.println("Date of treatment is: " + cow.getTreatment().get(l).getDateOfTreatment().get(Calendar.DATE) + "/" + cow.getTreatment().get(l).getDateOfTreatment().get(Calendar.MONTH) + "/" + cow.getTreatment().get(l).getDateOfTreatment().get(Calendar.YEAR));
                        System.out.println("Details of treatment are: " + first.getDetails());
                        System.out.println("Emergency status: "+ first.isEmergency());
                        System.out.println("Vet who gave the treatment: " + first.getVet().getEmpID());
                        if (first.getMedication().size() != 0) {
                            System.out.println("Medication details are as follows:");
                            for (int h = 0; h < first.getMedication().size(); h++) {
                                System.out.print((l + 1) + "." + (h + 1) + ") ");
                                System.out.println("Details: " + first.getMedication().get(h).getDetails());
                                System.out.println("Duration: " + first.getMedication().get(h).getDuration());
                                System.out.println("Start Date: " + first.getMedication().get(h).getStartdate().get(Calendar.DATE) + "/" + first.getMedication().get(h).getStartdate().get(Calendar.MONTH) + "/" + first.getMedication().get(h).getStartdate().get(Calendar.YEAR));
                                System.out.println("Dosage: " + first.getMedication().get(h).getDosage());
                                System.out.println("Notes: " + first.getMedication().get(h).getNotes());
                            }
                        }
                    } else if (treat.get(l) instanceof CleaningTreatment) {
                        second = (CleaningTreatment) treat.get(l);
                        System.out.print((l + 1) + ") Cleaning Treatment\n");
                        System.out.println("Date of treatment is: " + second.getDateOfTreatment().get(Calendar.DATE) + "/" + second.getDateOfTreatment().get(Calendar.MONTH) + "/" + second.getDateOfTreatment().get(Calendar.YEAR));
                        System.out.println("Materials used are: " + second.getMaterialsused());
                        System.out.println("Given by this farm worker: " + second.getWorker().getEmpID());

                    }
                }
            }
        }
    }

    /**
     * Displays all the cows the farm has
     */
    public void listCows() {
        if (AnimalList.size() == 0) {
            System.out.println("NO cows in the list.\nPlease add cows first");
        } else {
            for (Animal iteration : AnimalList) {
                if (iteration instanceof Cow)
                    displayCow((Cow) iteration);
            }
        }
    }

    /**
     * Displays all the sheep in the farm
     */
    public void listSheep() {
        if (AnimalList.size() == 0) {
            System.out.println("NO sheep in the list.\nPlease add sheep first");
        } else {
            for (Animal iteration : AnimalList) {
                if (iteration instanceof Sheep)
                    displaySheep((Sheep) iteration);
            }
        }
    }

    /**
     * Displays all the vets the farm has
     */
    public void listVets() {
        if (EmployeeList.size() == 0) {
            System.out.println("NO vets in the list.\nPlease add vets first");
        } else {
            for (Employee iteration : EmployeeList) {
                if (iteration instanceof Veterinary) {
                    System.out.println("Vet ID: " + iteration.getEmpID());
                    System.out.println("Vet gender: " + iteration.getGender());
                    System.out.println("Vet Date of Birth: " + iteration.getDateOfBirth().get(Calendar.DATE) + "/" + iteration.getDateOfBirth().get(Calendar.MONTH) + "/" + iteration.getDateOfBirth().get(Calendar.YEAR));
                    iteration.getGrossSalary();
                    System.out.println("\n");
                }

            }
        }
    }

    /**
     * Displays all the farm workers in the farm
     */
    public void listFarmWorkers() {
        if (EmployeeList.size() == 0) {
            System.out.println("NO workers in the list.\nPlease add workers first");
        } else {
            for (Employee iteration : EmployeeList) {
                if (iteration instanceof FarmWorker) {
                    System.out.println("Farm worker ID: " + iteration.getEmpID());
                    System.out.println("Farm worker gender: " + iteration.getGender());
                    System.out.println("Farm worker Date of Birth: " + iteration.getDateOfBirth().get(Calendar.DATE) + "/" + iteration.getDateOfBirth().get(Calendar.MONTH) + "/" + iteration.getDateOfBirth().get(Calendar.YEAR));
                    System.out.println("Farm worker's previous farm: " + ((FarmWorker) iteration).getPreviousFarmName());
                    System.out.println("Farm worker's experience: " + ((FarmWorker) iteration).getWorkexperience() + " years");
                    iteration.getGrossSalary();
                    System.out.println("\n");
                }

            }
        }
    }

    /**
     * Displays the specific cow
     *
     * @param cow cow instance
     */
    public static void displayCow(Cow cow) {
        System.out.println("Tag Number: " + cow.getTagNo());
        System.out.println("Gender: " + cow.getGender());
        System.out.println("Date of Birth: " + cow.getDateOfBirth().get(Calendar.DATE) + "/" + cow.getDateOfBirth().get(Calendar.MONTH) + "/" + cow.getDateOfBirth().get(Calendar.YEAR));
        if (cow.isPurchased()) {
            System.out.println("The cow is purchased");
        } else {
            System.out.println("The cow is raised by the farm");
            System.out.println("The weight of the cow is: " + cow.getWeight());
        }
        if (cow.getTreatment() == null) {
            System.out.println("The cow has no current treatments\n");
        } else {
            System.out.println("The cow has treatments in the list\n");
        }
    }

    /**
     * displays a specific sheep
     *
     * @param sheep sheep to be displayed
     */
    public void displaySheep(Sheep sheep) {
        System.out.println("Tag Number: " + sheep.getTagNo());
        System.out.println("Gender: " + sheep.getGender());
        System.out.println("Date of Birth: " + sheep.getDateOfBirth().get(Calendar.DATE) + "/" + sheep.getDateOfBirth().get(Calendar.MONTH) + "/" + sheep.getDateOfBirth().get(Calendar.YEAR));
        if (sheep.isPurchased()) {
            System.out.println("The sheep is purchased");
        } else {
            System.out.println("The sheep is farm-raised");
        }
        if (sheep.getTreatment() == null) {
            System.out.println("The sheep has no current treatments\n");
        } else {
            System.out.println("The sheep has treatments in the list\n");
        }
    }

    /**
     * Displays a specific vet
     *
     * @param vet vet instance
     */
    public void displayVet(Employee vet) {
        System.out.println("Id Number: " + vet.getEmpID());
        System.out.println("Gender: " + vet.getGender());
        System.out.println("Date of Birth: " + vet.getDateOfBirth().get(Calendar.DATE) + "/" + vet.getDateOfBirth().get(Calendar.MONTH) + "/" + vet.getDateOfBirth().get(Calendar.YEAR));
        System.out.println("Salary for this vet is: " + vet.getGrossSalary() + "a month");
    }

    /**
     * Displays the menu options for the farm
     */
    public void menu() {
        System.out.println("\n------Menu------");
        System.out.println("1) Add Cow");
        System.out.println("2) Delete Cow");
        System.out.println("3) Get cow details");
        System.out.println("4) Add Vet");
        System.out.println("5) Delete Vet");
        System.out.println("6) Get vet details");
        System.out.println("7) Add Treatment");
        System.out.println("8) Get Cow treatment");
        System.out.println("9) Get Cow treatment by date");
        System.out.println("10) List Cows");
        System.out.println("11) List Sheep");
        System.out.println("12) List Vets");
        System.out.println("13) List Farm workers");
        System.out.println("14) Feeding animal");
        System.out.println("15) Get Employee salary");
        System.out.println("16) Add milking measurement");
        System.out.println("0) Exit");
    }

    /**
     * to add the milking information about the cow
     *
     * @param tagNo  tag of the cow
     * @param amount amount of milk obtained
     */
    static void addMilkingMeasurement(int tagNo, double amount) {
        if (tagNo > AnimalList.size()) {
            System.out.println("No such animal");
            return;
        } else if (tagNo < 0) {
            System.out.println("Incorrect input");
            return;
        }
        for (Animal iteration : AnimalList) {
            if (iteration.getTagNo() == tagNo) {
                iteration.setMilking(amount);
            }
        }
    }

    /**
     * Explains with what to feed a certain animal
     *
     * @param animal animal to see the feeding information for
     */
    void feedingAnimal(int animal) {
        for (Animal iteration : AnimalList) {
            if (iteration.getTagNo() == animal) {
                System.out.println("The feeding method for the animal with this tag " + animal + " is:");
                iteration.feeding();
            }
        }
    }

    /**
     * Shows the salary of a certain worker of the farm
     */
    void getsalary() {
        int option2 = 0, flag1 = 0;
        char choice = 'N';
        String choose;
        try {
            do {
                System.out.print("Please specify the employee: ");
                option2 = input.nextInt();
                ;
                if (option2 > EmployeeList.size()) {
                    System.out.println("You do not have an employee with this Id number");
                    return;
                } else {
                    for (Employee iteration : EmployeeList) {
                        if (iteration.getEmpID() == option2 && (iteration instanceof Veterinary)) {
                            System.out.println("The employee is a Veterinary\nThe salary is: " + iteration.getGrossSalary() + " a month");
                            flag1 = 1;
                        } else if (iteration.getEmpID() == option2 && (iteration instanceof FarmWorker)) {
                            System.out.println("The employee is a Farm worker\nThe salary is: " + iteration.getGrossSalary() + " a month");
                            flag1 = 1;
                        }
                    }
                }
                if (flag1 == 0) {
                    System.out.println("You do not have an employee with this ID\nDo you want to reenter the ID, Please enter Y for yes and N for No:");
                    do {
                        choice = input.next().charAt(0);
                        if (choice == 'N')
                            flag1 = 1;
                        else if (choice != 'Y')
                            System.out.println("Incorrect input, please try again");
                    } while (choice != 'Y' && choice != 'N');
                }
            } while (flag1 == 0);
        } catch (Exception InputMismatchException) {
            choose = input.next();
            System.out.println("Incorrect form of the input");
        }

    }

}


