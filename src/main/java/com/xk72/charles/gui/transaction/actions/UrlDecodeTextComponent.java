package com.xk72.charles.gui.transaction.actions;

import javax.swing.text.JTextComponent;

public class UrlDecodeTextComponent extends UrlDecode {
    private final JTextComponent component;

    public UrlDecodeTextComponent(JTextComponent jTextComponent) {
        super(jTextComponent);
        this.component = jTextComponent;
    }

    @Override
    protected String getBody() {
        String selectedText = this.component.getSelectedText();
        if (selectedText == null) {
            selectedText = this.component.getText();
        }
        return selectedText;
    }
}
