package project.modules.Flight.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Flight.Controller.FlightController;
import project.modules.Flight.Entity.FlightEntity;
import project.modules.Flight.Type.FlightStatusType;
import project.modules.Airplane.Entity.AirplaneEntity;
import project.modules.Airport.Entity.AirportEntity;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class FlightRasterizeActionListener extends AbstractActionListener
{
    public FlightRasterizeActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        JComboBox airplane           = (JComboBox)  getComponent("airplane");
        JComboBox airportOrigin      = (JComboBox)  getComponent("airport-origin");
        JComboBox airportDestination = (JComboBox)  getComponent("airport-destination");
        JTextField price             = (JTextField) getComponent("price");
        JComboBox status             = (JComboBox)  getComponent("status");
        JTextField dateDeparture     = (JTextField) getComponent("date-departure");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


        System.out.println(((AirplaneEntity) airplane.getSelectedItem()).getDescription());

        FlightEntity flightEntity = new FlightEntity();
        try {
            flightEntity.setAirplane((AirplaneEntity) airplane.getSelectedItem())
                        .setAirportOrigin((AirportEntity) airportOrigin.getSelectedItem())
                        .setAirportDestination((AirportEntity) airportDestination.getSelectedItem())
                        .setPrice(Double.parseDouble(price.getText()))
                        .setStatus(((FlightStatusType) status.getSelectedItem()).getValue())
                        .setDateDeparture(dateFormat.parse(dateDeparture.getText()));
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        getController().rasterizeFlightEntityAction(flightEntity);
    }

    public FlightController getController()
    {
        return new FlightController(configuration);
    }
}
