package project.modules.Authentication.Entity;

public class UserEntity
{
    private Integer id = null;
    private String user;
    private String password;
    private Boolean supervisor;
    private String nome;

    public UserEntity setId(Integer id)
    {
        this.id = id;
        return this;
    }

    public Integer getId()
    {
        return id;
    }

    public UserEntity setUser(String user)
    {
        this.user = user;
        return this;
    }

    public String getUser()
    {
        return user;
    }

    public UserEntity setPassword(String password)
    {
        this.password = password;
        return this;
    }

    public String getPassword()
    {
        return password;
    }

    public UserEntity setSupervisor(Boolean supervisor)
    {
        this.supervisor = supervisor;
        return this;
    }

    public Boolean isSupervisor()
    {
        return supervisor;
    }

    public UserEntity setNome(String nome)
    {
        this.nome = nome;
        return this;
    }

    public String getNome()
    {
        return nome;
    }

    public Boolean isEmpty()
    {
        return id == -1;
    }
}
