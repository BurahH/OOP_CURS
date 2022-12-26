package com.Client;

import com.API.domain.User;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(User user) throws HeadlessException {
        super("Auto-Vision");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JTabbedPane jTabbedPane = new JTabbedPane();

        jTabbedPane.addTab("Парковка", new ParkingPane());
        jTabbedPane.addTab("Личный кабинет", new ProfilePane());
        jTabbedPane.addTab("Пользователи", new JButton("users"));
//        jTabbedPane.addTab("Автомобили", new CarsListPane());


        add(jTabbedPane);
    }
}
