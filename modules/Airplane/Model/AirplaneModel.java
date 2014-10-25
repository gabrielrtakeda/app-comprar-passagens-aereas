package project.modules.Airplane.Model;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Model.AbstractModel;
import project.modules.Airplane.DataAccessObject.AirplaneDAO;
import project.modules.Airplane.View.AirplaneMenuView;
import project.modules.Airplane.View.AirplaneRegisterView;

public class AirplaneModel extends AbstractModel
{
    public AirplaneModel(ConfigurationEntity configuration)
    {
        configuration.setModel(this);
        setConfiguration(configuration);
    }

    private AirplaneDAO dao()
    {
        return new AirplaneDAO();
    }

    public void navigate(String destination)
    {
        configuration.getView().dispose();
        switch (destination) {
            case "root-menu":
                goToMenu();
                break;

            case "menu":
                new AirplaneMenuView(configuration);
                break;

            case "register":
                new AirplaneRegisterView(configuration);
                break;

            default:
                new AirplaneMenuView(configuration);
        }
    }
}
