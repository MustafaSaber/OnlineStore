package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static A2Z.system.BrandCon;
import static A2Z.system.administrators;

public class Vbrand extends JFrame{
    JLabel label1=new JLabel("Enter Brand Name :");
    JLabel label2=new JLabel("Enter Brand ID :");
    JLabel label3=new JLabel("Enter The New Brand Name :");
    JLabel label4=new JLabel("Click On Any Button !!");
    JTextField BrandName=new JTextField(50);
    JTextField BrandID=new JTextField(50);
    JTextField newBrandName=new JTextField(50);
    JButton Add = new JButton("Add Store");
    JButton Remove = new JButton("Remove Store");
    JButton Update = new JButton("Update");
    JButton Back = new JButton("Back");
    Administrator myAdmin=new Administrator();

    public Vbrand(String UserName){
        setTitle("** Brand View **");
        setSize(600,600);
        Add.addActionListener(new action());
        Remove.addActionListener(new action());
        Update.addActionListener(new action());
        Back.addActionListener(new action());
        for (int i=0;i<administrators.size();i++){
            if(administrators.get(i).getUsername().equals(UserName)){
                myAdmin=administrators.get(i);
                break;
            }
        }
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(label1);
        getContentPane().add(BrandName);
        getContentPane().add(label2);
        getContentPane().add(BrandID);
        getContentPane().add(label3);
        getContentPane().add(newBrandName);
        getContentPane().add(Add);
        getContentPane().add(Remove);
        getContentPane().add(Update);
        getContentPane().add(Back);
        getContentPane().add(label4);


    }

    private class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed=e.getSource();
            boolean flag;
            if(buttonPressed.equals(Add)){
                flag=BrandCon.AddBrandToDB(BrandName.getText(),BrandID.getText());
                if(flag){label4.setText("AddStore Brand To DB successfully ");}
                else {label4.setText("AddStore Brand To DB fail ");}
            }
            if(buttonPressed.equals(Remove)){
                flag=BrandCon.RemoveBrandToDB(BrandName.getText(),BrandID.getText());
                if(flag){label4.setText("RemoveStore Brand To DB successfully ");}
                else {label4.setText("RemoveStore Brand To DB fail ");}
            }
            if(buttonPressed.equals(Update)){
                flag=BrandCon.UpdateBrandToDB(BrandName.getText(),BrandID.getText(),newBrandName.getText());
                if(flag){label4.setText("Update Brand To DB successfully ");}
                else {label4.setText("Update Brand To DB fail ");}
            }
            if(buttonPressed.equals(Back)){
                Vadmin object1=new Vadmin(myAdmin.getUsername());
                object1.setVisible(true);
            }
        }
    }
}