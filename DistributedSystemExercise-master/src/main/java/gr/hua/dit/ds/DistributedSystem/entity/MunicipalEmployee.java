package gr.hua.dit.ds.DistributedSystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "municipalemployee")
public class MunicipalEmployee {

    @Column(name = "fullname")
    private String fullName;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "AMKA")
    private int AMKA;

    @Column(name = "municipalhouse")
    private String municipalHouse;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    public MunicipalEmployee(String fullName, int AMKA, String municipalHouse, String password, String email) {
        this.fullName = fullName;
        this.AMKA = AMKA;
        this.municipalHouse = municipalHouse;
        this.password = password;
        this.email = email;
    }

    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="municipalemployee_pet",
            joinColumns=@JoinColumn(name="municipalemployee_amka"),
            inverseJoinColumns=@JoinColumn(name="pet_microchip"))
    private List<Pet> petList;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="municipalemployee_citizen",
            joinColumns=@JoinColumn(name="municipalemployee_amka"),
            inverseJoinColumns=@JoinColumn(name="citizen_amka"))
    private List<Citizen> citizenList;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="lostPet_Pet",
            joinColumns=@JoinColumn(name="pet_numberOfMicrochip"),
            inverseJoinColumns=@JoinColumn(name="lostPet_numberOfMicrochip"))
    private List<Pet> lostPets;

    public List<Pet> getLostPets(){
        return lostPets;
    }

    public MunicipalEmployee() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAMKA() {
        return AMKA;
    }

    public void setAMKA(int AMKA) {
        this.AMKA = AMKA;
    }

    public String getMunicipalHouse() {
        return municipalHouse;
    }

    public void setMunicipalHouse(String municipalHouse) {
        this.municipalHouse = municipalHouse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ΜunicipalΕmployee{" +
                "fullName='" + fullName + '\'' +
                ", AMKA='" + AMKA + '\'' +
                ", municipalHouse='" + municipalHouse + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}