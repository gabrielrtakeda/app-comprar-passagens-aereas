package project.modules.Airplane.Entity;

import java.util.Date;

public class AirplaneEntity
{
    protected Integer id;
    protected String descricao;
    protected String modelo;
    protected Integer assentosTotal;
    protected Integer assentosVagos;
    protected String status;
    protected Date dataCadastro;

    public Integer getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getModelo() {
        return this.modelo;
    }

    public Integer getAssentosTotal() {
        return this.assentosTotal;
    }

    public Integer getAssentosVagos() {
        return this.assentosVagos;
    }

    public String getStatus() {
        return this.status;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public AirplaneEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public AirplaneEntity setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public AirplaneEntity setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public AirplaneEntity setAssentosTotal(Integer assentosTotal) {
        this.assentosTotal = assentosTotal;
        return this;
    }

    public AirplaneEntity setAssentosVagos(Integer assentosVagos) {
        this.assentosVagos = assentosVagos;
        return this;
    }

    public AirplaneEntity setStatus(String status) {
        this.status = status;
        return this;
    }

    public AirplaneEntity setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }
}
