import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

public class List_farm_workers extends JFrame{
    private JPanel main_panel;
    private JLabel farm_workers;
    private JScrollPane Scroll_far_workers;
    private JButton All_Done;
    private JTable table1;


    public List_farm_workers(JFrame main){
        setContentPane(main_panel);
        setTitle("Displaying farm workers");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);
        All_Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List_farm_workers.super.setVisible(false);
                main.setVisible(true);
            }
        });

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        ArrayList<Employee> EmployeeList = FarmMe.EmployeeList;
        FarmWorker farm_worker=null;
        // TODO: place custom component creation code here
        String[] columnNames = { "Emp ID", "Gender", "Date Of Birth", "Previous Farm", "Work Experience"};
        DefaultTableModel model = new DefaultTableModel(0,5);
        model.setColumnIdentifiers(columnNames);
        for(int i=0; i<EmployeeList.size();i++){
            farm_worker=null;
            if(EmployeeList.get(i) instanceof FarmWorker){
                farm_worker = (FarmWorker) EmployeeList.get(i);

                Object[] row = {farm_worker.getEmpID(), farm_worker.getGender(),
                        (farm_worker.getDateOfBirth().get(Calendar.DATE)+"/"+farm_worker.getDateOfBirth().get(Calendar.MONTH)+"/"+farm_worker.getDateOfBirth().get(Calendar.YEAR)),
                        farm_worker.getPreviousFarmName(),farm_worker.getWorkexperience()
                };
                if (farm_worker!=null){
                    model.addRow(row);
                }
            }

        }
        table1 = new JTable(model);
    }
    public void reeset(){
        ArrayList<Employee> EmployeeList= FarmMe.EmployeeList;
        FarmWorker farm_worker =null;
        int flag=0;
        for (int k =0; k<EmployeeList.size();k++){
            flag=0;
            if(EmployeeList.get(k) instanceof FarmWorker){
                for(int i=0;i<table1.getRowCount();i++){
                    if(EmployeeList.get(k).getEmpID()==Integer.parseInt(table1.getValueAt(i,0).toString())){
                        flag=1;
                    }
                }
                if(flag==0){
                    farm_worker = (FarmWorker) EmployeeList.get(k);

                    Object[] row = {farm_worker.getEmpID(), farm_worker.getGender(),
                            (farm_worker.getDateOfBirth().get(Calendar.DATE)+"/"+farm_worker.getDateOfBirth().get(Calendar.MONTH)+"/"+farm_worker.getDateOfBirth().get(Calendar.YEAR)),
                            farm_worker.getPreviousFarmName(),farm_worker.getWorkexperience()
                    };
                    ((DefaultTableModel) table1.getModel()).addRow(row);
                }
            }
        }

    }
}
