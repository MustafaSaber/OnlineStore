package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static A2Z.system.StoreCon;
import static A2Z.system.storeOwners;

public class Vstore extends JFrame{
    JLabel label1=new JLabel("Enter Store Name :");
    JLabel label2=new JLabel("Enter Store ID :");
    JLabel label3=new JLabel("Enter The New Store Name :");
    JLabel label4=new JLabel("Click On Any Button !!");
    JTextField StoreName=new JTextField(50);
    JTextField StoreID=new JTextField(50);
    JTextField newStoreName=new JTextField(50);
    JButton Add = new JButton("Add Store");
    JButton Remove = new JButton("Remove Store");
    JButton Update = new JButton("Update");
    JButton Back = new JButton("Login");
    StoreOwner myStoreOwner=new StoreOwner();

    public Vstore(String UserName){
        setTitle("** Store View **");
        setSize(600,600);
        Add.addActionListener(new action());
        Remove.addActionListener(new action());
        Update.addActionListener(new action());
        Back.addActionListener(new action());
        for(int i=0;i<storeOwners.size();i++){
            if(storeOwners.get(i).getUsername().equals(UserName)){
                myStoreOwner=storeOwners.get(i);
                break;
            }
        }
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(label1);
        getContentPane().add(StoreName);
        getContentPane().add(label2);
        getContentPane().add(StoreID);
        getContentPane().add(label3);
        getContentPane().add(newStoreName);
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

            boolean flag=false;
            if(buttonPressed.equals(Add)){
                if(!StoreName.getText().equals("") && !StoreID.getText().equals("")){
                    flag=StoreCon.AddStoreToDB(StoreName.getText(),StoreID.getText());
                }
                else {flag=false;}
                if(flag==true){label4.setText("AddStore Store To DB successfully ");}
                else {label4.setText("AddStore Store To DB fail ");}
            }
            if(buttonPressed.equals(Remove)){
                if(!StoreName.getText().equals("") && !StoreID.getText().equals("")){
                    flag=StoreCon.RemoveStoreToDB(StoreName.getText(),StoreID.getText());
                }
                else {flag=false;}
                if(flag){label4.setText("RemoveStore Store To DB successfully ");}
                else {label4.setText("RemoveStore Store To DB fail ");}
            }
            if (buttonPressed.equals(Update)){
                if(!StoreName.getText().equals("") && !StoreID.getText().equals("") && !newStoreName.getText().equals("")){
                    flag=StoreCon.UpdateStoreToDB(StoreName.getText(),StoreID.getText(),newStoreName.getText());
                }
                else {flag=false;}
                if(flag){label4.setText("Update Store To DB successfully ");}
                else {label4.setText("Update Store To DB fail ");}
            }
            if(buttonPressed.equals(Back)){
                VStoreOwner object1=new VStoreOwner(myStoreOwner.getUsername());
                object1.setVisible(true);
                dispose();
            }
        }
    }
}