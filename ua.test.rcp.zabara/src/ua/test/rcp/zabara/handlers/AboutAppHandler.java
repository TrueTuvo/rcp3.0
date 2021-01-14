package ua.test.rcp.zabara.handlers;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import ua.test.rcp.zabara.jface.AboutApplicationDialog;


public class AboutAppHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        new AboutApplicationDialog().open();
        return null;
    }

}
