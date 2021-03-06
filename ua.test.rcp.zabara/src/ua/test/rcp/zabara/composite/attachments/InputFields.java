package ua.test.rcp.zabara.composite.attachments;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import ua.test.rcp.zabara.Utils;

/**
 * This composite responsible input data
 * 
 * @author SZabara
 */
public class InputFields extends Composite {

    private final Text nameTextField;

    private final Text groupTextField;

    public InputFields(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout(2, true));

        Label nameLabel = new Label(this, SWT.FILL);
        nameLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        nameTextField = new Text(this, SWT.FILL);
        nameTextField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        nameTextField.setToolTipText("Input cannot be empty");
        Label groupLabel = new Label(this, SWT.FILL);
        groupLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        groupTextField = new Text(this, SWT.FILL);
        groupTextField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        groupTextField.setToolTipText("Group must be a number from 1 to 99");
        nameLabel.setText("Name ");
        groupLabel.setText("Group ");

        setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        nameTextField.addVerifyListener(new VerifyListener() {

            @Override
            public void verifyText(VerifyEvent e) {
                String oldS = ((Text) e.widget).getText();
                String newS = oldS.substring(0, e.start) + e.text + oldS.substring(e.end);
                if (Utils.isName(newS)) {
                    e.doit = true;
                } else {
                    e.doit = false;
                }
            }
        });

        groupTextField.addVerifyListener(new VerifyListener() {

            @Override
            public void verifyText(VerifyEvent e) {
                String oldS = ((Text) e.widget).getText();
                String newS = oldS.substring(0, e.start) + e.text + oldS.substring(e.end);
                if (newS.matches("[0-9]{1,2}") || newS.matches("")) {
                    e.doit = true;
                } else {
                    e.doit = false;
                }
            }
        });
    }

    /**
     * returns groupTextField of this object
     * 
     * @return groupTextField
     */
    public Text getGroupTextField() {
        return groupTextField;
    }

    /**
     * returns nameTextField of this object
     * 
     * @return nameTextField
     */
    public Text getNameTextField() {
        return nameTextField;
    }

}
