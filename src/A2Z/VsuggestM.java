package A2Z;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static A2Z.system.normalCustomers;
import static A2Z.system.storeOwners;
import static A2Z.system.suggestModels;

public class VsuggestM extends JFrame{
    JLabel label1=new JLabel("Enter Model Name :");
    JLabel label2=new JLabel("Enter Model ID :");
    JLabel label3 =new JLabel("Click On Any Button !!");
    JTextField ModelName =new JTextField(50);
    JTextField ModelID =new JTextField(50);
    JButton Submit = new JButton("Submit Model");
    JButton Back = new JButton("Back");
    User myStoreOwner;//=new StoreOwner();

    public VsuggestM(String UserName){
        setTitle("** Suggest Model View **");
        setSize(600,600);
        Submit.addActionListener(new action());
        Back.addActionListener(new action());
        Boolean flag = false;
        for(int i=0;i<storeOwners.size();i++){
            if(storeOwners.get(i).getUsername().equals(UserName)){
                myStoreOwner=storeOwners.get(i);
                flag = true;
                break;
            }
        }
        if(flag == false){
            for(int i=0;i<system.normalCustomers.size();i++){
                if(normalCustomers.get(i).getUsername().equals(UserName)){
                    myStoreOwner=normalCustomers.get(i);
                    break;
                }
            }
        }

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(label1);
        getContentPane().add(ModelName);
        getContentPane().add(label2);
        getContentPane().add(ModelID);
        getContentPane().add(Submit);
        getContentPane().add(Back);
        getContentPane().add(label3);


    }

    private class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed=e.getSource();

            if(buttonPressed.equals(Submit)){
                Model object=new Model();
                object.setName(ModelName.getText());
                object.setModelID(ModelID.getText());
                suggestModels.add(object);
                label3.setText("Submit Brand is successful ");

            }

            if(buttonPressed.equals(Back)){
                if(myStoreOwner instanceof StoreOwner ) {
                    VStoreOwner object1 = new VStoreOwner(myStoreOwner.getUsername());
                    object1.setVisible(true);
                    dispose();
                }
                else if(myStoreOwner instanceof NormalCustomer)
                {
                    VnormalCustomer object1 = new VnormalCustomer(myStoreOwner.getUsername());
                    object1.setVisible(true);
                    dispose();
                }
            }
        }
    }
}