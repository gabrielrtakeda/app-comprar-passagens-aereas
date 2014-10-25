package project.modules.Airplane.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Airplane.View.Template.AirplaneRasterizeTemplate;

public class AirplaneRasterizeView extends AbstractView
{
    public AirplaneRasterizeView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Cadastrar Aeronave"));
        setTemplate(new AirplaneRasterizeTemplate(configuration));
        showTemplate();
    }
}
