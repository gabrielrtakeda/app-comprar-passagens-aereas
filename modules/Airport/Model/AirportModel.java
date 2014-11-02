package project.modules.Airport.Model;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.AbstractEntity;
import project.modules.Application.Form.Validator.FormRequiredFieldValidator;
import project.modules.Application.Model.AbstractModel;
import project.modules.Airport.Entity.AirportEntity;
import project.modules.Airport.DataAccessObject.AirportDAO;
import project.modules.Airport.Type.AirportConsultSearchComboType;
import project.modules.Airport.View.AirportMenuView;
import project.modules.Airport.View.AirportConsultView;
import project.modules.Airport.View.AirportConsultResultView;
import project.modules.Airport.View.AirportEditContentView;
import project.modules.Airport.View.AirportDeleteConfirmationView;
import java.util.List;
import javax.swing.JOptionPane;

public class AirportModel extends AbstractModel
{
    public AirportModel(ConfigurationEntity configuration)
    {
        configuration.setModel(this);
        setConfiguration(configuration);
    }

    private AirportDAO dao()
    {
        return new AirportDAO();
    }

    public void register(AirportEntity airportEntity)
    {
        Integer optionsResult = JOptionPane.showConfirmDialog(
            null,
            configuration.getTranslator().__("Confirma o cadastro do Aeroporto?"),
            configuration.getTranslator().__("Confirmação de Cadastro do Aeroporto"),
            JOptionPane.YES_NO_OPTION
        );

        if (optionsResult == JOptionPane.YES_OPTION) {
            Boolean result = false;
            String successMessage = "",
                   errorMessage = "";

            // Verifica se o registro já existe a partir da sigla
            List<AbstractEntity> searchEntity
                = dao().consult("sigla", airportEntity.getAbbreviation());

            if (searchEntity.size() < 1) {
                // Inserir caso não exista
                result = dao().register(airportEntity);
                successMessage = "Aeroporto cadastrado com sucesso!";
                errorMessage = "Não foi possível finalizar o cadastro do Aeroporto.";
            } else {
                // Atualizar caso exista
                result = dao().update(airportEntity);
                successMessage = "Aeroporto alterado com sucesso!";
                errorMessage = "Não foi possível finalizar a alteração do Aeroporto.";
            }

            if (result) {
                JOptionPane.showMessageDialog(
                    null,
                    configuration.getTranslator().__(successMessage),
                    configuration.getTranslator().__("Sucesso"),
                    JOptionPane.INFORMATION_MESSAGE
                );
                configuration.removeEntity("airport");
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

    public void consult(AirportConsultSearchComboType columnType, String search)
    {
        FormRequiredFieldValidator.validateField(columnType.toString(), search);
        if (FormRequiredFieldValidator.hasError()) {
            FormRequiredFieldValidator.setConfiguration(configuration);
            FormRequiredFieldValidator.showErrorMessage();
        } else {
            List<AbstractEntity> airportEntities = dao().consult(
                columnType.getValue(),
                search
            );

            if (airportEntities.size() < 1) {
                JOptionPane.showMessageDialog(
                    null,
                    configuration.getTranslator().__("Nenhum registro foi encontrado."),
                    configuration.getTranslator().__("Resultado"),
                    JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                configuration.getView().dispose();
                configuration.setEntitiesCollection(airportEntities);
                new AirportConsultResultView(configuration);
            }
        }
    }

    public void menu()
    {
        configuration.getView().dispose();
        new AirportMenuView(configuration);
    }

    public void searchConsult()
    {
        configuration.getView().dispose();
        configuration.setQueryString("airport-consult", "consult");
        new AirportConsultView(configuration);
    }

    public void editConsult()
    {
        configuration.getView().dispose();
        configuration.setQueryString("airport-consult", "edit");
        new AirportConsultView(configuration);
    }

    public void editContent(AirportEntity airportEntity)
    {
        configuration.getView().dispose();
        configuration.clearQueryStrings();
        configuration.clearEntitiesCollection();
        configuration.setEntity("airport", airportEntity);
        new AirportEditContentView(configuration);
    }

    public void deleteConsult()
    {
        configuration.getView().dispose();
        configuration.setQueryString("airport-consult", "delete");
        new AirportConsultView(configuration);
    }

    public void deleteConfirmation(AirportEntity airportEntity)
    {
        configuration.getView().dispose();
        configuration.clearQueryStrings();
        configuration.clearEntitiesCollection();
        configuration.setEntity("airport", airportEntity);
        configuration.setQueryString("airport-consult-confirmation", "delete");
        new AirportDeleteConfirmationView(configuration);
    }

    public void delete()
    {
        Integer optionsResult = JOptionPane.showConfirmDialog(
            null,
            configuration.getTranslator().__("Tem certeza que deseja prosseguir com a ação?"),
            configuration.getTranslator().__("Confirmação de Exclusão do Aeroporto"),
            JOptionPane.YES_NO_OPTION
        );

        if (optionsResult == JOptionPane.YES_OPTION) {
            AirportEntity airportEntity = (AirportEntity) configuration.getEntity("airport");
            Boolean result = dao().delete(airportEntity);

            if (result) {
                JOptionPane.showMessageDialog(
                    null,
                    configuration.getTranslator().__("Aeroporto excluído com sucesso!"),
                    configuration.getTranslator().__("Sucesso"),
                    JOptionPane.INFORMATION_MESSAGE
                );
                configuration.getView().dispose();
                configuration.removeEntity("airport");
                configuration.clearQueryStrings();
                goToMenu();
            } else {
                JOptionPane.showMessageDialog(
                    null,
                    configuration.getTranslator().__(
                        "Não foi possível finalizar a exclusão do Aeroporto."
                    ),
                    configuration.getTranslator().__("Erro"),
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}
