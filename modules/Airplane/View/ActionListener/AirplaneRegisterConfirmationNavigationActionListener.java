package project.modules.Airplane.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airplane.View.AirplaneRegisterView;
import java.awt.event.ActionEvent;

public class AirplaneRegisterConfirmationNavigationActionListener extends AbstractActionListener
{
    public AirplaneRegisterConfirmationNavigationActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        configuration.getView().dispose();
        new AirplaneRegisterView(configuration);
    }
}
