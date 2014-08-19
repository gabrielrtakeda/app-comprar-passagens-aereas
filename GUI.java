package project;

import project.view.pages.ChooseLanguagePage;
import javax.swing.JFrame;

public class GUI
{
    public static JFrame page;
    public static String language;

    public GUI()
    {
        page = new ChooseLanguagePage();
    }

    public static void main(String args[])
    {
        new GUI();
    }
}
