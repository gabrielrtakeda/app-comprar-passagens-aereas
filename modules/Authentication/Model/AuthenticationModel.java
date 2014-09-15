package project.modules.Authentication.Model;

import project.modules.Application.Library.FileManager;
import project.modules.Application.Model.AbstractModel;
import project.modules.Authentication.Entity.UserEntity;
import java.util.HashMap;
import java.util.Iterator;

public class AuthenticationModel extends AbstractModel
{
    protected UserEntity userEntity = new UserEntity();

    public UserEntity authenticate(String user, String password)
    {
        FileManager fileManager = new FileManager("modules/Authentication/Model/users.auth");

        HashMap<Integer, String> map = fileManager.getMap();

        Iterator<Integer> keySetIterator = map.keySet().iterator();
        while (keySetIterator.hasNext())
        {
            Integer id = keySetIterator.next();
            String[] userData = map.get(id).split(";");
            userEntity = buildUserEntity(id, userData);

            if (isValidUser(user, password)) {
                return userEntity;
            }
        }
        userEntity.setId(-1);
        return userEntity;
    }

    public Boolean isValidUser(String user, String password)
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
