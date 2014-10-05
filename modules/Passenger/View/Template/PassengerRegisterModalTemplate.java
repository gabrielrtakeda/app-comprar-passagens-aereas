package project.modules.Passenger.View.Template;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.Application.View.Panel.ApplicationBaseLayoutHeaderPanel;
import project.modules.Application.View.Panel.ApplicationBaseLayoutFooterPanel;
import project.modules.Passenger.View.Panel.PassengerRegisterFormPanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;

public class PassengerRegisterModalTemplate extends AbstractTemplate
{
    public PassengerRegisterModalTemplate(ConfigurationEntity configuration)
    {
        configuration.setTemplate(this);
        setConfiguration(configuration);

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        add(new ApplicationBaseLayoutHeaderPanel(config), BorderLayout.NORTH);
        add(new ApplicationBaseLayoutFooterPanel(config), BorderLayout.SOUTH);
        add(new PassengerRegisterFormPanel(config), BorderLayout.CENTER);
    }
}
