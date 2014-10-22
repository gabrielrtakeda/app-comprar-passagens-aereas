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
            configuration.getTranslator().__("Confirma o cadastro da Aeronave?"),
            configuration.getTranslator().__("Confirmação de Cadastro da Aeronave"),
            JOptionPane.YES_NO_OPTION
        );

        if (optionsResult == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(
                null,
                configuration.getTranslator().__("Aeronave cadastrada com sucesso!"),
                configuration.getTranslator().__("Sucesso"),
                JOptionPane.INFORMATION_MESSAGE
            );
            configuration.getView().dispose();
            goToMenu();
        }
    }
}
