import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cleaning_Treatment extends JFrame{
    private JPanel Cleaning_Treatment_Main_Panel;
    private JLabel Farm_Worker_Id;
    private JLabel Animal_Tag;
    private JTextField Text_Vet_Id;
    private JTextField Text_Animal_Id;
    private JLabel Treatment_Date;
    private JTextField Text_Treatment_Date;
    private JLabel Materials_Used;
    private JTextField Text_Materials_Used;
    private JButton All_Done;
    private JButton Add;
    private JLabel Errorms;
    int ID;
    int tag;
    String date;
    String Materials_used;

    public Cleaning_Treatment(JFrame main_frame){
        setContentPane(Cleaning_Treatment_Main_Panel);
        setTitle("Adding Cleaning Treatment Of The Animal");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);
        All_Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cleaning_Treatment.super.setVisible(false);
                main_frame.setVisible(true);
            }
        });
        Text_Vet_Id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ID=Integer.parseInt(Text_Vet_Id.getText().toString());
            }
        });
        Text_Animal_Id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tag=Integer.parseInt(Text_Animal_Id.getText().toString());
            }
        });
        Text_Treatment_Date.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date=Text_Treatment_Date.getText().toString();
            }
        });
        Text_Materials_Used.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Materials_used=Text_Materials_Used.getText().toString();
            }
        });

        Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag=0;
                Animal animal=null;
                FarmWorker farm=null;
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
                    if (FarmMe.EmployeeList.get(i).getEmpID() == ID && FarmMe.EmployeeList.get(i) instanceof FarmWorker){
                        flag = 2;
                        farm= (FarmWorker) FarmMe.EmployeeList.get(i);
                    }
                }
                if(flag!=2)
                    Errorms.setText("No farm worker with this tag");
                else
                    Errorms.setText("");

                if(flag==0){
                    if(date==null || date.length()!=10 || date.charAt(2)!='/'||date.charAt(5)!='/' ){
                        Errorms.setText("Incorrect date");
                        flag=0;
                    }
                }
                if(Materials_used==null){
                    Errorms.setText("No materials specified");
                    flag=0;
                }
                if(flag!=0 && animal!=null){
                    Errorms.setText("Treatment added");
                    animal.setTreatment(new CleaningTreatment(Materials_used,FarmMe.checkingDate(1,date),farm));
                }

            }
        });
    }

}
