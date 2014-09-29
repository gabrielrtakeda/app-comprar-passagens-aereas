package project.modules.Passenger.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Passenger.View.ActionListener.PassengerRegisterShowFormActionListener;
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
        addGridBagElement(
            buildTitleLabel(
                configuration.getTranslator().__("Informações dos Passageiros")
            ),
            gridBagLayout,
            gridBagConstraints
        );

        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        addGridBagElement(
            new ImageButton(
                configuration.getTranslator().__("Cadastrar Passageiro"),
                "/images/buttonIcons/user.png",
                new PassengerRegisterShowFormActionListener(configuration)
            ),
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

    private void addGridBagElement(Component component,
                                   GridBagLayout gridBagLayout,
                                   GridBagConstraints gridBagConstraints)
    {
        gridBagLayout.setConstraints(component, gridBagConstraints);
        add(component);
    }
}
