package project.modules.ChooseLanguage.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Application.View.AbstractView;
import project.modules.Application.View.GenericView;
import project.modules.Authentication.View.AuthenticationView;
import project.modules.Menu.View.MenuSupervisorView;
import project.modules.Translation.Translator;
import java.lang.reflect.Constructor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

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

        if (widget == USING_WIDGET) {
            try {
                config.getView().dispose();
                // Class<?> reflectionClass = Class.forName("project.modules.Authentication.View.AuthenticationView");
                Class<?> reflectionClass = Class.forName(config.getView().getClass().getName());
                Constructor<?> reflectionConstructor = reflectionClass.getConstructor(ConfigurationEntity.class);
                AbstractView reflectionView = (AbstractView) reflectionConstructor.newInstance(config);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            System.out.println(config.toString());
        } else {
            config.getView().dispose();
            new AuthenticationView(config);
        }
    }
}
