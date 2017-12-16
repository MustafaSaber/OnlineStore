package A2Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import static A2Z.system.storeOwners;


public class VStoreOwner extends JFrame{
    JLabel label =new JLabel("Click On Any Button !!");
    JLabel EStat = new JLabel();
    JLabel Top = new JLabel();
    Vector<JButton> view=new Vector<>();

    JButton AddStore = new JButton("Add Store");
    JButton RemoveStore = new JButton("Remove Store");
    JButton SuggestModel = new JButton("Suggest Model");
    JButton SuggestBrand = new JButton("Suggest Brand");
    JButton top = new JButton("Most Viewied Product In Each Store");
    JButton Estat = new JButton("Number Of Views For Each Product");
    JButton Logout = new JButton("Logout");
    StoreOwner myStoreOwner;//=new StoreOwner();

    public VStoreOwner(String UserName){
        setTitle("** Store Owner View **");
        setSize(600,600);
        AddStore.setPreferredSize(new Dimension(550, 20));
        RemoveStore.setPreferredSize(new Dimension(550, 20));
        SuggestBrand.setPreferredSize(new Dimension(550, 20));
        SuggestModel.setPreferredSize(new Dimension(550, 20));
        Logout.setPreferredSize(new Dimension(550, 20));
        Estat.setPreferredSize(new Dimension(550, 20));
        top.setPreferredSize(new Dimension(550, 20));

        AddStore.addActionListener(new action());
        RemoveStore.addActionListener(new action());
        SuggestModel.addActionListener(new action());
        SuggestBrand.addActionListener(new action());
        Logout.addActionListener(new action());
        Estat.addActionListener(new action());
        top.addActionListener(new action());
        for(int i=0;i<storeOwners.size();i++){
            if(storeOwners.get(i).getUsername().equals(UserName)){
                myStoreOwner=storeOwners.get(i);
                break;
            }
        }

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(AddStore);
        getContentPane().add(RemoveStore);
        getContentPane().add(SuggestModel);
        getContentPane().add(SuggestBrand);
        getContentPane().add(Estat);
        getContentPane().add(top);
        getContentPane().add(Logout);
        getContentPane().add(label);

        for (int i = 0; i < myStoreOwner.getStores().size(); i++) {
            view.add(new JButton(myStoreOwner.getStores().get(i).getName()));
            view.get(i).setPreferredSize(new Dimension(550, 20));
            getContentPane().add(view.get(i));
        }

        for(int i = 0 ; i < view.size(); i++)
            view.get(i).addActionListener(new action());

        for (int i = 0; i < myStoreOwner.getStores().size(); i++) {
            if(myStoreOwner.getStores().get(i).getProducts().size()>0)
                getContentPane().add(new JLabel("// Store " + (i+1) + " >> products: "));
            for (int j = 0 ; j < myStoreOwner.getStores().get(i).getProducts().size(); j++)
            //view.add(new JButton(myStoreOwner.getStores().get(i).getName()));
            getContentPane().add(new JLabel(myStoreOwner.getStores().get(i).getProducts().get(j).getModel().getName()));
        }
    }

    private class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed=e.getSource();

            if(buttonPressed.equals(AddStore)){
                Vstore object=new Vstore(myStoreOwner.getUsername());
                object.setVisible(true);
                dispose();
            }
            if(buttonPressed.equals(RemoveStore)){
                Vstore object=new Vstore(myStoreOwner.getUsername());
                object.setVisible(true);
                dispose();
            }
            if(buttonPressed.equals(SuggestModel)){
                VsuggestM object=new VsuggestM(myStoreOwner.getUsername());
                object.setVisible(true);
                dispose();
            }
            if(buttonPressed.equals(SuggestBrand)){
                VsuggestB object=new VsuggestB(myStoreOwner.getUsername());
                object.setVisible(true);
                dispose();
            }

            if(buttonPressed.equals(Logout)){
                View object=new View();
                object.setVisible(true);
                dispose();
            }
            if (buttonPressed.equals(Estat))
            {
                String title = "";
                if(myStoreOwner instanceof StoreOwnerRegular)
                    title = "Error";
                else
                    title = "Number of views for each product";

                JOptionPane.showMessageDialog(null,myStoreOwner.NumberOfViewsForEachProduct(),title,JOptionPane.WARNING_MESSAGE);
            }
            if (buttonPressed.equals(top))
            {
                String title = "";
                if(myStoreOwner instanceof StoreOwnerRegular)
                    title = "Error";
                else
                    title = "Most viewied product in each store";

                JOptionPane.showMessageDialog(null,myStoreOwner.MostViewiedProductInEachStore(),title,JOptionPane.WARNING_MESSAGE);
            }
            for(int i = 0 ; i < view.size(); i++)
            {
                if(buttonPressed.equals(view.get(i)))
                {
                    Vproduct object=new Vproduct(myStoreOwner.getName(), myStoreOwner.getStores().get(i));
                    object.setVisible(true);
                    dispose();
                }
            }
        }
    }
}