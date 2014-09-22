package project.modules.Authentication.View;

import project.modules.Application.View.AbstractView;
import project.modules.Authentication.View.Template.AuthenticationTemplate;

public class AuthenticationView extends AbstractView
{
    public AuthenticationView()
    {
        setTitle("Autenticação");
        setTemplate(new AuthenticationTemplate());
        showTemplate();
    }
}
