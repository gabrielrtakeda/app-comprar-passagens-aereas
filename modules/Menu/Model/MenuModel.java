package project.modules.Menu.Model;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Model.AbstractModel;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airport.Controller.AirportController;
import project.modules.Airport.View.ActionListener.AirportMenuViewActionListener;

public class MenuModel extends AbstractModel
{
    public MenuModel(ConfigurationEntity configuration)
    {
        configuration.setModel(this);
        setConfiguration(configuration);
    }

    public AbstractActionListener airportMenu()
    {
        configuration.getView().dispose();
        new AirportController(configuration);
        return new AirportMenuViewActionListener(configuration);
    }
}
