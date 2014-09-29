package project.modules.Passage.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Passage.View.PassageConsultResultView;
import java.awt.event.ActionEvent;

public class PassageConsultResultActionListener extends AbstractActionListener
{
    public PassageConsultResultActionListener(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setActionListener(this));
    }

    public void actionPerformed(ActionEvent e)
    {
        config.getView().dispose();
        new PassageConsultResultView(config);
    }
}
