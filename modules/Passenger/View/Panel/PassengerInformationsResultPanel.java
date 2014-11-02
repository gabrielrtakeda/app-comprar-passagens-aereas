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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        PassengerEntity passengerEntity = new PassengerEntity();
        try {
            passengerEntity.setId(1)
                           .setSalutation("Sr.")
                           .setDateBirth(dateFormat.parse("1992-04-14"))
                           .setFullName("Gabriel Ramos Takeda")
                           .setResponsible(true)
                           .setEmail("gabrieel.rt@gmail.com")
                           .setPhone("(11) 97999-9994")
                           .setProfile("Adulto");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passengerEntity;
    }

    /**
     * Mock:
     * Preencher com dados do Banco de Dados.
     */
    private PassengerEntity[] buildOthersPassenger()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        PassengerEntity[] passengers = new PassengerEntity[2];
        PassengerEntity passengerEntity = new PassengerEntity();

        try {
            passengers[0] = passengerEntity.setId(2)
                                           .setSalutation("Sra.")
                                           .setDateBirth(dateFormat.parse("1996-12-15"))
                                           .setFullName("Joyce dos Santos Ferreira")
                                           .setResponsible(false)
                                           .setEmail("joyce@teste.com")
                                           .setPhone("(11) 96666-6666")
                                           .setProfile("Adulto");

            passengerEntity = new PassengerEntity();
            passengers[1] = passengerEntity.setId(3)
                                           .setSalutation("Srta.")
                                           .setDateBirth(dateFormat.parse("2011-01-01"))
                                           .setFullName("Beatriz Ramos Takeda")
                                           .setResponsible(false)
                                           .setEmail("beatriz@teste.com")
                                           .setPhone("(11) 97777-7777")
                                           .setProfile("Criança");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passengers;
    }
}
