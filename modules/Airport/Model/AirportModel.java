package project.modules.Airport.Model;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.AbstractEntity;
import project.modules.Application.Model.AbstractModel;
import project.modules.Airport.Entity.AirportEntity;
import project.modules.Airport.DataAccessObject.AirportDAO;
import project.modules.Airport.Type.AirportConsultSearchComboType;
import project.modules.Airport.View.AirportConsultResultView;
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

    public Boolean register(AirportEntity airportEntity)
    {
        Boolean result = false;
        Integer optionsResult = JOptionPane.showConfirmDialog(
            null,
            config.getTranslator().__("Confirma o cadastro do Aeroporto?"),
            config.getTranslator().__("Confirmação de Cadastro do Aeroporto"),
            JOptionPane.YES_NO_OPTION
        );

        if (optionsResult == JOptionPane.YES_OPTION) {
            result = dao().register(airportEntity);

            String message, title;
            Integer type;
            if (result) {
                JOptionPane.showMessageDialog(
                    null,
                    config.getTranslator().__("Aeroporto cadastrado com sucesso!"),
                    config.getTranslator().__("Sucesso"),
                    JOptionPane.INFORMATION_MESSAGE
                );
                config.getView().dispose();
                goToMenu();
            } else {
                JOptionPane.showMessageDialog(
                    null,
                    config.getTranslator().__(
                        "Não foi possível finalizar o cadastro do Aeroporto."),
                    config.getTranslator().__("Erro"),
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
        return result;
    }

    public void consultBy(AirportConsultSearchComboType columnType,
                                         String search)
    {
        List<AbstractEntity> airportEntities = null;
        if (search.isEmpty()) {
            JOptionPane.showMessageDialog(
                null,
                config.getTranslator().__("Por favor, preencha o campo") + ": " + columnType.toString(),
                config.getTranslator().__("Campo Obrigatório"),
                JOptionPane.ERROR_MESSAGE
            );
        } else {
            airportEntities = dao().consultBy(
                ((AirportConsultSearchComboType) columnType).getValue(),
                search
            );

            if (airportEntities.size() < 1) {
                JOptionPane.showMessageDialog(
                    null,
                    config.getTranslator().__("Nenhum registro foi encontrado."),
                    config.getTranslator().__("Resultado"),
                    JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                config.getView().dispose();
                config.setEntitiesCollection(airportEntities);
                new AirportConsultResultView(config);
            }
        }
    }
}
