import java.util.GregorianCalendar;
/**
 * This class implements the sheep of the specific animal
 *  @author  Daniil Belousov id 2491827
 *  @version 1.2, 27.11.22
 */
public class Sheep extends Animal{
    /**
     * Basic constructor if we know nothing about the cow
     */
    /*Cow(){
        tagNo=numberOfObjects+1;
        gender=new String("Not set");
        dateOfBirth=new GregorianCalendar (1111,11,11);
        purchased=false;
        treatment= new ArrayList<Treatment>();
        numberOfObjects++;
    }*/
    /**
     * Constructor if we know everything about the cow
     * @param gender gender of the cow
     * @param dateOfBirth date the cow was born
     * @param purchased information of the cows type: purchased or raised on the farm
     */
    Sheep(String gender, GregorianCalendar dateOfBirth, boolean purchased){
        setGender(gender);
        setDateOfBirth(dateOfBirth);
        setPurchased(purchased);
    }
    Sheep(int tagNO, String gender, GregorianCalendar dateOfBirth, boolean purchased){
        setTagNo(tagNO);
        setGender(gender);
        setDateOfBirth(dateOfBirth);
        setPurchased(purchased);
    }
    /**
     * Displays the information about the feeding methods for a sheep
     */
    public String feeding(){
        String gender = getGender();
        int age = getAge();
        if (gender.equals("Male")&& age<=5){
            return "Feeding: only grass";
        }
        else if (gender.equals("Female")&& age<=8){
            return "Feeding: only grass";
        }
        else if (gender.equals("Male")&& age>5){
            return "Feeding: Total mixed ration";
        }
        else{
            return "Feeding: Total mixed ration";
        }
    }


}
