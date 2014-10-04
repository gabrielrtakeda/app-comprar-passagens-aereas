package project.modules.Passage.View.ActionListener;

import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Passage.View.PassageConsultView;
import java.awt.event.ActionEvent;

public class PassageConsultResultNavigationActionListener extends AbstractActionListener
{
    public PassageConsultResultNavigationActionListener(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setActionListener(this));
    }

    public void actionPerformed(ActionEvent e)
    {
        config.getView().dispose();
        new PassageConsultView(config);
    }
}
