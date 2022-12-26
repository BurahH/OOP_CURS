package com.Client;

import com.API.Service.RegistrationService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegFrame extends JFrame {
    public RegFrame() throws HeadlessException {
        super("Auto-Vision");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel emailLabel = new JLabel("E-Mail");
        JTextField emailText = new JTextField(20);

        JLabel loginLabel = new JLabel("Логин");
        JTextField loginText = new JTextField(20);

        JLabel passwordLabel1 = new JLabel("Пароль");
        JTextField passwordText1 = new JPasswordField(20);

        JLabel passwordLabel2 = new JLabel("Подтверждение пароля");
        JTextField passwordText2 = new JPasswordField(20);

        JButton reg = new JButton("Зарегистрироваться");
        JButton enter = new JButton("Есть аккаунт?");

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
        c5.gridwidth = 2;
        c5.gridheight = 2;

        GridBagConstraints c6 = new GridBagConstraints();
        c6.gridx = 2;
        c6.gridy = 4;
        c6.gridwidth = 2;
        c6.gridheight = 1;

        GridBagConstraints c7 = new GridBagConstraints();
        c7.gridx = 0;
        c7.gridy = 6;
        c7.gridwidth = 2;
        c7.gridheight = 2;

        GridBagConstraints c8 = new GridBagConstraints();
        c8.gridx = 2;
        c8.gridy = 6;
        c8.gridwidth = 2;
        c8.gridheight = 1;

        GridBagConstraints c9 = new GridBagConstraints();
        c9.gridx = 0;
        c9.gridy = 8;
        c9.gridwidth = 4;
        c9.gridheight = 1;

        GridBagConstraints c10 = new GridBagConstraints();
        c10.gridx = 0;
        c10.gridy = 10;
        c10.gridwidth = 4;
        c10.gridheight = 1;

        panel.add(emailLabel, c1);
        panel.add(emailText, c2);
        panel.add(loginLabel, c3);
        panel.add(loginText, c4);
        panel.add(passwordLabel1, c5);
        panel.add(passwordText1, c6);
        panel.add(passwordLabel2, c7);
        panel.add(passwordText2, c8);
        panel.add(reg, c9);
        panel.add(enter, c10);
        add(panel);

        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailText.getText();
                String username = loginText.getText();
                String password = passwordText1.getText();
                String repeatPassword = passwordText2.getText();
                if(password.equals(repeatPassword)){
                    RegistrationService registrationService = new RegistrationService();
                    boolean response = registrationService.postRegistration(username, password);

                    if (response == true) {
                        setVisible(false);
                        EnterFrame enterFrame = new EnterFrame();
                        enterFrame.setSize(1000, 600);
                        enterFrame.setLocationRelativeTo(null);
                        enterFrame.setVisible(true);
                    }else {
                        JOptionPane.showMessageDialog(RegFrame.this, "Пользователь с таким логином или паролем уже существует!");
                    }
                }
            }
        });

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                EnterFrame enterFrame = new EnterFrame();
                enterFrame.setSize(1000, 600);
                enterFrame.setLocationRelativeTo(null);
                enterFrame.setVisible(true);
            }
        });
    }
}
