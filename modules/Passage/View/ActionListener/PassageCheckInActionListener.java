package project.modules.Passage.View.ActionListener;

import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Menu.View.MenuSupervisorView;
import project.modules.Menu.View.MenuAtendenteView;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class PassageCheckInActionListener extends AbstractActionListener
{
    public PassageCheckInActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        Integer optionsResult = JOptionPane.showConfirmDialog(
            null,
            configuration.getTranslator().__("Confirma o Check In?"),
            configuration.getTranslator().__("Confirmação do Check In"),
            JOptionPane.YES_NO_OPTION
        );

        if (optionsResult == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(
                null,
                configuration.getTranslator().__("Check In efetuado com sucesso"),
                configuration.getTranslator().__("Sucesso"),
                JOptionPane.INFORMATION_MESSAGE
            );
            configuration.getView().dispose();
            if (configuration.getUser().isSupervisor()) {
                new MenuSupervisorView(configuration);
            } else {
                new MenuAtendenteView(configuration);
            }
        }
    }
}
