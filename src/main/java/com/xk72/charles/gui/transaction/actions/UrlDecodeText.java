package com.xk72.charles.gui.transaction.actions;

import java.awt.*;

public class UrlDecodeText extends UrlDecode {
    private final String text;

    public UrlDecodeText(String str) {
        super(null);
        this.text = str;
    }

    public UrlDecodeText(String str, Component component) {
        super(component);
        this.text = str;
    }

    @Override
    protected String getBody() {
        return this.text;
    }
}