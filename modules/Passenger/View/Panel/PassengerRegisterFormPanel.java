package project.modules.Passenger.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Passenger.Entity.PassengerEntity;
import project.modules.Passenger.View.ActionListener.PassengerRegisterModalCloseActionListener;
import project.modules.Passenger.View.ActionListener.PassengerRegisterActionListener;
import project.modules.Passenger.Type.SalutationType;
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
import java.util.List;
import java.util.ArrayList;
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
    /**
     * @var Boolean responsibleLayout
     * Define se o passageiro é o responsável.
     */
    protected Boolean responsibleLayout = false;

    /**
     * @var PassengerRegisterActionListener
     */
    protected PassengerRegisterActionListener passengerRegisterActionListener;

    public PassengerRegisterFormPanel(ConfigurationEntity configuration)
    {
        this.responsibleLayout =
            configuration.getQueryString("passenger-register:responsible-passenger")
                .equals("true") ? true : false;

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

        /**
         * Formulário: Dados Cadastrais
         */
        passengerRegisterActionListener =
            new PassengerRegisterActionListener(configuration);

        List<Component[]> components = new ArrayList<Component[]>();
        components.add(
            new Component[] {
                new JLabel(configuration.getTranslator().__("Responsável pela compra?")),
                buildResponsiblePassengerRadioGroup(configuration)
            }
        );
        components.add(
            new Component[] {
                new JLabel(configuration.getTranslator().__("Forma de tratamento") + ":"),
                passengerRegisterActionListener.addComponent(
                    "salutation",
                    new JComboBox<SalutationType>(
                        new SalutationType[] {
                            new SalutationType(configuration, "Selecione...", "selecione"),
                            new SalutationType(configuration, "Sr.", PassengerEntity.SALUTATION_MISTER),
                            new SalutationType(configuration, "Sra.", PassengerEntity.SALUTATION_MISIZ),
                            new SalutationType(configuration, "Srta.", PassengerEntity.SALUTATION_MISS),
                            new SalutationType(configuration, "Madame", PassengerEntity.SALUTATION_MADAM),
                        }
                    )
                )
            }
        );
        components.add(
            new Component[] {
                new JLabel(configuration.getTranslator().__("Data de Nascimento") + ":"),
                passengerRegisterActionListener.addComponent(
                    "birth-date",
                    new JTextField()
                )
            }
        );
        components.add(
            new Component[] {
                new JLabel("CPF:"),
                passengerRegisterActionListener.addComponent(
                    "cpf",
                    new JTextField()
                )
            }
        );
        components.add(
            new Component[] {
                new JLabel(configuration.getTranslator().__("Nome Completo") + ":"),
                passengerRegisterActionListener.addComponent(
                    "name",
                    new JTextField()
                )
            }
        );
        if (responsibleLayout) {
            components.add(
                new Component[] {
                    new JLabel(configuration.getTranslator().__("Email") + ":"),
                    passengerRegisterActionListener.addComponent(
                        "email",
                        new JTextField()
                    )
                }
            );
            components.add(
                new Component[] {
                    new JLabel(configuration.getTranslator().__("Telefone para contato") + ":"),
                    passengerRegisterActionListener.addComponent(
                        "phone",
                        new JTextField()
                    )
                }
            );
        }
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        ColoredGridLayout.make(
            this,
            gridEntity.setGridBagConstraints(gridBagConstraints)
                      .setComponents(components.toArray(new Component[components.size()][]))
        );

        /**
         * Invetando todos os Components na ActionListener
         * para finalizar o processo de cadastro de passageiros.
         */
        PassengerRegisterModalCloseActionListener
            passengerRegisterModalCloseActionListener =
                new PassengerRegisterModalCloseActionListener(configuration);
        passengerRegisterModalCloseActionListener.setComponents(
            passengerRegisterActionListener.getComponents()
        );

        /**
         * Botões
         */
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Finalizar"),
                "/images/buttonIcons/thunderbolt.png",
                new Dimension(200, 40),
                passengerRegisterModalCloseActionListener
            )
        );
        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Cadastrar"),
                "/images/buttonIcons/check.png",
                new Dimension(200, 40),
                passengerRegisterActionListener
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

    /**
     * Método responsável por agrupar os Radio
     * Buttons de Passageiro Responsável.
     * @return JPanel
     */
    private JPanel buildResponsiblePassengerRadioGroup(ConfigurationEntity configuration)
    {
        JPanel responsavelOpcoesPanel = new JPanel(new FlowLayout());
        responsavelOpcoesPanel.setBackground(new Color(204, 204, 204));

        JRadioButton simRadioButton = new JRadioButton(configuration.getTranslator().__("Sim"));
        JRadioButton naoRadioButton = new JRadioButton(configuration.getTranslator().__("Não"));
        simRadioButton.setEnabled(false);
        naoRadioButton.setEnabled(false);

        if (responsibleLayout) {
            simRadioButton.setSelected(true);
        } else {
            naoRadioButton.setSelected(true);
        }

        /**
         * Passar os elementos para o ActionListener
         * para pegar o item selecionado.
         */
        passengerRegisterActionListener.addComponent(
            "responsible-passenger:yes",
            simRadioButton
        );
        passengerRegisterActionListener.addComponent(
            "responsible-passenger:no",
            naoRadioButton
        );

        /**
         * Agrupar os Radio Buttons.
         */
        ButtonGroup responsibleRadioGroup = new ButtonGroup();
        responsibleRadioGroup.add(simRadioButton);
        responsibleRadioGroup.add(naoRadioButton);

        /**
         * Adicionar o grupo de Radio Buttons no JPanel interno.
         */
        responsavelOpcoesPanel.add(simRadioButton);
        responsavelOpcoesPanel.add(naoRadioButton);

        return responsavelOpcoesPanel;
    }
}
