package project.modules.Airplane.Controller;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Controller.AbstractController;
import project.modules.Airplane.Model.AirplaneModel;

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

    public void confirmRegisterAction()
    {
        model.confirmRegister();
    }
}
