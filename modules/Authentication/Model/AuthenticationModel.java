package project.modules.Authentication.Model;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Library.FileManager;
import project.modules.Application.Model.AbstractModel;
import project.modules.Authentication.Entity.UserEntity;
import project.modules.Authentication.View.AuthenticationView;
import project.modules.Menu.View.MenuAtendenteView;
import project.modules.Menu.View.MenuSupervisorView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.text.DateFormat;
import javax.swing.JOptionPane;

public class AuthenticationModel extends AbstractModel
{
    public AuthenticationModel(ConfigurationEntity configuration)
    {
        configuration.setModel(this);
        setConfiguration(configuration);
    }

    public void index()
    {
        configuration.getView().dispose();
        new AuthenticationView(configuration);
    }

    public void authenticate(String user, String password)
    {
        FileManager fileManager             = getUsersAuthenticationFile();
        HashMap<Integer, String> usersMap   = fileManager.getMap();
        Iterator<Integer> keySetIterator    = usersMap.keySet().iterator();
        UserEntity userEntity               = new UserEntity();

        while (keySetIterator.hasNext())
        {
            Integer userId = keySetIterator.next();
            userEntity = buildUserEntity(
                userId,
                usersMap.get(userId).split(";")
            );

            if (isAuthenticatedUser(userEntity, user, password)) {
                break;
            } else {
                userEntity.setId(-1);
            }
        }

        if (!userEntity.isEmpty()) {

            userEntity.setDataLogin(
                DateFormat.getDateTimeInstance().format(new Date())
            );
            configuration.getView().dispose();
            configuration.setUser(userEntity);

            if (userEntity.isSupervisor()) {
                new MenuSupervisorView(configuration);
            } else {
                new MenuAtendenteView(configuration);
            }
        } else {
            JOptionPane.showMessageDialog(
                null,
                configuration.getTranslator().__("Falha na autenticação") + ".",
                configuration.getTranslator().__("Autenticação"),
                JOptionPane.WARNING_MESSAGE
            );
        }
    }

    private FileManager getUsersAuthenticationFile()
    {
        return new FileManager("modules/Authentication/Model/users.auth");
    }

    public Boolean isAuthenticatedUser(UserEntity userEntity, String user, String password)
    {
        Boolean validateUser = userEntity.getUser().equals(user);
        Boolean validatePassword = userEntity.getPassword().equals(password);
        return validateUser && validatePassword;
    }

    private UserEntity buildUserEntity(Integer id, String[] data)
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id)
                  .setUser(data[0])
                  .setPassword(data[1])
                  .setSupervisor(data[2].equals("true"))
                  .setNome(data[3]);

        return userEntity;
    }
}
