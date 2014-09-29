package project.modules.Passenger.Entity;

public class PassengerEntity
{
    public Integer id;
    public String formaTratamento;
    public String dataNascimento;
    public String nomeCompleto;
    public Boolean responsavel;
    public String email;
    public String telefone;
    public String perfil;

    public Integer getId()
    {
        return id;
    }

    public PassengerEntity setId(Integer id)
    {
        this.id = id;
        return this;
    }

    public String getFormaTratamento()
    {
        return formaTratamento;
    }

    public PassengerEntity setFormaTratamento(String formaTratamento)
    {
        this.formaTratamento = formaTratamento;
        return this;
    }

    public String getDataNascimento()
    {
        return dataNascimento;
    }

    public PassengerEntity setDataNascimento(String dataNascimento)
    {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public String getNomeCompleto()
    {
        return nomeCompleto;
    }

    public PassengerEntity setNomeCompleto(String nomeCompleto)
    {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public Boolean getResponsavel()
    {
        return responsavel;
    }

    public PassengerEntity setResponsavel(Boolean responsavel)
    {
        this.responsavel = responsavel;
        return this;
    }

    public String getEmail()
    {
        return email;
    }

    public PassengerEntity setEmail(String email)
    {
        this.email = email;
        return this;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public PassengerEntity setTelefone(String telefone)
    {
        this.telefone = telefone;
        return this;
    }

    public String getPerfil()
    {
        return perfil;
    }

    public PassengerEntity setPerfil(String perfil)
    {
        this.perfil = perfil;
        return this;
    }
}
