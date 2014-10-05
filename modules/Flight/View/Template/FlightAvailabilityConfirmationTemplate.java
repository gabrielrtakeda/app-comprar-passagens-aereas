package project.modules.Flight.View.Template;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.Application.View.Panel.ApplicationBaseLayoutHeaderPanel;
import project.modules.Application.View.Panel.ApplicationBaseLayoutFooterPanel;
import project.modules.Flight.View.Panel.FlightAvailabilityConfirmationPanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;

public class FlightAvailabilityConfirmationTemplate extends AbstractTemplate
{
    public FlightAvailabilityConfirmationTemplate(ConfigurationEntity configuration)
    {
        configuration.setTemplate(this);
        setConfiguration(configuration);

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        add(new ApplicationBaseLayoutHeaderPanel(config), BorderLayout.NORTH);
        add(new ApplicationBaseLayoutFooterPanel(config), BorderLayout.SOUTH);
        add(new FlightAvailabilityConfirmationPanel(config), BorderLayout.CENTER);
    }
}
