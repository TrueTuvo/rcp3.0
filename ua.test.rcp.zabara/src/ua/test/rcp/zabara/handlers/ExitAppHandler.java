package ua.test.rcp.zabara.handlers;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import ua.test.rcp.zabara.jface.ModelProvider;
import ua.test.rcp.zabara.jface.Person;



public class ExitAppHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        if (MessageDialog.openConfirm(Display.getCurrent().getActiveShell(), "Confirmation", "Do you want to exit?")) {
            URL url = null;
            try {
                url = new URL("platform:/plugin/ua.test.rcp.zabara/database.txt");
                FileWriter tfw = new FileWriter(new File("C:\\luxoft\\database.txt"));
                BufferedWriter tbw = new BufferedWriter(tfw);

                for (Person person : ModelProvider.INSTANCE.getPersons()) {
                    tbw.write(person.getName() + "," + person.getGroup() + "," + person.isSwtDone());
                    tbw.newLine();
                }
                tbw.flush();

                tbw.close();
            } catch (IOException ex) {
                System.err.println("Some problem with writing file. Changes was not saved.");
            }
            Display.getCurrent().getActiveShell().close();
        }
        return null;
    }

}
