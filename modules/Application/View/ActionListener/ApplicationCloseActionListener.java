package project.modules.Application.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class ApplicationCloseActionListener extends AbstractActionListener
{
    public ApplicationCloseActionListener(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setActionListener(this));
    }

    public void actionPerformed(ActionEvent e)
    {
        Integer optionsResult = JOptionPane.showConfirmDialog(
            null,
            configuration.getTranslator().__("Tem certeza que deseja encerrar a sessão?"),
            configuration.getTranslator().__("Requisição de encerramento de sessão"),
            JOptionPane.YES_NO_OPTION
        );

        if (optionsResult == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
