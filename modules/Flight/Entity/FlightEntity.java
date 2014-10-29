package project.modules.Flight.Entity;

import project.modules.Application.Entity.AbstractEntity;
import project.modules.Airplane.Entity.AirplaneEntity;
import project.modules.Airport.Entity.AirportEntity;
import java.util.Date;

public class FlightEntity extends AbstractEntity
{
    public static final String STATUS_AVAILABLE    = "Disponível";
    public static final String STATUS_CANCELED     = "Cancelado";
    public static final String STATUS_POSTPONED    = "Adiado";
    public static final String STATUS_EXTENDED     = "Prorrogado";
    public static final String STATUS_SUSPENDED    = "Suspenso";
    public static final String STATUS_TRANSFERRED  = "Transferido";
    public static final String STATUS_PENDING      = "Pendente";

    protected Integer id;
    protected AirplaneEntity airplane;
    protected AirportEntity airportOrigin;
    protected AirportEntity airportDestination;
    protected Double price;
    protected String status;
    protected Date dateDeparture;
    protected Date dateRegister;

    public Integer getId() {
        return this.id;
    }

    public AirplaneEntity getAirplane() {
        return this.airplane;
    }

    public AirportEntity getAirportOrigin() {
        return this.airportOrigin;
    }

    public AirportEntity getAirportDestination() {
        return this.airportDestination;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getStatus() {
        return this.status;
    }

    public Date getDateDeparture() {
        return this.dateDeparture;
    }

    public Date getDateRegister() {
        return this.dateRegister;
    }

    public FlightEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public FlightEntity setAirplane(AirplaneEntity airplane) {
        this.airplane = airplane;
        return this;
    }

    public FlightEntity setAirportOrigin(AirportEntity airportOrigin) {
        this.airportOrigin = airportOrigin;
        return this;
    }

    public FlightEntity setAirportDestination(AirportEntity airportDestination) {
        this.airportDestination = airportDestination;
        return this;
    }

    public FlightEntity setPrice(Double price) {
        this.price = price;
        return this;
    }

    public FlightEntity setStatus(String status) {
        this.status = status;
        return this;
    }

    public FlightEntity setDateDeparture(Date dateDeparture) {
        this.dateDeparture = dateDeparture;
        return this;
    }

    public FlightEntity setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
        return this;
    }
}
