package gr.hua.dit.ds.DistributedSystem.controller;

import gr.hua.dit.ds.DistributedSystem.entity.*;
import gr.hua.dit.ds.DistributedSystem.repository.*;
import gr.hua.dit.ds.DistributedSystem.service.MunicipalEmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@RequestMapping("/MunicipalEmployeeController")
public class MunicipalEmployeeController {

    @Autowired
    private MunicipalEmployeeRepository municipalEmployeeRepository;

    @Autowired
    private LostPetRepository lostPetRepository;

    @Autowired
    private FoundPetRepository foundPetRepository;

    @Autowired
    private PetRepository petRepository;
    @GetMapping("/MunicipalEmployeePage")
    public String municipalEmployeePage(@RequestParam(name = "name", required = false, defaultValue = "user") String name, Model model) {
        model.addAttribute("name", name);
        return "municipalEmployee_page";
    }

    @GetMapping("/ShowLostPets")
    public String showLostPets(Model model){
        List<LostPet> listLostPet = lostPetRepository.findAll();
        model.addAttribute("listLostPet", listLostPet);
        return "show_lost_pets";
    }

    @GetMapping("/ShowFoundPets")
    public String showFoundPets(Model model){
        List<FoundPet> listFoundPet = foundPetRepository.findAll();
        model.addAttribute("listFoundPet", listFoundPet);
        return "show_found_pets";
    }

}