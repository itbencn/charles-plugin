package com.xk72.charles.gui.transaction.actions;

import com.xk72.charles.CharlesContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class CopyHexToClipboardAction extends AbstractAction {
    private final Component source;

    protected CopyHexToClipboardAction(Component component) {
        super("Copy Hex");
        this.source = component;
    }

    protected abstract String getBody();

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            WaringDialog("URL Decode Result", getBody());
        } catch (Exception exception) {
            CharlesContext.getInstance().error("Failed to url decode. Probably not valid");
        }
    }
    
    public void WaringDialog(String title, String content) {
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
}
