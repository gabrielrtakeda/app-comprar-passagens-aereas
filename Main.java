package project;

import project.modules.Application.Controller.AbstractController;
import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.ChooseLanguage.View.ChooseLanguageView;
import project.modules.Passage.View.PassageConsultView;
import project.modules.Translation.Translator;

public class Main
{
    public Main()
    {
        new ChooseLanguageView(new ConfigurationEntity());
    }

    // public Main()
    // {
    //     ConfigurationEntity configurationEntity = new ConfigurationEntity();
    //     configurationEntity.setTranslator(new Translator("br"));
    //     new PassageConsultView(configurationEntity);
    // }

    public static void main(String args[])
    {
        new Main();
    }
}
