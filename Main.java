package project;

import project.modules.Application.Translation.Translator;
import project.modules.Application.Controller.AbstractController;
import project.modules.Application.View.AbstractView;
import project.modules.ChooseLanguage.Controller.ChooseLanguageController;
import javax.swing.JFrame;

public class Main
{
    public static Translator translator;
    public static AbstractController controller;
    public static AbstractView view;

    public Main()
    {
        controller = new ChooseLanguageController();
    }

    public static void main(String args[])
    {
        new Main();
    }
}
