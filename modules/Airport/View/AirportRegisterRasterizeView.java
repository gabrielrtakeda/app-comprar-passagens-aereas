package project.modules.Airport.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Airport.View.Template.AirportRegisterRasterizeTemplate;

public class AirportRegisterRasterizeView extends AbstractView
{
    public AirportRegisterRasterizeView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Cadastro de Aeroporto"));
        setTemplate(new AirportRegisterRasterizeTemplate(configuration));
        showTemplate();
    }
}
