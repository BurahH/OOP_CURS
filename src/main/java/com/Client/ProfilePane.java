package com.Client;

import com.API.domain.User;

import javax.swing.*;
import java.awt.*;

public class ProfilePane extends JPanel{
    public ProfilePane(User user){
        super();
        setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.LEFT);
        tabbedPane.addTab("Личные данные", new PersonalDataPane(user));
        tabbedPane.addTab("Безопасность", new JButton("БЗ"));
        tabbedPane.addTab("Автомобили", new CarsListPane());
        add(tabbedPane);

    }
}
