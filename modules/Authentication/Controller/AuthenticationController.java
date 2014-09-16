package project.modules.Authentication.Controller;

import project.modules.Application.Controller.AbstractController;
import project.modules.Authentication.View.AuthenticationView;
import project.modules.Authentication.Model.AuthenticationModel;
import project.modules.Authentication.Entity.UserEntity;

public class AuthenticationController extends AbstractController
{
    private AuthenticationModel
        model = new AuthenticationModel();

    public AuthenticationController()
    {}

    public UserEntity authenticate(String user, String password)
    {
        return model.authenticate(user, password);
    }
}
