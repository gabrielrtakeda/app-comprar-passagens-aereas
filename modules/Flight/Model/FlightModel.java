package project.modules.Flight.Model;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.AbstractEntity;
import project.modules.Application.Form.Validator.FormRequiredFieldValidator;
import project.modules.Application.Model.AbstractModel;
import project.modules.Flight.DataAccessObject.FlightDAO;
import project.modules.Flight.Entity.FlightEntity;
import project.modules.Flight.View.FlightRegisterView;
import project.modules.Flight.View.FlightConsultView;
import project.modules.Flight.View.FlightConsultResultView;
import project.modules.Flight.View.FlightRasterizeView;
import project.modules.Flight.Type.FlightStatusType;
import project.modules.Airplane.DataAccessObject.AirplaneDAO;
import project.modules.Airplane.Type.AirplaneEntityComboType;
import project.modules.Airport.DataAccessObject.AirportDAO;
import project.modules.Airport.Entity.AirportEntity;
import project.modules.Airport.Type.AirportEntityComboType;
import java.util.List;
import javax.swing.JOptionPane;

public class FlightModel extends AbstractModel
{
    public FlightModel(ConfigurationEntity configuration)
    {
        configuration.setModel(this);
        setConfiguration(configuration);
    }

    /**
     * Data Access Objects
     */
    private FlightDAO dao() { return new FlightDAO(); }
    private AirplaneDAO daoAirplane() { return new AirplaneDAO(); }
    private AirportDAO daoAirport() { return new AirportDAO(); }

    public void navigate(String destination)
    {
        configuration.getView().dispose();

        switch (destination) {

            case "root-menu":
                configuration.clearQueryStrings();
                configuration.clearEntitiesCollection();
                goToMenu();
                break;

            case "register":
                new FlightRegisterView(configuration);
                break;

            case "consult":
                new FlightConsultView(configuration);
                break;

            case "consult-result":
                new FlightConsultResultView(configuration);
                break;

            case "rasterize":
                new FlightRasterizeView(configuration);
                break;
        }
    }

    public AirplaneEntityComboType[] getAirplaneEntitiesComboType()
    {
        List<AirplaneEntityComboType> types = daoAirplane().loadComboType();
        return types.toArray(new AirplaneEntityComboType[types.size()]);
    }

    public AirportEntityComboType[] getAirportEntitiesComboType()
    {
        List<AirportEntityComboType> types = daoAirport().loadComboType();
        return types.toArray(new AirportEntityComboType[types.size()]);
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

    public void rasterizeFlightEntity(FlightEntity flightEntity)
    {
        configuration.setEntity("flight", flightEntity);
        navigate("rasterize");
    }

    public void register()
    {
        FlightEntity flightEntity = (FlightEntity) configuration.getEntity("flight");

        Integer optionsResult = JOptionPane.showConfirmDialog(
            null,
            configuration.getTranslator().__("Confirma o cadastro do Voo?"),
            configuration.getTranslator().__("Confirmação de Cadastro de Voo"),
            JOptionPane.YES_NO_OPTION
        );

        if (optionsResult == JOptionPane.YES_OPTION) {
            Boolean result = false;
            String successMessage = "",
                   errorMessage = "";

            // Verifica se o registro já existe
            List<AbstractEntity> searchEntity
                = dao().consult(
                    new String[] {
                        "idAeronave", "idAeroportoOrigem", "idAeroportoDestino", "dataPartida"
                    },
                    new String[] {
                        String.valueOf(flightEntity.getAirplane().getId()),
                        String.valueOf(flightEntity.getAirportOrigin().getId()),
                        String.valueOf(flightEntity.getAirportDestination().getId()),
                        flightEntity.getDateDeparture().toString()
                    }
                );

            if (searchEntity.size() < 1) {
                // Inserir caso não exista
                result = dao().register(flightEntity);
                successMessage = "Voo cadastrado com sucesso!";
                errorMessage = "Não foi possível finalizar o cadastro do Voo.";
            } else {
                // Atualizar caso exista
                // result = dao().update(airportEntity);
                successMessage = "Voo alterado com sucesso!";
                errorMessage = "Não foi possível finalizar a alteração do Voo.";
            }

            if (result) {
                JOptionPane.showMessageDialog(
                    null,
                    configuration.getTranslator().__(successMessage),
                    configuration.getTranslator().__("Sucesso"),
                    JOptionPane.INFORMATION_MESSAGE
                );
                configuration.removeEntity("flight");
                configuration.getView().dispose();
                goToMenu();
            } else {
                JOptionPane.showMessageDialog(
                    null,
                    configuration.getTranslator().__(errorMessage),
                    configuration.getTranslator().__("Erro"),
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    public void consult(String[] columns, String[] searches)
    {
        FormRequiredFieldValidator.validateFields(columns, searches);
        if (FormRequiredFieldValidator.hasError()) {
            FormRequiredFieldValidator.setConfiguration(configuration);
            FormRequiredFieldValidator.showErrorMessage();
        } else {
            List<AbstractEntity> entities = dao().consult(columns, searches);

            if (entities.size() < 1) {
                JOptionPane.showMessageDialog(
                    null,
                    configuration.getTranslator().__("Nenhum registro foi encontrado."),
                    configuration.getTranslator().__("Resultado"),
                    JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                configuration.getView().dispose();
                configuration.setEntitiesCollection(entities);
                navigate("consult-result");
            }
        }
    }
}
