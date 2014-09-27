package project.modules.Passage.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Menu.View.MenuSupervisorView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PassageInformationNavigationButton extends AbstractActionListener
{
    public PassageInformationNavigationButton(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setActionListener(this));
    }

    public void actionPerformed(ActionEvent e)
    {
        config.getView().dispose();

        switch (e.getActionCommand()) {
            case "back":
                new MenuSupervisorView(config);
                break;
        }
    }
}
