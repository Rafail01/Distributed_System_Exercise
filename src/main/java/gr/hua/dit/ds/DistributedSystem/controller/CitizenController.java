package gr.hua.dit.ds.DistributedSystem.controller;
import gr.hua.dit.ds.DistributedSystem.entity.FoundPet;
import gr.hua.dit.ds.DistributedSystem.entity.LostPet;
import gr.hua.dit.ds.DistributedSystem.entity.Pet;
import gr.hua.dit.ds.DistributedSystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/CitizenController")
public class CitizenController {

    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private MunicipalEmployeeRepository municipalEmployeeRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private LostPetRepository lostPetRepository;

    @Autowired
    private FoundPetRepository foundPetRepository;


    @GetMapping("/CitizenPage")
    public String citizenPage(@RequestParam(name = "name", required = false, defaultValue = "user") String name, Model model) {
        model.addAttribute("name", name);
        return "citizen_page";
    }

    @GetMapping("/NewPetForm")
    public String NewPetForm(Pet pet, Model model){
        return "new_pet";
    }

    @RequestMapping(value = "/NewPetSave", method = { RequestMethod.GET, RequestMethod.POST })
    public String NewPetSave(Pet pet, Model model){
        model.addAttribute("pet", pet);
        Pet savedPet = petRepository.save(pet);
        System.out.println("Saved pet number of microchip"+savedPet.getNumberOfMicrochip());
        return "redirect:/CitizenController/CitizenPage";
    }

    @GetMapping("/LostPetForm")
    public String lostPetForm(LostPet lostPet, Model model){
//        model.addAttribute("lostPet", new LostPet());
        return "lostPet_form";
    }

    //Κάνει μια δήλωση ότι έχασε το κατοικίδιο του
    @RequestMapping(value = "/LostPet", method = { RequestMethod.GET, RequestMethod.POST })
    public String lostPet(LostPet lostPet, Model model) {
        model.addAttribute("lostPet", lostPet);
        LostPet savedLostPet = lostPetRepository.save(lostPet);
        System.out.println("Lost pet numberOfMicrochip"+savedLostPet.getNumberOfMicrochip());
        return "redirect:/CitizenController/CitizenPage";
    }

    @GetMapping("/FoundPetForm")
    public String FoundPetForm(FoundPet foundPet, Model model){
//        model.addAttribute("lostPet", new LostPet());
        return "foundPet_form";
    }

    //Κάνει μια δήλωση ότι έχασε το κατοικίδιο του
    @RequestMapping(value = "/FoundPet", method = { RequestMethod.GET, RequestMethod.POST })
    public String foundPet(FoundPet foundPet, Model model) {
        model.addAttribute("foundPet", foundPet);
        FoundPet savedFoundPet = foundPetRepository.save(foundPet);
        System.out.println("Found pet numberOfMicrochip"+savedFoundPet.getNumberOfMicrochip());
        return "redirect:/CitizenController/CitizenPage";
    }

}