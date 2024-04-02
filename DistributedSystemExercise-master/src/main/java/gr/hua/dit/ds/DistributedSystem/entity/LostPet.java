package gr.hua.dit.ds.DistributedSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "lostpet")
public class LostPet {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "numberofmicrochip")
    private Integer numberOfMicrochip;

    @Column(name = "amkaowner")
    private String amkaOwner;

    public LostPet(Integer numberOfMicrochip,String amkaOwner) {
        this.numberOfMicrochip = numberOfMicrochip;
        this.amkaOwner = amkaOwner;
    }

    public LostPet(){}

    public Integer getNumberOfMicrochip() {
        return numberOfMicrochip;
    }

    public void setNumberOfMicrochip(Integer numberOfMicrochip) {
        this.numberOfMicrochip = numberOfMicrochip;
    }

    public String getAmkaOwner() {
        return amkaOwner;
    }

    public void setAmkaOwner(String amkaOwner) {
        this.amkaOwner = amkaOwner;
    }

    @Override
    public String toString() {
        return "LostPet{" +
                ", numberOfMicrochip='" + numberOfMicrochip + '\'' +
                ", amkaOwner='" + amkaOwner + '\'' +
                '}';
    }

}