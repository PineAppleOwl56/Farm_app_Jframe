import java.util.GregorianCalendar;
/**
 *  Subclass of treatment
 *  @author  Daniil Belousov id 2491827
 *  @version 1.2, 27.11.22
 */
public class CleaningTreatment extends Treatment{
    private String materialsused;
    private FarmWorker Worker;

    /**
     * Basic constructor
     */
    CleaningTreatment() {
        this.materialsused = new String("None");
    }

    /**
     * constractor that sets all the values straight away
     * @param materialsused what to use to clean
     * @param dateOfTreatment when the treatment starts
     * @param worker who assighned the treetment
     */
    public CleaningTreatment(String materialsused, GregorianCalendar dateOfTreatment, FarmWorker worker){
        this.materialsused=new String(materialsused);
        setDateOfTreatment(dateOfTreatment);
        this.Worker= new FarmWorker(worker.getEmpID(), worker.getGender(), worker.getDateOfBirth(), worker.getPreviousFarmName(),worker.getWorkexperience());
    }

    /**
     * Returns the materials for the specific treatment
     * @return materials to use
     */
    public String getMaterialsused() {
        return materialsused;
    }

    /**
     * sets the materials to use
     * @param materialsused materials to use
     */
    public void setMaterialsused(String materialsused) {
        this.materialsused = materialsused;
    }

    /**
     * returns the worker who assigned the treatment
     * @return worker who gave the treatment
     */
    public FarmWorker getWorker() {
        return Worker;
    }

    /**
     * sets the worker who gave the treatment
     * @param worker worker who set the treatment
     */
    public void setWorker(FarmWorker worker) {
        Worker = worker;
    }
}
