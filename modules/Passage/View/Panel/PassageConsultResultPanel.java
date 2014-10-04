package project.modules.Passage.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Passage.View.ActionListener.PassageConsultResultNavigationActionListener;
import project.modules.Passage.View.ActionListener.PassageConsultResultActionListener;
import project.modules.Passage.View.Panel.PassageConsultPanel;
import project.modules.Passage.View.Panel.PassageInformationsResultPanel;
import project.modules.Passenger.View.Panel.PassengerInformationsPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
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

public class PassageConsultResultPanel extends JPanel
{
    public PassageConsultResultPanel(ConfigurationEntity configuration)
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        // Navigation Button
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        AbstractGridBagLayout.addGridBagElement(
            this,
            buildNavigationBackButton(configuration),
            gridBagLayout,
            gridBagConstraints
        );

        // Consultar Passagem
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        AbstractGridBagLayout.addGridBagElement(
            this,
            new PassageConsultPanel(
                configuration,
                PassageConsultPanel.HIDE_NAVIGATION_BUTTON
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Separation Line
        gridBagConstraints.insets = new Insets(10, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            new JLabel("Line Here"),
            gridBagLayout,
            gridBagConstraints
        );

        // Informações da Passagem
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        AbstractGridBagLayout.addGridBagElement(
            this,
            new PassageInformationsResultPanel(configuration),
            gridBagLayout,
            gridBagConstraints
        );
    }

    private JLabel buildTitleLabel(String message)
    {
        JLabel label = new JLabel(message);
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        return label;
    }

    private JButton buildNavigationBackButton(ConfigurationEntity configuration)
    {
        JButton backButton = new JButton(
            new ImageIcon(getClass().getResource("/images/buttonIcons/arrow-left.png"))
        );
        backButton.setPreferredSize(new Dimension(25, 25));
        backButton.setFocusable(false);
        backButton.setActionCommand("back");
        backButton.addActionListener(
            new PassageConsultResultNavigationActionListener(configuration)
        );
        return backButton;
    }
}
