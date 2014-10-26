package project.modules.Airport.Controller;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.AbstractEntity;
import project.modules.Application.Controller.AbstractController;
import project.modules.Airport.Entity.AirportEntity;
import project.modules.Airport.Type.AirportConsultSearchComboType;
import project.modules.Airport.Model.AirportModel;
import java.util.List;

public class AirportController extends AbstractController
{
    AirportModel model;

    public AirportController(ConfigurationEntity configuration)
    {
        configuration.setController(this);
        setConfiguration(configuration);

        model = new AirportModel(configuration);
    }

    public void registerAction(AirportEntity airportEntity)
    {
        model.register(airportEntity);
    }

    public void consultAction(AirportConsultSearchComboType columnType,
                          String search)
    {
        model.consult(columnType, search);
    }

    public void menuAction()
    {
        model.menu();
    }

    public void searchConsultAction()
    {
        model.searchConsult();
    }

    public void editConsultAction()
    {
        model.editConsult();
    }

    public void editContentAction(AirportEntity airportEntity)
    {
        model.editContent(airportEntity);
    }

    public void deleteConsultAction()
    {
        model.deleteConsult();
    }

    public void deleteConfirmationAction(AirportEntity airportEntity)
    {
        model.deleteConfirmation(airportEntity);
    }

    public void deleteAction()
    {
        model.delete();
    }
}
