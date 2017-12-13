package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static A2Z.system.storeOwners;

public class VregisterSO extends JFrame{
    JLabel label1=new JLabel("Enter Name :");
    JLabel label2=new JLabel("Enter email :");
    JLabel label3=new JLabel("Enter Username :");
    JLabel label4=new JLabel("Enter Password :");
    JLabel label5 =new JLabel("Click On Any Button !!");
    JTextField Name =new JTextField(50);
    JTextField Email =new JTextField(50);
    JTextField Username =new JTextField(50);
    JTextField Password =new JTextField(50);

    JButton Register = new JButton("Register");
    JButton Login = new JButton("Login");

    public VregisterSO(){
        setTitle("** Register Normal View **");
        setSize(600,600);
        Login.addActionListener(new action());
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(label1);
        getContentPane().add(Name);
        getContentPane().add(label2);
        getContentPane().add(Email);
        getContentPane().add(label3);
        getContentPane().add(Username);
        getContentPane().add(label4);
        getContentPane().add(Password);
        getContentPane().add(label5);
        getContentPane().add(Register);
        getContentPane().add(Login);
        getContentPane().add(label5);
    }

    private class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed=e.getSource();
            if(buttonPressed.equals(Register)){
                StoreOwner object=new StoreOwner(Name.getText(), Email.getText(), Username.getText(), Password.getText());
                storeOwners.add(object);
                if(Name.getText()=="" || Email.getText()=="" || Username.getText()=="" || Password.getText()=="" ){
                    label5.setText(" Registration fail ");}
                else {
                    label5.setText(" Registration successful ");}
            }
            if(buttonPressed.equals(Login)){
                VStoreOwner object1=new VStoreOwner(Username.getText());
                object1.setVisible(true);
                dispose();
            }
        }
    }
}