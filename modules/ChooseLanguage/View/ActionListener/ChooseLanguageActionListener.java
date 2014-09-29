package project.modules.ChooseLanguage.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Application.View.AbstractView;
import project.modules.Application.View.GenericView;
import project.modules.Authentication.View.AuthenticationView;
import project.modules.Translation.Translator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class ChooseLanguageActionListener extends AbstractActionListener
{
    public static Boolean USING_WIDGET = true;
    public static Boolean NOT_USING_WIDGET = false;

    private Boolean widget;

    public ChooseLanguageActionListener()
    {}

    public ChooseLanguageActionListener(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setActionListener(this));
        this.widget = NOT_USING_WIDGET;
    }

    public ChooseLanguageActionListener(ConfigurationEntity configuration,
                                        Boolean widget)
    {
        setConfiguration(configuration.setActionListener(this));
        this.widget = widget;
    }

    public void actionPerformed(ActionEvent e)
    {
        String language = e.getActionCommand();
        setConfiguration(
            config.setTranslator(
                new Translator(language)
            )
        );

        config.getView().dispose();

        if (widget == USING_WIDGET) {
            new GenericView(config);
        } else {
            new AuthenticationView(config);
        }
    }
}
