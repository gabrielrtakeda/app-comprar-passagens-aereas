package project.modules.Airplane.View.Template;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.Application.View.Panel.ApplicationBaseLayoutHeaderPanel;
import project.modules.Application.View.Panel.ApplicationBaseLayoutFooterPanel;
import project.modules.Airplane.View.Panel.AirplaneRasterizePanel;
import java.awt.BorderLayout;

public class AirplaneRasterizeTemplate extends AbstractTemplate
{
    public AirplaneRasterizeTemplate(ConfigurationEntity configuration)
    {
        configuration.setTemplate(this);
        setConfiguration(configuration);

        setLayout(new BorderLayout());
        add(new ApplicationBaseLayoutHeaderPanel(configuration), BorderLayout.NORTH);
        add(new ApplicationBaseLayoutFooterPanel(configuration), BorderLayout.SOUTH);
        add(new AirplaneRasterizePanel(configuration), BorderLayout.CENTER);
    }
}
