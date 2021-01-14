package ua.test.rcp.zabara;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.ViewPart;


import ua.test.rcp.zabara.composite.attachments.MainComposite;

import ua.test.rcp.zabara.jface.Utils;

public class CompositePart extends ViewPart {
    
    public static final String ID = "ua.test.rcp.zabara.view.composite";
    
    private MainComposite mainComposite;

    public MainComposite getMainComposite() {
        return mainComposite;
    }


    @Override
    public void createPartControl(Composite parent) {
        mainComposite = new MainComposite(parent, SWT.NONE);
        IHandlerService service = (IHandlerService) getSite().getService(IHandlerService.class);
        mainComposite.getNewButton().addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Utils.executeCommand("ua.test.rcp.zabara.command.new", service);
            }
        });
        mainComposite.getSaveButton().addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                Utils.executeCommand("ua.test.rcp.zabara.command.save", service);

            }
        });

        mainComposite.getResetButton().addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                Utils.executeCommand("ua.test.rcp.zabara.command.cancel", service);

            }
        });

        mainComposite.getDeleteButton().addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                Utils.executeCommand("ua.test.rcp.zabara.command.delete", service);

            }
        });

    }

    @Override
    public void setFocus() {
        // TODO Auto-generated method stub

    }

}
