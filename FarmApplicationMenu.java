import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FarmApplicationMenu  extends JFrame{
    static FarmMe main_opperations = new FarmMe();

    public static void main(String[] args) throws IOException {
        main_opperations.Populate();
        main_opperations.listCows();

        JFrame main_frame= new JFrame("Farm application task menu");
        JTextArea starting_lable=new JTextArea("\n\n\tHello!\n\tWelcome to the Farm application\n\tTo start an activity, please choose the task\n\tat the top left corner");
        main_frame.setSize(600,600);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setLocationRelativeTo(null);
        main_frame.setLayout(new BorderLayout());

        Add_Cow add_cow= new Add_Cow(main_frame, main_opperations);
        Add_Vet add_vet = new Add_Vet(main_frame,main_opperations);
        Cleaning_Treatment cleaning_treatment = new Cleaning_Treatment(main_frame);
        Cow_treatment_by_date cow_treatment_by_date = new Cow_treatment_by_date(main_frame);
        Cow_Treatment_To_Be_Displayed cow_treatment_to_be_displayed = new Cow_Treatment_To_Be_Displayed(main_frame);
        Delete_Cow delete_cow = new Delete_Cow(main_frame, main_opperations);
        Delete_Vet delete_vet= new Delete_Vet(main_frame,main_opperations);
        Employee_salary employee_salary = new Employee_salary(main_frame);
        Feeding_animal feeding_animal = new Feeding_animal(main_frame);
        Get_Cow_Details get_cow_details=new Get_Cow_Details(main_frame);
        Get_Vet_Details get_vet_details=new Get_Vet_Details(main_frame);
        List_cows list_cows = new List_cows(main_frame,main_opperations);
        List_farm_workers list_farm_workers= new List_farm_workers(main_frame);
        List_vets list_vets =new List_vets(main_frame);
        List_sheep list_sheep= new List_sheep(main_frame);
        Medication_Gui medication= new Medication_Gui(main_frame);
        Milking_info milking_info=new Milking_info(main_frame);
        Health_Treatment health_treatment = new Health_Treatment(medication,main_frame);

        Add_Treatment add_treatment= new Add_Treatment(main_frame,cleaning_treatment,health_treatment);



        JMenuBar menuBar = new JMenuBar();
        //buttom declaration
        JMenu menu = new JMenu("Treatment");
        JMenu menu1 = new JMenu("Animals");
        JMenu menu3 = new JMenu("Employee");
        JMenu menu2 = new JMenu("List");
        JMenu menu4 = new JMenu("Exit");

        JMenuItem Add_Cow= new JMenuItem("Add Cow");
        JMenuItem Delete_Cow= new JMenuItem("Delete Cow");
        JMenuItem Get_cow_details= new JMenuItem("Get cow details");
        JMenuItem Add_Vet= new JMenuItem("Add Vet");
        JMenuItem Delete_Vet= new JMenuItem("Delete Vet");
        JMenuItem Get_vet_details= new JMenuItem("Get vet details");
        JMenuItem Add_Treatment= new JMenuItem("Add Treatment");
        JMenuItem Get_Cow_treatment= new JMenuItem("Get Cow treatment");
        JMenuItem Get_Cow_treatment_by_date= new JMenuItem("Get Cow treatment by date");
        JMenuItem List_Cows= new JMenuItem("List Cows");
        JMenuItem List_Sheep= new JMenuItem("List Sheep");
        JMenuItem List_Vets= new JMenuItem("List Vets");
        JMenuItem List_Farm_workers= new JMenuItem("List Farm workers");
        JMenuItem Feeding_animal= new JMenuItem("Feeding animal");
        JMenuItem Get_Employee_salary= new JMenuItem("Get Employee salary");
        JMenuItem Add_milking_measurement= new JMenuItem("Add milking measurement");
        JMenuItem Exit= new JMenuItem("Exit");
        JMenuItem Save_Exit= new JMenuItem("Save & exit");

        // buttom listeners

        Add_Cow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_opperations.listCows();
                main_frame.setVisible(false);
                add_cow.setVisible(true);
            }
        });
        Delete_Cow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.setVisible(false);
                delete_cow.setVisible(true);
            }
        });
        Get_cow_details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.setVisible(false);
                get_cow_details.setVisible(true);
            }
        });
        Add_Vet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.setVisible(false);
                add_vet.setVisible(true);
            }
        });
        Delete_Vet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.setVisible(false);
                delete_vet.setVisible(true);
            }
        });
        Get_vet_details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.setVisible(false);
                get_vet_details.setVisible(true);
            }
        });
        Add_Treatment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.setVisible(false);
                add_treatment.setVisible(true);
            }
        });
        Get_Cow_treatment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.setVisible(false);
                cow_treatment_to_be_displayed.setVisible(true);
            }
        });
        Get_Cow_treatment_by_date.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.setVisible(false);
                cow_treatment_by_date.setVisible(true);
            }
        });
        List_Cows.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.setVisible(false);
                list_cows.reeset();
                list_cows.setVisible(true);
            }
        });
        List_Sheep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.setVisible(false);
                list_sheep.reeset();
                list_sheep.setVisible(true);
            }
        });
        List_Vets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.setVisible(false);
                list_vets.reeset();
                list_vets.setVisible(true);
            }
        });
        List_Farm_workers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.setVisible(false);
                list_farm_workers.reeset();
                list_farm_workers.setVisible(true);
            }
        });
        Feeding_animal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.setVisible(false);
                feeding_animal.setVisible(true);
            }
        });
        Get_Employee_salary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.setVisible(false);
                employee_salary.setVisible(true);
            }
        });
        Add_milking_measurement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.setVisible(false);
                milking_info.setVisible(true);
            }
        });
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        Save_Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    main_opperations.StoreData();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.exit(1);
            }
        });

        menu1.add(Add_Cow);
        menu1.add(Delete_Cow);
        menu1.add(Get_cow_details);
        menu3.add(Add_Vet);
        menu3.add(Delete_Vet);
        menu3.add(Get_vet_details);
        menu.add(Add_Treatment);
        menu1.add(Get_Cow_treatment);
        menu1.add(Get_Cow_treatment_by_date);
        menu2.add(List_Cows);
        menu2.add(List_Sheep);
        menu2.add(List_Vets);
        menu2.add(List_Farm_workers);
        menu1.add(Feeding_animal);
        menu3.add(Get_Employee_salary);
        menu1.add(Add_milking_measurement);
        menu4.add(Exit);
        menu4.add(Save_Exit);

        menuBar.add(menu);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        main_frame.add(menuBar,BorderLayout.NORTH);

        main_frame.add(starting_lable,BorderLayout.CENTER);
        main_frame.setVisible(true);
        Container container = new Container();
        container.add(main_frame);
        container.add(add_cow);
        container.add(add_treatment);
        container.add(add_vet);
        container.add(cleaning_treatment);
        container.add(cow_treatment_by_date);
        container.add(cow_treatment_to_be_displayed);
        container.add(delete_cow);
        container.add(delete_vet);
        container.add(employee_salary);
        container.add(feeding_animal);
        container.add(get_cow_details);
        container.add(get_vet_details);
        container.add(health_treatment);
        container.add(list_cows);
        container.add(list_farm_workers);
        container.add(list_sheep);
        container.add(list_vets);
        container.add(medication);
        container.add(milking_info);
    }

}
