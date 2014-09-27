package project.modules.Menu.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Menu.View.Template.MenuAtendenteTemplate;

public class MenuAtendenteView extends AbstractView
{
    public MenuAtendenteView(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setView(this));
        setTitle(
            config.getTranslator().__("Menu Inicial")
        );
        setTemplate(new MenuAtendenteTemplate(config));
        showTemplate();
    }
}
