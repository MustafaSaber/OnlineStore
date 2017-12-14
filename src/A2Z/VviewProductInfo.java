package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static A2Z.system.*;

public class VviewProductInfo extends JFrame{

    JTextField BrandName=new JTextField(50);
    JButton Back = new JButton("Back");
    NormalCustomer myCustomer=new NormalCustomer();

    public VviewProductInfo(String UserName, String ModelName){
        setTitle("** Product Info View **");
        setSize(600,600);
        Back.addActionListener(new action());
        getContentPane().setLayout(new FlowLayout());
        for (int i=0;i<normalCustomers.size();i++){
            if(normalCustomers.get(i).getUsername().equals(UserName)){
                myCustomer=normalCustomers.get(i);
                break;
            }
        }

        getContentPane().add(Back);


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
        }
    }
}