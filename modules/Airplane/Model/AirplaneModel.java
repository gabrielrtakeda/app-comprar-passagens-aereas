package project.modules.Airplane.Model;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.AbstractEntity;
import project.modules.Application.Form.Validator.FormRequiredFieldValidator;
import project.modules.Application.Model.AbstractModel;
import project.modules.Airplane.DataAccessObject.AirplaneDAO;
import project.modules.Airplane.Entity.AirplaneEntity;
import project.modules.Airplane.View.AirplaneMenuView;
import project.modules.Airplane.View.AirplaneRasterizeView;
import project.modules.Airplane.View.AirplaneRegisterView;
import project.modules.Airplane.View.AirplaneConsultView;
import project.modules.Airplane.View.AirplaneConsultResultView;
import project.modules.Airplane.Type.AirplaneConsultSearchComboType;
import java.util.List;
import javax.swing.JOptionPane;

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
                configuration.removeEntity("airplane");
                configuration.removeQueryString("airplane-consult");
                configuration.removeQueryString("airplane-consult-confirmation");
                goToMenu();
                break;

            case "menu":
                new AirplaneMenuView(configuration);
                break;

            case "rasterize":
                new AirplaneRasterizeView(configuration);
                break;

            case "register":
                new AirplaneRegisterView(configuration);
                break;

            case "consult":
                configuration.setQueryString("airplane-consult", "consult");
                new AirplaneConsultView(configuration);
                break;

            case "edit":
                configuration.setQueryString("airplane-consult", "edit");
                new AirplaneConsultView(configuration);
                break;

            case "delete":
                configuration.setQueryString("airplane-consult", "delete");
                new AirplaneConsultView(configuration);
                break;

            case "consult-result":
                new AirplaneConsultResultView(configuration);
                break;

            default:
                new AirplaneMenuView(configuration);
        }
    }

    public void register()
    {
        Integer optionsResult = JOptionPane.showConfirmDialog(
            null,
            configuration.getTranslator().__("Confirma o cadastro da Aeronave?"),
            configuration.getTranslator().__("Confirmação de Cadastro da Aeronave"),
            JOptionPane.YES_NO_OPTION
        );

        if (optionsResult == JOptionPane.YES_OPTION) {
            Boolean result = false;
            String successMessage = "",
                   errorMessage = "";

            // Verifica se o registro já existe a partir da sigla
            AirplaneEntity airplaneEntity = (AirplaneEntity) configuration.getEntity("airplane");
            List<AbstractEntity> searchEntity
                = dao().consult("modelo", airplaneEntity.getModel());

            if (searchEntity.size() < 1) {
                // Inserir caso não exista
                result = dao().register(airplaneEntity);
                successMessage = "Aeronave cadastrada com sucesso!";
                errorMessage = "Não foi possível finalizar o cadastro da Aeronave.";
            } else {
                // Atualizar caso exista
                result = dao().update(airplaneEntity);
                successMessage = "Aeronave alterada com sucesso!";
                errorMessage = "Não foi possível finalizar a alteração da Aeronave.";
            }

            if (result) {
                JOptionPane.showMessageDialog(
                    null,
                    configuration.getTranslator().__(successMessage),
                    configuration.getTranslator().__("Sucesso"),
                    JOptionPane.INFORMATION_MESSAGE
                );
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

    public void consult(AirplaneConsultSearchComboType columnType, String search)
    {
        FormRequiredFieldValidator.validateField(columnType.toString(), search);
        if (FormRequiredFieldValidator.hasError()) {
            FormRequiredFieldValidator.setConfiguration(configuration);
            FormRequiredFieldValidator.showErrorMessage();
        } else {
            List<AbstractEntity> airplaneEntities = dao().consult(
                ((AirplaneConsultSearchComboType) columnType).getValue(),
                search
            );

            if (airplaneEntities.size() < 1) {
                JOptionPane.showMessageDialog(
                    null,
                    configuration.getTranslator().__("Nenhum registro foi encontrado."),
                    configuration.getTranslator().__("Resultado"),
                    JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                configuration.setEntitiesCollection(airplaneEntities);
                navigate("consult-result");
            }
        }
    }

    public void edit(AirplaneEntity airplaneEntity)
    {
        configuration.setEntity("airplane", airplaneEntity);
        navigate("register");
    }

    public void delete(AirplaneEntity airplaneEntity)
    {
        configuration.setQueryString("airplane-consult-confirmation", "delete");
        configuration.setEntity("airplane", airplaneEntity);
        navigate("rasterize");
    }

    public void deleteConfirmation()
    {
        Integer optionsResult = JOptionPane.showConfirmDialog(
            null,
            configuration.getTranslator().__("Tem certeza que deseja prosseguir com a ação?"),
            configuration.getTranslator().__("Confirmação de Exclusão da Aeronave"),
            JOptionPane.YES_NO_OPTION
        );

        if (optionsResult == JOptionPane.YES_OPTION) {
            AirplaneEntity airplaneEntity = (AirplaneEntity) configuration.getEntity("airplane");
            Boolean result = dao().delete(airplaneEntity);

            if (result) {
                JOptionPane.showMessageDialog(
                    null,
                    configuration.getTranslator().__("Aeronave excluída com sucesso!"),
                    configuration.getTranslator().__("Sucesso"),
                    JOptionPane.INFORMATION_MESSAGE
                );
                configuration.getView().dispose();
                configuration.removeEntity("airplane");
                configuration.clearQueryStrings();
                goToMenu();
            } else {
                JOptionPane.showMessageDialog(
                    null,
                    configuration.getTranslator().__(
                        "Não foi possível finalizar a exclusão da Aeronave."
                    ),
                    configuration.getTranslator().__("Erro"),
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}
