package project.modules.Application.View.Modal;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import java.awt.event.WindowEvent;
import java.awt.LayoutManager;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Container;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class AbstractModal extends JDialog
{
    protected ConfigurationEntity configuration;

    public AbstractModal(AbstractView owner)
    {
        super(owner);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public void setConfiguration(ConfigurationEntity configuration)
    {
        this.configuration = configuration;
    }

    public ConfigurationEntity getConfiguration()
    {
        return configuration;
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

    public void showModal()
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
