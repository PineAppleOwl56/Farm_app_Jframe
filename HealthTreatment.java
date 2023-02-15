import java.util.ArrayList;
import java.util.GregorianCalendar;
/**
 * Class that extends the Treatment abstract class
 *  @author  Daniil Belousov id 2491827
 *  @version 1.2, 27.11.22
 */
public class HealthTreatment extends Treatment{
    private String details;
    private Veterinary vet;
    private ArrayList<Medication> medication;
    boolean emergency;

    public HealthTreatment(){
        details= new String("No details specified");
        vet =null;
        emergency=false;
        medication= new ArrayList<Medication>();
    }
    /**
     * Constructor for the case when we know all the parameters of the object
     * @param dateOfTreatment date the treatment was given
     * @param details details of the treatment
     * @param vet the vet that provided the treatment
     */
    public HealthTreatment(boolean emergency, GregorianCalendar dateOfTreatment, String details, Veterinary vet){
        this.emergency=emergency;
        setDateOfTreatment(dateOfTreatment);
        this.details = details;
        this.vet= new Veterinary(vet.getEmpID(),vet.getGender(),vet.getDateOfBirth(),vet.isBScDegree(),vet.getDateOfGraduation(),vet.getExpertiseLevel());
        medication= new ArrayList<Medication>();
    }
    /**
     * This function returns a specific medication based on the index of this medication
     * @param index the number of medication in the list
     * @return the specific medication of specific treatment
     */
    public Medication getMedication(int index) {
        return medication.get(index);
    }

    /**
     * Retrieves the list of all the medications
     * @return the list of medications
     */
    public ArrayList<Medication> getMedication() {
        return medication;
    }
    /**
     * Adds a new medication to the treatment
     * @param medication medication for the treatment
     */
    public void setMedication(Medication medication) {
        this.medication.add(medication);
    }

    /**
     * Returns the vet that gave the medication
     * @return vet object
     */
    public Employee getVet() {
        return vet;
    }

    /**
     * Setts the vet that gave the medication to the corresponding existing treatment
     * @param vet vet object that gave the treatment
     */
    public void setVet(Veterinary vet) {
        this.vet= new Veterinary(vet.getEmpID(),vet.getGender(),vet.getDateOfBirth(),vet.isBScDegree(),vet.getDateOfGraduation(),vet.getExpertiseLevel());
    }

    /**
     * Retrieves details  of the existing treatment
     * @return treatment details
     */
    public String getDetails() {
        return details;
    }

    /**
     * Returns the emergency status
     * @return emergency status
     */
    public boolean isEmergency() {
        return emergency;
    }

    /**
     * Sets the emergency status
     * @param emergency status of the emergencyy
     */
    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    /**
     * Sets details of the existing treatment
     * @param details details of the treatment
     */
    public void setDetails(String details) {
        this.details = details;
    }
}
