package com.Client;

import com.API.Service.ListCarService;
import com.API.domain.Car;
import com.API.domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarsListPane extends JPanel {
    public CarsListPane(User user) {
        super(new BorderLayout());
        JButton addButton = new JButton("Добавить");
        JButton delButton = new JButton("Удалить");
        JButton editButton = new JButton("Редактировать");

        CarsListModel carsListModel = new CarsListModel();
        ListCarService listCarService = new ListCarService();

        JList<Car> list = new JList<Car>(carsListModel);
        JScrollPane jScrollPane = new JScrollPane(list);
        carsListModel.addCar(user);

        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setText("<html>" + "Марка:   " +
                        ((Car) value).getModel() + "<br/>" +
                        "Номер:   " +
                        ((Car) value).getNumber());
                setHorizontalAlignment(CENTER);
                setBorder(BorderFactory.createLineBorder(Color.black));
                return this;
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditCarDialog editCarDialog = new EditCarDialog("Добавление автомобиля");
                editCarDialog.addCar(listCarService, carsListModel, user);
            }
        });

        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                int selection = JOptionPane.showConfirmDialog(CarsListPane.this, "Удалить автомобиль?",
                        "Подтверждение удаления",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (selection == JOptionPane.OK_OPTION) {
                    carsListModel.deleteCar(listCarService, selectedIndex);
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                EditCarDialog editCarDialog = new EditCarDialog("Редактирование автомобиля");
                editCarDialog.editCar(user, listCarService, carsListModel, selectedIndex);
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(editButton);
        buttonPanel.add(delButton);

        add(addButton, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        add(jScrollPane, BorderLayout.CENTER);

    }
}
