package project.modules.Authentication.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Authentication.View.Template.AuthenticationTemplate;

public class AuthenticationView extends AbstractView
{
    public AuthenticationView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        setConfiguration(configuration);
        setTitle(
            config.getTranslator().__("Autenticação")
        );
        setTemplate(new AuthenticationTemplate(config));
        showTemplate();
    }
}
