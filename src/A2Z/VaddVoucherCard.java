package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Nardeen on 16-Dec-17.
 */
public class VaddVoucherCard extends JFrame {
    JLabel id = new JLabel("Enter voucher card id :");
    JTextField vId =new JTextField(50);
    JLabel date = new JLabel("Enter voucher card expire date : (Format: dd/MM/yyyy)");
    JTextField vDate =new JTextField(50);
    JLabel value = new JLabel("Enter voucher card value :");
    JTextField vValue =new JTextField(50);
    JButton submit = new JButton("Submit");
    JButton back = new JButton("Back");
    JLabel label = new JLabel("Click on any button !!");
    Administrator myAdmin=new Administrator();

    public VaddVoucherCard(String admin) {
        setTitle("** Add Vocher card View **");
        setSize(600,600);
       // submit.setPreferredSize(new Dimension(550,20));
        submit.addActionListener(new action());
        back.addActionListener(new action());
        for (int i=0;i<system.administrators.size();i++){
            if(system.administrators.get(i).getUsername().equals(admin)){
                myAdmin=system.administrators.get(i);
                break;
            }
        }
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(id);
        getContentPane().add(vId);
        getContentPane().add(date);
        getContentPane().add(vDate);
        getContentPane().add(value);
        getContentPane().add(vValue);
        getContentPane().add(submit);
        getContentPane().add(back);
        getContentPane().add(label);
    }

    private class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed=e.getSource();
            if(buttonPressed.equals(submit)){
                Double vl = Double.parseDouble(vValue.getText());
                Date date = null;
                try {
                    date = new SimpleDateFormat("dd/MM/yyyy").parse(vDate.getText());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                VoucherCard vc = new VoucherCard(vl,date,vId.getText());
                system.voucherCards.add(vc);
                label.setText("Submited successfully");
            }
            if(buttonPressed.equals(back)){
                Vadmin object=new Vadmin(myAdmin.getUsername());
                object.setVisible(true);
            }

        }
    }
}