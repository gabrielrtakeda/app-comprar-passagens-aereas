package project.modules.Passenger.Controller;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Controller.AbstractController;
import project.modules.Passenger.Entity.PassengerEntity;
import project.modules.Passenger.Model.PassengerModel;
import project.modules.Passage.View.PassagePurchaseView;

public class PassengerController extends AbstractController
{
    protected PassengerModel model;

    public PassengerController(ConfigurationEntity configuration)
    {
        configuration.setController(this);
        setConfiguration(configuration);

        model = new PassengerModel(configuration);
    }

    public void registerAction()
    {
        model.register();
    }

    public void passagePurchaseViewAction()
    {
        configuration.disposeView();
        new PassagePurchaseView(configuration);
    }
}
