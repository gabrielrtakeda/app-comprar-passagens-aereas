package project.modules.Passage.Entity;

import project.modules.Application.Entity.AbstractEntity;
import project.modules.Flight.Entity.FlightEntity;
import java.util.Date;

public class PassageEntity extends AbstractEntity
{
    public static final String STATUS_CONFIRMED = "Confirmado";
    public static final String STATUS_TRANSFERED = "Transferido";
    public static final String STATUS_CANCELED = "Cancelado";

    protected Integer id;
    protected FlightEntity flight;
    protected String status;;
    protected Double priceTotal;
    protected Date dateCheckIn;
    protected Date dateRegister;

    public Integer getId() {
        return this.id;
    }

    public FlightEntity getFlight() {
        return this.flight;
    }

    public String getStatus() {
        return this.status;
    }

    public Double getPriceTotal() {
        return this.priceTotal;
    }

    public Date getDateCheckIn() {
        return this.dateCheckIn;
    }

    public Date getDateRegister() {
        return this.dateRegister;
    }

    public PassageEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public PassageEntity setFlight(FlightEntity flight) {
        this.flight = flight;
        return this;
    }

    public PassageEntity setStatus(String status) {
        this.status = status;
        return this;
    }

    public PassageEntity setPriceTotal(Double priceTotal) {
        this.priceTotal = priceTotal;
        return this;
    }

    public PassageEntity setDateCheckIn(Date dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
        return this;
    }

    public PassageEntity setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
        return this;
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("\n\t\t\t");
        builder.append("id: " + getId());
        builder.append("\n\t\t\t");
        builder.append("flight: " + getFlight().toString());
        builder.append("\n\t\t\t");
        builder.append("status: " + getStatus());
        builder.append("\n\t\t\t");
        builder.append("date-check-in: " + getDateCheckIn());
        builder.append("\n\t\t\t");
        builder.append("date-register: " + getDateRegister());
        return builder.toString();
    }
}
