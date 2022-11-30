package com.xk72.charles.gui.session.popups;

import com.xk72.charles.gui.find.AdvancedFindDialog;
import com.xk72.charles.gui.session.actions.FindInNodesAction;
import com.xk72.charles.gui.transaction.actions.*;
import com.xk72.charles.gui.transaction.viewers.TransactionViewerContentTypeManager;
import com.xk72.charles.model.EditableTransaction;
import com.xk72.charles.model.Transaction;
import com.xk72.net.Location;
import com.xk72.proxy.http.HttpUtils;

import java.awt.event.MouseEvent;

public class TransactionPopupMenu extends AbstractModelNodePopupMenu {
    private final Transaction transaction;

    public TransactionPopupMenu(Transaction transaction, com.xk72.charles.gui.navigator.a<?> abstractC0441a, com.xk72.charles.gui.session.y c0588y, AdvancedFindDialog advancedFindDialog) {
        super(transaction, abstractC0441a, c0588y, advancedFindDialog);
        this.transaction = transaction;
    }

    @Override
    protected void prepare(MouseEvent mouseEvent) {
        prepare(true);
    }

    public void prepare(boolean z) {
        if (a()) {
            return;
        }
        add(new CopyURLAction(this.transaction));
        add(new CopyToClipboardAction$CurlCommand(this.transaction));
        if (this.transaction.getRequestSize() > 0) {
            add(new CopyToClipboardAction$Request(this.transaction));
            add(new CopyRequestHex(this.transaction));
        }
        CopyToClipboardAction$Response response = new CopyToClipboardAction$Response(this.transaction);
        response.setEnabled(this.transaction.getResponseSize() > 0);
        add(response);
        CopyResponseHex responseHex = new CopyResponseHex(this.transaction);
        responseHex.setEnabled(this.transaction.getResponseSize() > 0);
        add(responseHex);
        if (this.transaction.getRequestSize() > 0) {
            add(new SaveBodyAction$Request(this.transaction));
        }
        SaveBodyAction$Response response2 = new SaveBodyAction$Response(this.transaction);
        response2.setEnabled(this.transaction.getResponseSize() > 0);
        add(response2);
        if (Boolean.TRUE.equals(this.transaction.getWebSocket())) {
            add(new SaveWebSocketMessagesAction(this.transaction));
        }
        if (this.findDialog != null) {
            add(new FindInNodesAction(this.findDialog, this.transaction));
        }
        add(new ExportAction(this.transaction));
        addSeparator();
        add(new TransactionComposeAction(this.transaction));
        add(new RepeatAction(this.transaction));
        add(new AdvancedRepeatAction(this.transaction));
        add(new ValidateAction(this.transaction));
        add(new PublishAction(this.transaction));
        if (this.transaction.getInterruptableChannel() != null) {
            add(new TerminateAction(this.transaction));
        }
        addSeparator();
        com.xk72.charles.gui.session.popups.g c0518g = new g(this);
        add(ViewAsTypeMenu.a(c0518g));
        add(ViewAsTypeMenu.b(c0518g));
        addLocationUsingTool(new TransactionViewerContentTypeManager());
        if ((this.navigator instanceof com.xk72.charles.gui.session.tables.a) || (this.navigator instanceof com.xk72.charles.gui.session.trees.h)) {
            addSeparator();
            add(new SwitchStructureNavigatorAction(this.transaction, this.navigator));
        } else if (this.navigator instanceof com.xk72.charles.gui.session.trees.p) {
            addSeparator();
            add(new SwitchSequenceNavigatorAction(this.transaction, this.navigator));
        }
        if (z) {
            addSeparator();
            if (addReorder()) {
                addSeparator();
            }
            addFocus();
            addIgnore();
            addSeparator();
            addClear();
            addClearOthers();
            if (this.transaction.getProtocol() != null && HttpUtils.d(this.transaction.getProtocol())) {
                addSeparator();
                addSSLProxyingSelector();
            }
            addSeparator();
            addSelectingTools();
            addSeparator();
            addUsingTools();
        }
    }

    private boolean a() {
        return this.transaction.getParent() instanceof EditableTransaction;
    }

    @Override
    protected Location toLocation() {
        return this.transaction.toLocation();
    }
}
