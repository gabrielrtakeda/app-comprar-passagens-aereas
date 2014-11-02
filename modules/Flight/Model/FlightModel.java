package project.modules.Flight.Model;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.AbstractEntity;
import project.modules.Application.Form.Validator.FormRequiredFieldValidator;
import project.modules.Application.Model.AbstractModel;
import project.modules.Flight.DataAccessObject.FlightDAO;
import project.modules.Flight.Entity.FlightEntity;
import project.modules.Flight.View.FlightMenuView;
import project.modules.Flight.View.FlightRegisterView;
import project.modules.Flight.View.FlightConsultView;
import project.modules.Flight.View.FlightConsultResultView;
import project.modules.Flight.View.FlightRasterizeView;
import project.modules.Flight.Type.FlightStatusType;
import project.modules.Flight.View.Modal.FlightAvailabilityConfirmationModal;
import project.modules.Airplane.DataAccessObject.AirplaneDAO;
import project.modules.Airplane.Type.AirplaneEntityComboType;
import project.modules.Airport.DataAccessObject.AirportDAO;
import project.modules.Airport.Entity.AirportEntity;
import project.modules.Airport.Type.AirportEntityComboType;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
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

            case "menu":
                new FlightMenuView(configuration);
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

        String confirmationMessage = "Confirma o cadastro do Voo?",
               confirmationTitleMessage = "Confirmação de Cadastro de Voo";

        Boolean edit = false;

        // Verifica se o Voo já existe
        List<AbstractEntity> searchEntities = dao().consult(
            new String[] {"idVoo"},
            new String[] {String.valueOf(flightEntity.getId())}
        );
        if (configuration.hasQueryString("flight-consult") || searchEntities.size() > 0) {
            if (configuration.getQueryString("flight-consult").equals("edit")) {
                confirmationMessage = "Confirma a alteração do Voo?";
                confirmationTitleMessage = "Confirmação de alteração de Voo";
            }
            edit = true;
        }

        Integer optionsResult = JOptionPane.showConfirmDialog(
            null,
            configuration.getTranslator().__(confirmationMessage),
            configuration.getTranslator().__(confirmationTitleMessage),
            JOptionPane.YES_NO_OPTION
        );

        if (optionsResult == JOptionPane.YES_OPTION) {
            Boolean result = false;

            String successMessage = "",
                   errorMessage = "";
            if (edit) {
                result = dao().update((FlightEntity) configuration.getEntity("flight"));
                successMessage = "Voo alterado com sucesso!";
                errorMessage = "Não foi possível finalizar a alteração do Voo.";
            } else {
                result = dao().register(flightEntity);
                successMessage = "Voo cadastrado com sucesso!";
                errorMessage = "Não foi possível finalizar o cadastro do Voo.";
            }

            if (result) {
                JOptionPane.showMessageDialog(
                    null,
                    configuration.getTranslator().__(successMessage),
                    configuration.getTranslator().__("Sucesso"),
                    JOptionPane.INFORMATION_MESSAGE
                );
                configuration.removeEntity("flight");
                navigate("root-menu");
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

    public Boolean validateRegister(String[] fields, String[] values)
    {
        Boolean valid = false;
        FormRequiredFieldValidator.validateFields(fields, values);
        if (FormRequiredFieldValidator.hasError()) {
            FormRequiredFieldValidator.setConfiguration(configuration);
            FormRequiredFieldValidator.showErrorMessage();
        } else {
            valid = true;
        }
        return valid;
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

    public void delete()
    {
        Integer optionsResult = JOptionPane.showConfirmDialog(
            null,
            configuration.getTranslator().__("Tem certeza que deseja prosseguir com a ação?"),
            configuration.getTranslator().__("Confirmação de Cancelamento de Voo"),
            JOptionPane.YES_NO_OPTION
        );

        if (optionsResult == JOptionPane.YES_OPTION) {
            FlightEntity flightEntity = (FlightEntity) configuration.getEntity("flight");
            Boolean result = dao().delete(flightEntity);

            if (result) {
                JOptionPane.showMessageDialog(
                    null,
                    configuration.getTranslator().__("Voo cancelado com sucesso!"),
                    configuration.getTranslator().__("Sucesso"),
                    JOptionPane.INFORMATION_MESSAGE
                );
                configuration.removeEntity("flight");
                navigate("root-menu");
            } else {
                JOptionPane.showMessageDialog(
                    null,
                    configuration.getTranslator().__(
                        "Não foi possível finalizar o cancelamento do Voo."
                    ),
                    configuration.getTranslator().__("Erro"),
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    public void registerNavigate()
    {
        configuration.setQueryString("flight-rasterize", "register");
        navigate("register");
    }

    public void defaultConsult()
    {
        configuration.setQueryString("flight-consult", "consult");
        configuration.setQueryString("flight-rasterize", "consult");
        navigate("consult");
    }

    public void editConsult()
    {
        configuration.setQueryString("flight-consult", "edit");
        navigate("consult");
    }

    public void editContent(FlightEntity flightEntity)
    {
        configuration.setQueryString("flight-rasterize", "edit");
        configuration.setEntity("flight", flightEntity);
        navigate("consult-result");
    }

    public void deleteConsult()
    {
        configuration.setQueryString("flight-consult", "delete");
        navigate("consult");
    }

    public void deleteConfirmation()
    {
        configuration.setQueryString("flight-rasterize", "delete");
        navigate("rasterize");
    }

    public AbstractEntity checkAvailability(String[] columns, String[] values)
    {
        FlightEntity flightEntity = new FlightEntity();
        FormRequiredFieldValidator.validateFields(columns, values);
        if (FormRequiredFieldValidator.hasError()) {
            FormRequiredFieldValidator.setConfiguration(configuration);
            FormRequiredFieldValidator.showErrorMessage();
        } else {
            List<AbstractEntity> entities = dao().consult(columns, values);
            if (entities.size() < 1) {
                JOptionPane.showMessageDialog(
                    null,
                    "Não há disponibilidade para essa passagem.",
                    "Indisponibilidade",
                    JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                flightEntity = (FlightEntity) entities.get(0);
                configuration.setEntity("passage-purchase-flight", flightEntity);
                new FlightAvailabilityConfirmationModal(configuration);
            }
        }

        return flightEntity;
    }
}
