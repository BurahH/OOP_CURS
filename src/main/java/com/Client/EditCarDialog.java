package com.Client;

import com.API.domain.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditCarDialog extends JDialog {
    public JPanel panel = new JPanel();
    public JLabel modelLabel = new JLabel("Модель");
    public JTextField modelText = new JTextField(20);
    public JLabel numberLabel = new JLabel("Номер");
    public JTextField numberText = new JTextField(20);
    public JButton ok = new JButton("ok");

    public EditCarDialog() {
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
        panel.add(modelLabel, c1);
        panel.add(modelText, c2);
        panel.add(numberLabel, c3);
        panel.add(numberText, c4);
        panel.add(ok, c5);
        add(panel);
        setSize(500, 300);
        setLocationRelativeTo(null);
    }

    public void editCar(CarsListModel carsListModel, int selectedIndex){
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String model = modelText.getText();
                String number = numberText.getText();
                carsListModel.editCar(model, number, selectedIndex);
                setVisible(false);
            }
        });
    }

    public void addCar(CarsListModel carsListModel){
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Car car = new Car();
                String model = modelText.getText();
                String number = numberText.getText();
                car.setModel(model);
                car.setNumber(number);
                carsListModel.addCar(car);
                setVisible(false);
            }
        });
    }
}
