import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Employee_salary extends JFrame{
    private JLabel Employee_id;
    private JTextField Text_Emp_id;
    private JPanel main_panel;
    private JTextArea textArea1;
    private JLabel Salary;
    private JButton All_Done;
    int empID;

    public Employee_salary(JFrame main){
        setContentPane(main_panel);
        setTitle("Employee Salary");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);
        All_Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee_salary.super.setVisible(false);
                textArea1.setText("");
                main.setVisible(true);
            }
        });

        Text_Emp_id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag=0;
                textArea1.setText("");
                empID=Integer.parseInt(Text_Emp_id.getText().toString());
                for(int i=0; i<FarmMe.EmployeeList.size();i++){
                    if(FarmMe.EmployeeList.get(i).getEmpID()==empID){
                        flag=1;
                        textArea1.append(FarmMe.EmployeeList.get(i).getGrossSalary()+"\n");
                    }
                }
                if (flag==0)
                    textArea1.append("No such vet");
            }
        });
    }
}
