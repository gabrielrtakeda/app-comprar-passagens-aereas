package project.modules.Passenger.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
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

        // Entidade do Grid
        ColoredGridDependencyEntity gridEntity = new ColoredGridDependencyEntity();
        gridEntity.setGridBagLayout(gridBagLayout)
                  .setGridBagConstraints(gridBagConstraints)
                  .setPanelSize(new Dimension(450, 30))
                  .setLineColumns(new Integer[] {1, 4})
                  .setBackgroundColor("gray", new Color(204, 204, 204))
                  .setBackgroundColor("white", Color.WHITE);

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
        Integer count = 0;
        Component[][] components = new Component[passengers.length][2];
        for (PassengerEntity passenger : passengers) {
            JLabel nome = new JLabel(
                passenger.getSalutation() + " " +
                passenger.getFullName());
            nome.setHorizontalAlignment(JLabel.CENTER);

            JLabel perfil = new JLabel(passenger.getProfile());
            perfil.setHorizontalAlignment(JLabel.CENTER);

            components[count][0] = nome;
            components[count][1] = perfil;
            count++;
        }
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        ColoredGridLayout.make(
            this,
            gridEntity.setGridBagConstraints(gridBagConstraints)
                      .setComponents(components)
        );
    }

    /**
     * Método similar ao ColoredGridLayout.make(),
     * mas com a diferença que centraliza o texto.
     * @suggest Passar para a classe ColoredGridLayout
     *          e utilizar estaticamente.
     * @return JPanel
     */
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
}
