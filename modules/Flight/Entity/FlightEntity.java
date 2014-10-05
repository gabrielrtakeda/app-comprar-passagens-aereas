package project.modules.Flight.Entity;

import project.modules.Airplane.Entity.AirplaneEntity;
import project.modules.Airport.Entity.AirportEntity;
import java.util.Date;

public class FlightEntity
{
    protected Integer id;
    protected AirplaneEntity airplane;
    protected AirportEntity airport;
    protected String status;
    protected Float valor;
    protected Date dataPartida;

    public Integer getId() {
        return this.id;
    }

    public AirplaneEntity getAirplane() {
        return this.airplane;
    }

    public AirportEntity getAirport() {
        return this.airport;
    }

    public String getStatus() {
        return this.status;
    }

    public Float getValor() {
        return this.valor;
    }

    public Date getDataPartida() {
        return this.dataPartida;
    }

    public FlightEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public FlightEntity setAirplane(AirplaneEntity airplane) {
        this.airplane = airplane;
        return this;
    }

    public FlightEntity setAirport(AirportEntity airport) {
        this.airport = airport;
        return this;
    }

    public FlightEntity setStatus(String status) {
        this.status = status;
        return this;
    }

    public FlightEntity setValor(Float valor) {
        this.valor = valor;
        return this;
    }

    public FlightEntity setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
        return this;
    }
}
