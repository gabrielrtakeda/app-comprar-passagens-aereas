package project.modules.Airplane.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class AirplaneRegisterConfirmationActionListener extends AbstractActionListener
{
    public AirplaneRegisterConfirmationActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        Integer optionsResult = JOptionPane.showConfirmDialog(
            null,
            config.getTranslator().__("Confirma o cadastro da Aeronave?"),
            config.getTranslator().__("Confirmação de Cadastro da Aeronave"),
            JOptionPane.YES_NO_OPTION
        );

        if (optionsResult == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(
                null,
                config.getTranslator().__("Aeronave cadastrada com sucesso!"),
                config.getTranslator().__("Sucesso"),
                JOptionPane.INFORMATION_MESSAGE
            );
            config.getView().dispose();
            goToMenu();
        }
    }
}
