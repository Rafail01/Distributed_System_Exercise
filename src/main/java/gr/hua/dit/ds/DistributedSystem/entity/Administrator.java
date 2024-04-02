package gr.hua.dit.ds.DistributedSystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "administrator")

public class Administrator {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private String admin_id;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    private List<Veterinary> veterinary;

    @OneToMany(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    private List<Citizen> citizen;

    @OneToMany(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    private List<MunicipalEmployee> municipalEmployee;

    public Administrator() {
    }

    public Administrator(String admin_id, String password, String email) {
        this.admin_id = admin_id;
        this.password = password;
        this.email = email;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setAdmin_id(String amin_id) {
        this.admin_id = amin_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void PrintUser(){

    }

    public void modificationData(){

    }

    public void addUser(){

    }

    public void deleteUser(){

    }

    public void logIn(){

    }

}