package project.modules.Menu.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Button.ImageButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuSupervisorPanel extends JPanel
{
    public MenuSupervisorPanel(ConfigurationEntity configuration)
    {
        super(new BorderLayout());

        add(new MenuAtendentePanel(configuration), BorderLayout.NORTH);
        add(buildSupervisorPanel(configuration), BorderLayout.SOUTH);
    }

    private JPanel buildSupervisorPanel(ConfigurationEntity configuration)
    {
        String imageDirectoryPath = "/images/buttonIcons/";

        JPanel supervisorPanel = new JPanel(new GridLayout(3, 1));
        supervisorPanel.setBorder(new EmptyBorder(0, 45, 0, 45));

        supervisorPanel.add(new ImageButton(
            configuration.getTranslator().__("Cadastrar Voos"),
            imageDirectoryPath + "calendar.png")
        );
        supervisorPanel.add(new ImageButton(
            configuration.getTranslator().__("Cadastrar Aeronaves"),
            imageDirectoryPath + "shipping.png"
        ));
        supervisorPanel.add(new ImageButton(
            configuration.getTranslator().__("Consultar Vendas"),
            imageDirectoryPath + "bank.png"
        ));

        return supervisorPanel;
    }
}
