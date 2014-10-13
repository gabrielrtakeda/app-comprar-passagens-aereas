package project.modules.Flight.View.Template;

import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Panel.ApplicationBaseLayoutHeaderPanel;
import project.modules.Application.View.Panel.ApplicationBaseLayoutFooterPanel;
import project.modules.Flight.View.Panel.FlightRegisterPanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;

public class FlightRegisterTemplate extends AbstractTemplate
{
    public FlightRegisterTemplate(ConfigurationEntity configuration)
    {
        configuration.setTemplate(this);
        setConfiguration(configuration);

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        add(new ApplicationBaseLayoutHeaderPanel(configuration), BorderLayout.NORTH);
        add(new ApplicationBaseLayoutFooterPanel(configuration), BorderLayout.SOUTH);
        add(new FlightRegisterPanel(configuration), BorderLayout.CENTER);
    }
}
