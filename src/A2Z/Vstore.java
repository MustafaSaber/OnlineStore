package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static A2Z.system.StoreCon;
import static A2Z.system.storeOwners;
import static A2Z.system.stores;

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
    JButton Back = new JButton("Back");
    StoreOwner myStoreOwner;//=new StoreOwner();

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
                system.StoreOwnerCon.setSo(myStoreOwner);
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
                    flag=system.StoreOwnerCon.AddStoreCont(StoreName.getText(),StoreID.getText());
                    myStoreOwner.setStores(system.StoreOwnerCon.getSo().getStores());
                }
                else {flag=false;}
                if(flag==true){label4.setText("AddStore Store To DB successfully ");}
                else {label4.setText("AddStore Store To DB fail ");}
                //System.out.println(myStoreOwner.getStores().size());

            }
            if(buttonPressed.equals(Remove)){
                if(!StoreName.getText().equals("") && !StoreID.getText().equals("")){
                   // System.out.println(myStoreOwner.getStores().size());
                    flag=system.StoreOwnerCon.RemoveStoreCont(StoreName.getText(),StoreID.getText());
                   // System.out.println(flag);
                    myStoreOwner.setStores(system.StoreOwnerCon.getSo().getStores());
                    //System.out.println(myStoreOwner.getStores().size());
                }
                else {flag=false;}
                if(flag){label4.setText("RemoveStore Store To DB successfully ");}
                else {label4.setText("RemoveStore Store To DB fail ");}

            }
            if (buttonPressed.equals(Update)){
                if(!StoreName.getText().equals("") && !StoreID.getText().equals("") && !newStoreName.getText().equals("")){
                    flag=StoreCon.UpdateStoreToDB(StoreName.getText(),StoreID.getText(),newStoreName.getText());
                    for(Store s : myStoreOwner.getStores()){
                        if(s.getName().equals(StoreName.getText())){
                            s.setName(newStoreName.getText());
                        }
                    }
                }
                else {flag=false;}
                if(flag){label4.setText("Update Store To DB successfully ");}
                else {label4.setText("Update Store To DB fail ");}
            }
            if(buttonPressed.equals(Back)){
                //System.out.println(myStoreOwner.getUsername() + " " + myStoreOwner.getStores().size());
                VStoreOwner object1=new VStoreOwner(myStoreOwner.getUsername());
                object1.setVisible(true);
                dispose();
            }
        }
    }
}