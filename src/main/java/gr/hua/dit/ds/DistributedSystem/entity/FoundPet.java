package gr.hua.dit.ds.DistributedSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "foundpet")
public class FoundPet {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "numberofmicrochip")
    private Integer numberOfMicrochip;

    public FoundPet(Integer numberOfMicrochip) {
        this.numberOfMicrochip = numberOfMicrochip;
    }

    public FoundPet(){}

    public Integer getNumberOfMicrochip() {
        return numberOfMicrochip;
    }

    public void setNumberOfMicrochip(Integer numberOfMicrochip) {
        this.numberOfMicrochip = numberOfMicrochip;
    }

    @Override
    public String toString() {
        return "FoundPet{" +
                ", numberOfMicrochip='" + numberOfMicrochip + '\'' +
                '}';
    }

}