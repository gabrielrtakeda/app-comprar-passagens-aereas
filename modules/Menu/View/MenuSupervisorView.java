package project.modules.Menu.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Menu.View.Template.MenuSupervisorTemplate;
import project.modules.Authentication.View.Template.AuthenticationTemplate;

public class MenuSupervisorView extends AbstractView
{
    public MenuSupervisorView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Menu Inicial"));
        setTemplate(new MenuSupervisorTemplate(configuration));
        showTemplate();
        System.out.println(configuration.toString());
    }
}
