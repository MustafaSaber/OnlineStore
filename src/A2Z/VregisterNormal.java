package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static A2Z.system.normalCustomers;

public class VregisterNormal extends JFrame{
    JLabel label1=new JLabel("Enter Name :");
    JLabel label2=new JLabel("Enter email :");
    JLabel label3=new JLabel("Enter Username :");
    JLabel label4=new JLabel("Enter Password :");
    JLabel label5 =new JLabel("Click On Any Button !!");
    JTextField Name =new JTextField(50);
    JTextField Email =new JTextField(50);
    JTextField Username =new JTextField(50);
    JPasswordField Password =new JPasswordField(50);
    JButton Register = new JButton("Register");
    JButton Login = new JButton("Login");
    boolean flagR = false;

    public VregisterNormal(){
        setTitle("** Register Normal View **");
        setSize(600,600);
        Register.addActionListener(new action());
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
                if(!Name.getText().equals("") && !Email.getText().equals("") && !Username.getText().equals("") && !Password.getText().equals(""))
                {
                    if(!system.CheckForNormalCustmer(Username.getText()) && !system.CheckForStoreOwner(Username.getText()) && !system.CheckForAdmin(Username.getText()))
                    {
                        NormalCustomer object=new NormalCustomer(Name.getText(), Email.getText(), Username.getText(), Password.getText());
                        normalCustomers.add(object);
                        label5.setText(" Registration successful ");
                        flagR = true;
                    }
                     else
                        JOptionPane.showMessageDialog(null,"Username is already taken !! Please enter another username" ,"Error",JOptionPane.WARNING_MESSAGE);
                }
                else
                    label5.setText(" Registration fail");
            }
            if(buttonPressed.equals(Login)){
                if(flagR && system.CheckForNormalCustmer(Username.getText())){
                    label5.setText(" Login successful ");
                    VnormalCustomer object1 = new VnormalCustomer(Username.getText());
                    object1.setVisible(true);
                    dispose();
                }
                else
                    label5.setText("Login failed");
            }
        }
    }
}