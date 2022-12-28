package com.Client;

import com.API.Service.ListCarService;
import com.API.domain.Car;
import com.API.domain.User;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class EditCarDialog extends JDialog {
    public JPanel panel = new JPanel();
    public JLabel modelLabel = new JLabel("Модель");
    public JTextField modelText = new JTextField(20);
    public JLabel numberLabel = new JLabel("Номер");
    public MaskFormatter maskFormatter;
    {
        try {
            maskFormatter = new MaskFormatter("U###UU##*");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public JFormattedTextField numberText = new JFormattedTextField(maskFormatter);
    public JButton ok = new JButton("ok");
    public EditCarDialog(String title) {
        super();
        setTitle(title);
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
    public void editCar(User user, ListCarService listCarService, CarsListModel carsListModel, int selectedIndex){
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String model = modelText.getText();
                String number = numberText.getText();
                carsListModel.editCar(listCarService, user, model, number, selectedIndex);
                setVisible(false);
            }
        });
    }
    public void addCar(ListCarService listCarService, CarsListModel carsListModel, User user){
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Car car = new Car();
                String model = modelText.getText();
                String number = numberText.getText();
                car.setModel(model);
                car.setNumber(number);
                listCarService.postCar(user, car);
                carsListModel.addCar(user, car);
                setVisible(false);
            }
        });
    }
}
