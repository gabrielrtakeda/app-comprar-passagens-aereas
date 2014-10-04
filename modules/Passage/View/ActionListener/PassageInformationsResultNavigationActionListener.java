package project.modules.Passage.View.ActionListener;

import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Application.Entity.ConfigurationEntity;
import java.awt.event.ActionEvent;

public class PassageInformationsResultNavigationActionListener extends AbstractActionListener
{
    public PassageInformationsResultNavigationActionListener(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setActionListener(this));
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("PassageInformationsResultNavigationActionListener");
    }
}
