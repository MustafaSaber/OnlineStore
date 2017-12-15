package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static A2Z.system.*;

public class Vproduct extends JFrame{
    JLabel label1=new JLabel("Enter product ID :");
    JLabel label2=new JLabel("Enter product price :");
    JLabel label3=new JLabel("Enter model ID :");
    JLabel label5=new JLabel("Enter brand ID :");
    JLabel label6=new JLabel("Click On Any Button !!");
    JTextField productID =new JTextField(50);
    JTextField productPrice =new JTextField(50);
    JTextField modelID =new JTextField(50);
    JTextField brandID =new JTextField(50);
    JButton Add = new JButton("Add product");
    JButton Back = new JButton("Back");
    StoreOwner myStoreOwner;
    Store myStore;

    public Vproduct(String UserName , Store x){
        setTitle("** Product View **");
        setSize(600,600);
        Add.addActionListener(new action());
        Back.addActionListener(new action());
        myStore = x;
        for(int i=0;i<storeOwners.size();i++){
            if(storeOwners.get(i).getUsername().equals(UserName)){
                myStoreOwner=storeOwners.get(i);
                break;
            }
        }
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(label1);
        getContentPane().add(productID);
        getContentPane().add(label2);
        getContentPane().add(productPrice);
        getContentPane().add(label3);
        getContentPane().add(modelID);
        getContentPane().add(label5);
        getContentPane().add(brandID);
        getContentPane().add(Add);
        getContentPane().add(Back);
        getContentPane().add(label6);

    }

    private class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed=e.getSource();

            boolean flag1=false , flag2 = false , flag3 = true;
            if(buttonPressed.equals(Add)){
                Model temp= new Model();
                Brand tempB = new Brand();
                if(!productID.getText().equals("") && !productPrice.getText().equals("") && !modelID.getText().equals("")  && !brandID.getText().equals("")){
                    for(int i = 0; i < models.size(); i++){
                        if(models.get(i).getModelID().equals(modelID.getText())){
                            temp = models.get(i);
                            flag1 = true;
                            break;
                        }
                    }
                    for(int i = 0; i < brands.size(); i++){
                        if(brands.get(i).getBrandID().equals(brandID.getText())){
                            tempB = brands.get(i);
                            flag2 = true;
                            break;
                        }
                    }
                    for (int i = 0 ; i <myStore.getProducts().size(); i++)
                        if(myStore.getProducts().get(i).getProductID().equals(productID.getText()))
                        {
                            flag3 = false;
                            break;
                        }

                }
                if(flag1 == true && flag2 == true && flag3 ==  true){
                    myStore.AddProduct(new Product(productID.getText(), temp , tempB , Double.parseDouble(productPrice.getText()),myStore));
                    label6.setText("AddStore Store To DB successfully ");
                }
                else {
                    label6.setText("AddStore Store To DB fail ");
                }
            }
            if(buttonPressed.equals(Back)){
                VStoreOwner object1=new VStoreOwner(myStoreOwner.getUsername());
                object1.setVisible(true);
                dispose();
            }
        }
    }
}