package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

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
    JList models;
    JList brands;
    JList smodels;
    JList sbrands;

    JList list;
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
        Vector<String >s = new Vector<>();
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
            s.add("Models : ");
        for(Model m:system.models)
        {
            s.add(m.getName());
        }
        models = new JList(s);
        getContentPane().add(models);
        s=new Vector<>();
        if(system.brands.size()>0)
            s.add("Brands : ");
        for(Brand b:system.brands)
        {
            s.add(b.getName());
        }
        brands = new JList(s);
        getContentPane().add(brands);
        s=new Vector<>();

        if(system.suggestModels.size()>0)
            s.add("Suggested Models : ");
        for(Model m: system.suggestModels)
        {
            s.add("Model Name: " + m.getName());
            s.add("Model ID: " + m.getModelID());
        }
        smodels = new JList(s);
        getContentPane().add(smodels);
        s=new Vector<>();
        if(system.suggestBrands.size()>0)
            s.add("Suggested Brands :");
        for(Brand b: system.suggestBrands)
        {
            s.add("Brand Name: " + b.getName());
            s.add("Brand ID: " + b.getBrandID());
        }
        sbrands = new JList(s);
        getContentPane().add(sbrands);
        s=new Vector<>();
        if(system.voucherCards.size()>0)
            s.add("Voucher Cards : ");
        for (VoucherCard v : system.voucherCards)
        {
            String string = "ID : "+v.getVoucherID() + " ,value : " + v.getValue();
            s.add(string);
        }
        list = new JList(s);
        getContentPane().add(list);
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