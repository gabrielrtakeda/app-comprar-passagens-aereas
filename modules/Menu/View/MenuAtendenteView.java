package project.modules.Menu.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Menu.View.Template.MenuAtendenteTemplate;
import project.modules.Authentication.View.Template.AuthenticationTemplate;

public class MenuAtendenteView extends AbstractView
{
    public MenuAtendenteView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        configuration.setPreviousTemplate(new AuthenticationTemplate(configuration));
        setConfiguration(configuration);
        setTitle(
            configuration.getTranslator().__("Menu Inicial")
        );
        setTemplate(new MenuAtendenteTemplate(configuration));
        showTemplate();
    }
}
