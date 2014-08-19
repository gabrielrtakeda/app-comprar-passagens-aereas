package project.view.panels;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class ChooseLanguageHeaderPanel extends JPanel
{
    protected String txSelecione = "Selecione o idioma:";

    public ChooseLanguageHeaderPanel()
    {
        super(new GridBagLayout());
        add(new JLabel(txSelecione));
    }
}
