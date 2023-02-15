import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Medication_Gui extends JFrame{
    private JLabel Details;
    private JLabel Duration;
    private JLabel Start_Date;
    private JLabel Dosage;
    private JLabel Notes;
    private JTextField Text_Details;
    private JTextField Text_Duration;
    private JTextField Text_Start_date;
    private JTextField Text_dosage;
    private JTextField Text_Notes;
    private JPanel Main_panel;
    private JButton All_Done;
    private JLabel Errorms;
    String details;
    int duration;
    String date;
    double dosage;
    String notes;
    Medication medication=null;

    public Medication_Gui(JFrame main){
        setContentPane(Main_panel);
        setTitle("Adding Medication for the Treatment Of The Animal");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);
        All_Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag=0;
                if(flag==0&&(date==null || date.length()!=10 || date.charAt(2)!='/'||date.charAt(5)!='/' )){
                    Errorms.setText("Incorrect date");
                    flag=1;}

                else if(details==null){
                    Errorms.setText("No details specified");
                    flag=1;
                }
                else if(notes==null){
                    Errorms.setText("No notes specified");
                    flag=1;
                }
                else if(!(duration>0)){
                    Errorms.setText("No duration specified");
                    flag=1;
                }
                else if(!(dosage>0)){
                    Errorms.setText("No dosage specified");
                    flag=1;
                }
                else {
                    medication = new Medication(details,duration,FarmMe.checkingDate(1,date),dosage,notes);
                    Medication_Gui.super.setVisible(false);
                    main.setVisible(true);
                }
            }}
        );
        Text_Start_date.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date=Text_Start_date.getText().toString();
            }
        });
        Text_Details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                details=Text_Details.getText().toString();
            }
        });
        Text_Notes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notes=Text_Notes.getText().toString();
            }
        });
        Text_Duration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                duration=Integer.parseInt(Text_Duration.getText().toString());
            }
        });
        Text_dosage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dosage=Double.parseDouble(Text_dosage.getText().toString());
            }
        });

    }
    public Medication getmedcreate(){
        return medication;
    }

}
