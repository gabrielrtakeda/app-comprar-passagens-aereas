package project.view.pages;

import java.awt.GridBagLayout;
import java.awt.Container;
import project.view.panels.AuthenticationPanel;

public class AuthenticationPage extends AbstractPage
{
    public AuthenticationPage()
    {
        super("Autenticação");

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        container.add(new AuthenticationPanel());
        pack();
        showPage();
    }
}
