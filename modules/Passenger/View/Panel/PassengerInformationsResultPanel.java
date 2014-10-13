package project.modules.Passenger.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Passenger.Entity.PassengerEntity;
import project.modules.Passenger.View.ActionListener.PassengerRegisterModalActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PassengerInformationsResultPanel extends JPanel
{
    public PassengerInformationsResultPanel(ConfigurationEntity configuration)
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

        // Informações dos Passageiros
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildTitleLabel(
                configuration.getTranslator().__("Informações dos Passageiros")
            ),
            gridBagLayout,
            gridBagConstraints
        );

        Component[][] components = {
            // Perfil Adulto
            new Component[] {
                new JLabel(configuration.getTranslator().__("Perfil") + ":"),
                new JLabel("Adulto (Temporário)"),
                new JLabel(configuration.getTranslator().__("Total de Passageiros") + ":"),
                new JLabel("2 (Temporário)")
            },
            // Perfil Criança
            new Component[] {
                new JLabel(configuration.getTranslator().__("Perfil") + ":"),
                new JLabel("Criança (Temporário)"),
                new JLabel(configuration.getTranslator().__("Total de Passageiros") + ":"),
                new JLabel("1 (Temporário)")
            }
        };
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        ColoredGridLayout.make(
            this,
            gridEntity.setGridBagConstraints(gridBagConstraints)
                      .setComponents(components)
        );

        // Passageiro Responsável
        AbstractGridBagLayout.addGridBagElement(
            this,
            new RasterizeResponsiblePassengerInformationPanel(
                configuration,
                buildResponsiblePassenger()
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Outros Passageiros
        AbstractGridBagLayout.addGridBagElement(
            this,
            new RasterizeSimplePassengerInformationPanel(
                configuration,
                buildOthersPassenger()
            ),
            gridBagLayout,
            gridBagConstraints
        );
    }

    /**
     * Mock:
     * Preencher com dados do Banco de Dados.
     */
    private PassengerEntity buildResponsiblePassenger()
    {
        PassengerEntity passengerEntity = new PassengerEntity();
        return passengerEntity.setId(1)
                              .setFormaTratamento("Sr.")
                              .setDataNascimento("14/04/1992")
                              .setNomeCompleto("Gabriel Ramos Takeda")
                              .setResponsavel(true)
                              .setEmail("gabrieel.rt@gmail.com")
                              .setTelefone("(11) 97999-9994")
                              .setPerfil("Adulto");
    }

    /**
     * Mock:
     * Preencher com dados do Banco de Dados.
     */
    private PassengerEntity[] buildOthersPassenger()
    {
        PassengerEntity[] passengers = new PassengerEntity[2];

        PassengerEntity passengerEntity = new PassengerEntity();
        passengers[0] = passengerEntity.setId(2)
                                       .setFormaTratamento("Sra.")
                                       .setDataNascimento("15/12/1996")
                                       .setNomeCompleto("Joyce dos Santos Ferreira")
                                       .setResponsavel(false)
                                       .setEmail("joyce@teste.com")
                                       .setTelefone("(11) 96666-6666")
                                       .setPerfil("Adulto");

        passengerEntity = new PassengerEntity();
        passengers[1] = passengerEntity.setId(3)
                                       .setFormaTratamento("Srta.")
                                       .setDataNascimento("01/01/2011")
                                       .setNomeCompleto("Beatriz Ramos Takeda")
                                       .setResponsavel(false)
                                       .setEmail("beatriz@teste.com")
                                       .setTelefone("(11) 97777-7777")
                                       .setPerfil("Criança");
        return passengers;
    }
}
