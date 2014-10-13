package project.modules.Passenger.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Passenger.View.ActionListener.PassengerRegisterModalCloseActionListener;
import project.modules.Passenger.View.ActionListener.PassengerRegisterActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.BorderFactory;

public class PassengerRegisterFormPanel extends JPanel
{
    public PassengerRegisterFormPanel(ConfigurationEntity configuration)
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        // Entidade de Dependência do Grid
        ColoredGridDependencyEntity gridEntity = new ColoredGridDependencyEntity();
        gridEntity.setBorderColor(Color.BLACK)
                  .setPanelSize(new Dimension(400, 30))
                  .setLineColumns(new Integer[] {1, 2})
                  .setBackgroundColor("gray", new Color(204, 204, 204))
                  .setBackgroundColor("white", Color.WHITE)
                  .setGridBagLayout(gridBagLayout);

        // Título
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildTitleLabel(
                configuration.getTranslator().__("Dados Cadastrais")
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Formulário: Dados Cadastrais
        Component[][] components = {
            new Component[] {
                new JLabel(configuration.getTranslator().__("Forma de tratamento") + ":"),
                new JComboBox<String>(
                    new String[] {
                        configuration.getTranslator().__("Selecione..."),
                        configuration.getTranslator().__("Sr."),
                        configuration.getTranslator().__("Sra."),
                        configuration.getTranslator().__("Srta."),
                        configuration.getTranslator().__("Dr."),
                        configuration.getTranslator().__("Dra.")
                    }
                )
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Data de Nascimento") + ":"),
                new JTextField()
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Nome Completo") + ":"),
                new JTextField()
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Responsável pela compra?")),
                buildResponsiblePassengerRadioGroup(configuration)
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Email") + ":"),
                new JTextField()
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Telefone para contato") + ":"),
                new JTextField()
            },
        };
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        ColoredGridLayout.make(
            this,
            gridEntity.setGridBagConstraints(gridBagConstraints)
                      .setComponents(components)
        );

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Voltar"),
                "/images/buttonIcons/arrow-left.png",
                new Dimension(200, 40),
                new PassengerRegisterModalCloseActionListener(configuration)
            )
        );
        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Cadastrar"),
                "/images/buttonIcons/check.png",
                new Dimension(200, 40),
                new PassengerRegisterActionListener(configuration)
            )
        );
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            buttonsPanel,
            gridBagLayout,
            gridBagConstraints
        );
    }

    private JButton buildButtonWithActionListener(JButton button, ActionListener actionListener)
    {
        button.addActionListener(actionListener);
        return button;
    }

    private JPanel buildResponsiblePassengerRadioGroup(ConfigurationEntity configuration)
    {
        JPanel responsavelOpcoesPanel = new JPanel(new FlowLayout());
        responsavelOpcoesPanel.setBackground(Color.WHITE);

        JRadioButton simRadioButton = new JRadioButton(configuration.getTranslator().__("Sim"));
        JRadioButton naoRadioButton = new JRadioButton(configuration.getTranslator().__("Não"));

        ButtonGroup responsibleRadioGroup = new ButtonGroup();
        responsibleRadioGroup.add(simRadioButton);
        responsibleRadioGroup.add(naoRadioButton);

        responsavelOpcoesPanel.add(simRadioButton);
        responsavelOpcoesPanel.add(naoRadioButton);

        return responsavelOpcoesPanel;
    }
}
