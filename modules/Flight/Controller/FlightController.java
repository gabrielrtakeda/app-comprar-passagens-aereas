package project.modules.Flight.Controller;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Controller.AbstractController;
import project.modules.Flight.Model.FlightModel;
import project.modules.Flight.Type.FlightStatusType;
import project.modules.Airport.Type.AirportEntityComboType;

public class FlightController extends AbstractController
{
    private FlightModel model;

    public FlightController(ConfigurationEntity configuration)
    {
        configuration.setController(this);
        setConfiguration(configuration);

        model = new FlightModel(configuration);
    }

    public void navigateAction(String destination)
    {
        model.navigate(destination);
    }

    /**
     * Mock
     */
    public String[] getAirplanes()
    {
        return new String[]
        {
            "ERJ 135", "ERJ 140", "ERJ 145", "ERJ 145 XR",
            "E170", "E175", "E190", "E195",
            "E175-E2", "E190-E2", "E195-E2"
        };
    }

    public AirportEntityComboType[] getAirportEntitiesComboTypeAction()
    {
        return model.getAirportEntitiesComboType();
    }

    public FlightStatusType[] getFlightStatusTypesAction()
    {
        return model.getFlightStatusTypes();
    }
}
