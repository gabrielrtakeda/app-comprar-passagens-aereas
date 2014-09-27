package project.modules.ChooseLanguage.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Application.View.AbstractView;
import project.modules.Authentication.View.AuthenticationView;
import project.modules.Translation.Translator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class ChooseLanguageActionListener extends AbstractActionListener
{
    public ChooseLanguageActionListener()
    {}

    public ChooseLanguageActionListener(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setActionListener(this));
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
        new AuthenticationView(config);
    }
}
