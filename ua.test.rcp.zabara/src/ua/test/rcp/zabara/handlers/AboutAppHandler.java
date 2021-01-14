package ua.test.rcp.zabara.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import ua.test.rcp.zabara.jface.dialogs.AboutApplicationDialog;

/**
 * Handler, which displaying additional info about app
 * 
 * @author SZabara
 *
 */
public class AboutAppHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        new AboutApplicationDialog().open();
        return null;
    }

}
