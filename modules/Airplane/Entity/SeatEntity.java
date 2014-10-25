package project.modules.Airplane.Entity;

import project.modules.Application.Entity.AbstractEntity;

import java.util.Date;

public class SeatEntity extends AbstractEntity
{
    protected Integer id;
    protected Integer airplaneId;
    protected String kind;
    protected String location;
    protected String status;
    protected Date dateRegister;

    public Integer getId() {
        return this.id;
    }

    public Integer getAirplaneId() {
        return this.airplaneId;
    }

    public String getKind() {
        return this.kind;
    }

    public String getLocation() {
        return this.location;
    }

    public String getStatus() {
        return this.status;
    }

    public Date getDateRegister() {
        return this.dateRegister;
    }

    public SeatEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public SeatEntity setAirplaneId(Integer airplaneId) {
        this.airplaneId = airplaneId;
        return this;
    }

    public SeatEntity setKind(String kind) {
        this.kind = kind;
        return this;
    }

    public SeatEntity setLocation(String location) {
        this.location = location;
        return this;
    }

    public SeatEntity setStatus(String status) {
        this.status = status;
        return this;
    }

    public SeatEntity setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
        return this;
    }
}
