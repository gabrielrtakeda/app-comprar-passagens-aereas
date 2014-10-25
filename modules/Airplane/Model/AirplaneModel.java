package project.modules.Airplane.Model;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Model.AbstractModel;
import project.modules.Airplane.DataAccessObject.AirplaneDAO;
import project.modules.Airplane.Entity.AirplaneEntity;
import project.modules.Airplane.View.AirplaneMenuView;
import project.modules.Airplane.View.AirplaneRegisterView;
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

    public void confirmRegister()
    {
        Integer optionsResult = JOptionPane.showConfirmDialog(
            null,
            configuration.getTranslator().__("Confirma o cadastro da Aeronave?"),
            configuration.getTranslator().__("Confirmação de Cadastro da Aeronave"),
            JOptionPane.YES_NO_OPTION
        );

        if (optionsResult == JOptionPane.YES_OPTION) {
            AirplaneEntity airplaneEntity = (AirplaneEntity) configuration.getEntity("airplane");
            Boolean result = dao().register(airplaneEntity);

            if (result) {
                JOptionPane.showMessageDialog(
                    null,
                    configuration.getTranslator().__("Aeronave cadastrada com sucesso!"),
                    configuration.getTranslator().__("Sucesso"),
                    JOptionPane.INFORMATION_MESSAGE
                );
                configuration.getView().dispose();
                goToMenu();
            } else {
                JOptionPane.showMessageDialog(
                    null,
                    configuration.getTranslator().__(
                        "Não foi possível finalizar o cadastro da Aeronave."
                    ),
                    configuration.getTranslator().__("Erro"),
                    JOptionPane.INFORMATION_MESSAGE
                );
                configuration.getView().dispose();
                goToMenu();
            }
        }
    }
}
