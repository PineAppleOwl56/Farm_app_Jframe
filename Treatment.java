import java.util.GregorianCalendar;
import java.util.ArrayList;

/**
 *  This class implements the treatment of the specific cow
 *  @author  Daniil Belousov id 2491827
 *  @version 1.2, 27.11.22
 */
public class Treatment {
    private GregorianCalendar dateOfTreatment;

    /**
     * Basic constructor if we do not know all the parameters
     */
    public Treatment(){
        this.dateOfTreatment = new GregorianCalendar(1111,11,11);

    }
    /**
     * Function retrieves the date when the treatment was given
     * @return returns the date of the treatment
     */
    public GregorianCalendar getDateOfTreatment() {
        return dateOfTreatment;
    }


    /**
     * Sets the date the existing treatment was given
     * @param dateOfTreatment treatment date
     */
    public void setDateOfTreatment(GregorianCalendar dateOfTreatment) {
        this.dateOfTreatment = dateOfTreatment;
    }


}
