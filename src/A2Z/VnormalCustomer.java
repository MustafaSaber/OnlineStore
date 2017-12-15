package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import static A2Z.system.*;

public class VnormalCustomer extends JFrame{
    Vector<JLabel> Product=new Vector<>();
    Vector<JButton> AddToCart=new Vector<>();
    Vector<JButton> ViewModel=new Vector<>();
    JButton MyCart = new JButton("MyCart");
    JButton Logout = new JButton("Logout");
    JButton SM = new JButton("Suggest Model");
    JButton SB = new JButton("Suggest Brand");
    ArrayList<JButton> allproductsB = new ArrayList<>();
    ArrayList<Product> allproducts = new ArrayList<>();
    User myCustomer;

    public VnormalCustomer(String UserName){
        setTitle("** Normal Customer View **");
        setSize(600,600);
        Logout.addActionListener(new action());
        MyCart.addActionListener(new action());
        SM.addActionListener(new action());
        SB.addActionListener(new action());
        getContentPane().setLayout(new FlowLayout());
        for (int i=0;i<normalCustomers.size();i++){
            if(normalCustomers.get(i).getUsername().equals(UserName)){
                myCustomer=normalCustomers.get(i);
                break;
            }
        }
        getContentPane().add(SM);
        getContentPane().add(SB);
        getContentPane().add(MyCart);
        getContentPane().add(Logout);

        for(int i = 0 ; i < system.stores.size(); i++){
            if(stores.get(i).getProducts().size()>0)
                getContentPane().add(new JLabel("Store: " + stores.get(i).getName()));
            for(int j = 0; j < stores.get(i).getProducts().size(); j++){
                allproductsB.add(new JButton(stores.get(i).getProducts().get(j).getModel().getName()));
                allproducts.add(stores.get(i).getProducts().get(j));
                getContentPane().add(allproductsB.get(allproducts.size()-1));
            }
        }
        for(int i = 0; i < allproductsB.size(); i++) allproductsB.get(i).addActionListener(new action());


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
            if(buttonPressed.equals(SM)){
                VsuggestM object=new VsuggestM(myCustomer.getUsername());
                object.setVisible(true);
                dispose();
            }
            if(buttonPressed.equals(SB)){
                VsuggestB object=new VsuggestB(myCustomer.getUsername());
                object.setVisible(true);
                dispose();
            }
            for(int i = 0 ; i < allproductsB.size(); i++){
                if(buttonPressed.equals(allproductsB.get(i))){
                    VviewProductInfo ob = new VviewProductInfo(myCustomer.getUsername(), allproducts.get(i));
                    ob.setVisible(true);
                    dispose();
                }
            }

        }
    }
}