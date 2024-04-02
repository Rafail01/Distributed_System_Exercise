package gr.hua.dit.ds.DistributedSystem.service;

import gr.hua.dit.ds.DistributedSystem.entity.Pet;
import gr.hua.dit.ds.DistributedSystem.repository.CitizenRepository;
import gr.hua.dit.ds.DistributedSystem.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class CitizenServiceImpl implements CitizenService{

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private PetRepository petRepository;

//    @Override
//    @Transactional
//    public boolean logIn(String email, String password) {
//        if (email != null){
//            Optional<Citizen> citizen = citizenRepository.findById(email);
//
//            if (citizen != null){
//                if(citizen.get().getPassword()== password){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

//    @Override
//    @Transactional
//    public ResponseEntity<Object> addNewPet(@RequestBody Pet pet) {
//        Pet savedPet = petRepository.save(pet);
//        System.out.println("pet: number of microchip"+savedPet.getNumberOfMicrochip());
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{numberOfMicrochip}").buildAndExpand(savedPet.getAmkaOwner()).toUri();
//        return ResponseEntity.created(location).build();
//    }
//
//    List<Optional<Pet>> listLostPet;

    //Κάνει μια δήλωση ότι έχασε το κατοικίδιο του
//    @Override
//    @Transactional
//    public void lostPet(@RequestBody Pet pet) {
//        // εδώ θα έχω μια φόρμα
//        Optional<Pet> optionalPet = petRepository.findById(pet.getNumberOfMicrochip());
//        listLostPet.add(optionalPet);
//        System.out.println(listLostPet);
//    }

    //Κάνει μια δήλωση ότι βρήκε ένα κατοικίδιο κάποιου άλλου ιδιοκτήτη
//    @Override
//    @Transactional
//    public void findPet(@RequestBody Pet pet) {
//        Optional<Pet> optionalPet = petRepository.findById(pet.getNumberOfMicrochip());
//        if (optionalPet.isPresent()){
//
//        }
//    }
}