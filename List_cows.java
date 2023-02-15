import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

public class List_cows extends  JFrame{
    private JLabel All_cows;
    private JScrollPane Scroll_animals;
    private JPanel main_panel;
    private JButton All_Done;
    private JTable table1;

    public List_cows(JFrame main, FarmMe farm){
        setContentPane(main_panel);
        setTitle("Displaying cows");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);
        for(int i =0; i<farm.returnAnimalList().size();i++){
            }

        All_Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List_cows.super.setVisible(false);
                main.setVisible(true);
            }
        });

    }

    private void createUIComponents() {
        int milking=0;
        int treatment =0;
        ArrayList<Animal> Animallist = FarmMe.AnimalList;
        Cow cow=null;
        // TODO: place custom component creation code here
        String[] columnNames = { "Tag No", "Gender", "Date Of Birth", "Type", "Weight", "Treatment", "Milking" };
        DefaultTableModel model = new DefaultTableModel(0,7);
        model.setColumnIdentifiers(columnNames);
        for(int i=0; i<Animallist.size();i++){
            System.out.println("-------------------"+i);
            milking=0;
            treatment=0;

            cow=null;
            if(Animallist.get(i) instanceof Cow){

                cow = (Cow) Animallist.get(i);

                if(cow.getTreatment()!=null)
                  treatment= cow.getTreatment().size();
                milking= cow.getMilkingsize();
                Object[] row = {cow.getTagNo(), cow.getGender(),
                       (cow.getDateOfBirth().get(Calendar.DATE)+"/"+cow.getDateOfBirth().get(Calendar.MONTH)+"/"+cow.getDateOfBirth().get(Calendar.YEAR)),
                       cow.isPurchased(),cow.getWeight(),treatment,milking
               };
               if (cow!=null){
                   model.addRow(row);
               }
            }

        }
        table1 = new JTable(model);

    }
    public void reeset(){
        ArrayList<Animal> AnimalList= FarmMe.AnimalList;
        Cow cow =null;
        int flag=0;
        int milking=0;
        int treatment=0;
        for (int k =0; k<AnimalList.size();k++){
            flag=0;
            if(AnimalList.get(k) instanceof Cow){
                for(int i=0;i<table1.getRowCount();i++){
                    if(AnimalList.get(k).getTagNo()==Integer.parseInt(table1.getValueAt(i,0).toString())){
                        flag=1;
                    }
                }
                if(flag==0){
                    cow= (Cow) AnimalList.get(k);
                    if(cow.getTreatment()!=null)
                        treatment= cow.getTreatment().size();
                    milking= cow.getMilkingsize();
                    Object[] row = {cow.getTagNo(), cow.getGender(),
                            (cow.getDateOfBirth().get(Calendar.DATE)+"/"+cow.getDateOfBirth().get(Calendar.MONTH)+"/"+cow.getDateOfBirth().get(Calendar.YEAR)),
                            cow.isPurchased(),cow.getWeight(),treatment,milking
                    };
                    ((DefaultTableModel) table1.getModel()).addRow(row);
                }
            }
        }

    }
}
