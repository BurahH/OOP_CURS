package com.Client;

import com.API.Service.ProfileService;
import com.API.domain.Message;
import com.API.domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessagesPain extends JPanel {

    private ReceivedMessagesModel receivedMessagesModel = new ReceivedMessagesModel();
    private SentMessagesModel sentMessagesModel = new SentMessagesModel();
    private JList<Message> received = new JList<Message>(receivedMessagesModel);
    private JList<Message> sent = new JList<Message>(sentMessagesModel);
    public MessagesPain(User user){
        super();

        ProfileService profileService = new ProfileService();

        JPanel panel = new JPanel(new BorderLayout());

        JScrollPane lScrollPane = new JScrollPane(received);
        JScrollPane rScrollPane = new JScrollPane(sent);

        JPanel lPanel = new JPanel(new BorderLayout());
        lPanel.add(lScrollPane, BorderLayout.CENTER);
        Button update = new Button("Обновить");
        lPanel.add(update, BorderLayout.SOUTH);

        JPanel rPanel = new JPanel(new BorderLayout());
        rPanel.add(rScrollPane, BorderLayout.CENTER);

        JButton sendButton = new JButton("Отправить сообщение");

        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.addTab("Входящие", lPanel);
        jTabbedPane.addTab("Исходящие", rPanel);
        panel.add(jTabbedPane, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.SOUTH);
        add(panel);

        receivedMessagesModel.addMessage(user);
        sentMessagesModel.addMessage(user);

        received.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setText("<html>" +
                        "<head>" +
                        "<body><div>" +
                        "<p style = \"word-wrap: break-word; width: 500px\";>" +
                        ((Message) value).getAuthor() + ":" + "<br/>" +
                        ((Message) value).getMessage() + "</p></div></body></html>");
                setBorder(BorderFactory.createLineBorder(Color.black));
                return this;
            }
        });
        sent.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setText("<html>" +
                        "<head>" +
                        "<body><div>" +
                        "<p style = \"word-wrap: break-word; width: 500px\";>" +
                        ((Message) value).getMessage() + "</p></div></body></html>");
                setBorder(BorderFactory.createLineBorder(Color.black));
                return this;
            }
        });

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SentMessageDialog sentMessageDialog = new SentMessageDialog("Отправка сообщения Администратору");
                sentMessageDialog.getMessage(user, sentMessagesModel);
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                receivedMessagesModel.addMessage(user);
            }
        });
    }

    public void uplist(User user){
        receivedMessagesModel.addMessage(user);
    }
}
