package project.modules.Flight.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Flight.Controller.FlightController;
import project.modules.Airport.Type.AirportEntityComboType;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class FlightConsultMacroSearchActionListener extends AbstractActionListener
{
    public FlightConsultMacroSearchActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        JComboBox airportOrigin = (JComboBox) getComponent("airport-origin");
        JComboBox airportDestination = (JComboBox) getComponent("airport-destination");
        JTextField dateDeparture = (JTextField) getComponent("date-departure");

        getController().consulSearchtAction(
            new String[] {"idAeroportoOrigem", "idAeroportoDestino", "dataPartida"},
            new String[] {
                String.valueOf(
                    ((AirportEntityComboType) airportOrigin.getSelectedItem()).getId()
                ),
                String.valueOf(
                    ((AirportEntityComboType) airportDestination.getSelectedItem()).getId()
                ),
                dateDeparture.getText()
            }
        );
    }

    private FlightController getController()
    {
        return new FlightController(configuration);
    }
}
