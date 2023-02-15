import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;





/**
 * Class to populate date for the farm
 *  @author  Daniil Belousov id 2491827
 *  @version 1.2, 27.11.22
 */
public class PopulateData {
    public static GregorianCalendar Datecheck(String date){
        //System.out.println(date);
        GregorianCalendar datetosend = new GregorianCalendar();
        String[] check = date.split("/");
        try {
            datetosend.set(Integer.parseInt(check[2]),Integer.parseInt(check[1]),Integer.parseInt(check[0]));

        }
        catch(NumberFormatException ex){
            System.out.println("received an exception in the file read");
            datetosend.set(1111,11,11);
        }
        return datetosend;
    }
    public static void main(ArrayList<Animal> AnimalList,ArrayList<Employee> EmployeeList ) throws IOException {
        FarmWorker farmworker = null;
        String[] check;
        int tagNo, empid, exlevel=0, duration, maxAnimal = 0, maxEmployee = 0,escape=0,itteration=0;
        boolean purchased, emergency, degree = false;
        Veterinary vet = null;
        double weight = 0, dosage,amount;
        Cow tosend = null;
        Sheep tosend1 = null;
        String date, gender, details1 = null, details2, materialsused;
        String[] dummy, dummy1;
        Medication medication = null;
        GregorianCalendar datetosend = new GregorianCalendar();
        GregorianCalendar datetosend2 = new GregorianCalendar();
        HealthTreatment healthtreat = null;
        CleaningTreatment cleaningtreat = null;
        String working_file = new String(System.getProperty("user.dir") + "/Data");

        File reading = new File(working_file);
        if(!reading.exists()){
            reading.mkdir();
        }
        //adding animals
        for (int time = 0; time < 2; time++) {
            if (time == 0){
                reading = new File(working_file + "/cow.dat");
            }
            else{
                reading = new File(working_file + "/sheep.dat");
            }
            if (reading.exists()) {
                File[] items = reading.listFiles();
                for (File item : items) {
                    //System.out.println(item.getAbsolutePath());
                    escape=0;
                    //System.out.println("Work with "+item.getAbsolutePath());
                    BufferedReader reader = new BufferedReader(new FileReader(item.getAbsolutePath()));
                    tagNo = (Integer.parseInt(reader.readLine().split(" ", 2)[1]));
                    gender = new String((reader.readLine()).split(" ", 2)[1]);
                    datetosend = Datecheck(((reader.readLine()).split(" ", 2)[1]));
                    purchased = (Boolean.parseBoolean(reader.readLine().split(" ", 2)[1]));
                    if (time == 0)
                        weight = Double.parseDouble(reader.readLine().split(" ", 2)[1]);
                    dummy = (reader.readLine().split(" ", 5));
                    if (time == 0)
                        tosend = new Cow(tagNo, gender, datetosend, purchased, weight);
                    else
                        tosend1 = new Sheep(tagNo, gender, datetosend, purchased);
                    //animal number count
                    if (tagNo > maxAnimal) {
                        maxAnimal = tagNo;
                    }
                    //reading the  treatment
                    if (!(dummy[1].equals("none"))) {
                        // reading health
                        reader.readLine();
                        for (int i = 0; i < Integer.parseInt(dummy[2]); i++) {
                            System.out.println(85);
                            escape=0;
                            healthtreat = new HealthTreatment();
                            datetosend = Datecheck((reader.readLine().split(" ", 2)[1]));
                            healthtreat.setDateOfTreatment(datetosend);
                            details1 = new String((reader.readLine()).substring(9));
                            emergency = Boolean.parseBoolean(reader.readLine().split(" ", 2)[1]);
                            empid = Integer.parseInt(reader.readLine().split(" ", 2)[1]);
                            for (Employee itemm : EmployeeList) {
                                if (itemm != null && itemm.getEmpID() == empid && itemm instanceof Veterinary) {
                                    vet = (Veterinary) itemm;
                                    escape = 1;
                                }
                            }
                            gender = (reader.readLine().split(" ", 2)[1]);
                            datetosend2 = Datecheck((reader.readLine().split(" ", 2)[1]));
                            degree = Boolean.parseBoolean(reader.readLine().split(" ", 2)[1]);
                            if (degree)
                                datetosend = Datecheck((reader.readLine().split(" ", 2)[1]));
                            exlevel = Integer.parseInt(reader.readLine().split(" ", 2)[1]);
                            if(escape!=1)
                                vet = new Veterinary(empid, gender, datetosend2, degree, datetosend, exlevel);
                            healthtreat.setDetails(details1);
                            healthtreat.setEmergency(emergency);
                            healthtreat.setVet(vet);
                            dummy1 = reader.readLine().split(" ", 2);
                            for (int j = 0; j < Integer.parseInt(dummy1[1]); j++) {
                                details2 = new String((reader.readLine()).substring(9));
                                duration = Integer.parseInt(reader.readLine().split(" ", 2)[1]);
                                datetosend = Datecheck((reader.readLine().split(" ", 2)[1]));
                                dosage = Double.parseDouble((reader.readLine().split(" ", 2)[1]));
                                details1 = new String((reader.readLine()).substring(7));
                                medication = new Medication(details2, duration, datetosend, dosage, details1);
                                healthtreat.setMedication(medication);
                            }
                            if (escape!=1 ){
                                EmployeeList.add(vet);
                            }
                        }
                        escape=0;
                        reader.readLine();
                        for (int i = 0; i < Integer.parseInt(dummy[4]); i++) {
                            System.out.println(126);
                            cleaningtreat = new CleaningTreatment();
                            datetosend = Datecheck((reader.readLine().split(" ", 2)[1]));
                            cleaningtreat.setDateOfTreatment(datetosend);
                            System.out.println(item.getAbsolutePath());
                            materialsused = new String((reader.readLine()).substring(16));

                            cleaningtreat.setMaterialsused(materialsused);
                            empid = Integer.parseInt(reader.readLine().split(" ", 2)[1]);
                            for (Employee itemm : EmployeeList) {
                                if (itemm != null && itemm.getEmpID() == empid && itemm instanceof FarmWorker) {
                                    farmworker = (FarmWorker) itemm;
                                    escape = 1;
                                }
                            }

                            gender = (reader.readLine().split(" ", 2)[1]);
                            datetosend2 = Datecheck((reader.readLine().split(" ", 2)[1]));
                            details1 = new String((reader.readLine()).substring(20));
                            exlevel = Integer.parseInt(reader.readLine().split(" ", 2)[1]);
                            if(escape!=1)
                                farmworker = new FarmWorker(empid, gender, datetosend2, details1, exlevel);
                            cleaningtreat.setWorker(farmworker);
                            if (escape!=1){
                                EmployeeList.add(farmworker);
                            }
                        }
                        if (time == 0) {
                            tosend.setTreatment(healthtreat);
                            tosend.setTreatment(cleaningtreat);
                        } else {
                            tosend1.setTreatment(healthtreat);
                            tosend1.setTreatment(cleaningtreat);
                        }
                    }
                    if (time == 0) {
                        itteration = Integer.parseInt((reader.readLine()).split(" ", 2)[1]);
                        for (int r = 0; r < itteration; r++) {
                            datetosend = Datecheck(reader.readLine().split(" ", 2)[1]);
                            amount = Double.parseDouble(reader.readLine().split(" ", 2)[1]);
                            tosend.setMilking(datetosend, amount);
                        }
                    }
                    if (time == 0)
                        AnimalList.add(tosend);
                    else
                        AnimalList.add(tosend1);
                    Animal.numberOfObjects = maxAnimal;
                    reader.close();
                }

            } else {
                System.out.println("Until now you have no cows, a new folder was created");
                reading.mkdir();
            }
        }
        //adding workers
        for (int time1 = 0; time1 < 2; time1++) {
            if (time1 == 0)
                reading = new File(working_file + "/Vet.dat");
            else
                reading = new File(working_file + "/FarmWorker.dat");
            if (reading.exists()) {
                File[] items = reading.listFiles();
                for (File item : items) {
                    escape=0;
                    BufferedReader reader = new BufferedReader(new FileReader(item.getAbsolutePath()));
                    //System.out.println(item.getAbsolutePath());
                    empid = Integer.parseInt(reader.readLine().split(" ", 2)[1]);

                    for (Employee itemm : EmployeeList) {
                        if (itemm != null && itemm.getEmpID() == empid) {
                            escape = 1;
                        }
                    }

                    if (escape==1){
                        reader.close();
                        continue;
                    }
                    if (empid > maxEmployee) {
                        maxEmployee = empid;
                    }
                    gender = (reader.readLine().split(" ", 2)[1]);
                    datetosend2 = Datecheck((reader.readLine().split(" ", 2)[1]));
                    if (time1 == 0) {
                        degree = Boolean.parseBoolean(reader.readLine().split(" ", 2)[1]);
                        if(degree)
                            datetosend = Datecheck((reader.readLine().split(" ", 2)[1]));
                    } else
                        details1 = new String((reader.readLine()).substring(20));
                    exlevel = Integer.parseInt(reader.readLine().split(" ", 2)[1]);
                    if (time1 == 0) {
                        vet = new Veterinary(empid, gender, datetosend2, degree, datetosend, exlevel);
                        EmployeeList.add(vet);
                    } else {
                        farmworker = new FarmWorker(empid, gender, datetosend2, details1, exlevel);
                        EmployeeList.add(farmworker);
                    }
                    Employee.numberOfObjects = maxEmployee;
                    reader.close();
                }


            } else {
                System.out.println("Until now you have no cows, a new folder was created");
                reading.mkdir();
            }

        }
        Employee.numberOfObjects=maxEmployee;
        Animal.numberOfObjects=maxAnimal;
    }
}
