import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class Add_Treatment extends JFrame{
    private JPanel Adding_Treatment;
    private JLabel Employee_ID;
    private JButton HealthTreatment;
    private JButton CleanignTreatment;
    private JButton Return;

    public Add_Treatment(JFrame main_frame,Cleaning_Treatment cleaning_treatment, Health_Treatment health_treatment){
        setContentPane(Adding_Treatment);
        setLocationRelativeTo(null);
        setTitle("Treatment Choice");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);

        HealthTreatment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_Treatment.super.setVisible(false);
                health_treatment.setVisible(true);
            }
        });
        CleanignTreatment.addComponentListener(new ComponentAdapter() {
        });
        CleanignTreatment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_Treatment.super.setVisible(false);
                cleaning_treatment.setVisible(true);
            }
        });
        Return.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_Treatment.super.setVisible(false);
                main_frame.setVisible(true);
            }
        });
    }

}
