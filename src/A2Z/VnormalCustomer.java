package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import static A2Z.system.*;

public class VnormalCustomer extends JFrame{
    Vector<JLabel> Product=new Vector<>();
    Vector<JButton> AddToCart=new Vector<>();
    Vector<JButton> ViewModel=new Vector<>();
    JButton MyCart = new JButton("MyCart");
    JButton Logout = new JButton("Logout");
    NormalCustomer myCustomer=new NormalCustomer();

    public VnormalCustomer(String UserName){
        setTitle("** Normal Customer View **");
        setSize(600,600);
        Logout.addActionListener(new action());
        MyCart.addActionListener(new action());
        getContentPane().setLayout(new FlowLayout());
        for (int i=0;i<normalCustomers.size();i++){
            if(normalCustomers.get(i).getUsername().equals(UserName)){
                myCustomer=normalCustomers.get(i);
                break;
            }
        }
        getContentPane().add(MyCart);
        getContentPane().add(Logout);


    }

    private class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed=e.getSource();
            if(buttonPressed.equals(MyCart)){
                Vcart object=new Vcart(myCustomer.getUsername());
                object.setVisible(true);
                dispose();
            }
            if(buttonPressed.equals(Logout)){
                View object=new View();
                object.setVisible(true);
                dispose();
            }

        }
    }
}