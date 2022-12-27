package com.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParkingPane extends JPanel {

    private int x;
    private Dialog dialog;
    public ParkingPane() {
        super();
        JPanel panel = new JPanel();
        JButton []buttons= new  JButton[24];
        int y=2;
        x=1;
        GridBagLayout gridBagLayout = new GridBagLayout();
        panel.setLayout(gridBagLayout);
        for (int i = 0; i< buttons.length;i++){
            buttons[i]=new JButton(String.valueOf(i+1));
            GridBagConstraints c1 = new GridBagConstraints();
            c1.gridx = x;
            c1.gridy = y;
            c1.gridwidth = 1;
            c1.gridheight = 1;
            panel.add(buttons[i],c1);
            buttons[i].setPreferredSize(new Dimension(100,100));
            x+=1;
            if (x==7){
                x=1;
                y+=1;
            }
        }

        add(panel);
        for (JButton button : buttons) {
            /*System.out*/
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    // Делаем видимым второе окно
                    dialog = new ParkingPlaceDialog(button.getText());
                    dialog.setVisible(true);
                }
            });
        }


    }

}