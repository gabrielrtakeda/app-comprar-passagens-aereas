package project.modules.Authentication.Controller;

import project.modules.Application.Controller.AbstractController;
import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Authentication.Model.AuthenticationModel;

public class AuthenticationController extends AbstractController
{
    private AuthenticationModel model;

    public AuthenticationController(ConfigurationEntity configuration)
    {
        configuration.setController(this);
        setConfiguration(configuration);

        model = new AuthenticationModel(configuration);
    }

    public void indexAction()
    {
        model.index();
    }

    public void authenticateAction(String user, String password)
    {
        model.authenticate(user, password);
    }
}
