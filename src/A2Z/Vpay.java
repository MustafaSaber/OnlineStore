package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static A2Z.system.*;

public class Vpay extends JFrame{
    JLabel AddAddress=new JLabel("Enter your address");
    JLabel AddCardID=new JLabel("or Enter your Card ID");
    JTextField Address=new JTextField(50);
    JTextField CardID=new JTextField(50);
    JButton Submit = new JButton("Submit");
    JButton Back = new JButton("Back");
    NormalCustomer myCustomer=new NormalCustomer();

    public Vpay(String UserName){
        setTitle("** Payment View **");
        setSize(600,600);
        Submit.addActionListener(new action());
        Back.addActionListener(new action());
        getContentPane().setLayout(new FlowLayout());
        for (int i=0;i<normalCustomers.size();i++){
            if(normalCustomers.get(i).getUsername().equals(UserName)){
                myCustomer=normalCustomers.get(i);
                break;
            }
        }
        getContentPane().add(AddAddress);
        getContentPane().add(Address);
        getContentPane().add(AddCardID);
        getContentPane().add(CardID);
        getContentPane().add(Submit);
        getContentPane().add(Back);

    }

    private class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed=e.getSource();
            if(buttonPressed.equals(Submit)){
                VnormalCustomer object=new VnormalCustomer(myCustomer.getUsername());
                object.setVisible(true);
                dispose();
            }
            if(buttonPressed.equals(Back)){
                Vcart object=new Vcart(myCustomer.getUsername());
                object.setVisible(true);
                dispose();
            }

        }
    }
}