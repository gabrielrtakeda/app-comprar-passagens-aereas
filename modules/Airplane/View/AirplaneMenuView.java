package project.modules.Airplane.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Airplane.View.Template.AirplaneMenuTemplate;

public class AirplaneMenuView extends AbstractView
{
    public AirplaneMenuView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Aeronaves"));
        setTemplate(new AirplaneMenuTemplate(configuration));
        showTemplate();
    }
}
