import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Health_Treatment extends JFrame{
    private JLabel Animal_Tag;
    private JTextField Text_Aniaml_Tag;
    private JTextField Text_Vet_Id;
    private JLabel Date_Of_Treatment;
    private JTextField Text_Treatment_Date;
    private JLabel Details_of_treatment;
    private JTextField Text_Treatment_Details;
    private JLabel Emergency_Status;
    private JComboBox Emergency_type;
    private JLabel Medication_amount;
    private JTextField Medication_num;
    private JPanel HealthTreatmen_main_panel;
    private JButton All_Done;
    private JButton Add;
    private JLabel Errorms;
    int tag;
    int ID;
    String date;
    String details;
    boolean status;
    int med;

    public Health_Treatment(Medication_Gui medication,JFrame main){
        setContentPane(HealthTreatmen_main_panel);
        setTitle("Adding Health Treatment Of The Animal");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        Emergency_type.addItem(new String("Type"));
        Emergency_type.addItem(new String("True"));
        Emergency_type.addItem(new String("False"));
        setLocationRelativeTo(null);
        All_Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Health_Treatment.super.setVisible(false);
                main.setVisible(true);
            }
        });

        Text_Aniaml_Tag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tag=Integer.parseInt(Text_Aniaml_Tag.getText().toString());
            }
        });
        Text_Vet_Id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ID=Integer.parseInt(Text_Vet_Id.getText().toString());
            }
        });
        Text_Treatment_Date.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date=Text_Treatment_Date.getText().toString();
            }
        });
        Text_Treatment_Details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                details=Text_Treatment_Details.getText().toString();
            }
        });
        Emergency_type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status=Boolean.parseBoolean(Emergency_type.getSelectedItem().toString());
            }
        });
        Medication_num.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                med=Integer.parseInt(Medication_num.getText().toString());
            }
        });
        Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag=0;
                Animal animal=null;
                Veterinary vet=null;
                for(int i = 0; i<FarmMe.AnimalList.size();i++) {
                    if (FarmMe.AnimalList.get(i).getTagNo() == tag){
                        animal=FarmMe.AnimalList.get(i);
                        flag = 1;}
                }
                if(flag!=1)
                    Errorms.setText("No cow with this tag");
                else
                    Errorms.setText("");

                for(int i = 0; i<FarmMe.EmployeeList.size();i++) {
                    if (FarmMe.EmployeeList.get(i).getEmpID() == ID && FarmMe.EmployeeList.get(i) instanceof Veterinary){
                        flag = 2;
                        vet= (Veterinary) FarmMe.EmployeeList.get(i);
                    }
                }
                if(flag!=2)
                    Errorms.setText("No vet with this tag");
                else
                    Errorms.setText("");

                if(flag==0){
                    if(date==null || date.length()!=10 || date.charAt(2)!='/'||date.charAt(5)!='/' ){
                        Errorms.setText("Incorrect date");
                        flag=0;
                    }
                }
                if(details==null){
                    Errorms.setText("No details specified");
                    flag=0;
                }
                if(status!=true && status!=false){
                    Errorms.setText("No details specified");
                    flag=0;
                }
                if(med==0){
                   animal.setTreatment(new HealthTreatment(status,FarmMe.checkingDate(1,date),details,vet));
                }
                else{
                    HealthTreatment  ht=new HealthTreatment(status,FarmMe.checkingDate(1,date),details,vet);
                    Errorms.setText("Treatment added");
                    for(int i=0; i<med;i++) {
                        medication.setVisible(true);
                        ht.setMedication(medication.getmedcreate());
                    }
                    animal.setTreatment(ht);
                }
            }
        });
    }
}
