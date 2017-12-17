package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static A2Z.system.*;

public class Vcart extends JFrame{

    JButton Back = new JButton("Back");
    JButton cvc = new JButton("Check for voucher card");
    JButton CheckOut = new JButton("CheckOut");
    JButton TotalPrice = new JButton("TotalPrice");
    NormalCustomer myCustomer=new NormalCustomer();

    public Vcart(String UserName){
        setTitle("** Cart View **");
        setSize(600,600);
        Back.setPreferredSize(new Dimension(550,20));
        CheckOut.setPreferredSize(new Dimension(550,20));
        TotalPrice.setPreferredSize(new Dimension(550,20));
        cvc.setPreferredSize(new Dimension(550,20));
        Back.addActionListener(new action());
        CheckOut.addActionListener(new action());
        TotalPrice.addActionListener(new action());
        cvc.addActionListener(new action());
        getContentPane().setLayout(new FlowLayout());
        for (int i=0;i<normalCustomers.size();i++){
            if(normalCustomers.get(i).getUsername().equals(UserName)){
                myCustomer=normalCustomers.get(i);
                system.NormalCustomerCon.setNormal(myCustomer);
                break;
            }
        }
        getContentPane().add(TotalPrice);
        getContentPane().add(CheckOut);
        getContentPane().add(cvc);
        getContentPane().add(Back);


        for (Product p : myCustomer.getCart().getProducts())
        {
            getContentPane().add(new JLabel(p.getModel().getName()));
        }
    }

    private class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed=e.getSource();
            if(buttonPressed.equals(TotalPrice)){
                double i = 0;
                if (cartController.getCart() != null && cartController.getCart().getVouchercard() != null)
                    i = cartController.getCart().getVouchercard().getValue();
                String totalPrice = Double.toString(myCustomer.getCart().getTotalPrice()-i);
                JOptionPane.showMessageDialog(null,totalPrice ,"Total price",JOptionPane.WARNING_MESSAGE);
            }
            if(buttonPressed.equals(CheckOut)){
                Vpay object=new Vpay(myCustomer.getUsername());
                object.setVisible(true);
            }
            if(buttonPressed.equals(Back)){
                VnormalCustomer object=new VnormalCustomer(myCustomer.getUsername());
                object.setVisible(true);
            }
            if (buttonPressed.equals(cvc)){
                Random rand = new Random();
                int i = 1;
                if (system.voucherCards.size() > 0)
                    i = rand.nextInt(system.voucherCards.size()*2);
                if (i < system.voucherCards.size()){
                    Cart c = system.NormalCustomerCon.getNormal().getCart();
                    system.cartController.setCart(c);
                    VoucherCard v =system.voucherCards.get(i);
                    system.cartController.AddVoucherCont(v);
                    system.voucherCards.remove(i);
                    JOptionPane.showMessageDialog(null, "Voucher card discount : " + v.getValue() ,"Check voucher card",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "No voucher card available" ,"Check voucher card",JOptionPane.WARNING_MESSAGE);
                }
            }

        }
    }
}