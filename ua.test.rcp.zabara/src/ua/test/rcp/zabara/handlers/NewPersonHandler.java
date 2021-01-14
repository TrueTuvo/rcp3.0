package ua.test.rcp.zabara.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import ua.test.rcp.zabara.Utils;
import ua.test.rcp.zabara.jface.dialogs.CreateNewPersonDialog;
import ua.test.rcp.zabara.parts.TableViewerPart;

/**
 * Handler, which opens dialog for create new person
 * 
 * @author SZabara
 *
 */
public class NewPersonHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        TableViewerPart tableViewerPart = Utils.getTableViewerPart();
        new CreateNewPersonDialog(tableViewerPart).open();
        return null;
    }

}
