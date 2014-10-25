package project.modules.Airplane.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airplane.Controller.AirplaneController;
import java.awt.event.ActionEvent;

public class AirplaneMenuNavigationActionListener extends AbstractActionListener
{
    public AirplaneMenuNavigationActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        getController().navigateAction("root-menu");
    }

    private AirplaneController getController()
    {
        return new AirplaneController(configuration);
    }
}
