package project.modules.Airport.Entity;

import project.modules.Application.Entity.AbstractEntity;
import java.util.Date;

public class AirportEntity extends AbstractEntity
{
    protected Integer id;
    protected String description;
    protected String abbreviation;
    protected String address;
    protected Date dateRegister;

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public String getAddress() {
        return this.address;
    }

    public Date getDateRegister() {
        return this.dateRegister;
    }

    public AirportEntity setId(String id) {
        this.id = Integer.parseInt(id);
        return this;
    }

    public AirportEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public AirportEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public AirportEntity setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
        return this;
    }

    public AirportEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public AirportEntity setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
        return this;
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("\t\t\t");
        builder.append("id: " + getId());
        builder.append("\n\t\t\t");
        builder.append("description: " + getDescription());
        builder.append("\n\t\t\t");
        builder.append("abbreviation: " + getAbbreviation());
        builder.append("\n\t\t\t");
        builder.append("address: " + getAddress());
        builder.append("\n\t\t\t");
        builder.append("date-register: " + getDateRegister());
        return builder.toString();
    }
}
