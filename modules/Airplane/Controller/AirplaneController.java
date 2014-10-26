package project.modules.Airplane.Controller;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Controller.AbstractController;
import project.modules.Airplane.Entity.AirplaneEntity;
import project.modules.Airplane.Model.AirplaneModel;
import project.modules.Airplane.Type.AirplaneConsultSearchComboType;

public class AirplaneController extends AbstractController
{
    private AirplaneModel model;

    public AirplaneController(ConfigurationEntity configuration)
    {
        configuration.setController(this);
        setConfiguration(configuration);

        model = new AirplaneModel(configuration);
    }

    public void navigateAction(String destination)
    {
        model.navigate(destination);
    }

    public void registerAction()
    {
        model.register();
    }

    public void consultAction(AirplaneConsultSearchComboType columnType, String search)
    {
        model.consult(columnType, search);
    }

    public void editAction(AirplaneEntity airplaneEntity)
    {
        model.edit(airplaneEntity);
    }

    public void deleteAction(AirplaneEntity airplaneEntity)
    {
        model.delete(airplaneEntity);
    }

    public void deleteConfirmationAction()
    {
        model.deleteConfirmation();
    }
}
