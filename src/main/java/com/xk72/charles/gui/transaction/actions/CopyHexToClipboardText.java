package com.xk72.charles.gui.transaction.actions;

import java.awt.*;

public class CopyHexToClipboardText extends CopyHexToClipboardAction {
    private final String text;

    public CopyHexToClipboardText(String str) {
        super(null);
        this.text = str;
    }

    public CopyHexToClipboardText(String str, Component component) {
        super(component);
        this.text = str;
    }

    protected String getBody() {
        return this.text;
    }
}
