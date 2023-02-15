import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete_Cow extends JFrame {
    private JPanel Delete_Cow_From_Data;
    private JLabel Cow_Tag;
    private JTextField Cow_to_delete;
    private JButton All_Done;
    int tagno;
    public Delete_Cow(JFrame main, FarmMe main_operations){
        setContentPane(Delete_Cow_From_Data);
        setTitle("Deleting Cow");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);
        All_Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delete_Cow.super.setVisible(false);
                main.setVisible(true);
            }
        });
        Cow_to_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tagno= Integer.parseInt(Cow_to_delete.getText().toString());
                FarmMe.deleteCow(tagno);
            }
        });
    }

}
