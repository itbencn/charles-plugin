package com.xk72.charles.gui.transaction.popups;

import com.xk72.charles.gui.session.popups.TransactionPopupMenu;
import com.xk72.charles.gui.transaction.actions.*;
import com.xk72.charles.model.Transaction;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.text.JTextComponent;

public class TransactionViewerPopupMenu extends TransactionPopupMenu {
    public TransactionViewerPopupMenu(Transaction transaction) {
        super(transaction, null, null, null);
    }

    @Override
    protected void prepare(MouseEvent mouseEvent) {
        Component component = (Component) mouseEvent.getSource();
        if (component instanceof JTable) {
            JTable jTable = (JTable) component;
            Point point = mouseEvent.getPoint();
            int rowAtPoint = jTable.rowAtPoint(point);
            int columnAtPoint = jTable.columnAtPoint(point);
            Object valueAt;
            if (rowAtPoint >= 0 && columnAtPoint >= 0 && (valueAt = jTable.getValueAt(rowAtPoint, columnAtPoint)) != null) {
                add(new CopyToClipboardAction$Text(valueAt.toString()));
                if (valueAt instanceof String) {
                    add(new Base64DecodeAction$Text((String) valueAt, component));
                } else {
                    add(new CopyHexToClipboardText((String) valueAt, component));
                }
                addSeparator();
            }
        } else if (component instanceof JTextComponent) {
            add(new CopyToClipboardAction$TextComponent((JTextComponent) component));
            add(new Base64DecodeAction$TextComponent((JTextComponent) component));
            add(new CopyHexToClipboardTextComponent((JTextComponent) component));
            addSeparator();
        }
        super.prepare(false);
    }
}
