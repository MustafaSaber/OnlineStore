package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static A2Z.system.administrators;

public class Vadmin extends JFrame{
    JButton AddB = new JButton("Add Brand");
    JButton RemoveB = new JButton("Remove Brand");
    JButton AddM = new JButton("Add Model");
    JButton RemoveM = new JButton("Remove Model");
    JButton AddA = new JButton("Add Admin");
    JButton RemoveA = new JButton("Remove Admin");
    JButton VocherCard = new JButton("Add Voucher Card");
    JButton Logout = new JButton("Logout");
    Administrator myAdmin=new Administrator();

    public Vadmin(String UserName){
        setTitle("** Admin View **");
        setSize(600,600);
        AddA.setPreferredSize(new Dimension(550,20));
        AddM.setPreferredSize(new Dimension(550,20));
        AddB.setPreferredSize(new Dimension(550,20));
        RemoveA.setPreferredSize(new Dimension(550,20));
        RemoveB.setPreferredSize(new Dimension(550,20));
        RemoveM.setPreferredSize(new Dimension(550,20));
        VocherCard.setPreferredSize(new Dimension(550,20));
        Logout.setPreferredSize(new Dimension(550,20));

        AddB.addActionListener(new action());
        RemoveB.addActionListener(new action());
        AddM.addActionListener(new action());
        RemoveM.addActionListener(new action());
        AddA.addActionListener(new action());
        RemoveA.addActionListener(new action());
        VocherCard.addActionListener(new action());
        Logout.addActionListener(new action());
        for (int i=0;i<administrators.size();i++){
            if(administrators.get(i).getUsername().equals(UserName)){
                myAdmin=administrators.get(i);
                break;
            }
        }
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(AddB);
        getContentPane().add(RemoveB);
        getContentPane().add(AddM);
        getContentPane().add(RemoveM);
        getContentPane().add(AddA);
        getContentPane().add(RemoveA);
        getContentPane().add(VocherCard);
        getContentPane().add(Logout);

        if(system.models.size()>0)
            getContentPane().add(new JLabel("Models : "));
        for(Model m:system.models)
        {
            getContentPane().add(new JLabel(m.getName()));
        }
        if(system.brands.size()>0)
            getContentPane().add(new JLabel("Brands : "));
        for(Brand b:system.brands)
        {
            getContentPane().add(new JLabel(b.getName()));
        }
        if(system.suggestModels.size()>0)
            getContentPane().add(new JLabel("Suggested Models : "));
        for(Model m: system.suggestModels)
        {
            getContentPane().add(new JLabel("Model Name: " + m.getName() + ",Model ID: " + m.getModelID()));
        }
        if(system.suggestBrands.size()>0)
            getContentPane().add(new JLabel("Suggested Brands :"));
        for(Brand b: system.suggestBrands)
        {
            getContentPane().add(new JLabel("Brand Name: " + b.getName() + ",Brand ID: " + b.getBrandID()));
        }
    }

    private class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed=e.getSource();

            if(buttonPressed.equals(AddB)){
                Vbrand object=new Vbrand(myAdmin.getUsername());
                object.setVisible(true);
            }
            if(buttonPressed.equals(RemoveB)){
                Vbrand object=new Vbrand(myAdmin.getUsername());
                object.setVisible(true);
            }
            if (buttonPressed.equals(AddM)){
                Vmodel object=new Vmodel(myAdmin.getUsername());
                object.setVisible(true);
            }
            if (buttonPressed.equals(RemoveM)){
                Vmodel object=new Vmodel(myAdmin.getUsername());
                object.setVisible(true);
            }
            if (buttonPressed.equals(AddA)){
                VaddRemadmin object=new VaddRemadmin(myAdmin.getUsername());
                object.setVisible(true);
            }
            if (buttonPressed.equals(RemoveA)){
                VaddRemadmin object=new VaddRemadmin(myAdmin.getUsername());
                object.setVisible(true);
            }
            if(buttonPressed.equals(VocherCard))
            {
                VaddVoucherCard ob = new VaddVoucherCard(myAdmin.getUsername());
                ob.setVisible(true);
            }
            if(buttonPressed.equals(Logout)){
                View object=new View();
                object.setVisible(true);
            }
        }
    }
}