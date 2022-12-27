package com.Client;

import com.API.Service.RegistrationService;
import com.API.Service.ProfileService;
import com.API.domain.Personal;
import com.API.domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPersonalDataDialog extends JDialog {
    JPanel panel = new JPanel();
    JLabel nameLabel = new JLabel("ФИО");
    JTextField nameText = new JTextField(20);
    JLabel ageLabel = new JLabel("Возраст");
    JTextField ageText = new JTextField(20);
    JButton edit = new JButton("Сохранить");

    public EditPersonalDataDialog(){
        super();
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

        panel.add(nameLabel, c1);
        panel.add(nameText, c2);
        panel.add(ageLabel, c3);
        panel.add(ageText, c4);
        panel.add(edit, c5);
        add(panel);
        setSize(500, 300);
        setLocationRelativeTo(null);
    }

    public void editData(User user, Personal personal, JLabel nameLabel, JLabel ageLabel, ProfileService profileService){
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                int age = Integer.parseInt(ageText.getText());
                personal.setAge(age);
                personal.setName(name);
                profileService.postPersonal(user, personal);
                nameLabel.setText("ФИО: " + personal.getName());
                ageLabel.setText("Возраст: " + personal.getAge());
                setVisible(false);
            }
        });
    }

}
