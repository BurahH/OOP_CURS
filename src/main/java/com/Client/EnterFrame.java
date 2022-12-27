package com.Client;

import com.API.Service.ProfileService;
import com.API.Service.RegistrationService;
import com.API.domain.Personal;
import com.API.domain.User;
import com.Server.service.PersonalService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterFrame extends JFrame {
    public EnterFrame() throws HeadlessException {
        super("Auto-Vision");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel loginLabel = new JLabel("Логин");
        JTextField loginText = new JTextField(20);
        JLabel passwordLabel = new JLabel("Пароль");
        JTextField passwordText = new JPasswordField(20);
        JButton enter = new JButton("Войти");
        JButton reg = new JButton("Нет аккаунта?");
        setVisible(true);
        GridBagLayout gridBagLayout = new GridBagLayout();
        panel.setLayout(gridBagLayout);
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.gridwidth = 2;
        c1.gridheight = 2;
        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 2;
        c2.gridy = 0;
        c2.gridwidth = 2;
        c2.gridheight = 1;
        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 0;
        c3.gridy = 2;
        c3.gridwidth = 2;
        c3.gridheight = 2;
        GridBagConstraints c4 = new GridBagConstraints();
        c4.gridx = 2;
        c4.gridy = 2;
        c4.gridwidth = 2;
        c4.gridheight = 1;
        GridBagConstraints c5 = new GridBagConstraints();
        c5.gridx = 0;
        c5.gridy = 4;
        c5.gridwidth = 4;
        c5.gridheight = 1;
        GridBagConstraints c6 = new GridBagConstraints();
        c6.gridx = 0;
        c6.gridy = 6;
        c6.gridwidth = 4;
        c6.gridheight = 1;
        panel.add(loginLabel, c1);
        panel.add(loginText, c2);
        panel.add(passwordLabel, c3);
        panel.add(passwordText, c4);
        panel.add(enter, c5);
        panel.add(reg, c6);
        add(panel);

        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                RegFrame regFrame = new RegFrame();
                regFrame.setSize(1000, 600);
                regFrame.setLocationRelativeTo(null);
                regFrame.setVisible(true);
            }
        });

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = loginText.getText();
                String password = passwordText.getText();
                RegistrationService registrationService = new RegistrationService();
                User user = registrationService.postLogin(username, password);

                if (user == null) {
                    JOptionPane.showMessageDialog(EnterFrame.this, "Неверная пара логин-пароль!");
                } else {
//                    ProfileService profileService = new ProfileService();
//                    Personal personal = profileService.getPersonal(user);
//                    if (personal == null){
//                        personal.setAge(0);
//                        personal.setName("");
//                        personal.setUser(user);
//                    }
                    setVisible(false);
                    MainFrame mainFrame = new MainFrame(user);
                    mainFrame.setSize(1000, 600);
                    mainFrame.setLocationRelativeTo(null);
                    mainFrame.setVisible(true);
                }
            }
        });

    }
}
