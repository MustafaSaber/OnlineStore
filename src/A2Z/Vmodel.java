package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static A2Z.system.ModelCon;
import static A2Z.system.administrators;

public class Vmodel extends JFrame{
    JLabel label1=new JLabel("Enter Model Name :");
    JLabel label2=new JLabel("Enter Model ID :");
    JLabel label3=new JLabel("Enter model brand :");
    JLabel label4=new JLabel("Enter model brand ID :");
    JLabel label5=new JLabel("Enter Old Model ID :");
    JLabel label6=new JLabel("Click On Any Button !!");
    JTextField ModelName =new JTextField(50);
    JTextField ModelID =new JTextField(50);
    JTextField BrandName =new JTextField(50);
    JTextField BrandID =new JTextField(50);
    JTextField OldModelID =new JTextField(50);
    JButton Add = new JButton("Add Model");
    JButton Remove = new JButton("Remove Model");
    JButton Update = new JButton("Update Model id");
    JButton Back = new JButton("Back");
    Administrator myAdmin=new Administrator();

    public Vmodel(String UserName){
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
        getContentPane().add(ModelName);
        getContentPane().add(label2);
        getContentPane().add(ModelID);
        getContentPane().add(label3);
        getContentPane().add(BrandName);
        getContentPane().add(label4);
        getContentPane().add(BrandID);
        getContentPane().add(label5);
        getContentPane().add(OldModelID);
        getContentPane().add(Add);
        getContentPane().add(Remove);
        getContentPane().add(Update);
        getContentPane().add(Back);
        getContentPane().add(label6);


    }

    private class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed=e.getSource();
            boolean flag;
            if(buttonPressed.equals(Add)){

                flag= ModelCon.AddModelToDB(ModelName.getText(), ModelID.getText() , BrandName.getText() , BrandID.getText() );
                if(flag){label6.setText("AddStore Brand To DB successfully ");}
                else {label6.setText("AddStore Brand To DB fail ");}
            }
            if(buttonPressed.equals(Remove)){
                flag= ModelCon.RemoveModelFromDB(OldModelID.getText());
                if(flag){label6.setText("RemoveStore Brand To DB successfully ");}
                else {label6.setText("RemoveStore Brand To DB fail ");}
            }
            if(buttonPressed.equals(Update)){
                flag= ModelCon.UpdateModelDB(ModelName.getText(), ModelID.getText() , BrandName.getText() , BrandID.getText() , OldModelID.getText());
                if(flag){label6.setText("Update Brand To DB successfully ");}
                else {label6.setText("Update Brand To DB fail ");}
            }
            if(buttonPressed.equals(Back)){
                Vadmin object1=new Vadmin(myAdmin.getUsername());
                object1.setVisible(true);
                dispose();
            }
        }
    }
}