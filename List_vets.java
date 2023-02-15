import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

public class List_vets extends JFrame{
    private JPanel main_panel;
    private JLabel Vets;
    private JScrollPane Scroll_vets;
    private JButton All_Done;
    private JTable table1;

    public List_vets(JFrame main){
        setContentPane(main_panel);
        setTitle("Displaying vets");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);
        All_Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List_vets.super.setVisible(false);
                main.setVisible(true);
            }
        });

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        ArrayList<Employee> EmployeeList = FarmMe.EmployeeList;
        Veterinary vet=null;
        DefaultTableModel model = new DefaultTableModel(0,5);
        String[] columnNames = { "Emp ID", "Gender", "Date Of Birth", "Previous Farm", "Work Experience"};
        model.setColumnIdentifiers(columnNames);
        for(int i=0; i<EmployeeList.size();i++){
            System.out.println(EmployeeList.size());
            vet=null;
            if(EmployeeList.get(i) instanceof Veterinary){
                vet = (Veterinary) EmployeeList.get(i);
                Object[] row = {vet.getEmpID(), vet.getGender(),
                        (vet.getDateOfBirth().get(Calendar.DATE)+"/"+vet.getDateOfBirth().get(Calendar.MONTH)+"/"+vet.getDateOfBirth().get(Calendar.YEAR)),
                        vet.isBScDegree(),
                        (vet.getDateOfGraduation().get(Calendar.DATE)+"/"+vet.getDateOfGraduation().get(Calendar.MONTH)+"/"+vet.getDateOfGraduation().get(Calendar.YEAR))
                        ,vet.getExpertiseLevel()
                };
                if (vet!=null){
                    model.addRow(row);
                }
            }

        }
        table1 = new JTable(model);
    }
    public void reeset(){

        ArrayList<Employee> EmployeeList= FarmMe.EmployeeList;
        Veterinary vet =null;
        int flag=0;
        for (int k =0; k<EmployeeList.size();k++){
            flag=0;
            if(EmployeeList.get(k) instanceof Veterinary){
                for(int i=0;i<table1.getRowCount();i++){
                    if(EmployeeList.get(k).getEmpID()==Integer.parseInt(table1.getValueAt(i,0).toString())){
                        flag=1;
                    }
                }
                if(flag==0){
                    vet = (Veterinary) EmployeeList.get(k);
                    Object[] row = {vet.getEmpID(), vet.getGender(),
                            (vet.getDateOfBirth().get(Calendar.DATE)+"/"+vet.getDateOfBirth().get(Calendar.MONTH)+"/"+vet.getDateOfBirth().get(Calendar.YEAR)),
                            vet.isBScDegree(),
                            (vet.getDateOfGraduation().get(Calendar.DATE)+"/"+vet.getDateOfGraduation().get(Calendar.MONTH)+"/"+vet.getDateOfGraduation().get(Calendar.YEAR))
                            ,vet.getExpertiseLevel()
                    };
                    ((DefaultTableModel) table1.getModel()).addRow(row);
                }
            }
        }

    }
}
