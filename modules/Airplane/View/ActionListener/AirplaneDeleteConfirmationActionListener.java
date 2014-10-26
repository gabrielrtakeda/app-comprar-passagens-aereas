package project.modules.Airplane.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airplane.Controller.AirplaneController;
import java.awt.event.ActionEvent;

public class AirplaneDeleteConfirmationActionListener extends AbstractActionListener
{
    public AirplaneDeleteConfirmationActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        getController().deleteConfirmationAction();
    }

    public AirplaneController getController()
    {
        return new AirplaneController(configuration);
    }
}
