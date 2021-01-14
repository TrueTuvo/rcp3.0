package ua.test.rcp.zabara.parts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.ViewPart;

import ua.test.rcp.zabara.Utils;
import ua.test.rcp.zabara.composite.attachments.MainComposite;

/**
 * 
 * View, which is responsible for displaying the user menu. This includes fields for editing data of the selected
 * Person, and CRUD buttons.
 * 
 * @author SZabara
 *
 */
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
                Utils.executeCommand(Utils.COMMAND_NEW, service);

            }
        });
        mainComposite.getSaveButton().addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                Utils.executeCommand(Utils.COMMAND_SAVE, service);

            }
        });

        mainComposite.getResetButton().addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                Utils.executeCommand(Utils.COMMAND_CANCEL, service);

            }
        });

        mainComposite.getDeleteButton().addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                Utils.executeCommand(Utils.COMMAND_DELETE, service);

            }
        });

    }

    @Override
    public void setFocus() {
        mainComposite.setFocus();

    }

}
