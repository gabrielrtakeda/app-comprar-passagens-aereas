package project.modules.Menu.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Passage.View.ActionListener.PassagePurchaseActionListener;
import project.modules.Passage.View.ActionListener.PassageConsultActionListener;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuAtendentePanel extends JPanel
{
    public MenuAtendentePanel(ConfigurationEntity configuration)
    {
        super(new GridLayout(4, 1));
        setBorder(new EmptyBorder(0, 45, 0, 45));
        String imageDirectoryPath = "/images/buttonIcons/";

        add(new ImageButton(
            configuration.getTranslator().__("Compra de Passagem"),
            imageDirectoryPath + "basket.png",
            new PassagePurchaseActionListener(configuration)
        ));
        add(new ImageButton(
            configuration.getTranslator().__("Check-in"),
            imageDirectoryPath + "check.png",
            new PassageConsultActionListener(configuration)
        ));
        add(new ImageButton(
            configuration.getTranslator().__("Cancelamento"),
            imageDirectoryPath + "advertising.png"
        ));
        add(new ImageButton(
            configuration.getTranslator().__("Transferência"),
            imageDirectoryPath + "refresh.png"
        ));
    }
}
