package project.modules.Authentication.Controller;

import project.modules.Application.Controller.AbstractController;
import project.modules.Authentication.View.AuthenticationView;

public class AuthenticationController extends AbstractController
{
    public AuthenticationController()
    {
        setView(new AuthenticationView());
    }
}
