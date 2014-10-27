package project.modules.Flight.View.ActionListener;

public class FlightRasterizeActionListener extends AbstractActionListener
{
    public FlightRasterizeActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        getController().navigateAction("rasterize");
    }

    public FlightController getController()
    {
        return new FlightController(configuration);
    }
}
