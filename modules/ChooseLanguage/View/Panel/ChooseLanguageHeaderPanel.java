package project.modules.ChooseLanguage.View.Panel;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class ChooseLanguageHeaderPanel extends JPanel
{
    public ChooseLanguageHeaderPanel()
    {
        super(new GridBagLayout());
        add(new JLabel("Selecione o idioma"));
    }
}
