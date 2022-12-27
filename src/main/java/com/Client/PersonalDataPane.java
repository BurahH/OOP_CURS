package com.Client;

import com.API.Service.ProfileService;
import com.API.domain.Personal;
import com.API.domain.Phone;
import com.API.domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PersonalDataPane extends JPanel {

    public PersonalDataPane(User user){
        super(new BorderLayout());

        ProfileService profileService = new ProfileService();
        Personal personal = profileService.getPersonal(user);

        JPanel panel = new JPanel();
        JLabel nameLabel = new JLabel("ФИО: (Нет данных)");
        JLabel ageLabel = new JLabel("Возраст: (Нет данных)");
        JButton edit = new JButton("Редактировать");

        if (personal != null){
            nameLabel.setText("ФИО: " + personal.getName());
            ageLabel.setText("Возраст: " + personal.getAge());
        } else{
            personal = new Personal();
        }

        setVisible(true);
        GridBagLayout gridBagLayout = new GridBagLayout();
        panel.setLayout(gridBagLayout);
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.gridwidth = 4;
        c1.gridheight = 1;

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 0;
        c2.gridy = 2;
        c2.gridwidth = 4;
        c2.gridheight = 1;

        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 0;
        c3.gridy = 4;
        c3.gridwidth = 4;
        c3.gridheight = 1;

        panel.add(nameLabel, c1);
        panel.add(ageLabel, c2);
        panel.add(edit, c3);

        JPanel panel1 = new JPanel();

        JButton addButton = new JButton("Добавить номер телефона");
        JButton delButton = new JButton("Удалить");
        JButton editButton = new JButton("Редактировать номер");

        PhonesListModel phonesListModel = new PhonesListModel();
        JList<Phone> list = new JList<Phone>(phonesListModel);

        List<Phone> list0 = profileService.getPhone(user);
        for(Phone phone : list0){
            phonesListModel.addPhone(user);
        }

        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setText(((Phone) value).getNumber());
                setHorizontalAlignment(CENTER);
                return this;
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditPhoneDialog editPhoneDialog = new EditPhoneDialog();
                editPhoneDialog.addPhone(profileService, phonesListModel, user);
            }
        });

        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                int selection = JOptionPane.showConfirmDialog(panel1, "Удалить автомобиль?",
                        "Подтверждение удаления",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (selection == JOptionPane.OK_OPTION) {
                    phonesListModel.deletePhone(selectedIndex, profileService);
                }

            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                EditPhoneDialog editPhoneDialog = new EditPhoneDialog();
                editPhoneDialog.editPhone(user, profileService, phonesListModel, selectedIndex);
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(editButton);
        buttonPanel.add(delButton);

        JPanel lp = new JPanel();
        lp.setLayout(gridBagLayout);
        lp.add(new JLabel("Номера:"), c1);
        lp.add(list, c2);

        panel1.setLayout(new BorderLayout());
        panel1.add(addButton, BorderLayout.CENTER);
        panel1.add(lp, BorderLayout.NORTH);
        panel1.add(buttonPanel, BorderLayout.SOUTH);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel, panel1);
        splitPane.setDividerLocation(300);
        add(splitPane);

        Personal finalPersonal = personal;
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditPersonalDataDialog editPersonalDataDialog = new EditPersonalDataDialog();
                editPersonalDataDialog.editData(user, finalPersonal, nameLabel, ageLabel, profileService);
            }
        });

    }
}
