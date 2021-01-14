package ua.test.rcp.zabara.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import ua.test.rcp.zabara.Utils;
import ua.test.rcp.zabara.parts.CompositePart;
import ua.test.rcp.zabara.parts.TableViewerPart;

/**
 * Handler, which undo changes of selected person
 * 
 * @author SZabara
 *
 */
public class CancelPesonHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {

        TableViewerPart tableViewerPart = Utils.getTableViewerPart();

        CompositePart compositePart = Utils.getCompositePart();

        if (tableViewerPart.getCurrentPerson() != null) {
            Utils.removeChangesPersonData(compositePart.getMainComposite(), tableViewerPart.getCurrentPerson());
            tableViewerPart.getViewer().refresh();
        }
        return compositePart;
    }

}
