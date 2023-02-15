import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cow_Treatment_To_Be_Displayed extends JFrame{
    private JPanel Main_Panel;
    private JTextArea textArea1;
    private JTextField Text_animal_id;
    private JLabel Animal_tag;
    private JButton All_Done;

    public Cow_Treatment_To_Be_Displayed(JFrame main){
        setContentPane(Main_Panel);
        setTitle("Displaying the treatment of the animal");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);
        All_Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cow_Treatment_To_Be_Displayed.super.setVisible(false);
                main.setVisible(true);
            }
        });
        Text_animal_id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tagNo=Integer.parseInt(Text_animal_id.getText().toString());
                textArea1.setText("");
                GregorianCalendar date=null;
                Cow cow=null;
                int flag =0;
                ArrayList<Treatment> treat;
                HealthTreatment first=null;
                for (int i = 0; i < FarmMe.AnimalList.size(); i++) {
                    if (FarmMe.AnimalList.get(i).getTagNo() == tagNo && (FarmMe.AnimalList.get(i) instanceof Cow)) {
                        cow = (Cow) FarmMe.AnimalList.get(i);
                        flag = 1;
                        break;
                    }

                }
                if (flag == 0)
                    textArea1.append("No such cow in the list");
                else if (flag == 1 && cow.getTreatment() == null) {
                    textArea1.append("No treatment for this cow is specified");
                } else {
                    treat = cow.getTreatment();
                    for (int l = 0; l < cow.getTreatment().size(); l++) {
                        //need to do this big comparison because time the instance in the database will never equal to the time we request to display, as they are not created simultaneously
                            if (treat.get(l) instanceof HealthTreatment) {
                                flag=3;
                                first = (HealthTreatment) treat.get(l);
                                textArea1.append((l + 1) + ") Treatment\n");
                                textArea1.append("Date of treatment is: " + cow.getTreatment().get(l).getDateOfTreatment().get(Calendar.DATE) + "/" + cow.getTreatment().get(l).getDateOfTreatment().get(Calendar.MONTH) + "/" + cow.getTreatment().get(l).getDateOfTreatment().get(Calendar.YEAR)+"\n");
                                textArea1.append("Details of treatment are: " + first.getDetails()+"\n");
                                textArea1.append("Emergency status: "+ first.isEmergency()+"\n");
                                textArea1.append("Vet who gave the treatment: " + first.getVet().getEmpID()+"\n");
                                if (first.getMedication().size() != 0) {
                                    textArea1.append("Medication details are as follows:"+"\n");
                                    for (int h = 0; h < first.getMedication().size(); h++) {
                                        textArea1.append((l + 1) + "." + (h + 1) + ") "+"\n");
                                        textArea1.append("Details: " + first.getMedication().get(h).getDetails()+"\n");
                                        textArea1.append("Duration: " + first.getMedication().get(h).getDuration()+"\n");
                                        textArea1.append("Start Date: " + first.getMedication().get(h).getStartdate().get(Calendar.DATE) + "/" + first.getMedication().get(h).getStartdate().get(Calendar.MONTH) + "/" + first.getMedication().get(h).getStartdate().get(Calendar.YEAR)+"\n");
                                        textArea1.append("Dosage: " + first.getMedication().get(h).getDosage()+"\n");
                                        textArea1.append("Notes: " + first.getMedication().get(h).getNotes()+"\n");
                                    }
                                }
                            } else if (treat.get(l) instanceof CleaningTreatment) {
                                CleaningTreatment second = (CleaningTreatment) treat.get(l);
                                textArea1.append((l + 1) + ") Cleaning Treatment\n");
                                textArea1.append("Date of treatment is: " + second.getDateOfTreatment().get(Calendar.DATE) + "/" + second.getDateOfTreatment().get(Calendar.MONTH) + "/" + second.getDateOfTreatment().get(Calendar.YEAR)+"\n");
                                textArea1.append("Materials used are: " + second.getMaterialsused()+"\n");
                                textArea1.append("Given by this farm worker: " + second.getWorker().getEmpID()+"\n");

                            }

                    }
                }

            }
        });
    }
}
