import java.util.GregorianCalendar;
/**
 * Farm worker  class extends the Employee abstract class
 *  @author  Daniil Belousov id 2491827
 *  @version 1.2, 27.11.22
 */
public class FarmWorker extends Employee {
    private String previousFarmName;
    int workexperience;

    /**
     * Basic constructor
     */
    FarmWorker(){
        previousFarmName = new String("None");
        workexperience=0;
    }

    /**
     * constractor that sets all the values of the worker
     * @param gender gender
     * @param dateOfBirth date of birth
     * @param previousFarmName farm the worker previously woked on
     * @param workexperience experiance of the worker in years
     */
    FarmWorker(String gender, GregorianCalendar dateOfBirth, String previousFarmName,int workexperience){

        this.previousFarmName = new String(previousFarmName);
        this.workexperience=workexperience;
        setGender(gender);
        setDateOfBirth(dateOfBirth);

    }

    /**
     * A constructor that is used if we want to copy the information of the worker but not affect the employee count
     * @param ID Id of the worker
     * @param gender gender
     * @param dateOfBirth date of birth
     * @param previousFarmName farm the worker previously worked on
     * @param workexperience experiance of worker in years
     */
    public FarmWorker(int ID, String gender, GregorianCalendar dateOfBirth, String previousFarmName,int workexperience) {

        this.previousFarmName = new String(previousFarmName);
        this.workexperience=workexperience;
        setEmppID(ID);
        setGender(gender);
        super.numberOfObjects--;
        setDateOfBirth(dateOfBirth);
    }

    /**
     * Returns the previous farm where the employee worked
     * @return previous farm name
     */
    public String getPreviousFarmName() {
        return previousFarmName;
    }

    /**
     * Sets the previous farm where the employee worked
     * @param previousFarmName previous farm name
     */
    public void setPreviousFarmName(String previousFarmName) {
        this.previousFarmName = previousFarmName;
    }

    /**
     * Returns the work experiance of the farm worker
     * @return experience in years
     */
    public int getWorkexperience() {
        return workexperience;
    }

    /**
     * Sets the work experiance of the farm worker
     * @param workexperience experience in years
     */
    public void setWorkexperience(int workexperience) {
        this.workexperience = workexperience;
    }

    /**
     * Returns the salery of the worker based on his parameters
     * @return salary
     */
    public double getGrossSalary(){
        return grossSalary+grossSalary*workexperience*0.2;
    }
    public void compareTo() {

    }
}
