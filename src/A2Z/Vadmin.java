package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static A2Z.system.administrators;

public class Vadmin extends JFrame{
    JButton AddB = new JButton("AddStore Brand");
    JButton RemoveB = new JButton("RemoveStore Brand");
    JButton AddM = new JButton("AddStore Model");
    JButton RemoveM = new JButton("RemoveStore Model");
    JButton AddA = new JButton("AddStore Admin");
    JButton RemoveA = new JButton("RemoveStore Admin");
    JButton Logout = new JButton("Logout");
    Administrator myAdmin=new Administrator();

    public Vadmin(String UserName){
        setTitle("** Admin View **");
        setSize(600,600);
        AddB.addActionListener(new action());
        RemoveB.addActionListener(new action());
        AddM.addActionListener(new action());
        RemoveM.addActionListener(new action());
        AddA.addActionListener(new action());
        RemoveA.addActionListener(new action());
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
        getContentPane().add(Logout);

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
            if(buttonPressed.equals(Logout)){
                View object=new View();
                object.setVisible(true);
            }
        }
    }
}