package project.modules.Passage.View.ActionListener;

import project.Main;
import project.modules.Passage.View.PassagePurchaseView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PassagePurchaseActionListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        Main.view.dispose();
        Main.view = new PassagePurchaseView();
    }
}
