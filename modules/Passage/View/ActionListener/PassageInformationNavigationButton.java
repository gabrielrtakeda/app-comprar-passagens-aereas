package project.modules.Passage.View.ActionListener;

import project.modules.Application.View.AbstractView;
import project.modules.Menu.View.MenuSupervisorView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PassageInformationNavigationButton implements ActionListener
{
    protected AbstractView view;

    public PassageInformationNavigationButton(AbstractView view)
    {
        this.view = view;
    }

    public void actionPerformed(ActionEvent e)
    {
        view.dispose();

        switch (e.getActionCommand()) {
            case "back":
                new MenuSupervisorView();
                break;
        }
    }
}
