import java.util.GregorianCalendar;

/**
 * This class represents the veterinaries that work on the farm
 * @author  Daniil Belousov id 2491827
 * @version 1.2, 27.11.22
 */
public class Veterinary extends Employee {
    //the number which represents the cows tag and as well displays the number of instances this class ever had
    // during the running process, this helps to identify the cow and not ever repeat the same tag for two instances
    private boolean BScDegree;
    private GregorianCalendar dateOfGraduation;
    private int expertiseLevel;

    /**
     * Basic constructor
     */
    public Veterinary() {
        BScDegree=false;
        this.dateOfGraduation = new GregorianCalendar(1111,11,11);
        expertiseLevel=0;
    }
    /**
     * The constructor that is used to create a vet instance knowing all the parameters
     *
     * @param gender      gender of the vet
     * @param dateOfBirth date of birth of the vet
     * @param degree      degree of the vet
     * @param dateOfGraduation when the vet graduated
     * @param level expertise level
     */

    public Veterinary(String gender, GregorianCalendar dateOfBirth,boolean degree,GregorianCalendar dateOfGraduation,int level) {
        System.out.println("Vet created");
        BScDegree=degree;
        this.dateOfGraduation = dateOfGraduation;
        expertiseLevel=level;
        setGender(gender);
        setDateOfBirth(dateOfBirth);
    }

    /**
     * A constructor that is used to copy all the vet's information so if the vet will be deleted the treatments that the vet gave will be still recorded on his name
     *
     * @param ID          id of the vet
     * @param gender      gender of the vet
     * @param dateOfBirth date of birth of the vet
     * @param degree      degree of the vet
     * @param dateOfGraduation when the vet graduated
     * @param level expertise level
     */
    public Veterinary(int ID, String gender, GregorianCalendar dateOfBirth,boolean degree,GregorianCalendar dateOfGraduation,int level) {
        BScDegree=degree;
        this.dateOfGraduation = dateOfGraduation;
        expertiseLevel=level;
        setEmppID(ID);
        setGender(gender);
        setDateOfBirth(dateOfBirth);
        super.numberOfObjects--;
    }

    /**
     * Returns the fact if the veterinary has a degree
     * @return degree status
     */
    public boolean isBScDegree() {
        return BScDegree;
    }

    /**
     * sets the status of the degree of the vet
     * @param BScDegree degree status
     */
    public void setBScDegree(boolean BScDegree) {
        this.BScDegree = BScDegree;
    }

    /**
     * Returns the date of the vet university graduation
     * @return date of graduation
     */
    public GregorianCalendar getDateOfGraduation() {
        return dateOfGraduation;
    }

    /**
     * Sets the date of vet graduation from the university
     * @param dateOfGraduation date of graduation
     */
    public void setDateOfGraduation(GregorianCalendar dateOfGraduation) {
        this.dateOfGraduation = dateOfGraduation;
    }

    /**
     * Returns the experience level of the vet in years
     * @return experience in years
     */
    public int getExpertiseLevel() {
        return expertiseLevel;
    }

    /**
     * Sets the experience level of the vet in years
     * @param expertiseLevel experience in years
     */
    public void setExpertiseLevel(int expertiseLevel) {
        this.expertiseLevel = expertiseLevel;
    }

    /**
     * Returns the salary of the vet based on ones parameters
     * @return salary
     */
    public double getGrossSalary(){
        return grossSalary+grossSalary*expertiseLevel*0.10;
    }

    public void compareTo() {

    }
}








