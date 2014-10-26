package project.modules.Airplane.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Airplane.View.ActionListener.AirplaneMenuNavigationActionListener;
import project.modules.Airplane.View.ActionListener.AirplaneRegisterViewActionListener;
import project.modules.Airplane.View.ActionListener.AirplaneConsultViewActionListener;
import project.modules.Airplane.View.ActionListener.AirplaneEditViewActionListener;
import project.modules.Airplane.View.ActionListener.AirplaneDeleteViewActionListener;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;

public class AirplaneMenuPanel extends JPanel
{
    public AirplaneMenuPanel(ConfigurationEntity configuration)
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        // Navigation Button
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildNavigationButton(
                new AirplaneMenuNavigationActionListener(configuration)
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
                new AirplaneRegisterViewActionListener(configuration)
            )
        );
        airportMenuPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Consultar"),
                buttonIconsDirectoryPath + "search.png",
                new AirplaneConsultViewActionListener(configuration)
            )
        );
        airportMenuPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Editar"),
                buttonIconsDirectoryPath + "config.png",
                new AirplaneEditViewActionListener(configuration)
            )
        );
        airportMenuPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Excluir"),
                buttonIconsDirectoryPath + "brainstorming.png",
                new AirplaneDeleteViewActionListener(configuration)
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
