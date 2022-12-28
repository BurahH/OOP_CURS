package com.Client;

import com.API.domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfilePane extends JPanel{
    public ProfilePane(User user){
        super();
        setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.LEFT);
        tabbedPane.addTab("Личные данные", new PersonalDataPane(user));

        tabbedPane.addTab("Безопасность", new JButton("sec"));
        tabbedPane.addTab("Автомобили", new CarsListPane(user));
        tabbedPane.addTab("Сообщения", new MessagesPain(user));

        add(tabbedPane);

    }
}
