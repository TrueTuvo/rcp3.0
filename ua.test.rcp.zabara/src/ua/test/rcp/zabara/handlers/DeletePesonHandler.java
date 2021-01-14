package ua.test.rcp.zabara.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import ua.test.rcp.zabara.Utils;
import ua.test.rcp.zabara.jface.dialogs.DeletePersonDialog;
import ua.test.rcp.zabara.parts.TableViewerPart;

/**
 * Handler, which remove selected person from model
 * 
 * @author SZabara
 *
 */
public class DeletePesonHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        TableViewerPart tableViewerPart = Utils.getTableViewerPart();
        if (tableViewerPart.getCurrentPerson() != null) {
            new DeletePersonDialog(tableViewerPart).open();
        }
        return null;
    }

}
