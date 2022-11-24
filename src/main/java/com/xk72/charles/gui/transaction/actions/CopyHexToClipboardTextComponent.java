package com.xk72.charles.gui.transaction.actions;

import javax.swing.text.JTextComponent;

public class CopyHexToClipboardTextComponent extends CopyHexToClipboardAction {
    private final JTextComponent component;

    public CopyHexToClipboardTextComponent(JTextComponent component) {
        super(component);
        this.component = component;
    }

    protected String getBody() {
        String selectedText = this.component.getSelectedText();
        return selectedText == null ? this.component.getText() : selectedText;
    }
}
