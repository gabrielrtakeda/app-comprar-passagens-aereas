package project.modules.Flight.Model;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Model.AbstractModel;
import project.modules.Flight.DataAccessObject.FlightDAO;
import project.modules.Flight.Entity.FlightEntity;
import project.modules.Flight.View.FlightRegisterView;
import project.modules.Flight.View.FlightConsultView;
import project.modules.Flight.Type.FlightStatusType;
import project.modules.Airplane.DataAccessObject.AirplaneDAO;
import project.modules.Airplane.Type.AirplaneEntityComboType;
import project.modules.Airport.DataAccessObject.AirportDAO;
import project.modules.Airport.Entity.AirportEntity;
import project.modules.Airport.Type.AirportEntityComboType;
import java.util.List;

public class FlightModel extends AbstractModel
{
    public FlightModel(ConfigurationEntity configuration)
    {
        configuration.setModel(this);
        setConfiguration(configuration);
    }

    private FlightDAO dao()
    {
        return new FlightDAO();
    }

    private AirplaneDAO daoAirplane()
    {
        return new AirplaneDAO();
    }

    private AirportDAO daoAirport()
    {
        return new AirportDAO();
    }

    public void navigate(String destination)
    {
        configuration.getView().dispose();

        switch (destination) {

            case "root-menu":
                goToMenu();
                break;

            case "register-view":
                new FlightRegisterView(configuration);
                break;

            case "consult-view":
                new FlightConsultView(configuration);
                break;

            case "rasterize":
                new FlightRasterizeView(configuration);
                break;
        }
    }

    public AirplaneEntityComboType[] getAirplaneEntitiesComboType()
    {
        List<AirplaneEntityComboType> types = daoAirplane().loadComboType();
        return types.toArray(
            new AirplaneEntityComboType[types.size()]
        );
    }

    public AirportEntityComboType[] getAirportEntitiesComboType()
    {
        List<AirportEntityComboType> types = daoAirport().loadComboType();
        return types.toArray(
            new AirportEntityComboType[types.size()]
        );
    }

    public FlightStatusType[] getFlightStatusTypes()
    {
        return new FlightStatusType[]
        {
            new FlightStatusType(configuration, FlightEntity.STATUS_AVAILABLE),
            new FlightStatusType(configuration, FlightEntity.STATUS_CANCELED),
            new FlightStatusType(configuration, FlightEntity.STATUS_POSTPONED),
            new FlightStatusType(configuration, FlightEntity.STATUS_EXTENDED),
            new FlightStatusType(configuration, FlightEntity.STATUS_SUSPENDED),
            new FlightStatusType(configuration, FlightEntity.STATUS_TRANSFERRED),
            new FlightStatusType(configuration, FlightEntity.STATUS_PENDING)
        };
    }
}
