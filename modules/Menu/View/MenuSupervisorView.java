package project.modules.Menu.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Menu.View.Template.MenuSupervisorTemplate;

public class MenuSupervisorView extends AbstractView
{
    public MenuSupervisorView(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setView(this));
        setTitle(
            config.getTranslator().__("Menu Inicial")
        );
        setTemplate(new MenuSupervisorTemplate(config));
        showTemplate();
    }
}
