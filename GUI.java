package project;

import javax.swing.JFrame;
import project.view.pages.ChooseLanguagePage;
import project.translation.Translator;

public class GUI
{
    public static Translator translator;
    public static JFrame page;

    public GUI()
    {
        page = new ChooseLanguagePage();
    }

    public static void main(String args[])
    {
        new GUI();
    }
}
