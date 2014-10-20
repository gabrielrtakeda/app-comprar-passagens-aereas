package project.modules.Airport.View.Template;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.Application.View.Panel.ApplicationBaseLayoutHeaderPanel;
import project.modules.Application.View.Panel.ApplicationBaseLayoutFooterPanel;
import project.modules.Airport.View.Panel.AirportRegisterRasterizePanel;
import java.awt.BorderLayout;

public class AirportRegisterRasterizeTemplate extends AbstractTemplate
{
    public AirportRegisterRasterizeTemplate(ConfigurationEntity configuration)
    {
        configuration.setTemplate(this);
        setConfiguration(configuration);

        setLayout(new BorderLayout());
        add(new ApplicationBaseLayoutHeaderPanel(configuration), BorderLayout.NORTH);
        add(new ApplicationBaseLayoutFooterPanel(configuration), BorderLayout.SOUTH);
        add(new AirportRegisterRasterizePanel(configuration), BorderLayout.CENTER);
    }
}
