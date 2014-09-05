package project.view.pages;

import project.view.panels.AuthenticationPanel;

public class AuthenticationPage extends AbstractPage
{
    public AuthenticationPage()
    {
        super("Autenticação");

        getContentPane().add(new AuthenticationPanel());
        pack();
        showPage();
    }
}
