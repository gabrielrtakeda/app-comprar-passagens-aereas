package project.modules.Authentication.View.Template;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.Application.View.Panel.ApplicationBaseLayoutFooterPanel;
import project.modules.Authentication.View.Panel.AuthenticationHeaderPanel;
import project.modules.Authentication.View.Panel.AuthenticationFormPanel;
import project.modules.ChooseLanguage.View.Panel.ChooseLanguageWidgetPanel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AuthenticationTemplate extends AbstractTemplate
{
    public AuthenticationTemplate(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setTemplate(this));
        setLayout(new BorderLayout());
        add(new AuthenticationHeaderPanel(), BorderLayout.NORTH);
        add(new ApplicationBaseLayoutFooterPanel(
                config,
                ApplicationBaseLayoutFooterPanel.HIDE_LOGIN_DATETIME
            ), BorderLayout.SOUTH
        );
        add(new AuthenticationFormPanel(config));
    }
}
