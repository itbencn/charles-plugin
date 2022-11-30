package com.xk72.charles.gui.transaction.actions;

import com.xk72.charles.CharlesContext;
import com.xk72.charles.model.Transaction;

import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;

public class CopyRequestHex extends CopyToClipboardAction {
    private final Transaction transaction;

    public CopyRequestHex(Transaction transaction) {
        super("Copy RequestHex");
        this.transaction = transaction;
    }

    @Override
    protected Transferable getBody() {
        try {
            return new StringSelection(ActionUtils.bytes2Hex(transaction.getDecodedRequestBody()));
        } catch (Exception ex) {
            CharlesContext.getInstance().error("Failed to CopyRequestHex. Probably not valid.");
            return new StringSelection("CopyRequestHex.getBody.Exception\n" + ex.getMessage());
        }
    }
}
