package project.modules.Passage.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Menu.View.MenuAtendenteView;
import project.modules.Menu.View.MenuSupervisorView;
import java.awt.event.ActionEvent;

public class PassageConsultNavigationActionListener extends AbstractActionListener
{
    public PassageConsultNavigationActionListener(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setActionListener(this));
    }

    public void actionPerformed(ActionEvent e)
    {
        config.getView().dispose();
        if(config.getUser().isSupervisor()) {
            new MenuSupervisorView(config);
         } else {
            new MenuAtendenteView(config);
         }
    }
}
