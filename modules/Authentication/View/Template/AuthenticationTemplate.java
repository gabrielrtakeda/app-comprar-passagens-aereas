package project.modules.Authentication.View.Template;

import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.Authentication.View.Panel.AuthenticationHeaderPanel;
import project.modules.Authentication.View.Panel.AuthenticationFormPanel;
import project.modules.ChooseLanguage.View.Panel.ChooseLanguageWidgetPanel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AuthenticationTemplate extends AbstractTemplate
{
	public AuthenticationTemplate()
	{
		setLayout(new BorderLayout());
        add(new AuthenticationHeaderPanel(), BorderLayout.NORTH);
        add(new AuthenticationFormPanel(), BorderLayout.CENTER);

        JPanel baseTemplateFooter = new JPanel();
        baseTemplateFooter.setLayout(new BorderLayout());
        baseTemplateFooter.setBorder(new EmptyBorder(0, 15, 15, 0));
        baseTemplateFooter.add(new ChooseLanguageWidgetPanel(), BorderLayout.WEST);
        add(baseTemplateFooter, BorderLayout.SOUTH);
	}
}
