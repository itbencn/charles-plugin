package com.xk72.charles.gui.transaction.actions;

import com.xk72.charles.CharlesContext;
import com.xk72.charles.model.Transaction;

import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class CopyResponseHex extends CopyToClipboardAction {
    private final Transaction transaction;

    public CopyResponseHex(Transaction transaction) {
        super("Copy ResponseHex");
        this.transaction = transaction;
    }

    @Override
    protected Transferable getBody() {
        try {
            return new StringSelection(ActionUtils.bytes2Hex(transaction.getDecodedResponseBody()));
        } catch (Exception ex) {
            CharlesContext.getInstance().error("Failed to CopyResponseHex. Probably not valid.");
            return new StringSelection("CopyResponseHex.getBody.Exception\n" + ex.getMessage());
        }
    }
}
