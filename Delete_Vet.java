import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete_Vet extends JFrame{
    private JLabel Vet_Id_To_Delete;
    private JTextField Text_Vet_ID;
    private JPanel Vet_Main_Panel;
    private JButton All_Done;
    int empId;

    public Delete_Vet(JFrame main, FarmMe main_operations){
        setContentPane(Vet_Main_Panel);
        setTitle("Deleting Vet");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);
        All_Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delete_Vet.super.setVisible(false);
                main.setVisible(true);
            }
        });
        Text_Vet_ID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empId=Integer.parseInt(Text_Vet_ID.getText().toString());
                main_operations.deleteVet(empId);
            }
        });
    }
}
