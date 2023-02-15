import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Vet extends JFrame{
    private JPanel Add_Vet_To_Data;
    private JLabel Vet_Gender;
    private JComboBox Combo_Box_Vet_Gender;
    private JLabel Vet_Degree_Status;
    private JComboBox Combo_Box_Vet_Degree;
    private JTextField Text_Vet_Graduation_Date;
    private JLabel Graduation_Date;
    private JTextField Text_Vet_Experience;
    private JLabel Vet_Experience;
    private JLabel Vets_DOB;
    private JTextField Vets_Date_Of_Birth;
    private JButton All_Done;
    private JButton Save;
    private JLabel Errorms;


    private boolean BScDegree;
    private String dateOfGraduation="0";
    private int expertiseLevel=-1;
    private String gender;
    private String dateOfBirth;



    public Add_Vet(JFrame main, FarmMe farm){
        setContentPane(Add_Vet_To_Data);
        setLocationRelativeTo(null);
        setTitle("Adding Vet");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Combo_Box_Vet_Gender.addItem(new String("Gender"));
        Combo_Box_Vet_Gender.addItem(new String("Female"));
        Combo_Box_Vet_Gender.addItem(new String("Male"));
        Combo_Box_Vet_Degree.addItem(new String("Degree"));
        Combo_Box_Vet_Degree.addItem(new String("True"));
        Combo_Box_Vet_Degree.addItem(new String("False"));
        setVisible(false);
        All_Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_Vet.super.setVisible(false);
                main.setVisible(true);
            }
        });

        Combo_Box_Vet_Gender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gender= Combo_Box_Vet_Gender.getSelectedItem().toString();
            }
        });
        Vets_Date_Of_Birth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dateOfBirth= Vets_Date_Of_Birth.getText().toString();
            }
        });

        Combo_Box_Vet_Degree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BScDegree= Boolean.parseBoolean(Combo_Box_Vet_Degree.getSelectedItem().toString());
            }
        });
        Text_Vet_Graduation_Date.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dateOfGraduation=Text_Vet_Graduation_Date.getText().toString();
            }
        });

        Text_Vet_Experience.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expertiseLevel=Integer.parseInt(Text_Vet_Experience.getText().toString());
            }
        });
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(BScDegree!=true && BScDegree!=false)
                    Errorms.setText("degree type wrong");
                else if(expertiseLevel<0)
                    Errorms.setText("Experience level  wrong");
                else if(!(gender.equals("Male")||gender.equals("Female")))
                    Errorms.setText("Incorrect gender");
                else if(dateOfBirth==null || dateOfBirth.length()!=10 || dateOfBirth.charAt(2)!='/'||dateOfBirth.charAt(5)!='/' )
                    Errorms.setText("Incorrect date of birth");
                else{
                    farm.addVet(gender,BScDegree,expertiseLevel,dateOfGraduation,dateOfBirth);
                    Errorms.setText("Vet created");}
            }
        });
    }

}
