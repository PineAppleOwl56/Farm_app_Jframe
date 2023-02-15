import java.util.GregorianCalendar;
/**
 * Medication that the Health Treatment requires
 *  @author  Daniil Belousov id 2491827
 *  @version 1.2, 27.11.22
 */
public class Medication {
    private String details;
    private int duration;
    private GregorianCalendar startdate;
    private double Dosage;
    private String notes;

    /**
     * Basic constructor to create the medication not knowing any parameters
     */
    public Medication(){
        this.details = new String("None");
        this.duration = 0;
        this.startdate = new GregorianCalendar(1111,11,11);
        Dosage = 0.0;
        this.notes = new String("None");
    }

    /**
     * Constructor that is used to create the new medication knowing all the parameters of the medication
     * @param details stores specific details of the medication
     * @param duration depicts the number of days the medication should be taken
     * @param startdate the date the medication should start
     * @param dosage the dose of the specified medication
     * @param notes any other information related to the medication
     */
    public Medication(String details, int duration, GregorianCalendar startdate, double dosage, String notes) {
        this.details = new String(details);
        this.duration = duration;
        this.startdate = startdate;
        Dosage = dosage;
        this.notes = notes;
    }

    /**
     * Retrieves the details of the medication
     * @return the details of the medication
     */
    public String getDetails() {
        return details;
    }
    /**
     * Retrieves the duration in days of the medication
     * @return the duration in days of the medication
     */
    public int getDuration() {
        return duration;
    }
    /**
     * Is needed to retrieve the starting date of the medication
     * @return the start date of the medication
     */
    public GregorianCalendar getStartdate() {
        return startdate;
    }
    /**
     * Needed to retrieve the dosage of the medicain
     * @return the dosage of the medication
     */
    public double getDosage() {
        return Dosage;
    }
    /**
     * Returns the note of the medication
     * @return the notes of the medication
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Adds the details to the medication
     * @param details details to the medication
     */
    public void setDetails(String details) {
        this.details = details;
    }
    /**
     * Sets duration of the medication
     * @param duration duration of the medication
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Sets the star date of the medication
     * @param startdate star date of the medication
     */
    public void setStartdate(GregorianCalendar startdate) {
        this.startdate = startdate;
    }

    /**
     * Sets the dosage of the medication
     * @param dosage the dosage of the medication that should be taken
     */
    public void setDosage(double dosage) {
        Dosage = dosage;
    }

    /**
     * Sets the notes of the medication
     * @param notes notes to be specified
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
