package project.modules.ChooseLanguage.Model;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Model.AbstractModel;
import project.modules.Application.View.AbstractView;
import project.modules.Translation.Translator;
import project.modules.ChooseLanguage.View.ChooseLanguageView;
import project.modules.Authentication.Controller.AuthenticationController;
import java.lang.reflect.Constructor;

public class ChooseLanguageModel extends AbstractModel
{
    public ChooseLanguageModel(ConfigurationEntity configuration)
    {
        configuration.setModel(this);
        setConfiguration(configuration);
    }

    public void index()
    {
        new ChooseLanguageView(configuration);
    }

    public void translator(String language)
    {
        configuration.setTranslator(new Translator(language));
        setConfiguration(configuration);
    }

    public void authentication()
    {
        configuration.getView().dispose();
        AuthenticationController
            authenticationController = new AuthenticationController(configuration);
        authenticationController.indexAction();
    }

    public void changeLanguage()
    {
        configuration.getView().dispose();
        configuration.removeQueryString("using-widget");
        try {
            Class<?> reflectionClass =
                Class.forName(configuration.getView().getClass().getName());

            Constructor<?> reflectionConstructor =
                reflectionClass.getConstructor(ConfigurationEntity.class);

            AbstractView reflectionView =
                (AbstractView) reflectionConstructor.newInstance(configuration);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
