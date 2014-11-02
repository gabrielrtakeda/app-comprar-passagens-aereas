package project.modules.Flight.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Passage.Controller.PassageController;
import project.modules.Airport.Entity.AirportEntity;
import project.modules.Flight.View.Modal.FlightAvailabilityConfirmationModal;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class FlightAvailabilityConfirmationActionListener extends AbstractActionListener
{
    public FlightAvailabilityConfirmationActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        JComboBox airportOrigin = (JComboBox) getComponent("airport-origin");
        JComboBox airportDestination = (JComboBox) getComponent("airport-destination");
        JTextField dateDeparture = (JTextField) getComponent("date-departure");

        /**
         * TODO: Verificar quantidade de assentos.
         */
        getController().flightAvailabilityConfirmationAction(
            new String[] {"idAeroportoOrigem", "idAeroportoDestino", "dataPartida"},
            new String[] {
                String.valueOf(((AirportEntity) airportOrigin.getSelectedItem()).getId()),
                String.valueOf(((AirportEntity) airportDestination.getSelectedItem()).getId()),
                dateDeparture.getText()
            }
        );
    }

    private PassageController getController()
    {
        return new PassageController(configuration);
    }
}
