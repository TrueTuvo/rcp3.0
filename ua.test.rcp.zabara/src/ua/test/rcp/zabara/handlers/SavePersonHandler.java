package ua.test.rcp.zabara.handlers;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import ua.test.rcp.zabara.CompositePart;
import ua.test.rcp.zabara.TableViewerPart;
import ua.test.rcp.zabara.jface.ModelProvider;
import ua.test.rcp.zabara.jface.Person;
import ua.test.rcp.zabara.jface.Utils;




public class SavePersonHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        String name = null;
        int group = 0;
        boolean swtDone = false;
        IWorkbenchPage compositePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        IViewPart compositeViewPart = null;
        try {
            compositeViewPart = compositePage.showView("ua.test.rcp.zabara.view.composite");
        } catch (PartInitException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        CompositePart compositePart = (CompositePart) compositeViewPart;
        try {
            name = compositePart.getMainComposite().getNameTextField().getText();
            group = Integer.parseInt(compositePart.getMainComposite().getGroupTextField().getText());
            swtDone = compositePart.getMainComposite().getSwtCheckdone().getSelection();
        } catch (NumberFormatException ignore) {
            MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Incoorect input",
                    "Your input was incorrect. Please, put the correct data");
        }
        if (Utils.isValidData(name, group)) {
            IWorkbenchPage tablePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
            IViewPart tableViewPart = null;
            try {
                tableViewPart = tablePage.showView(TableViewerPart.ID);
            } catch (PartInitException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            TableViewerPart tableViewerPart = (TableViewerPart) tableViewPart;
            Person selectionPerson = tableViewerPart.getCurrentPerson();

            if (tableViewerPart.getCurrentPerson() == null) {

                MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Information",
                        "Please, choose a row for saving data");
            } else {
                for (Person availablePerson : ModelProvider.INSTANCE.getPersons()) {
                    if (selectionPerson.equals(availablePerson)) {
                        Utils.updatePersonData(availablePerson, name, group, swtDone);
                        tableViewerPart.getViewer().refresh();
                    }
                }
            }
        }
        return null;
    }
    

}
