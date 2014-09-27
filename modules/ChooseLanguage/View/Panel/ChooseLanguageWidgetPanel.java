package project.modules.ChooseLanguage.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Button.TransparentButton;
import project.modules.ChooseLanguage.View.ActionListener.ChooseLanguageActionListener;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class ChooseLanguageWidgetPanel extends JPanel
{
    protected String[] arLanguages = {"br", "uk", "es", "fr"};

    public ChooseLanguageWidgetPanel(ConfigurationEntity configuration)
    {
        super(new GridLayout(1, 4));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        for (String language : arLanguages) {
            TransparentButton button =
                new TransparentButton(
                    new ImageIcon(getClass().getResource("/images/" + language + "_22x16.png")),
                    new Dimension(22, 16)
                );
            button.addActionListener(new ChooseLanguageActionListener(configuration));
            button.setActionCommand(language);
            add(button);
        }
    }
}
