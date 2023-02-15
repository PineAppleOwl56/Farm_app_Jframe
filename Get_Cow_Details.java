import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Get_Cow_Details extends JFrame{
    private JPanel Get_Cow_Details;
    private JTextField Cow_tag_input;
    private JLabel Cow_Tag_To_Display;
    private JTextArea Display_Cow_Here;
    private JButton All_Done;


    public Get_Cow_Details(JFrame main){
        setContentPane(Get_Cow_Details);
        setTitle("Getting Cow Details");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);
        All_Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Get_Cow_Details.super.setVisible(false);
                Display_Cow_Here.setText("");
                main.setVisible(true);
            }
        });
        Cow_tag_input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display_Cow_Here.setText("");
                int cowtag=Integer.parseInt(Cow_tag_input.getText().toString());
                int flag=0;
                for(int i=0;i<FarmMe.AnimalList.size();i++){
                    if(cowtag==FarmMe.AnimalList.get(i).getTagNo() && FarmMe.AnimalList.get(i) instanceof Cow){
                        flag=1;
                        Cow cow = (Cow) FarmMe.AnimalList.get(i);
                        Display_Cow_Here.append("Id: "+cow.getTagNo()+"\n");
                        Display_Cow_Here.append("Gender: " + cow.getGender()+"\n");
                        Display_Cow_Here.append("Date of Birth: " + cow.getDateOfBirth().get(Calendar.DATE) + "/" + cow.getDateOfBirth().get(Calendar.MONTH) + "/" + cow.getDateOfBirth().get(Calendar.YEAR)+"\n");
                        Display_Cow_Here.append("Purchased : "+cow.isPurchased()+"\n");
                        if(cow.getTreatment()!=null)
                            Display_Cow_Here.append("Treatment : "+cow.getTreatment().size()+"\n");
                        Display_Cow_Here.append("Milking : "+cow.getMilkingsize()+"\n");
                        Display_Cow_Here.append("Weight : "+cow.getWeight()+"\n");
                    }
                }
                if(flag==0){
                    Display_Cow_Here.append("No such vet");
                }
            }
        });
    }
}
