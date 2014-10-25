package project.modules.Menu.Controller;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Controller.AbstractController;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Menu.Model.MenuModel;

public class MenuController extends AbstractController
{
    MenuModel model;

    public MenuController(ConfigurationEntity configuration)
    {
        configuration.setController(this);
        setConfiguration(configuration);

        model = new MenuModel(configuration);
    }

    public AbstractActionListener airplaneMenuAction()
    {
        return model.airplaneMenu();
    }

    public AbstractActionListener airportMenuAction()
    {
        return model.airportMenu();
    }
}
