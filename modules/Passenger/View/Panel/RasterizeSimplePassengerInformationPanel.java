package project.modules.Passenger.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Passenger.Entity.PassengerEntity;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class RasterizeSimplePassengerInformationPanel extends JPanel
{
    public RasterizeSimplePassengerInformationPanel(ConfigurationEntity configuration,
                                                    PassengerEntity[] passengers)
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        // Especificação das colunas
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(10, 0, 10, 0);
        String[] columnsList = {
            configuration.getTranslator().__("Nome Completo"),
            configuration.getTranslator().__("Perfil")
        };
        AbstractGridBagLayout.addGridBagElement(
            this,
            buildColumnsSpecification(columnsList),
            gridBagLayout,
            gridBagConstraints
        );

        // Dados dos Passageiros
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        for (JPanel line : preparePassengersColoredGrid(passengers)) {
            AbstractGridBagLayout.addGridBagElement(
                this,
                line,
                gridBagLayout,
                gridBagConstraints
            );
        }
    }

    private JPanel buildColumnsSpecification(String[] columnsList)
    {
        JPanel columnsPanel = new JPanel(
            new GridLayout(1, columnsList.length)
        );
        columnsPanel.setPreferredSize(new Dimension(450, 20));

        for (String column : columnsList) {
            JLabel columnLabel = new JLabel(column);
            columnLabel.setHorizontalAlignment(JLabel.CENTER);
            columnsPanel.add(columnLabel);
        }
        return columnsPanel;
    }

    private JPanel[] preparePassengersColoredGrid(PassengerEntity[] passengers)
    {
        JPanel[] fullGrid = new JPanel[passengers.length];
        Integer count = 0;
        JPanel colorGrid = new JPanel();

        for (PassengerEntity passenger : passengers) {
            JLabel nome = new JLabel(
                passenger.getFormaTratamento() + " " +
                passenger.getNomeCompleto());
            nome.setHorizontalAlignment(JLabel.CENTER);

            JLabel perfil = new JLabel(passenger.getPerfil());
            perfil.setHorizontalAlignment(JLabel.CENTER);

            Component[] components = { nome, perfil };
            Integer[] lineColumns = {1, 2};

            if (count == 0) {
                colorGrid =
                    ColoredGridLayout.build(
                        ColoredGridLayout.allBorders,
                        Color.BLACK,
                        new Dimension(450, 30),
                        lineColumns,
                        new Color(204, 204, 204),
                        components
                    );
            } else {
                colorGrid =
                    ColoredGridLayout.build(
                        ColoredGridLayout.exceptTopBorders,
                        Color.BLACK,
                        new Dimension(450, 30),
                        lineColumns,
                        count % 2 == 0
                            ? new Color(204, 204, 204)
                            : Color.WHITE,
                        components
                    );
            }
            fullGrid[count] = colorGrid;
            count++;
        }
        return fullGrid;
    }
}
