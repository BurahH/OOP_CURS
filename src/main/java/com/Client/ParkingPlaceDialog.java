package com.Client;

import com.API.Service.ParkingService;
import com.API.domain.ParkingPlace;
import com.API.domain.Price;
import com.API.domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/*
 * Класс второго окна
 */
public class ParkingPlaceDialog extends JDialog {
    private int z;
    private int y;

    //Конструктор второго окна
    public ParkingPlaceDialog(JButton button, List<ParkingPlace> parkingPlaces, User user) {
        String x = button.getText();
        int rome = 0;
        try {
            rome = Integer.parseInt(x);

        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        ParkingPlace parkingPlace = parkingPlaces.get(rome - 1);
        Price price = parkingPlace.getPrice();


        z = 0;
        //Делаем невидимым окно
        setVisible(false);
        //Устанавливаем размеры
        setSize(400, 250);
        //Отображаем по центру
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();

        JLabel Node = new JLabel("Взять в аренду " + x + " место");
        String arend = "Аренда " + y + " р/м";
        JLabel Arend = new JLabel(arend);
        String cost = "Общая стоимость " + z + " p";
        JLabel Cost = new JLabel(cost);
        JLabel loginLabel = new JLabel("Количество месяцев аренды :");
        JTextField loginText = new JTextField(2);
        loginText.setText("1");

        System.out.println(loginText.getText());
        JButton enter = new JButton("Взять в аренду");
        JButton reg = new JButton("Рассчитать стоимость");
        setVisible(true);

        GridBagLayout gridBagLayout = new GridBagLayout();
        panel.setLayout(gridBagLayout);
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.gridwidth = 1;
        c1.gridheight = 1;

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 0;
        c2.gridy = 1;
        c2.gridwidth = 1;
        c2.gridheight = 1;

        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 0;
        c3.gridy = 4;
        c3.gridwidth = 1;
        c3.gridheight = 1;

        GridBagConstraints c4 = new GridBagConstraints();
        c4.gridx = 0;
        c4.gridy = 3;
        c4.gridwidth = 1;
        c4.gridheight = 1;

        GridBagConstraints c5 = new GridBagConstraints();
        c5.gridx = 1;
        c5.gridy = 3;
        c5.gridwidth = 1;
        c5.gridheight = 1;

        GridBagConstraints c9 = new GridBagConstraints();
        c9.gridx = 0;
        c9.gridy = 8;
        c9.gridwidth = 1;
        c9.gridheight = 1;

        GridBagConstraints c10 = new GridBagConstraints();
        c10.gridx = 0;
        c10.gridy = 10;
        c10.gridwidth = 1;
        c10.gridheight = 1;

        panel.add(Node, c1);
        panel.add(Arend, c2);
        panel.add(loginLabel, c4);
        panel.add(loginText, c5);
        panel.add(Cost, c3);
        panel.add(enter, c10);
        panel.add(reg, c9);
        add(panel);
        int y = 0;
        reg.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String str = loginText.getText();
                int rom = 0;
                try {
                    rom = Integer.parseInt(str);

                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }

                if (rom >= 0 && rom < 4) {
                    int y = price.getPriceOne();
                    int z = y * rom;
                    String arend = "Аренда " + y + " р/м";
                    String cost = "Общая стоимость " + z + " p";
                    SwingUtilities.invokeLater(() -> Arend.setText(arend));
                    SwingUtilities.invokeLater(() -> Cost.setText(cost));
                }

                if (rom > 3 && rom < 9) {
                    int y = price.getPriceTwo();
                    int z = y * rom;
                    String arend = "Аренда " + y + " р/м";
                    String cost = "Общая стоимость " + z + " p";
                    SwingUtilities.invokeLater(() -> Arend.setText(arend));
                    SwingUtilities.invokeLater(() -> Cost.setText(cost));
                }

                if (rom > 8) {
                    int y = price.getPriceThree();
                    int z = y * rom;
                    String arend = "Аренда " + y + " р/м";
                    String cost = "Общая стоимость " + z + " p";
                    SwingUtilities.invokeLater(() -> Arend.setText(arend));
                    SwingUtilities.invokeLater(() -> Cost.setText(cost));
                }
            }
        });
        enter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String str = Cost.getText();
                String str1 = loginText.getText();
                int month = 0;
                int cost = 0;
                try {
                    //             cost = Integer.parseInt(str);
                    month = Integer.parseInt(str1);

                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }

                if (month >= 0) {
                    ParkingService parkingService = new ParkingService();
                    Boolean parkingBuying = parkingService.buyParkingPlace(parkingPlace, user, month);
                }


                //SwingUtilities.invokeLater(() -> Cost.setText(cost));
                button.setEnabled(false);
                button.setBackground(Color.RED);
                JOptionPane.showMessageDialog(ParkingPlaceDialog.this,"Спасибо за все!");
                setVisible(false);
            }
        });
    }
}