package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static A2Z.system.storeOwners;
import static A2Z.system.suggestBrands;

public class VsuggestB extends JFrame{
    JLabel label1=new JLabel("Enter Brand Name :");
    JLabel label2=new JLabel("Enter Brand ID :");
    JLabel label3 =new JLabel("Click On Any Button !!");
    JTextField BrandName=new JTextField(50);
    JTextField BrandID=new JTextField(50);
    JButton Submit = new JButton("Submit Brand");
    JButton Back = new JButton("Back");
    StoreOwner myStoreOwner=new StoreOwner();

    public VsuggestB(String UserName){
        setTitle("** Suggest Brand View **");
        setSize(600,600);
        Submit.addActionListener(new action());
        Back.addActionListener(new action());
        for(int i=0;i<storeOwners.size();i++){
            if(storeOwners.get(i).getUsername().equals(UserName)){
                myStoreOwner=storeOwners.get(i);
                break;
            }
        }
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(label1);
        getContentPane().add(BrandName);
        getContentPane().add(label2);
        getContentPane().add(BrandID);
        getContentPane().add(Submit);
        getContentPane().add(Back);
        getContentPane().add(label3);


    }

    private class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed=e.getSource();

            if(buttonPressed.equals(Submit)){
                Brand object=new Brand();
                object.setName(BrandName.getText());
                object.setBrandID(BrandID.getText());
                suggestBrands.add(object);
                label3.setText("Submit Brand is successful ");

            }

            if(buttonPressed.equals(Back)){
                VStoreOwner object1=new VStoreOwner(myStoreOwner.getUsername());
                object1.setVisible(true);
                dispose();
            }
        }
    }
}