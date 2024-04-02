package gr.hua.dit.ds.DistributedSystem.service;

import gr.hua.dit.ds.DistributedSystem.entity.Administrator;
import gr.hua.dit.ds.DistributedSystem.entity.Citizen;
import gr.hua.dit.ds.DistributedSystem.entity.MunicipalEmployee;
import gr.hua.dit.ds.DistributedSystem.entity.Veterinary;
import gr.hua.dit.ds.DistributedSystem.entity.MunicipalEmployee;
import gr.hua.dit.ds.DistributedSystem.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

public interface AdministratorService {
    @Transactional
    public List<Citizen> ListCitizens();
    @Transactional
    public List<MunicipalEmployee> ListMunicipalEmployees();
    @Transactional
    public List<Veterinary> ListVeterinaries();
    @Transactional
    public ResponseEntity<Object> modificationMunicipalEmployee(@RequestBody MunicipalEmployee municipalEmployee, @PathVariable Integer AMKA);
    @Transactional
    public ResponseEntity<Object> modificationVeterinary(@RequestBody Veterinary veterinary,@PathVariable Integer AMKA);
    @Transactional
    public ResponseEntity<Object> modificationCitizen(@RequestBody Citizen citizen,@PathVariable Integer AMKA);
    @Transactional
    public ResponseEntity<Object> addCitizen(@RequestBody Citizen citizen);
    @Transactional
    public ResponseEntity<Object> addMunicipalEmployee(@RequestBody MunicipalEmployee municipalEmployee);
    @Transactional
    public ResponseEntity<Object> addVeterinary(@RequestBody Veterinary veterinary);
    @Transactional
    public void deleteCitizen(Integer AMKA);
    @Transactional
    public void saveCitizen(Citizen citizen);

    @Transactional
    void deleteCitizen(String email);
    @Transactional
    public void deleteMunicipalEmployee(Integer AMKA);
    @Transactional
    public void deleteVeterinary(Integer AMKA);
    @Transactional
    public boolean logIn(String email, String password);
}