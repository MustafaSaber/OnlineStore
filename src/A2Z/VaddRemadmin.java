package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static A2Z.system.AdminCon;
import static A2Z.system.administrators;

public class VaddRemadmin extends JFrame{
    JLabel label1=new JLabel("Enter Admin Name :");
    JLabel label2=new JLabel("Enter Admin email :");
    JLabel label3=new JLabel("Enter Admin Username :");
    JLabel label4=new JLabel("Enter Admin Password :");
    JLabel label5=new JLabel("Enter The New Admin Name :");
    JLabel label6=new JLabel("Enter The New Admin Password :");
    JLabel label7 =new JLabel("Click On Any Button !!");
    JTextField AdminName=new JTextField(50);
    JTextField AdminEmail=new JTextField(50);
    JTextField AdminUsername=new JTextField(50);
    JPasswordField AdminPassword=new JPasswordField(50);
    JTextField newAdminUsername=new JTextField(50);
    JTextField newAdminPassword=new JTextField(50);
    JButton Add = new JButton("Add admin");
    JButton Remove = new JButton("Remove admin");
    JButton UpdateN = new JButton("Update admin name");
    JButton UpdateP = new JButton("Update admin password");
    JButton Back = new JButton("Back");
    Administrator myAdmin=new Administrator();

    public VaddRemadmin(String UserName){
        setTitle("** Brand View **");
        setSize(600,600);
        Add.addActionListener(new action());
        Remove.addActionListener(new action());
        UpdateN.addActionListener(new action());
        UpdateP.addActionListener(new action());
        Back.addActionListener(new action());
        for (int i=0;i<administrators.size();i++){
            if(administrators.get(i).getUsername().equals(UserName)){
                myAdmin=administrators.get(i);
                break;
            }
        }
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(label1);
        getContentPane().add(AdminName);
        getContentPane().add(label2);
        getContentPane().add(AdminEmail);
        getContentPane().add(label3);
        getContentPane().add(AdminUsername);
        getContentPane().add(label4);
        getContentPane().add(AdminPassword);
        getContentPane().add(label5);
        getContentPane().add(newAdminUsername);
        getContentPane().add(label6);
        getContentPane().add(newAdminPassword);
        getContentPane().add(Add);
        getContentPane().add(Remove);
        getContentPane().add(UpdateN);
        getContentPane().add(UpdateP);
        getContentPane().add(Back);
        getContentPane().add(label7);


    }

    private class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed=e.getSource();
            boolean flag;
            if(buttonPressed.equals(Add)){
                flag= AdminCon.AddAdminToDBCont(AdminName.getText(),AdminEmail.getText(),AdminUsername.getText(),AdminPassword.getText());
                if(flag){
                    label7.setText("Add admin To DB successfully ");}
                else {
                    label7.setText("Add admin To DB failed ");}
            }
            if(buttonPressed.equals(Remove)){
                flag= AdminCon.RemoveAdminFromDBCont(AdminUsername.getText());
                if(flag){
                    label7.setText("Remove Admin To DB successfully ");}
                else {
                    label7.setText("Remove Admin To DB fail ");}
            }
            if(buttonPressed.equals(UpdateN)){
                flag= AdminCon.UpdateAdminName(AdminUsername.getText(),newAdminUsername.getText());
                if(flag){
                    label7.setText("Update admin name To DB successfully ");}
                else {
                    label7.setText("Update admin name To DB fail ");}
            }
            if(buttonPressed.equals(UpdateP)){
                flag= AdminCon.UpdateAdminPassword(AdminUsername.getText() , newAdminPassword.getText());
                if(flag){
                    label7.setText("Update admin password To DB successfully ");}
                else {
                    label7.setText("Update admin password To DB fail ");}
            }
            if(buttonPressed.equals(Back)){
                Vadmin object1=new Vadmin(myAdmin.getUsername());
                object1.setVisible(true);
            }
        }
    }
}