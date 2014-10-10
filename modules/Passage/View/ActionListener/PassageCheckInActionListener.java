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
        JOptionPane.showMessageDialog(
            null,
            config.getTranslator().__("Check In efetuado com sucesso"),
            config.getTranslator().__("Sucesso"),
            JOptionPane.INFORMATION_MESSAGE
        );
        config.getView().dispose();
        if (config.getUser().isSupervisor()) {
            new MenuSupervisorView(config);
        } else {
            new MenuAtendenteView(config);
        }
    }
}
