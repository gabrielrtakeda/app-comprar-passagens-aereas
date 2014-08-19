package project.view.pages;

import project.view.panels.AuthenticationHeaderPanel;

public class AuthenticationPage extends AbstractPage
{
    public AuthenticationPage()
    {
        super("Autenticação");

        getContentPane().add(new AuthenticationHeaderPanel());
        pack();
        showPage();
    }
}
