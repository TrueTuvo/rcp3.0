package ua.test.rcp.zabara.handlers;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import ua.test.rcp.zabara.CompositePart;
import ua.test.rcp.zabara.TableViewerPart;
import ua.test.rcp.zabara.jface.Utils;



public class CancelPesonHandler extends AbstractHandler {
    


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
        
        IWorkbenchPage compositePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        IViewPart compositeViewPart = null;
        try {
            compositeViewPart = compositePage.showView(CompositePart.ID);
        } catch (PartInitException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        CompositePart compositePart = (CompositePart) compositeViewPart;
        

        if (tableViewerPart.getCurrentPerson() != null) {
            Utils.removeChangesPersonData(compositePart.getMainComposite(), tableViewerPart.getCurrentPerson());
            tableViewerPart.getViewer().refresh();
        }
        return compositePart;
    }

}
