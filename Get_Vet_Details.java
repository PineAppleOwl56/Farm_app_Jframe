import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Get_Vet_Details extends JFrame{
    private JPanel Get_Vet_Details_Main_Panel;
    private JTextArea Vet_display;
    private JTextField Id_Of_The_Vet;
    private JLabel Tag_Of_The_Vet_To_Display;
    private JButton All_Done;

    public Get_Vet_Details(JFrame main){
        setContentPane(Get_Vet_Details_Main_Panel);
        setTitle("Displaying Vet");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);
        All_Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Get_Vet_Details.super.setVisible(false);
                Vet_display.setText("");
                main.setVisible(true);
            }
        });
        Id_Of_The_Vet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vet_display.setText("");
                int vetid=Integer.parseInt(Id_Of_The_Vet.getText().toString());
                int flag=0;
                for(int i=0;i<FarmMe.EmployeeList.size();i++){
                    if(vetid==FarmMe.EmployeeList.get(i).getEmpID() && FarmMe.EmployeeList.get(i) instanceof Veterinary){
                        flag=1;
                        Veterinary vet = (Veterinary) FarmMe.EmployeeList.get(i);
                        Vet_display.append("Id: "+vet.getEmpID()+"\n");
                        Vet_display.append("Gender: " + vet.getGender()+"\n");
                        Vet_display.append("Date of Birth: " + vet.getDateOfBirth().get(Calendar.DATE) + "/" + vet.getDateOfBirth().get(Calendar.MONTH) + "/" + vet.getDateOfBirth().get(Calendar.YEAR)+"\n");
                        Vet_display.append("BS degree: "+vet.isBScDegree()+"\n");
                        if(vet.isBScDegree())
                            Vet_display.append("Date of graduation:"+"Date of Birth: " + vet.getDateOfGraduation().get(Calendar.DATE) + "/" + vet.getDateOfGraduation().get(Calendar.MONTH) + "/" + vet.getDateOfGraduation().get(Calendar.YEAR)+"\n");
                        Vet_display.append("Salary for this vet is: " + FarmMe.EmployeeList.get(i).getGrossSalary() + "a month"+"\n");
                    }
                }
                if(flag==0){
                    Vet_display.append("No such vet");
                }
            }
        });
    }

}
