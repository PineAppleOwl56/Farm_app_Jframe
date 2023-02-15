import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Milking_info extends JFrame{
    private JPanel main_panel;
    private JLabel Animal_Id;
    private JTextField animal_id;
    private JTextField amount;
    private JLabel amount_from;
    private JButton All_Done;
    int tagno;
    double amount_to_send;

    public Milking_info(JFrame main){
        setContentPane(main_panel);
        setTitle("adding Milking Information");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);
        All_Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FarmMe.addMilkingMeasurement(tagno,amount_to_send);
                Milking_info.super.setVisible(false);
                main.setVisible(true);
            }
        });

        animal_id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tagno= Integer.parseInt(animal_id.getText().toString());
            }
        });
        amount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amount_to_send= Double.parseDouble(amount.getText().toString());
            }
        });
    }
}
