package project.modules.Passenger.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Passenger.View.ActionListener.PassengerRegisterModalActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PassengerInformationsPanel extends JPanel
{
    public PassengerInformationsPanel(ConfigurationEntity configuration)
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        setLayout(gridBagLayout);

        gridBagConstraints.fill = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(30, 0, 5, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildTitleLabel(
                configuration.getTranslator().__("Informações dos Passageiros")
            ),
            gridBagLayout,
            gridBagConstraints
        );

        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            new ImageButton(
                configuration.getTranslator().__("Cadastrar Passageiro"),
                "/images/buttonIcons/user.png",
                new PassengerRegisterModalActionListener(configuration)
            ),
            gridBagLayout,
            gridBagConstraints
        );
    }
}
