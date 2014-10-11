package project.modules.Airplane.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Airplane.View.Template.AirplaneRegisterRasterizeTemplate;

public class AirplaneRegisterRasterizeView extends AbstractView
{
    public AirplaneRegisterRasterizeView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Cadastrar Aeronave"));
        setTemplate(new AirplaneRegisterRasterizeTemplate(configuration));
        showTemplate();
    }
}
