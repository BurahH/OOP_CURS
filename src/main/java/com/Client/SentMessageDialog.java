package com.Client;

import com.API.domain.User;
import com.API.domain.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SentMessageDialog extends JDialog {

    public JPanel panel = new JPanel(new BorderLayout());
    public JTextArea messageText = new JTextArea(10, 20);
    public JScrollPane jScrollPane = new JScrollPane(messageText);

    public JButton sent = new JButton("Отправить");
    public SentMessageDialog(String title){
        super();
        messageText.setLineWrap(true);
        setTitle(title);
        setVisible(true);
        panel.add(jScrollPane, BorderLayout.CENTER);
        panel.add(sent, BorderLayout.SOUTH);
        add(panel);
        setSize(500, 300);
        setLocationRelativeTo(null);
    }
    public void getMessage(User user, SentMessagesModel sentMessagesModel){
        sent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mess = messageText.getText();
                Message message = new Message();
                message.setMessage(mess);
                sentMessagesModel.sentMessage(user, message);
                setVisible(false);
            }
        });
    }
}
