package project.modules.Flight.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Flight.Controller.FlightController;
import project.modules.Flight.Entity.FlightEntity;
import project.modules.Flight.View.ActionListener.FlightRegisterNavigationActionListener;
import project.modules.Flight.View.ActionListener.FlightRasterizeActionListener;
import project.modules.Flight.Type.FlightStatusType;
import project.modules.Airplane.Type.AirplaneEntityComboType;
import project.modules.Airport.Type.AirportEntityComboType;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class FlightRegisterPanel extends JPanel
{
    private ConfigurationEntity configuration;

    public FlightRegisterPanel(ConfigurationEntity configuration)
    {
        this.configuration = configuration;

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        ColoredGridDependencyEntity gridEntity = new ColoredGridDependencyEntity();
        gridEntity.setGridBagLayout(gridBagLayout)
                  .setGridBagConstraints(gridBagConstraints)
                  .setPanelSize(new Dimension(450, 30))
                  .setLineColumns(new Integer[] {1, 2})
                  .setBackgroundColor("gray", new Color(204, 204, 204))
                  .setBackgroundColor("white", Color.WHITE);

        // Navigation Button
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildNavigationButton(
                new FlightRegisterNavigationActionListener(configuration)
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Título
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildTitleLabel(
                configuration.getTranslator().__("Dados do Voo")
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Pegar dados para popular os ComboBoxes.
        AirplaneEntityComboType[]
            airplaneTypes = getController().getAirplaneEntitiesComboTypeAction();
        AirportEntityComboType[]
            airportTypes = getController().getAirportEntitiesComboTypeAction();
        FlightStatusType[]
            flightStatusTypes = getController().getFlightStatusTypesAction();

        /**
         * Se existir a entidade `flight` na configuração já setada,
         * exibir o formulário preenchido com esses valores.
         */
        Integer airplaneDefaultSelected = 0,
                airportOriginDefaultSelected = 0,
                airportDestinationDefaultSelected = 0,
                flightStatusDefaultSelected = 0;
        String priceDefined = "",
               dateDepartureDefined = "";

        if (configuration.hasEntity("flight")) {
            FlightEntity flightEntity = (FlightEntity) configuration.getEntity("flight");

            airplaneDefaultSelected = getAirplaneComboSelectedIndex(
                airplaneTypes,
                flightEntity.getAirplane().getId()
            );
            airportOriginDefaultSelected = getAirportComboSelectedIndex(
                airportTypes,
                flightEntity.getAirportOrigin().getId()
            );
            airportDestinationDefaultSelected = getAirportComboSelectedIndex(
                airportTypes,
                flightEntity.getAirportDestination().getId()
            );
            flightStatusDefaultSelected = getFlightStatusComboSelectedIndex(
                flightStatusTypes,
                flightEntity.getStatus()
            );
            priceDefined = String.valueOf(flightEntity.getPrice());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateDepartureDefined = dateFormat.format(flightEntity.getDateDeparture());
        }

        /**
         * Seta os ComboBoxes em variáveis.
         * Possibilitando a escolha de qual item virá selecionado por default.
         */
        JComboBox<AirplaneEntityComboType> airplaneCombo =
            new JComboBox<AirplaneEntityComboType>(airplaneTypes);
        airplaneCombo.setSelectedIndex(airplaneDefaultSelected);

        JComboBox<AirportEntityComboType> airportOriginCombo =
            new JComboBox<AirportEntityComboType>(airportTypes);
        airportOriginCombo.setSelectedIndex(airportOriginDefaultSelected);

        JComboBox<AirportEntityComboType> airportDestinationCombo =
            new JComboBox<AirportEntityComboType>(airportTypes);
        airportDestinationCombo.setSelectedIndex(airportDestinationDefaultSelected);

        JComboBox<FlightStatusType> flightStatusCombo =
            new JComboBox<FlightStatusType>(flightStatusTypes);
        flightStatusCombo.setSelectedIndex(flightStatusDefaultSelected);

        /**
         * Form
         */
        AbstractActionListener
            rasterizeActionListener = new FlightRasterizeActionListener(configuration);

        Component[][] components = {
            new Component[] {
                new JLabel(configuration.getTranslator().__("Aeronave") + ":"),
                rasterizeActionListener.addComponent(
                    "airplane",
                    airplaneCombo
                )
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Aeroporto de Origem") + ":"),
                rasterizeActionListener.addComponent(
                    "airport-origin",
                    airportOriginCombo
                )
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Aeroporto de Destino") + ":"),
                rasterizeActionListener.addComponent(
                    "airport-destination",
                    airportDestinationCombo
                )
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Valor") + " (R$) :"),
                rasterizeActionListener.addComponent(
                    "price",
                    new JTextField(priceDefined)
                )
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Status") + ":"),
                rasterizeActionListener.addComponent(
                    "status",
                    flightStatusCombo
                )
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Data Partida") + " :"),
                rasterizeActionListener.addComponent(
                    "date-departure",
                    new JTextField(dateDepartureDefined)
                )
            }
        };

        /**
         * Buttons
         */
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        ColoredGridLayout.make(
            this,
            gridEntity.setComponents(components)
        );

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Voltar"),
                "/images/buttonIcons/arrow-left.png",
                new Dimension(225, 40),
                new FlightRegisterNavigationActionListener(configuration)
            )
        );
        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Continuar"),
                "/images/buttonIcons/check.png",
                new Dimension(225, 40),
                rasterizeActionListener
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

    private Integer getAirplaneComboSelectedIndex(AirplaneEntityComboType[] airplaneTypes,
                                                  Integer airplaneSelectedId)
    {
        Integer index = 0;
        for (AirplaneEntityComboType type : airplaneTypes) {
            if (type.getId() == airplaneSelectedId) {
                break;
            }
            index++;
        }
        return index;
    }

    private Integer getAirportComboSelectedIndex(AirportEntityComboType[] airportTypes,
                                                 Integer airportSelectedId)
    {
        Integer index = 0;
        for (AirportEntityComboType type : airportTypes) {
            if (type.getId() == airportSelectedId) {
                break;
            }
            index++;
        }
        return index;
    }

    private Integer getFlightStatusComboSelectedIndex(FlightStatusType[] flightStatusTypes,
                                                      String flightStatusSelectedValue)
    {
        Integer index = 0;
        for (FlightStatusType type : flightStatusTypes) {
            if (type.getValue().equals(flightStatusSelectedValue)) {
                break;
            } else {
                index++;
            }
        }
        return index;
    }

    public FlightController getController()
    {
        return new FlightController(configuration);
    }
}
