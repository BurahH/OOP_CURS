package com.Client;

import com.API.Service.ProfileService;
import com.API.domain.Phone;
import com.API.domain.User;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class EditPhoneDialog extends JDialog {
    public JPanel panel = new JPanel();
    public JLabel numberLabel = new JLabel("Номер");
    public MaskFormatter maskFormatter;
    {
        try {
            maskFormatter = new MaskFormatter("8-###-###-##-##");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public JFormattedTextField numberText = new JFormattedTextField(maskFormatter);
    public JButton ok = new JButton("ok");

    public EditPhoneDialog() {
        super();
        numberText.setColumns(20);
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
        GridBagConstraints c5 = new GridBagConstraints();
        c5.gridx = 0;
        c5.gridy = 2;
        c5.gridwidth = 4;
        c5.gridheight = 1;
        panel.add(numberLabel, c1);
        panel.add(numberText, c2);
        panel.add(ok, c5);
        add(panel);
        setSize(500, 300);
        setLocationRelativeTo(null);
    }

    public void editPhone(User user, ProfileService profileService, PhonesListModel phonesListModel, int selectedIndex){
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = numberText.getText();
                if (number != null) {
                    phonesListModel.editPhone(user, number, selectedIndex, profileService);
                }
                setVisible(false);
            }
        });
    }
    public void addPhone(ProfileService profileService, PhonesListModel phonesListModel, User user){
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = numberText.getText();
                if (number != null) {
                    Phone phone = new Phone();
                    phone.setNumber(number);
                    profileService.postPhone(user, phone);
                    phonesListModel.addPhone(user);
                }
                setVisible(false);
            }
        });
    }
}
