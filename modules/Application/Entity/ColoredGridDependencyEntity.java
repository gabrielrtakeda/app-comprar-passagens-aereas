package project.modules.Application.Entity;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;

public class ColoredGridDependencyEntity
{
    protected GridBagLayout gridBagLayout;
    protected GridBagConstraints gridBagConstraints;
    protected Color borderColor;
    protected Dimension panelSize;
    protected Integer[] lineColumns;
    protected HashMap<String, Color> backgroundColors;
    protected Component[][] components;

    public ColoredGridDependencyEntity setGridBagLayout(GridBagLayout gridBagLayout)
    {
        this.gridBagLayout = gridBagLayout;
        return this;
    }

    public ColoredGridDependencyEntity setGridBagConstraints(GridBagConstraints gridBagConstraints)
    {
        this.gridBagConstraints = gridBagConstraints;
        return this;
    }

    public ColoredGridDependencyEntity setBorderColor(Color borderColor)
    {
        this.borderColor = borderColor;
        return this;
    }

    public ColoredGridDependencyEntity setBorderColor(Color borderColor)
    {
        this.borderColor = borderColor;
        return this;
    }

    public ColoredGridDependencyEntity setPanelSize(Dimension panelSize)
    {
        this.panelSize = panelSize;
        return this;
    }

    public ColoredGridDependencyEntity setLineColumns(Integer[] lineColumns)
    {
        this.lineColumns = lineColumns;
        return this;
    }

    public ColoredGridDependencyEntity setBackgroundColor(String name, Color backgroundColor)
    {
        this.backgroundColors.put(name, backgroundColor);
        return this;
    }

    public ColoredGridDependencyEntity setComponents(Component[][] components)
    {
        this.components = components;
        return this;
    }

    public GridBagLayout getGridBagLayout()
    {
        return gridBagLayout;
    }

    public GridBagConstraints getGridBagConstraints()
    {
        return gridBagConstraints;
    }

    public Color getBorderColor()
    {
        return borderColor;
    }

    public Dimension getPanelSize()
    {
        return panelSize;
    }

    public Integer[] getLineColumns()
    {
        return lineColumns;
    }

    public HashMap<String, Color> getBackgroundColors()
    {
        return backgroundColors;
    }

    public Color getBackgroundColor(String name)
    {
        return backgroundColors.get(name);
    }

    public Component[][] getComponents()
    {
        return components;
    }
}
