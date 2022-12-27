package com.Client;

import com.API.domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    public MainFrame(User user) throws HeadlessException {
        super("Auto-Vision");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JTabbedPane jTabbedPane = new JTabbedPane();
        JButton exit = new JButton("Выход");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(exit, BorderLayout.SOUTH);

        jTabbedPane.addTab("Парковка", new ParkingPane(user));
        jTabbedPane.addTab("Главная", panel);
        jTabbedPane.addTab("Личный кабинет", new ProfilePane(user));

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                EnterFrame enterFrame = new EnterFrame();
                enterFrame.setSize(1000, 600);
                enterFrame.setLocationRelativeTo(null);
                enterFrame.setVisible(true);
            }
        });

        add(jTabbedPane);
    }
}
