import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Feeding_animal extends JFrame {
    private JPanel main_panel;
    private JTextField Text_tag_of_the_animal;
    private JTextArea Area_to_display;
    private JLabel Animal_id;
    private JLabel Feeding_info;
    private JButton All_Done;
    int tagno;

    public Feeding_animal(JFrame main){
        setContentPane(main_panel);
        setTitle("Displaying the feeding of the animal");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);
        All_Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Feeding_animal.super.setVisible(false);
                Area_to_display.setText("");
                main.setVisible(true);


            }
        });
        Text_tag_of_the_animal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag=0;
                Area_to_display.setText("");
                tagno=Integer.parseInt(Text_tag_of_the_animal.getText().toString());
                for(int i=0; i<FarmMe.AnimalList.size();i++){
                    if(FarmMe.AnimalList.get(i).getTagNo()==tagno){
                        flag=1;
                        Area_to_display.append(FarmMe.AnimalList.get(i).feeding()+"\n");
                    }
                }
                if(flag==0){
                    Area_to_display.setText("No such animal");
                }
            }
        });
    }

}
