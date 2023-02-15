import Java.Lang.Comparable;
// an abstract class that is used for the all the people working on the farm subclass
import java.util.GregorianCalendar;
/**
 *  General abstract for the employees of the farm
 *  @author  Daniil Belousov id 2491827
 *  @version 1.2, 27.11.22
 */
public abstract class Employee implements Payment, Comparable {
    private int empID;
    private String gender;
    private GregorianCalendar dateOfBirth;
    static int numberOfObjects=0;
    /**
     * Basic constructor if we know nothing about the vet
     */
    public Employee(){
        empID = numberOfObjects+1;
        this.gender = new String("Not stated");
        this.dateOfBirth = new GregorianCalendar(1111,11,11);
        numberOfObjects++;
    }
    /**
     * Returns an ID of the specific vet
     * @return the ID
     */
    public int getEmpID() {
        return empID;
    }

    /**
     * Sets the ID for existing specific vet
     * @param empID ID
     */
    public void setEmppID(int empID) {
        this.empID = empID;
    }

    /**
     * Returns gender of the specific vet
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender for existing specific vet
     * @param gender gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    /**
     * Returns date of birth of the specific vet
     * @return the date the vet was born
     */
    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }


    /**
     * Sets the date of birth for existing specific vet
     * @param dateOfBirth date the vet was born
     */
    public void setDateOfBirth(GregorianCalendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Method compares two employees based on their salary
     * @param second second employee
     */
    public void compareTo(Employee second){
        if(this.getGrossSalary()>second.getGrossSalary())
            System.out.println("The employee "+this.getEmpID()+" salary is greater then the salary of "+second.getEmpID());
        else
            System.out.println("The employee "+second.getEmpID()+" salary is greater then the salary of "+this.getEmpID());
    }

}
