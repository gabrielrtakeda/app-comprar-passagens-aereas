package project.modules.Menu.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Menu.Controller.MenuController;
import project.modules.Flight.View.ActionListener.FlightMenuViewActionListener;
import project.modules.Airplane.View.ActionListener.AirplaneRegisterViewActionListener;
import project.modules.Airport.View.ActionListener.AirportMenuViewActionListener;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuSupervisorPanel extends JPanel
{
    private ConfigurationEntity configuration;

    public MenuSupervisorPanel(ConfigurationEntity configuration)
    {
        this.configuration = configuration;

        setLayout(new BorderLayout());
        add(new MenuAtendentePanel(configuration), BorderLayout.NORTH);
        add(buildSupervisorPanel(), BorderLayout.SOUTH);
    }

    private JPanel buildSupervisorPanel()
    {
        String imageDirectoryPath = "/images/buttonIcons/";

        JPanel supervisorPanel = new JPanel(new GridLayout(4, 1));
        supervisorPanel.setBorder(new EmptyBorder(0, 45, 0, 45));

        supervisorPanel.add(new ImageButton(
            configuration.getTranslator().__("Voos"),
            imageDirectoryPath + "calendar.png",
            new FlightMenuViewActionListener(configuration)
        ));
        supervisorPanel.add(new ImageButton(
            configuration.getTranslator().__("Cadastrar Aeronaves"),
            imageDirectoryPath + "shipping.png",
            new AirplaneRegisterViewActionListener(configuration)
        ));
        supervisorPanel.add(new ImageButton(
            configuration.getTranslator().__("Aeroportos"),
            imageDirectoryPath + "world.png",
            getController().airportMenuAction()
        ));
        supervisorPanel.add(new ImageButton(
            configuration.getTranslator().__("Consultar Vendas"),
            imageDirectoryPath + "bank.png"
        ));

        return supervisorPanel;
    }

    private MenuController getController()
    {
        return new MenuController(configuration);
    }
}
