package project.modules.ChooseLanguage.Controller;

import project.modules.Application.Controller.AbstractController;
import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.ChooseLanguage.Model.ChooseLanguageModel;

public class ChooseLanguageController extends AbstractController
{
    ChooseLanguageModel model;
    public ChooseLanguageController(ConfigurationEntity configuration)
    {
        configuration.setController(this);
        setConfiguration(configuration);

        model = new ChooseLanguageModel(configuration);
    }

    public void indexAction()
    {
        model.index();
    }

    public void translatorAction(String language)
    {
        model.translator(language);
    }

    public void authenticationAction()
    {
        model.authentication();
    }

    public void changeLanguageAction()
    {
        model.changeLanguage();
    }
}
