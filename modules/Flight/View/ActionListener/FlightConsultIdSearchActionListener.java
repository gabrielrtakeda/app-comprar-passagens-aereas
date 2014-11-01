package project.modules.Flight.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Flight.Controller.FlightController;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class FlightConsultIdSearchActionListener extends AbstractActionListener
{
    public FlightConsultIdSearchActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        JTextField id = (JTextField) getComponent("id");
        getController().consultAction(
            new String[] {"idVoo"},
            new String[] {id.getText()}
        );
    }

    private FlightController getController()
    {
        return new FlightController(configuration);
    }
}
