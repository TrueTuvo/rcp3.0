package ua.test.rcp.zabara.handlers;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import ua.test.rcp.zabara.TableViewerPart;
import ua.test.rcp.zabara.jface.CreateNewPersonDialog;



public class NewPersonHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IWorkbenchPage tablePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        IViewPart tableViewPart = null;
        try {
            tableViewPart = tablePage.showView(TableViewerPart.ID);
        } catch (PartInitException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        TableViewerPart tableViewerPart = (TableViewerPart) tableViewPart;
        new CreateNewPersonDialog(tableViewerPart).open();
        return null;
    }

}
