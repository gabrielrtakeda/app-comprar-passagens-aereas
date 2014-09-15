package project.modules.Menu.View.Panel;

import project.modules.Application.View.Button.ImageButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuSupervisorPanel extends JPanel
{
    public MenuSupervisorPanel()
    {
        super(new BorderLayout());

        add(new MenuAtendentePanel(), BorderLayout.NORTH);
        add(buildSupervisorPanel(), BorderLayout.SOUTH);
    }

    private JPanel buildSupervisorPanel()
    {
        String imageDirectoryPath = "/images/buttonIcons/";

        JPanel supervisorPanel = new JPanel(new GridLayout(3, 1));
        supervisorPanel.setBorder(new EmptyBorder(0, 45, 0, 45));

        supervisorPanel.add(new ImageButton(
            "Cadastrar Voos",
            imageDirectoryPath + "calendar.png")
        );
        supervisorPanel.add(new ImageButton(
            "Cadastrar Aeronaves",
            imageDirectoryPath + "shipping.png"
        ));
        supervisorPanel.add(new ImageButton(
            "Consultar Vendas",
            imageDirectoryPath + "bank.png"
        ));

        return supervisorPanel;
    }
}
