package project.modules.Passage.View.ActionListener;

import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Menu.View.MenuSupervisorView;
import project.modules.Menu.View.MenuAtendenteView;
import java.awt.event.ActionEvent;

public class PassageInformationsNavigationActionListener extends AbstractActionListener
{
    public PassageInformationsNavigationActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        configuration.getView().dispose();
        if (configuration.getUser().isSupervisor()) {
            new MenuSupervisorView(configuration);
        } else {
            new MenuAtendenteView(configuration);
        }
    }
}
