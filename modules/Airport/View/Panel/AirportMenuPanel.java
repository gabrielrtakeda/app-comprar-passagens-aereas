package project.modules.Airport.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Airport.View.ActionListener.AirportMenuNavigationActionListener;
import project.modules.Airport.View.ActionListener.AirportRegisterViewActionListener;
import project.modules.Airport.View.ActionListener.AirportConsultViewActionListener;
import project.modules.Airport.View.ActionListener.AirportEditViewActionListener;
import project.modules.Airport.View.ActionListener.AirportDeleteViewActionListener;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;

public class AirportMenuPanel extends JPanel
{
    public AirportMenuPanel(ConfigurationEntity configuration)
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        // Navigation Button
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildNavigationButton(
                new AirportMenuNavigationActionListener(configuration)
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Botões
        JPanel airportMenuPanel = new JPanel(new GridLayout(4, 1));
        String buttonIconsDirectoryPath = "/images/buttonIcons/";

        airportMenuPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Cadastrar"),
                buttonIconsDirectoryPath + "plus.png",
                new AirportRegisterViewActionListener(configuration)
            )
        );
        airportMenuPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Consultar"),
                buttonIconsDirectoryPath + "search.png",
                new AirportConsultViewActionListener(configuration)
            )
        );
        airportMenuPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Editar"),
                buttonIconsDirectoryPath + "config.png",
                new AirportEditViewActionListener(configuration)
            )
        );
        airportMenuPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Excluir"),
                buttonIconsDirectoryPath + "brainstorming.png",
                new AirportDeleteViewActionListener(configuration)
            )
        );
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.insets = new Insets(0, 45, 0, 45);
        AbstractGridBagLayout.addGridBagElement(
            this,
            airportMenuPanel,
            gridBagLayout,
            gridBagConstraints
        );
    }
}
