import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.*;
public class StoreData {
    public static void main(ArrayList<Animal> AnimalList, ArrayList<Employee> EmployeeList ) throws IOException {
        File wheretowrite=null;
        int flag=0,id=0;
        Veterinary vet=null;
        FarmWorker farm=null;
        Sheep sheep=null;
        Medication medication =null;
        Cow cow = null;
        HealthTreatment treatment =null;
        CleaningTreatment ctreatment =null;
        String position = new String(System.getProperty("user.dir") + "/Data");
        String destination=null;
        BufferedWriter writer= null;
        for(int i=0;i<EmployeeList.size();i++){
            if(EmployeeList.get(i) instanceof Veterinary) {
                vet = (Veterinary) EmployeeList.get(i);
                id = vet.getEmpID();
                wheretowrite= new File(position+"/Vet.dat"+"/"+id+".txt");
                writer = new BufferedWriter(new FileWriter(wheretowrite));
                writer.write("VetID: "+vet.getEmpID()+"\n");
                writer.write("Gender: "+vet.getGender()+"\n");
                writer.write("Date: "+vet.getDateOfBirth().get(Calendar.DATE) + "/" + vet.getDateOfBirth().get(Calendar.MONTH) + "/" + vet.getDateOfBirth().get(Calendar.YEAR)+"\n");
                writer.write("Degree: "+vet.isBScDegree()+"\n");
                if(vet.isBScDegree())
                    writer.write("Date: "+vet.getDateOfGraduation().get(Calendar.DATE) + "/" + vet.getDateOfGraduation().get(Calendar.MONTH) + "/" + vet.getDateOfGraduation().get(Calendar.YEAR)+"\n");
                writer.write("Exlevel: "+vet.getExpertiseLevel()+"\n");
            }
            else {
                farm = (FarmWorker)EmployeeList.get(i);
                id = farm.getEmpID();
                wheretowrite= new File(position+"/FarmWorker.dat"+"/"+id+".txt");
                writer = new BufferedWriter(new FileWriter(wheretowrite));
                writer.write("FarmerID: "+farm.getEmpID()+"\n");
                writer.write("Gender: "+farm.getGender()+"\n");
                writer.write("Date: "+farm.getDateOfBirth().get(Calendar.DATE) + "/" + vet.getDateOfBirth().get(Calendar.MONTH) + "/" + vet.getDateOfBirth().get(Calendar.YEAR)+"\n");
                writer.write("Previous Farm Name: "+farm.getPreviousFarmName()+"\n");
                writer.write("Exlevel: "+farm.getWorkexperience()+"\n");
            }
            writer.close();

        }
        for(int k=0;k<AnimalList.size();k++){
            System.out.println(AnimalList.get(k).getTagNo());
            if(AnimalList.get(k) instanceof Cow) {
                cow = (Cow) AnimalList.get(k);
                id = cow.getTagNo();
                wheretowrite= new File(position+"/Cow.dat"+"/"+id+".txt");
                writer = new BufferedWriter(new FileWriter(wheretowrite));
                writer.write("tagNo: "+cow.getTagNo()+"\n");
                writer.write("Gender: "+cow.getGender()+"\n");
                writer.write("dateOfBirth: "+cow.getDateOfBirth().get(Calendar.DATE) + "/" + cow.getDateOfBirth().get(Calendar.MONTH) + "/" + cow.getDateOfBirth().get(Calendar.YEAR)+"\n");
                writer.write("Purchased: "+cow.isPurchased()+"\n");
                writer.write("Weight: "+cow.getWeight()+"\n");
                if(cow.getTreatment()!=null && cow.getTreatment().size()>0) {
                    writer.write("Treatment: health: " + cow.getNumofhealthtr() + " cleaning: " + cow.getNumofcleantr() + "\n");
                    if(cow.getNumofhealthtr()>0)
                        writer.write("HEALTH:\n");
                    for(int l=0; l<cow.getNumofhealthtr();l++){
                        treatment= (HealthTreatment) cow.getTreatment(l);
                        writer.write("Date: "+treatment.getDateOfTreatment().get(Calendar.DATE) + "/" +treatment.getDateOfTreatment().get(Calendar.MONTH) + "/" + treatment.getDateOfTreatment().get(Calendar.YEAR)+"\n");
                        writer.write("Details: "+treatment.getDetails()+"\n");
                        writer.write("Emergency: "+treatment.isEmergency()+"\n");
                        vet = (Veterinary) treatment.getVet();
                        writer.write("VetID: "+vet.getEmpID()+"\n");
                        writer.write("Gender: "+vet.getGender()+"\n");
                        writer.write("Date: "+vet.getDateOfBirth().get(Calendar.DATE) + "/" + vet.getDateOfBirth().get(Calendar.MONTH) + "/" + vet.getDateOfBirth().get(Calendar.YEAR)+"\n");
                        writer.write("Degree: "+vet.isBScDegree()+"\n");
                        if(vet.isBScDegree())
                            writer.write("Date: "+vet.getDateOfGraduation().get(Calendar.DATE) + "/" + vet.getDateOfGraduation().get(Calendar.MONTH) + "/" + vet.getDateOfGraduation().get(Calendar.YEAR)+"\n");
                        writer.write("Exlevel: "+vet.getExpertiseLevel()+"\n");
                        for (int g=0; g<treatment.getMedication().size();g++){
                            medication = treatment.getMedication(g);
                            writer.write("Medication: "+g+1+"\n");
                            writer.write("Details: "+medication.getDetails()+"\n");
                            writer.write("Duration: "+medication.getDuration()+"\n");
                            writer.write("Start: "+medication.getStartdate().get(Calendar.DATE) + "/" + medication.getStartdate().get(Calendar.MONTH) + "/" + medication.getStartdate().get(Calendar.YEAR)+"\n");
                            writer.write("Dosage: "+medication.getDosage()+"\n");
                            writer.write("Notes: "+medication.getNotes()+"\n");
                        }
                    }
                    if(cow.getNumofcleantr()>0)
                        writer.write("CLEANING:\n");
                    for(int o=cow.getTreatment().size()-cow.getNumofcleantr();o<cow.getTreatment().size();o++){
                        ctreatment = (CleaningTreatment) cow.getTreatment(o);
                        writer.write("Date: "+ctreatment.getDateOfTreatment().get(Calendar.DATE) + "/" +ctreatment.getDateOfTreatment().get(Calendar.MONTH) + "/" + ctreatment.getDateOfTreatment().get(Calendar.YEAR)+"\n");
                        writer.write("Materials used: "+ctreatment.getMaterialsused()+"\n");
                        id = farm.getEmpID();
                        writer.write("FarmerID: "+farm.getEmpID()+"\n");
                        writer.write("Gender: "+farm.getGender()+"\n");
                        writer.write("Date: "+farm.getDateOfBirth().get(Calendar.DATE) + "/" + vet.getDateOfBirth().get(Calendar.MONTH) + "/" + vet.getDateOfBirth().get(Calendar.YEAR)+"\n");
                        writer.write("Previous Farm Name: "+farm.getPreviousFarmName()+"\n");
                        writer.write("Exlevel: "+farm.getWorkexperience()+"\n");
                    }
                }
                else
                    writer.write("Treatment: none\n");
                writer.write("milking: "+cow.getMilkingsize()+"\n");
                for(GregorianCalendar key : cow.getMilking().keySet()) {
                    writer.write("Date: " + key.get(Calendar.DATE) + "/" + key.get(Calendar.MONTH) + "/" + key.get(Calendar.YEAR) + "\n");
                    writer.write("Amount: "+cow.getMilking().get(key)+"\n");
                }
                writer.close();
            }
            else {
                sheep = (Sheep) AnimalList.get(k);
                id = sheep.getTagNo();
                wheretowrite= new File(position+"/Sheep.dat"+"/"+id+".txt");
                writer = new BufferedWriter(new FileWriter(wheretowrite));
                writer.write("tagNo: "+sheep.getTagNo()+"\n");
                writer.write("Gender: "+sheep.getGender()+"\n");
                writer.write("dateOfBirth: "+sheep.getDateOfBirth().get(Calendar.DATE) + "/" + sheep.getDateOfBirth().get(Calendar.MONTH) + "/" + sheep.getDateOfBirth().get(Calendar.YEAR)+"\n");
                writer.write("Purchased: "+sheep.isPurchased()+"\n");
                if(sheep.getTreatment()!=null && sheep.getTreatment().size()>0) {
                    writer.write("Treatment: health: " + sheep.getNumofhealthtr() + " cleaning: " + sheep.getNumofcleantr() + "\n");
                    if(sheep.getNumofhealthtr()>0)
                        writer.write("HEALTH:\n");
                    for(int l=0; l<sheep.getNumofhealthtr();l++){
                        treatment= (HealthTreatment) sheep.getTreatment(l);
                        writer.write("Date: "+treatment.getDateOfTreatment().get(Calendar.DATE) + "/" +treatment.getDateOfTreatment().get(Calendar.MONTH) + "/" + treatment.getDateOfTreatment().get(Calendar.YEAR)+"\n");
                        writer.write("Details: "+treatment.getDetails()+"\n");
                        writer.write("Emergency: "+treatment.isEmergency()+"\n");
                        vet = (Veterinary) treatment.getVet();
                        writer.write("VetID: "+vet.getEmpID()+"\n");
                        writer.write("Gender: "+vet.getGender()+"\n");
                        writer.write("Date: "+vet.getDateOfBirth().get(Calendar.DATE) + "/" + vet.getDateOfBirth().get(Calendar.MONTH) + "/" + vet.getDateOfBirth().get(Calendar.YEAR)+"\n");
                        writer.write("Degree: "+vet.isBScDegree()+"\n");
                        if(vet.isBScDegree())
                            writer.write("Date: "+vet.getDateOfGraduation().get(Calendar.DATE) + "/" + vet.getDateOfGraduation().get(Calendar.MONTH) + "/" + vet.getDateOfGraduation().get(Calendar.YEAR)+"\n");
                        writer.write("Exlevel: "+vet.getExpertiseLevel()+"\n");
                        for (int g=0; g<treatment.getMedication().size();g++){
                            medication = treatment.getMedication(g);
                            writer.write("Medication: "+g+1+"\n");
                            writer.write("Details: "+medication.getDetails()+"\n");
                            writer.write("Duration: "+medication.getDuration()+"\n");
                            writer.write("Start: "+medication.getStartdate().get(Calendar.DATE) + "/" + medication.getStartdate().get(Calendar.MONTH) + "/" + medication.getStartdate().get(Calendar.YEAR)+"\n");
                            writer.write("Dosage: "+medication.getDosage()+"\n");
                            writer.write("Notes: "+medication.getNotes()+"\n");
                        }
                    }
                    if(sheep.getNumofcleantr()>0)
                        writer.write("CLEANING:\n");
                    for(int o=sheep.getNumofcleantr();o<sheep.getTreatment().size();o++){
                        ctreatment = (CleaningTreatment) sheep.getTreatment(o);
                        writer.write("Date: "+ctreatment.getDateOfTreatment().get(Calendar.DATE) + "/" +ctreatment.getDateOfTreatment().get(Calendar.MONTH) + "/" + ctreatment.getDateOfTreatment().get(Calendar.YEAR)+"\n");
                        writer.write("Materials used: "+ctreatment.getMaterialsused()+"\n");
                        writer.write("FarmerID: "+farm.getEmpID()+"\n");
                        writer.write("Gender: "+farm.getGender()+"\n");
                        writer.write("Date: "+farm.getDateOfBirth().get(Calendar.DATE) + "/" + farm.getDateOfBirth().get(Calendar.MONTH) + "/" + farm.getDateOfBirth().get(Calendar.YEAR)+"\n");
                        writer.write("Previous Farm Name: "+farm.getPreviousFarmName()+"\n");
                        writer.write("Exlevel: "+farm.getWorkexperience()+"\n");
                    }
                }
                else
                    writer.write("Treatment: none\n");
                writer.close();
            }
        }
    }
}
