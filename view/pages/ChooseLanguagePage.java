package project.view.pages;

import project.view.panels.ChooseLanguagePanel;

public class ChooseLanguagePage extends AbstractPage
{
    public ChooseLanguagePage()
    {
        super("Linguagem");

        getContentPane().add(new ChooseLanguagePanel());
        pack();
        showPage();
    }
}
