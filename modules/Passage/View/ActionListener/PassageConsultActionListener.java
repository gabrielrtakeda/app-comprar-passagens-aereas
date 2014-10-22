package project.modules.Passage.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Passage.View.PassageConsultView;
import java.awt.event.ActionEvent;

public class PassageConsultActionListener extends AbstractActionListener
{
    public PassageConsultActionListener(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setActionListener(this));
    }

    public void actionPerformed(ActionEvent e)
    {
        configuration.getView().dispose();
        new PassageConsultView(configuration);
    }
}
