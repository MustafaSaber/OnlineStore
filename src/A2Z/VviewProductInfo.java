package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static A2Z.system.*;

public class VviewProductInfo extends JFrame{

    JTextField BrandName=new JTextField(50);
    JButton Back = new JButton("Back");
    JButton AddToCart = new JButton("Add To Cart");
    User myCustomer;
    Product product = new Product();

    public VviewProductInfo(String UserName, Product p){
        product = p;
        setTitle("** Product Info View **");
        setSize(800,400);
        Back.addActionListener(new action());
        AddToCart.addActionListener(new action());
        getContentPane().setLayout(new FlowLayout());
        for (int i=0;i<normalCustomers.size();i++){
            if(normalCustomers.get(i).getUsername().equals(UserName)){
                myCustomer=normalCustomers.get(i);
                system.NormalCustomerCon.setNormal(normalCustomers.get(i));
                break;
            }
        }
        getContentPane().add(Back);
        getContentPane().add(new JLabel(system.ProductCon.printInfoandUpdateView(p)));
        getContentPane().add(AddToCart);
    }

    private class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed=e.getSource();
            if(buttonPressed.equals(Back)){
                VnormalCustomer object1=new VnormalCustomer(myCustomer.getUsername());
                object1.setVisible(true);
                dispose();
            }
            if (buttonPressed.equals(AddToCart))
            {
                system.NormalCustomerCon.getNormal().getCart().addProuct(product);
            }
        }
    }
}