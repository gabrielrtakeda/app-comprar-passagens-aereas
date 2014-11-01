package project.modules.Flight.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Flight.View.ActionListener.FlightMenuNavigationActionListener;
import project.modules.Flight.View.ActionListener.FlightRegisterViewActionListener;
import project.modules.Flight.View.ActionListener.FlightConsultViewActionListener;
import project.modules.Flight.View.ActionListener.FlightEditViewActionListener;
import project.modules.Flight.View.ActionListener.FlightDeleteViewActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;

public class FlightMenuPanel extends JPanel
{
    public FlightMenuPanel(ConfigurationEntity configuration)
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        // Navigation Button
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildNavigationButton(
                new FlightMenuNavigationActionListener(configuration)
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Menu Buttons
        String imageDirectoryPath = "/images/buttonIcons/";
        JPanel menuGridPanel = new JPanel(new GridLayout(4, 1));

        menuGridPanel.add(new ImageButton(
            configuration.getTranslator().__("Cadastrar"),
            imageDirectoryPath + "plus.png",
            new FlightRegisterViewActionListener(configuration)
        ));
        menuGridPanel.add(new ImageButton(
            configuration.getTranslator().__("Consultar"),
            imageDirectoryPath + "search.png",
            new FlightConsultViewActionListener(configuration)
        ));
        menuGridPanel.add(new ImageButton(
            configuration.getTranslator().__("Editar"),
            imageDirectoryPath + "config.png",
            new FlightEditViewActionListener(configuration)
        ));
        menuGridPanel.add(new ImageButton(
            configuration.getTranslator().__("Cancelar"),
            imageDirectoryPath + "brainstorming.png",
            new FlightDeleteViewActionListener(configuration)
        ));
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.insets = new Insets(0, 45, 0, 45);
        AbstractGridBagLayout.addGridBagElement(
            this,
            menuGridPanel,
            gridBagLayout,
            gridBagConstraints
        );
    }
}
