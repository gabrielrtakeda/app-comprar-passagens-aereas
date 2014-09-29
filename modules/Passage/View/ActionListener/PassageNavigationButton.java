package project.modules.Passage.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Menu.View.MenuSupervisorView;
import project.modules.Passage.View.PassageNavigationView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PassageNavigationButton extends AbstractActionListener
{
    public PassageNavigationButton(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setActionListener(this));
    }

    public void actionPerformed(ActionEvent e)
    {
        config.getView().dispose();

        switch (e.getActionCommand()) {
            case "back":
                new PassageNavigationView(
                    config,
                    // config.getView().getTitle(),
                    "Autenticação",
                    config.getPreviousTemplate()
                );
                break;
        }
    }
}
