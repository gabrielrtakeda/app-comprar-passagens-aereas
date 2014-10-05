package project.modules.Airport.Entity;

import java.util.Date;

public class AirportEntity
{
    protected Integer id;
    protected String descricao;
    protected Date dataCadastro;

    public Integer getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public AirportEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public AirportEntity setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public AirportEntity setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }
}
