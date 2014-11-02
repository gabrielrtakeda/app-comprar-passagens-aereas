package project.modules.Passage.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Passage.Controller.PassageController;
import java.awt.event.ActionEvent;

public class PassagePurchaseFlightConfirmationActionListener extends AbstractActionListener
{
    public PassagePurchaseFlightConfirmationActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        getController().flightConfirmationAction();
    }

    private PassageController getController()
    {
        return new PassageController(configuration);
    }
}
