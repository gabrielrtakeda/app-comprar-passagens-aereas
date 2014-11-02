package project.modules.Passenger.Entity;

import project.modules.Application.Entity.AbstractEntity;
import java.util.Date;

public class PassengerEntity extends AbstractEntity
{
    public static final String SALUTATION_MISTER = "Sr.";
    public static final String SALUTATION_MISIZ = "Sra.";
    public static final String SALUTATION_MISS = "Srta.";
    public static final String SALUTATION_MADAM = "Madame";

    public static final String PROFILE_ADULT = "Adulto";
    public static final String PROFILE_CHILD = "Criança";
    public static final String PROFILE_BABY = "Bebê";

    public static final Character GENDER_MALE = 'M';
    public static final Character GENDER_FEMALE = 'F';

    protected Integer id;
    protected String salutation;
    protected String fullName;
    protected Character gender;
    protected Date dateBirth;
    protected String profile;
    protected Long cpf;
    protected String email;
    protected String phone;
    protected Boolean responsible;
    protected Date dateRegister;

    public Integer getId() {
        return this.id;
    }

    public String getSalutation() {
        return this.salutation;
    }

    public String getFullName() {
        return this.fullName;
    }

    public Character getGender() {
        return this.gender;
    }

    public Date getDateBirth() {
        return this.dateBirth;
    }

    public String getProfile() {
        return this.profile;
    }

    public Long getCpf() {
        return this.cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public Boolean getResponsible() {
        return this.responsible;
    }

    public Date getDateRegister() {
        return this.dateRegister;
    }

    public PassengerEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public PassengerEntity setSalutation(String salutation) {
        this.salutation = salutation;
        return this;
    }

    public PassengerEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public PassengerEntity setGender(Character gender) {
        this.gender = gender;
        return this;
    }

    public PassengerEntity setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
        return this;
    }

    public PassengerEntity setProfile(String profile) {
        this.profile = profile;
        return this;
    }

    public PassengerEntity setCpf(Long cpf) {
        this.cpf = cpf;
        return this;
    }

    public PassengerEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public PassengerEntity setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public PassengerEntity setResponsible(Boolean responsible) {
        this.responsible = responsible;
        return this;
    }

    public PassengerEntity setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
        return this;
    }
}
