package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nardeen on 08-Dec-17.
 */
public class BrandView extends JFrame {
    JTextField BrandName=new JTextField(50);
    JTextField BrandID=new JTextField(50);
    JTextField newBrandName=new JTextField(50);
    JTextField newBrandID=new JTextField(50);
    JButton Add = new JButton("Add");
    JButton Remove = new JButton("Remove");
    JButton Update = new JButton("Update");

    public BrandView(){
        setTitle("** Brand View **");
        setSize(600,600);
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(BrandName);
        getContentPane().add(BrandID);
        getContentPane().add(Add);
        getContentPane().add(Remove);
        getContentPane().add(Update);
        Add.addActionListener(new action());
        Remove.addActionListener(new action());
        Update.addActionListener(new action());
    }

    private class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed=e.getSource();
            BrandController object=new BrandController();
            if(buttonPressed.equals(Add)){object.AddBrandToDB(BrandName.getText(),BrandID.getText());}
            if(buttonPressed.equals(Remove)){object.RemoveBrandToDB(BrandName.getText(),BrandID.getText());}
            if(buttonPressed.equals(Update)){
                object.UpdateBrandToDB(BrandName.getText(),BrandID.getText(),newBrandName.getText(),newBrandID.getText());
            }
        }
    }

}
