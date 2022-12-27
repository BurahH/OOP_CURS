package com.Client;

import com.API.domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainFrame extends JFrame {
    public AdminMainFrame(User user) throws HeadlessException {
        super("Auto-Vision");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JTabbedPane jTabbedPane = new JTabbedPane();
        JButton exit = new JButton("Выход");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(exit, BorderLayout.SOUTH);

        jTabbedPane.addTab("Парковка", new ParkingPane());
        jTabbedPane.addTab("Пользователи", panel);
        jTabbedPane.addTab("Сообщения", new JButton("messages"));

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
