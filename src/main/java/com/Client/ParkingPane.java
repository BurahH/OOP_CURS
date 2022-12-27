package com.Client;

import com.API.Service.ParkingService;
import com.API.domain.ParkingPlace;
import com.API.domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

public class ParkingPane extends JPanel {
    private int x;
    private Dialog dialog;

    public ParkingPane(User user) {
        super();
        if (x == 7) {

        }
        ParkingService parkingService = new ParkingService();
        List<ParkingPlace> parkingPlaces = parkingService.getParkingPlace();
        Collections.sort(parkingPlaces);

        JPanel panel = new JPanel();
        JButton[] buttons = new JButton[24];
        int y = 2;
        x = 1;
        GridBagLayout gridBagLayout = new GridBagLayout();
        panel.setLayout(gridBagLayout);
        for (ParkingPlace parkingPlace : parkingPlaces) {

            long q = parkingPlace.getNumber();
            int i = Math.toIntExact(q);
            boolean danet = parkingPlace.checkEndTime();

            buttons[i - 1] = new JButton(String.valueOf(i));
            GridBagConstraints c1 = new GridBagConstraints();
            c1.gridx = x;
            c1.gridy = y;
            c1.gridwidth = 1;
            c1.gridheight = 1;
            panel.add(buttons[i - 1], c1);
            buttons[i - 1].setPreferredSize(new Dimension(100, 100));
            if (!danet) {
                buttons[i - 1].setBackground(Color.GREEN);
            } else {
                buttons[i - 1].setEnabled(false);
                buttons[i - 1].setBackground(Color.RED);
            }
            x += 1;
            if (x == 7) {
                x = 1;
                y += 1;
            }
        }
        add(panel);

        for (JButton button : buttons) {

            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    // Делаем видимым второе окно
                    dialog = new ParkingPlaceDialog(button,parkingPlaces, user);
                    dialog.setVisible(true);
                }
            });
        }
    }

}