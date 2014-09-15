package project.modules.Authentication.View;

import project.modules.Application.View.AbstractView;
import project.modules.Authentication.View.Template.AuthenticationTemplate;
import java.awt.GridBagLayout;
import java.awt.Container;

public class AuthenticationView extends AbstractView
{
    public AuthenticationView()
    {
        setTitle("Autenticação");
        setLayout(new GridBagLayout());
        setTemplate(new AuthenticationTemplate());
        showTemplate();
    }
}
