package project.modules.Passenger.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Passenger.Entity.PassengerEntity;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class RasterizeResponsiblePassengerInformationPanel extends JPanel
{
    public RasterizeResponsiblePassengerInformationPanel(ConfigurationEntity configuration,
                                                         PassengerEntity passengerEntity)
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(10, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            buildTitleLabel(configuration.getTranslator().__("Passageiro Responsável")),
            gridBagLayout,
            gridBagConstraints
        );

        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        Dimension lineDimension = new Dimension(725, 30);
        Integer[] lineColumns = {1, 4};

        // Nome, Data de Nascimento
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        Component[] components = {
            new JLabel(configuration.getTranslator().__("Nome Completo") + ":"),
            new JLabel(
                passengerEntity.getFormaTratamento() + " " +
                passengerEntity.getNomeCompleto()
            ),
            new JLabel(configuration.getTranslator().__("Data de Nascimento") + ":"),
            new JLabel(passengerEntity.getDataNascimento()),
        };
        AbstractGridBagLayout.addGridBagElement(
            this,
            ColoredGridLayout.build(
                ColoredGridLayout.allBorders,
                Color.BLACK,
                lineDimension,
                lineColumns,
                new Color(204, 204, 204),
                components
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Perfil, Responsável
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        components = new Component[] {
            new JLabel(configuration.getTranslator().__("Perfil") + ":"),
            new JLabel(passengerEntity.getPerfil()),
            new JLabel(configuration.getTranslator().__("Responsável") + ":"),
            new JLabel(
                passengerEntity.getResponsavel()
                ? configuration.getTranslator().__("Sim")
                : configuration.getTranslator().__("Não")
            ),
        };
        AbstractGridBagLayout.addGridBagElement(
            this,
            ColoredGridLayout.build(
                ColoredGridLayout.sidesBorders,
                Color.BLACK,
                lineDimension,
                lineColumns,
                Color.WHITE,
                components
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Email, Telefone para contato
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        components = new Component[] {
            new JLabel(configuration.getTranslator().__("Email") + ":"),
            new JLabel(passengerEntity.getEmail()),
            new JLabel(configuration.getTranslator().__("Telefone para contato") + ":"),
            new JLabel(passengerEntity.getTelefone()),
        };
        AbstractGridBagLayout.addGridBagElement(
            this,
            ColoredGridLayout.build(
                ColoredGridLayout.allBorders,
                Color.BLACK,
                lineDimension,
                lineColumns,
                new Color(204, 204, 204),
                components
            ),
            gridBagLayout,
            gridBagConstraints
        );
    }

    private JLabel buildTitleLabel(String message)
    {
        JLabel title = new JLabel(message);
        title.setFont(new Font("Arial", Font.PLAIN, 14));
        return title;
    }
}
