package project.modules.Application.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.ChooseLanguage.View.Panel.ChooseLanguageWidgetPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class ApplicationBaseLayoutFooterPanel extends JPanel
{
    public static Boolean SHOW_LOGIN_DATETIME = true;
    public static Boolean HIDE_LOGIN_DATETIME = false;

    public ApplicationBaseLayoutFooterPanel(ConfigurationEntity configuration)
    {
        build(configuration, SHOW_LOGIN_DATETIME);
    }

    public ApplicationBaseLayoutFooterPanel(ConfigurationEntity configuration,
                                            Boolean showLoginDatetime)
    {
        build(configuration, showLoginDatetime);
    }

    private void build(ConfigurationEntity configuration,
                       Boolean showLoginDatetime)
    {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 3, 3, 3));
        add(
            new ChooseLanguageWidgetPanel(configuration),
            BorderLayout.WEST
        );
        if (showLoginDatetime) {
            add(
                buildLoginLabel(
                    configuration.getTranslator().__("Logado desde") + ": " +
                    configuration.getUser().getDataLogin()
                ), BorderLayout.EAST
            );
        }
    }

    private JLabel buildLoginLabel(String message)
    {
        JLabel label = new JLabel(message);
        label.setFont(new Font("Arial", Font.PLAIN, 10));
        return label;
    }
}
