package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import static A2Z.system.*;

public class View extends JFrame{
    JLabel label1=new JLabel("Enter Username :");
    JLabel label2=new JLabel("Enter Password :");
    JLabel label3 =new JLabel("Click On Any Button !!");
    Vector<JButton> productsB=new Vector<>();
    Vector<Product> products=new Vector<>();
    JTextField Email=new JTextField(50);
    JTextField Password=new JTextField(50);
    JButton RegisterN = new JButton("Register As Normal User");
    JButton RegisterSO = new JButton("Register As Store Owner");
    JButton Login = new JButton("Login");


    public View(){
        setTitle("** View **");
        setSize(600,600);

        Email.setColumns(40);
        Password.setColumns(40);
        RegisterN.setPreferredSize(new Dimension(550, 20));
        RegisterSO.setPreferredSize(new Dimension(550,20));


        RegisterN.addActionListener(new action());
        RegisterSO.addActionListener(new action());
        Login.addActionListener(new action());

        getContentPane().setLayout(new FlowLayout());

        for(int i=0;i<system.stores.size();i++){
            getContentPane().add(new JLabel(system.stores.get(i).getName()));
            for(int j=0;j<system.stores.get(i).getProducts().size();j++) {
                productsB.add(new JButton(system.stores.get(i).getProducts().get(j).getModel().getName()));
                products.add(system.stores.get(i).getProducts().get(j));
                productsB.get(productsB.size()-1).addActionListener(new action());
                productsB.get( productsB.size()-1).setPreferredSize(new Dimension(550,30));
                getContentPane().add(productsB.get( productsB.size()-1));
            }
        }
        getContentPane().add(label1);
        getContentPane().add(Email);
        getContentPane().add(label2);
        getContentPane().add(Password);
        getContentPane().add(Login);
        getContentPane().add(label3);
        getContentPane().add(RegisterN);
        getContentPane().add(RegisterSO);
    }

    private class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed=e.getSource();

            if(buttonPressed.equals(RegisterN)){
                VregisterNormal object=new VregisterNormal();
                object.setVisible(true);
                dispose();
            }
            if(buttonPressed.equals(RegisterSO)){
                VregisterSO object=new VregisterSO();
                object.setVisible(true);
                dispose();
            }
            if(buttonPressed.equals(Login)){
                boolean flag=false;
                for(int i=0;i<normalCustomers.size();i++){
                    if(normalCustomers.get(i).getUsername().equals(Email.getText()) && normalCustomers.get(i).getPassword().equals(Password.getText())){
                        VnormalCustomer object=new VnormalCustomer(normalCustomers.get(i).getUsername());
                        object.setVisible(true);
                        dispose();
                        flag=true;
                        break;
                    }
                }
                if(flag==false){
                    for(int i=0;i<storeOwners.size();i++){
                        if(storeOwners.get(i).getUsername().equals(Email.getText()) && storeOwners.get(i).getPassword().equals(Password.getText())){
                            VStoreOwner object=new VStoreOwner(storeOwners.get(i).getUsername());
                            object.setVisible(true);
                            dispose();
                            flag=true;
                            break;
                        }
                    }
                }
                if(flag==false){
                    for(int i=0;i<administrators.size();i++){
                        if(administrators.get(i).getUsername().equals(Email.getText()) && administrators.get(i).getPassword().equals(Password.getText())){
                            Vadmin object=new Vadmin(administrators.get(i).getUsername());
                            object.setVisible(true);
                            dispose();
                            flag=true;
                            break;
                        }
                    }
                }
                if (flag==false){
                    label3.setText(" Login fail ");
                }
            }
            for(int i=0;i<productsB.size();i++)
            {
                if (buttonPressed.equals(productsB.get(i))){
                      JOptionPane.showMessageDialog(null,system.ProductCon.printInfoandUpdateView(products.get(i)),"Product info",JOptionPane.WARNING_MESSAGE);
                }
            }
    }
}
}