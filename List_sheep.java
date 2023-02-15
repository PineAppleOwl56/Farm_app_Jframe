import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

public class List_sheep extends JFrame{
    private JPanel main_panel;
    private JLabel All_sheeps;
    private JScrollPane Scroll_sheep;
    private JButton All_Done;
    private JTable table1;

    public List_sheep(JFrame main){
        setContentPane(main_panel);
        setTitle("Displaying sheep");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);
        All_Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List_sheep.super.setVisible(false);
                main.setVisible(true);
            }
        });

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        int milking=0;
        int treatment =0;
        ArrayList<Animal> Animallist = FarmMe.AnimalList;
        Sheep sheep=null;
        // TODO: place custom component creation code here
        String[] columnNames = { "Tag No", "Gender", "Date Of Birth", "Type", "Weight", "Treatment", "Milking" };
        DefaultTableModel model = new DefaultTableModel(0,7);
        model.setColumnIdentifiers(columnNames);
        for(int i=0; i<Animallist.size();i++){
            milking=0;
            treatment=0;
            sheep=null;
            if(Animallist.get(i) instanceof Sheep){
                sheep = (Sheep) Animallist.get(i);
                if(sheep.getTreatment()!=null)
                  treatment= sheep.getTreatment().size();
                milking=sheep.getMilkingsize();
                Object[] row = {sheep.getTagNo(), sheep.getGender(),
                        (sheep.getDateOfBirth().get(Calendar.DATE)+"/"+sheep.getDateOfBirth().get(Calendar.MONTH)+"/"+sheep.getDateOfBirth().get(Calendar.YEAR)),
                        sheep.isPurchased(),treatment,milking
                };
                if (sheep!=null){
                    model.addRow(row);
                }
            }

        }
        table1 = new JTable(model);
    }

    public void reeset(){
        ArrayList<Animal> AnimalList= FarmMe.AnimalList;
        Sheep sheep =null;
        int flag=0;
        int milking=0;
        int treatment=0;
        for (int k =0; k<AnimalList.size();k++){
            flag=0;
            if(AnimalList.get(k) instanceof Sheep){
                for(int i=0;i<table1.getRowCount();i++){
                    if(AnimalList.get(k).getTagNo()==Integer.parseInt(table1.getValueAt(i,0).toString())){
                        flag=1;
                    }
                }
                if(flag==0){
                    sheep= (Sheep) AnimalList.get(k);
                    if(sheep.getTreatment()!=null)
                        treatment= sheep.getTreatment().size();
                    milking=sheep.getMilkingsize();
                    Object[] row = {sheep.getTagNo(), sheep.getGender(),
                            (sheep.getDateOfBirth().get(Calendar.DATE)+"/"+sheep.getDateOfBirth().get(Calendar.MONTH)+"/"+sheep.getDateOfBirth().get(Calendar.YEAR)),
                            sheep.isPurchased(),treatment,milking
                    };
                    ((DefaultTableModel) table1.getModel()).addRow(row);
                }
            }
        }

    }
}
