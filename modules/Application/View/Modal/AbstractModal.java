package project.modules.Application.View.Modal;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import java.awt.LayoutManager;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Container;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class AbstractModal extends JDialog
{
    protected ConfigurationEntity config;

    public AbstractModal(AbstractView owner)
    {
        super(owner);
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

    public Container getTemplate()
    {
        return getContentPane();
    }

    public void showModalTemplate()
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
