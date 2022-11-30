package com.xk72.charles.gui.transaction.actions;

import javax.swing.*;
import java.awt.*;

public class ActionUtils {
    public static void ContentDialog(String title, String content) {
        JFrame JFrame = new JFrame(title);
        JFrame.setPreferredSize(new Dimension(800, 500));
        JTextArea textArea = new JTextArea();
        textArea.setText(content + "\n");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane jScrollPane = new JScrollPane(textArea);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jScrollPane.setAutoscrolls(false);
        JFrame.setContentPane(jScrollPane);
        JFrame.pack();
        JFrame.setVisible(true);
    }

    public static String bytes2Hex(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return "";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            String temp = null;
            for (int i = 0; i < bytes.length; i++) {
                temp = Integer.toHexString(bytes[i] & 0xFF);
                if (temp.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(temp);
            }
            return stringBuffer.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
}
