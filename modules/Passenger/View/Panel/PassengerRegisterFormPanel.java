package project.modules.Passenger.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Passenger.View.ActionListener.PassengerRegisterCloseFormActionListener;
import project.modules.Passenger.View.ActionListener.PassengerRegisterActionListener;
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
import javax.swing.JButton;
import javax.swing.BorderFactory;

public class PassengerRegisterFormPanel extends JPanel
{
    public PassengerRegisterFormPanel(ConfigurationEntity configuration)
    {
        super(new BorderLayout());

        add(buildTitleLabel("Dados Cadastrais"), BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(6, 1));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        Dimension lineDimension = new Dimension(400, 30);
        Integer[] lineColumns = {1, 2};
        Color grayBackground = new Color(204, 204, 204);
        Color whiteBackground = new Color(255, 255, 255);

        String[] formasTratamento = {
            configuration.getTranslator().__("Sr."),
            configuration.getTranslator().__("Sra."),
            configuration.getTranslator().__("Srta."),
            configuration.getTranslator().__("Dr."),
            configuration.getTranslator().__("Dra.")
        };
        JComboBox<String> formaTratamentoComboBox = new JComboBox<String>(formasTratamento);
        Component[] components = {
            new JLabel(configuration.getTranslator().__("Forma de tratamento") + ":"),
            formaTratamentoComboBox,
        };
        formPanel.add(
            ColoredGridLayout.build(
                ColoredGridLayout.allBorders,
                Color.BLACK,
                lineDimension,
                lineColumns,
                grayBackground,
                components
            )
        );

        components = new Component[] {
            new JLabel(
                configuration.getTranslator().__("Data de Nascimento") + ":"
            ),
            new JTextField()
        };
        formPanel.add(
            ColoredGridLayout.build(
                ColoredGridLayout.exceptTopBorders,
                Color.BLACK,
                lineDimension,
                lineColumns,
                whiteBackground,
                components
            )
        );

        components = new Component[] {
            new JLabel(
                configuration.getTranslator().__("Nome Completo") + ":"
            ),
            new JTextField()
        };
        formPanel.add(
            ColoredGridLayout.build(
                ColoredGridLayout.exceptTopBorders,
                Color.BLACK,
                lineDimension,
                lineColumns,
                grayBackground,
                components
            )
        );

        JPanel responsavelOpcoesPanel = new JPanel(new FlowLayout());
        responsavelOpcoesPanel.setBackground(whiteBackground);

        JRadioButton simRadioButton = new JRadioButton();
        simRadioButton.setBackground(whiteBackground);
        responsavelOpcoesPanel.add(simRadioButton);
        responsavelOpcoesPanel.add(
            new JLabel(
                configuration.getTranslator().__("Sim")
            )
        );

        JRadioButton naoRadioButton = new JRadioButton();
        naoRadioButton.setBackground(whiteBackground);
        responsavelOpcoesPanel.add(naoRadioButton);
        responsavelOpcoesPanel.add(
            new JLabel(
                configuration.getTranslator().__("Não")
            )
        );

        components = new Component[] {
            new JLabel(
                configuration.getTranslator().__("Responsável pela compra?")
            ),
            responsavelOpcoesPanel
        };
        formPanel.add(
            ColoredGridLayout.build(
                ColoredGridLayout.exceptTopBorders,
                Color.BLACK,
                lineDimension,
                lineColumns,
                whiteBackground,
                components
            )
        );

        components = new Component[] {
            new JLabel(
                configuration.getTranslator().__("Email") + ":"
            ),
            new JTextField()
        };
        formPanel.add(
            ColoredGridLayout.build(
                ColoredGridLayout.exceptTopBorders,
                Color.BLACK,
                lineDimension,
                lineColumns,
                grayBackground,
                components
            )
        );

        components = new Component[] {
            new JLabel(
                configuration.getTranslator().__("Telefone para contato") + ":"
            ),
            new JTextField()
        };
        formPanel.add(
            ColoredGridLayout.build(
                ColoredGridLayout.exceptTopBorders,
                Color.BLACK,
                lineDimension,
                lineColumns,
                whiteBackground,
                components
            )
        );
        add(formPanel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        buttonsPanel.setPreferredSize(new Dimension(200, 60));
        buttonsPanel.add(
            buildButtonWithActionListener(
                new JButton(
                    configuration.getTranslator().__("Voltar")
                ),
                new PassengerRegisterCloseFormActionListener(configuration)
            )
        );
        buttonsPanel.add(
            buildButtonWithActionListener(
                new JButton(
                    configuration.getTranslator().__("Cadastrar")
                ),
                new PassengerRegisterActionListener(configuration)
            )
        );
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    private JLabel buildTitleLabel(String message)
    {
        JLabel label = new JLabel(message, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        return label;
    }

    private JButton buildButtonWithActionListener(JButton button, ActionListener actionListener)
    {
        button.addActionListener(actionListener);
        return button;
    }
}
