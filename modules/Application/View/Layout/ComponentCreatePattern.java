package project.modules.Application.View.Layout;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ComponentCreatePattern
{
    public static JLabel buildTitleLabel(String message)
    {
        JLabel title = new JLabel(message);
        title.setFont(new Font("Arial", Font.PLAIN, 18));
        return title;
    }

    public static JLabel buildSubTitleLabel(String message)
    {
        JLabel subTitle = new JLabel(message);
        subTitle.setFont(new Font("Arial", Font.PLAIN, 14));
        return subTitle;
    }

    public static JLabel buildTextLabel(String message)
    {
        JLabel text = new JLabel(message);
        text.setFont(new Font("Arial", Font.PLAIN, 10));
        return text;
    }

    public static JButton buildNavigationButton(AbstractActionListener actionListener)
    {
        JButton navigationButton = new JButton(
            new ImageIcon(
                ComponentCreatePattern.class.getResource(
                    "/images/buttonIcons/arrow-left.png"
                )
            )
        );
        navigationButton.setPreferredSize(new Dimension(25, 25));
        navigationButton.setFocusable(false);
        navigationButton.addActionListener(actionListener);
        return navigationButton;
    }

    // private JButton buildNavigationButton(ConfigurationEntity configuration)
    // {
    //     JButton backButton = new JButton(
    //         new ImageIcon(getClass().getResource("/images/buttonIcons/arrow-left.png"))
    //     );
    //     backButton.setPreferredSize(new Dimension(25, 25));
    //     backButton.setFocusable(false);
    //     backButton.setActionCommand("back");
    //     backButton.addActionListener(
    //         new PassageInformationsNavigationActionListener(configuration)
    //     );
    //     return backButton;
    // }

    // private JButton buildNavigationBackButton(ConfigurationEntity configuration)
    // {
    //     JButton backButton = new JButton(
    //         new ImageIcon(getClass().getResource("/images/buttonIcons/arrow-left.png"))
    //     );
    //     backButton.setPreferredSize(new Dimension(25, 25));
    //     backButton.setFocusable(false);
    //     backButton.setActionCommand("back");
    //     backButton.addActionListener(
    //         new PassageConsultNavigationActionListener(configuration)
    //     );
    //     return backButton;
    // }
}
