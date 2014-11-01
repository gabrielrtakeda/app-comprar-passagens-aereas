package project.modules.Flight.Controller;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Controller.AbstractController;
import project.modules.Flight.Entity.FlightEntity;
import project.modules.Flight.Model.FlightModel;
import project.modules.Flight.Type.FlightStatusType;
import project.modules.Airplane.Type.AirplaneEntityComboType;
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

    public AirplaneEntityComboType[] getAirplaneEntitiesComboTypeAction()
    {
        return model.getAirplaneEntitiesComboType();
    }

    public AirportEntityComboType[] getAirportEntitiesComboTypeAction()
    {
        return model.getAirportEntitiesComboType();
    }

    public FlightStatusType[] getFlightStatusTypesAction()
    {
        return model.getFlightStatusTypes();
    }

    public void registerNavigateAction()
    {
        model.registerNavigate();
    }

    public void rasterizeFlightEntityAction(FlightEntity flightEntity)
    {
        model.rasterizeFlightEntity(flightEntity);
    }

    public void registerAction()
    {
        model.register();
    }

    public Boolean validateRegisterAction(String[] fields, String[] values)
    {
        return model.validateRegister(fields, values);
    }

    public void consultAction(String[] columns, String[] searches)
    {
        model.consult(columns, searches);
    }

    public void defaultConsultAction()
    {
        model.defaultConsult();
    }

    public void editConsultAction()
    {
        model.editConsult();
    }

    public void deleteConsultAction()
    {
        model.deleteConsult();
    }

    public void editContentAction(FlightEntity flightEntity)
    {
        model.editContent(flightEntity);
    }

    public void deleteConfirmationAction()
    {
        model.deleteConfirmation();
    }

    public void deleteAction()
    {
        model.delete();
    }
}
