package project.modules.Passenger.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
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

        // Entidade do Grid
        ColoredGridDependencyEntity gridEntity = new ColoredGridDependencyEntity();
        gridEntity.setGridBagLayout(gridBagLayout)
                  .setGridBagConstraints(gridBagConstraints)
                  .setPanelSize(new Dimension(725, 30))
                  .setLineColumns(new Integer[] {1, 4})
                  .setBackgroundColor("gray", new Color(204, 204, 204))
                  .setBackgroundColor("white", Color.WHITE);

        // Título
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(10, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildSubTitleLabel(
                configuration.getTranslator().__("Passageiro Responsável")
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Formulário: Passageiro Responsável
        Component[][] components = {
            // Nome | Data de Nascimento
            new Component[] {
                new JLabel(configuration.getTranslator().__("Nome Completo") + ":"),
                new JLabel(
                    passengerEntity.getFormaTratamento() + " " +
                    passengerEntity.getNomeCompleto()
                ),
                new JLabel(configuration.getTranslator().__("Data de Nascimento") + ":"),
                new JLabel(passengerEntity.getDataNascimento())
            },
            // Perfil | Responsável
            new Component[] {
                new JLabel(configuration.getTranslator().__("Perfil") + ":"),
                new JLabel(passengerEntity.getPerfil()),
                new JLabel(configuration.getTranslator().__("Responsável") + ":"),
                new JLabel(
                    passengerEntity.getResponsavel()
                    ? configuration.getTranslator().__("Sim")
                    : configuration.getTranslator().__("Não")
                )
            },
            // Email | Telefone para contato
            new Component[] {
                new JLabel(configuration.getTranslator().__("Email") + ":"),
                new JLabel(passengerEntity.getEmail()),
                new JLabel(configuration.getTranslator().__("Telefone para contato") + ":"),
                new JLabel(passengerEntity.getTelefone()),
            }
        };
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        ColoredGridLayout.make(
            this,
            gridEntity.setGridBagConstraints(gridBagConstraints)
                      .setComponents(components)
        );
    }
}
