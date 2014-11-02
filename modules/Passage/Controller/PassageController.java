package project.modules.Passage.Controller;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Controller.AbstractController;
import project.modules.Passage.Entity.PassageEntity;
import project.modules.Passage.Model.PassageModel;
import project.modules.Flight.Entity.FlightEntity;
import project.modules.Flight.Model.FlightModel;
import project.modules.Airport.Type.AirportEntityComboType;

public class PassageController extends AbstractController
{
    private PassageModel model;
    private FlightModel modelFlight;

    public PassageController(ConfigurationEntity configuration)
    {
        configuration.setController(this);
        setConfiguration(configuration);

        model = new PassageModel(configuration);
        modelFlight = new FlightModel(configuration);
    }

    public AirportEntityComboType[] getAirportEntitiesComboTypeAction()
    {
        return modelFlight.getAirportEntitiesComboType();
    }

    public void flightAvailabilityConfirmationAction(String[] columns, String[] values)
    {

        modelFlight.checkAvailability(columns, values);
    }

    public void flightConfirmationAction()
    {
        model.flightConfirmation();
    }
}
