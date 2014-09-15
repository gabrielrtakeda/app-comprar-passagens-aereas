package project.modules.Application.View.Panel;

import project.modules.ChooseLanguage.View.Panel.ChooseLanguageWidgetPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class ApplicationBaseLayoutFooterPanel extends JPanel
{
    public ApplicationBaseLayoutFooterPanel()
    {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 3, 3, 3));
        add(new ChooseLanguageWidgetPanel(), BorderLayout.WEST);
        add(buildLoginLabel("Login em: 13/09/2014 23:48:00"), BorderLayout.EAST);
    }

    private JLabel buildLoginLabel(String message)
    {
        JLabel label = new JLabel(message);
        label.setFont(new Font("Arial", Font.PLAIN, 10));
        return label;
    }
}
