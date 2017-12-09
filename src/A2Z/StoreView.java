package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nardeen on 08-Dec-17.
 */
public class StoreView extends JFrame{
    JTextField StoreName=new JTextField(50);
    JTextField StoreID=new JTextField(50);
    JTextField newStoreName=new JTextField(50);
    JTextField newStoreID=new JTextField(50);
    JButton Add = new JButton("Add");
    JButton Remove = new JButton("Remove");
    JButton Update = new JButton("Update");

    public StoreView(){
        setTitle("** Brand View **");
        setSize(600,600);
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(StoreName);
        getContentPane().add(StoreID);
        getContentPane().add(newStoreName);
        getContentPane().add(newStoreID);
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
            StoreController object=new StoreController();
            if(buttonPressed.equals(Add)){
                object.AddStoreToDB(StoreName.getText(),StoreID.getText());
            }
            if(buttonPressed.equals(Remove)){
                object.RemoveStoreToDB(StoreName.getText(),StoreID.getText());
            }
            if (buttonPressed.equals(Update)){
                object.UpdateStoreToDB(StoreName.getText(),StoreID.getText(),newStoreName.getText(),newStoreID.getText());
            }
        }
    }
}
