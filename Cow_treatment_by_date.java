import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cow_treatment_by_date extends  JFrame {
    private JPanel main_panel;
    private JTextField Tagno;
    private JTextField text_date;
    private JLabel Animal_tag;
    private JLabel Date_of_the_treatment;
    private JTextArea display_treatment;
    private JButton All_Done;
    int tagNo;
    String date;

    public Cow_treatment_by_date(JFrame main){
        setContentPane(main_panel);
        setTitle("Displaying the treatment of the animal");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);
        All_Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cow_treatment_by_date.super.setVisible(false);
                main.setVisible(true);
            }
        });

        Tagno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tagNo=Integer.parseInt(Tagno.getText().toString());
            }
        });

        text_date.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display_treatment.setText("");
                GregorianCalendar date=null;
                Cow cow=null;
                int flag =0;
                ArrayList<Treatment> treat;
                HealthTreatment first=null;
                System.out.println(text_date.getText().toString());
                date= FarmMe.checkingDate(1,text_date.getText().toString());
                for (int i = 0; i < FarmMe.AnimalList.size(); i++) {
                    if (FarmMe.AnimalList.get(i).getTagNo() == tagNo && (FarmMe.AnimalList.get(i) instanceof Cow)) {
                        cow = (Cow) FarmMe.AnimalList.get(i);
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0)
                    display_treatment.append("No such cow in the list");
                else if (flag == 1 && cow.getTreatment() == null) {
                    display_treatment.append("No treatment for this date and this cow is specified");
                } else {
                        treat = cow.getTreatment();
                        for (int l = 0; l < cow.getTreatment().size(); l++) {
                            //need to do this big comparison because time the instance in the database will never equal to the time we request to display, as they are not created simultaneously
                            if (cow.getTreatment().get(l).getDateOfTreatment().get(Calendar.DATE) == date.get(Calendar.DATE) && cow.getTreatment().get(l).getDateOfTreatment().get(Calendar.MONTH) == date.get(Calendar.MONTH) && cow.getTreatment().get(l).getDateOfTreatment().get(Calendar.YEAR) == date.get(Calendar.YEAR)) {

                                if (treat.get(l) instanceof HealthTreatment) {
                                    flag=3;
                                    first = (HealthTreatment) treat.get(l);
                                    display_treatment.append((l + 1) + ") Treatment\n");
                                    display_treatment.append("Date of treatment is: " + cow.getTreatment().get(l).getDateOfTreatment().get(Calendar.DATE) + "/" + cow.getTreatment().get(l).getDateOfTreatment().get(Calendar.MONTH) + "/" + cow.getTreatment().get(l).getDateOfTreatment().get(Calendar.YEAR)+"\n");
                                    display_treatment.append("Details of treatment are: " + first.getDetails()+"\n");
                                    display_treatment.append("Emergency status: "+ first.isEmergency()+"\n");
                                    display_treatment.append("Vet who gave the treatment: " + first.getVet().getEmpID()+"\n");
                                    if (first.getMedication().size() != 0) {
                                        display_treatment.append("Medication details are as follows:"+"\n");
                                        for (int h = 0; h < first.getMedication().size(); h++) {
                                            display_treatment.append((l + 1) + "." + (h + 1) + ") "+"\n");
                                            display_treatment.append("Details: " + first.getMedication().get(h).getDetails()+"\n");
                                            display_treatment.append("Duration: " + first.getMedication().get(h).getDuration()+"\n");
                                            display_treatment.append("Start Date: " + first.getMedication().get(h).getStartdate().get(Calendar.DATE) + "/" + first.getMedication().get(h).getStartdate().get(Calendar.MONTH) + "/" + first.getMedication().get(h).getStartdate().get(Calendar.YEAR)+"\n");
                                            display_treatment.append("Dosage: " + first.getMedication().get(h).getDosage()+"\n");
                                            display_treatment.append("Notes: " + first.getMedication().get(h).getNotes()+"\n");
                                        }
                                    }
                                } else if (treat.get(l) instanceof CleaningTreatment) {
                                    CleaningTreatment second = (CleaningTreatment) treat.get(l);
                                    display_treatment.append((l + 1) + ") Cleaning Treatment\n");
                                    display_treatment.append("Date of treatment is: " + second.getDateOfTreatment().get(Calendar.DATE) + "/" + second.getDateOfTreatment().get(Calendar.MONTH) + "/" + second.getDateOfTreatment().get(Calendar.YEAR)+"\n");
                                    display_treatment.append("Materials used are: " + second.getMaterialsused()+"\n");
                                    display_treatment.append("Given by this farm worker: " + second.getWorker().getEmpID()+"\n");

                                }
                            }
                        }
                        if(flag!=3)
                            display_treatment.append("No such treatment for this cow\n");
                    }

            }
        });
    }
}
