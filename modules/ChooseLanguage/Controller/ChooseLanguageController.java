package project.modules.ChooseLanguage.Controller;

import project.modules.Application.Controller.AbstractController;
import project.modules.ChooseLanguage.View.ChooseLanguageView;

public class ChooseLanguageController extends AbstractController
{
    public ChooseLanguageController()
    {
        setView(new ChooseLanguageView());
    }

    public ChooseLanguageController(String viewFlavour)
    {
        /**
         * TODO: Mix Factory and Strategy Pattern to
         * instantiate correct View : Default | Widget
         */
        setView();
    }
}
