package project;

import project.modules.Application.Translation.Translator;
import project.modules.Application.Controller.AbstractController;
import project.modules.Application.View.AbstractView;
import project.modules.ChooseLanguage.View.ChooseLanguageView;
import project.modules.Menu.View.MenuAtendenteView;
import project.modules.Passage.View.PassagePurchaseView;
import project.modules.Passenger.View.PassengerRegisterView;

public class Main
{
    public static Translator translator;
    public static AbstractView view;

    public Main()
    {
        view = new ChooseLanguageView();
    }

    public static void main(String args[])
    {
        new Main();
    }
}
