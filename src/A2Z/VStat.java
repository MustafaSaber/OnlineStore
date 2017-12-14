package A2Z;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class VStat extends JFrame{

    public VStat(){
        setTitle("** Payment View **");
        setSize(600,600);


    }

    private class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed=e.getSource();


        }
    }
}