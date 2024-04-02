package gr.hua.dit.ds.DistributedSystem.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "pet")
public class Pet {

    @Column(name = "race")
    private String race;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dateofbirth")
    private String dateOfBirth;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "numberofmicrochip")
    private Integer numberOfMicrochip;

    @Column(name = "amkaowner")
    private String amkaOwner;

//    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//            CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinColumn(name="amkaowner")
//    private Citizen citizen;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name= "vet_pet",
            joinColumns= {@JoinColumn(name = "vet_amka")},
            inverseJoinColumns= {@JoinColumn(name = "pet_microchip")}
    )
    private List<MunicipalEmployee> MunicipalEmployeeList;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="municipalemployee_pet",
            joinColumns=@JoinColumn(name="municipalemployee_amka"),
            inverseJoinColumns=@JoinColumn(name="pet_microchip"))
    private List<Pet> petList;

    public Pet(String race, String gender, String dateOfBirth, Integer numberOfMicrochip, String amkaOwner) {
        this.race = race;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.numberOfMicrochip = numberOfMicrochip;
        this.amkaOwner = amkaOwner;
    }

    public Pet(){}

    public String getRace() {
        return race;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getNumberOfMicrochip() {
        return numberOfMicrochip;
    }

    public String getAmkaOwner() {
        return amkaOwner;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setNumberOfMicrochip(Integer numberOfMicrochip) {
        this.numberOfMicrochip = numberOfMicrochip;
    }

    public void setAmkaOwner(String amkaOwner) {
        this.amkaOwner = amkaOwner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "race='" + race + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", numberOfMicrochip='" + numberOfMicrochip + '\'' +
                ", amkaOwner='" + amkaOwner + '\'' +
                '}';
    }
}
