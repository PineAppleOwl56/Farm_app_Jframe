import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
// an abstract class that is the base for animals in the farm
/**
 * An abstract class that for animals in the farm
 *  @author  Daniil Belousov id 2491827
 *  @version 1.2, 27.11.22
 */
public abstract class Animal {
    private int tagNo;
    private String gender;
    private GregorianCalendar dateOfBirth;
    private boolean purchased;
    private ArrayList<Treatment> treatment;
    private HashMap<GregorianCalendar, Double> milking;
    static int numberOfObjects=0;
    private int numofhealthtr=0;
    private int numofcleantr=0;


    public int getNumofhealthtr() {
        return numofhealthtr;
    }

    public int getNumofcleantr() {
        return numofcleantr;
    }

    /**
     * Basic constructor
     */
    Animal(){
        tagNo=numberOfObjects+1;
        gender=new String("Not set");
        dateOfBirth=new GregorianCalendar (1111,11,11);
        purchased=false;
        treatment= new ArrayList<Treatment>();
        milking=new HashMap<GregorianCalendar, Double>();
        numberOfObjects++;
    }

    /**
     * method that needs to be implemented in subclasses
     */
    public abstract String feeding();
    /**
     * Retrieves the tag number given to the specific cow
     * @return cow tag
     */
    public int getTagNo() {
        return tagNo;
    }

    /**
     * Sets the cows identification tag number
     * @param tagNo identification tag number
     */
    public void setTagNo(int tagNo) {
        this.tagNo = tagNo;
    }

    /**
     * Returns gender of the cow
     * @return cow gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the cow
     * @param gender cows gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Returns the dat ethe cow was born
     * @return cows date of birth
     */
    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the birthday of the cow
     * @param dateOfBirth cows birthday
     */
    public void setDateOfBirth(GregorianCalendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Returns information of the cows type: purchased or raised on the farm
     * @return information of the cows type
     */
    public boolean isPurchased() {
        return purchased;
    }

    /**
     * Sets the information of the cows type: purchased or raised on the farm
     * @param purchased information of the cows type
     */
    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    /**
     * Returns the all the treatments a cow has
     * @return treatment
     */
    public ArrayList<Treatment> getTreatment() {
        if(treatment.size()==0)
            return null;
        else
            return treatment;
    }




    /**
     * Returns a specific treatment
     * @param index the treatment number
     * @return treatment
     */
    public Treatment getTreatment(int index) {
        return treatment.get(index);
    }

    /**
     * setting the milking information about an animal
     * @param amount amount obtained from milking
     */
    public void setMilking(Double amount) {
        milking.put(new GregorianCalendar(), amount);
    }
    public void setMilking(GregorianCalendar date,Double amount) {
        milking.put(date, amount);
    }

    public int getMilkingsize() {
        return milking.size();
    }

    public HashMap<GregorianCalendar, Double> getMilking() {
        return milking;
    }

    /**
     * Sets a treatment for the cow
     * @param treatment treatment the cow will have
     */
    public void setTreatment(Treatment treatment) {
        if (treatment instanceof HealthTreatment){
            numofhealthtr++;
            this.treatment.add(0,treatment);}
        else{
            numofcleantr++;
            this.treatment.add(treatment);
        }
    }

    /**
     * returns the number of animals there ever was
     * @return number of animals
     */
    public static int getNumberOfObjects() {
        return numberOfObjects;
    }


    /**
     * Returns the age of the cow based on the current year
     * @return the age of the cow
     */
    public int getAge(){
        return ((new GregorianCalendar()).get(Calendar.YEAR)-this.dateOfBirth.get(Calendar.YEAR));
    }

}
