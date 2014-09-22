package project.modules.Passage.View.Panel;

import project.modules.Application.View.AbstractView;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Passage.View.ActionListener.PassageInformationNavigationButton;
import project.modules.Passenger.View.Panel.PassengerInformationsPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;

public class PassageInformationsPanel extends JPanel
{
    protected AbstractView view;

    public PassageInformationsPanel(AbstractView view)
    {
        this.view = view;

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        setLayout(gridBagLayout);

        JPanel navigationButton = new JPanel(new BorderLayout());
        navigationButton.add(
            buildNavigationButton(),
            BorderLayout.WEST
        );
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.gridwidth  =GridBagConstraints.REMAINDER;
        AbstractGridBagLayout.addGridBagElement(
            this,
            navigationButton,
            gridBagLayout,
            gridBagConstraints
        );

        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            buildTitleLabel("Informações da Passagem"),
            gridBagLayout,
            gridBagConstraints
        );

        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        Integer[] allBorders = {1, 1, 1, 1};
        Integer[] sidesBorders = {0, 1, 0, 1};
        Integer[] bottomSidesBorders = {1, 1, 0, 1};
        Integer[] lineColumns = {1, 4};
        Dimension lineDimension = new Dimension(725, 30);

        String[] destinos = {
            "Aeroporto de Congonhas",
            "Aeroporto de Guarulhos",
            "Aeroporto de Melborn",
            "Aeroporto de Los Angeles"
        };
        JComboBox<String> destinosComboBox = new JComboBox<String>(destinos);

        Component[] components = {
            new JLabel("Destino:"),
            destinosComboBox,
            new JLabel("Data Partida:"),
            new JTextField(20)
        };
        AbstractGridBagLayout.addGridBagElement(
            this,
            ColoredGridLayout.build(
                allBorders,
                Color.BLACK,
                lineDimension,
                lineColumns,
                new Color(204, 204, 204),
                components
            ),
            gridBagLayout,
            gridBagConstraints
        );

        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        AbstractGridBagLayout.addGridBagElement(
            this,
            new ImageButton(
                "Validar Disponibilidade",
                "/images/buttonIcons/check.png"
            ),
            gridBagLayout,
            gridBagConstraints
        );

        AbstractGridBagLayout.addGridBagElement(
            this,
            new PassengerInformationsPanel(),
            gridBagLayout,
            gridBagConstraints
        );
    }

    private JLabel buildTitleLabel(String message)
    {
        JLabel label = new JLabel(message);
        label.setFont(new Font("Arial", Font.PLAIN, 19));
        return label;
    }

    private JButton buildNavigationButton()
    {
        JButton backButton = new JButton(
            new ImageIcon(getClass().getResource("/images/buttonIcons/arrow-left.png"))
        );
        backButton.setPreferredSize(new Dimension(25, 25));
        backButton.setFocusable(false);
        backButton.setActionCommand("back");
        backButton.addActionListener(
            new PassageInformationNavigationButton(view)
        );
        return backButton;
    }
}
