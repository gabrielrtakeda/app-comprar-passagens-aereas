package project.modules.Airplane.Entity;

import project.modules.Application.Entity.AbstractEntity;

import java.util.Date;

public class AirplaneEntity extends AbstractEntity
{
    public static final String STATUS_AVAILABLE = "Disponível";
    public static final String STATUS_RESERVED = "Reservado";
    public static final String STATUS_INACTIVE = "Inativo";

    protected Integer id;
    protected String description;
    protected String family;
    protected String model;
    protected Integer seatsTotal;
    protected Integer seatsVacantTotal;
    protected String status;
    protected Date dateRegister;

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFamily() {
        return this.family;
    }

    public String getModel() {
        return this.model;
    }

    public Integer getSeatsTotal() {
        return this.seatsTotal;
    }

    public Integer getSeatsVacantTotal() {
        return this.seatsVacantTotal;
    }

    public String getStatus() {
        return this.status;
    }

    public Date getDateRegister() {
        return this.dateRegister;
    }

    public AirplaneEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public AirplaneEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public AirplaneEntity setFamily(String family) {
        this.family = family;
        return this;
    }

    public AirplaneEntity setModel(String model) {
        this.model = model;
        return this;
    }

    public AirplaneEntity setSeatsTotal(Integer seatsTotal) {
        this.seatsTotal = seatsTotal;
        return this;
    }

    public AirplaneEntity setSeatsVacantTotal(Integer seatsVacantTotal) {
        this.seatsVacantTotal = seatsVacantTotal;
        return this;
    }

    public AirplaneEntity setStatus(String status) {
        this.status = status;
        return this;
    }

    public AirplaneEntity setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
        return this;
    }
}
