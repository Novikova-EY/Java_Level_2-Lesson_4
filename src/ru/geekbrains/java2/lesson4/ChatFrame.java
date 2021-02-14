package ru.geekbrains.java2.lesson4;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ChatFrame extends JFrame {
    public ChatFrame () {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        setBounds(200, 200, 400, 500);

        JPanel upPanel = new JPanel();
        add(upPanel, BorderLayout.CENTER);
        upPanel.setLayout(new BorderLayout());

        JTextArea chatOut = new JTextArea();
        chatOut.setLineWrap(true);
        JScrollPane chatOutView = new JScrollPane(chatOut);
        chatOut.setBackground(new Color(238, 229, 222));
        chatOutView.setBorder(new LineBorder(Color.DARK_GRAY, 1));
        chatOutView.setViewportView(chatOut);
        upPanel.add(chatOutView, BorderLayout.CENTER);
        chatOut.setEditable(false);
        upPanel.add(chatOutView, BorderLayout.CENTER);

        JPanel downPanel = new JPanel();
        add(downPanel, BorderLayout.SOUTH);
        downPanel.setLayout(new BorderLayout());

        JTextField chat = new JTextField();
        chat.setBackground(new Color(255, 245, 238));
        chat.setBorder(new LineBorder(Color.DARK_GRAY, 1));
        downPanel.add(chat, BorderLayout.CENTER);
        chat.addActionListener(e -> chatOutput(chat, chatOut));

        JButton enter = new JButton("Enter");
        downPanel.add(enter, BorderLayout.EAST);
        enter.addActionListener(e -> chatOutput(chat, chatOut));

        setVisible(true);
    }

    private void chatOutput(JTextField chat, JTextArea chatOut) {
        if (!chat.getText().isEmpty()) {
            String text = chat.getText();
            chatOut.append(text + "\n");
            chat.setText("");
        }
    }
}

