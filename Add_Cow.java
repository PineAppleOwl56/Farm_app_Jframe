import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Cow extends JFrame{
    private JPanel Adding_Cow_to_Data;
    private JLabel Cow_Gender;
    private JLabel Cow_DOB;
    private JLabel Cow_Weight;
    private JLabel Cow_Type;
    private JComboBox Combo_Box_Cow_Gender;
    private JTextField Text_Field_Cow_DOB;
    private JComboBox Combo_Box_Cow_Type;
    private JTextField Text_Field_Cow_Weight;
    private JButton Save;
    private JButton Add_Data;
    private JLabel Errorms;
    private int flag=0;
    String gender;
    char type;
    double weight;
    String date;


    public Add_Cow(JFrame main, FarmMe farm){
        setLocationRelativeTo(null);
        setContentPane(Adding_Cow_to_Data);
        setTitle("Adding Cow");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        Combo_Box_Cow_Gender.addItem(new String("Gender"));
        Combo_Box_Cow_Gender.addItem(new String("Female"));
        Combo_Box_Cow_Gender.addItem(new String("Male"));
        Combo_Box_Cow_Type.addItem(new String("Type"));
        Combo_Box_Cow_Type.addItem(new String("Purchased"));
        Combo_Box_Cow_Type.addItem(new String("Farm-Raised"));
        Combo_Box_Cow_Gender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gender= Combo_Box_Cow_Gender.getSelectedItem().toString();
            }
        });
        Combo_Box_Cow_Type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type =(Combo_Box_Cow_Type.getSelectedItem().toString()).charAt(0);
                System.out.println(type);
            }
        });
        Text_Field_Cow_DOB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date= Text_Field_Cow_DOB.getText().toString();
                System.out.println(date);
            }
        });
        Text_Field_Cow_Weight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weight= Double.parseDouble(Text_Field_Cow_Weight.getText().toString());
            }
        });


        Add_Data.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_Cow.super.setVisible(false);
                main.setVisible(true);
            }
        });


        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(gender.equals("Male")||gender.equals("Female")))
                    Errorms.setText("Incorrect gender");
                else if(type!='P' && type!='F')
                    Errorms.setText("Incorrect type");
                else if(weight<=0)
                    Errorms.setText("Incorrect weight");
                else if(date==null || date.length()!=10 || date.charAt(2)!='/'||date.charAt(5)!='/' )
                    Errorms.setText("Incorrect date");

                else{
                    FarmMe.addCow(gender,type,weight,date);
                    Errorms.setText("Cow created");
                }
            }});
    }
}
