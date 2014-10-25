package project.modules.Menu.Model;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Model.AbstractModel;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airplane.View.ActionListener.AirplaneMenuViewActionListener;
import project.modules.Airport.View.ActionListener.AirportMenuViewActionListener;

public class MenuModel extends AbstractModel
{
    public MenuModel(ConfigurationEntity configuration)
    {
        configuration.setModel(this);
        setConfiguration(configuration);
    }

    public AbstractActionListener airplaneMenu()
    {
        configuration.getView().dispose();
        return new AirplaneMenuViewActionListener(configuration);
    }

    public AbstractActionListener airportMenu()
    {
        configuration.getView().dispose();
        return new AirportMenuViewActionListener(configuration);
    }
}
