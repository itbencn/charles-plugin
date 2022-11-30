package com.xk72.charles.gui.transaction.actions;

import com.xk72.charles.CharlesContext;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URLDecoder;

public abstract class UrlDecode extends AbstractAction {
    private final Component source;

    protected UrlDecode(Component component) {
        super("URL Decode");
        this.source = component;
    }

    protected abstract String getBody();

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String urlDecode = URLDecoder.decode(getBody(), "utf-8");
            urlDecode = urlDecode.replace("},{", "}\n\n{");
            ActionUtils.ContentDialog("URL Decode Result", urlDecode);
        } catch (Exception ex) {
            CharlesContext.getInstance().error("Failed to url decode. Probably not valid.");
        }
    }
}
