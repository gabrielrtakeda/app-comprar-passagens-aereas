package project.modules.Authentication.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Authentication.View.Template.AuthenticationTemplate;
import project.modules.ChooseLanguage.View.Template.ChooseLanguageDefaultTemplate;

public class AuthenticationView extends AbstractView
{
    public AuthenticationView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        configuration.setPreviousTemplate(new ChooseLanguageDefaultTemplate(configuration));
        setConfiguration(configuration);
        setTitle(
            configuration.getTranslator().__("Autenticação")
        );
        setTemplate(new AuthenticationTemplate(configuration));
        showTemplate();
    }
}
