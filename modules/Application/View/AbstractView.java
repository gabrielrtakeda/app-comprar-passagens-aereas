package project.modules.Application.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Interface.ConfigurationInterface;
import java.awt.LayoutManager;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class AbstractView extends JFrame
{
    protected ConfigurationEntity config;

    public AbstractView()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setConfiguration(ConfigurationEntity config)
    {
        this.config = config;
    }

    public ConfigurationEntity getConfiguration()
    {
        return config;
    }

    public void setLayout(Object layout)
    {
        getContentPane().setLayout((LayoutManager) layout);
    }

    public void setTemplate(JPanel template)
    {
        getContentPane().add(template);
    }

    public JFrame getTemplate()
    {
        return this;
    }

    public void showTemplate()
    {
        pack();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(
            (int) ((dimension.getWidth() - getWidth()) / 2),
            (int) ((dimension.getHeight() - getHeight()) / 2)
        );
        setVisible(true);
    }
}
