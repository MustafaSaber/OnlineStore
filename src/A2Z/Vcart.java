package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static A2Z.system.*;

public class Vcart extends JFrame{

    JButton Back = new JButton("Back");
    JButton CheckOut = new JButton("CheckOut");
    JButton TotalPrice = new JButton("TotalPrice");
    NormalCustomer myCustomer=new NormalCustomer();

    public Vcart(String UserName){
        setTitle("** Cart View **");
        setSize(600,600);
        Back.addActionListener(new action());
        CheckOut.addActionListener(new action());
        TotalPrice.addActionListener(new action());
        getContentPane().setLayout(new FlowLayout());
        for (int i=0;i<normalCustomers.size();i++){
            if(normalCustomers.get(i).getUsername().equals(UserName)){
                myCustomer=normalCustomers.get(i);
                break;
            }
        }
        getContentPane().add(TotalPrice);
        getContentPane().add(CheckOut);
        getContentPane().add(Back);


    }

    private class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed=e.getSource();
            if(buttonPressed.equals(TotalPrice)){

            }
            if(buttonPressed.equals(CheckOut)){
                Vpay object=new Vpay(myCustomer.getUsername());
                object.setVisible(true);
            }
            if(buttonPressed.equals(Back)){
                VnormalCustomer object=new VnormalCustomer(myCustomer.getUsername());
                object.setVisible(true);
            }

        }
    }
}