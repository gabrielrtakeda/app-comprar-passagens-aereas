package project.modules.Airport.Controller;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.AbstractEntity;
import project.modules.Application.Controller.AbstractController;
import project.modules.Airport.Entity.AirportEntity;
import project.modules.Airport.Model.AirportModel;
import project.modules.Airport.Type.AirportConsultSearchComboType;
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

    public void register(AirportEntity airportEntity)
    {
        model.register(airportEntity);
    }

    public void consultBy(AirportConsultSearchComboType columnType,
                          String search)
    {
        model.consultBy(columnType, search);
    }
}
