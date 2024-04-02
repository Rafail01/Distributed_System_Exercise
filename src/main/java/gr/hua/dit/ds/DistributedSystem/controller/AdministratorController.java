package gr.hua.dit.ds.DistributedSystem.controller;

import gr.hua.dit.ds.DistributedSystem.entity.Citizen;
import gr.hua.dit.ds.DistributedSystem.entity.MunicipalEmployee;
import gr.hua.dit.ds.DistributedSystem.entity.Veterinary;
import gr.hua.dit.ds.DistributedSystem.repository.AdministratorRepository;
import gr.hua.dit.ds.DistributedSystem.repository.CitizenRepository;
import gr.hua.dit.ds.DistributedSystem.repository.MunicipalEmployeeRepository;
import gr.hua.dit.ds.DistributedSystem.repository.VeterinaryRepository;
import gr.hua.dit.ds.DistributedSystem.service.AdministratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/AdministratorController")
public class AdministratorController {

    @Autowired
    private AdministratorRepository administratorRepository;
    @Autowired
    private CitizenRepository citizenRepository;
    @Autowired
    private MunicipalEmployeeRepository municipalEmployeeRepository;
    @Autowired
    private VeterinaryRepository veterinaryRepository;


    private AdministratorServiceImpl administratorServiceImpl;

    @GetMapping("/AdministratorPage")
    public String administratorPage(@RequestParam(name = "name", required = false, defaultValue = "user") String name, Model model) {
        model.addAttribute("name", name);
        return "administrator_page";
    }


    @RequestMapping(value = "/AdministratorDeletePage/Citizen/{AMKA}", method = { RequestMethod.GET, RequestMethod.POST })
    public String administratorDeleteCitizen(@PathVariable(value = "AMKA") Integer AMKA) {
        citizenRepository.deleteById(AMKA);
        return "redirect:/AdministratorController/AdministratorPage";
    }

    @RequestMapping(value = "/AdministratorDeletePage/Veterinary/{AMKA}", method = { RequestMethod.GET, RequestMethod.POST })
    public String administratorDeleteVeterinary(@PathVariable(value = "AMKA") Integer AMKA) {
        veterinaryRepository.deleteById(AMKA);
        return "redirect:/AdministratorController/AdministratorPage";
    }

    @RequestMapping(value = "/AdministratorDeletePage/MunicipalEmployee/{AMKA}", method = { RequestMethod.GET, RequestMethod.POST })
    public String administratorDeleteMunicipalEmployee(@PathVariable(value = "AMKA") Integer AMKA) {
        municipalEmployeeRepository.deleteById(AMKA);
        return "redirect:/AdministratorController/AdministratorPage";
    }


    @GetMapping("/AdministratorShowList")
    public String administratorShowList(@RequestParam(name = "name", required = false, defaultValue = "user") String name, Model model) {
        model.addAttribute("name", name);
        return "Admin_show_list";
    }

    @GetMapping("/AdministratorAddUser")
    public String administratorAddUser(@RequestParam(name = "name", required = false, defaultValue = "user") String name, Model model) {
        return "admin_add_user";
    }

    @GetMapping("/AdministratorAddUser/citizenForm")
    public String addCitizenForm(Citizen citizen, Model model){
        return "admin_add_citizen";
    }

    @RequestMapping(value = "/AdministratorAddUser/citizenSave", method = { RequestMethod.GET, RequestMethod.POST })
    public String addCitizenSave(Citizen citizen, Model model){
        model.addAttribute("citizen", citizen);
        Citizen savedCitizen = citizenRepository.save(citizen);
        System.out.println("Citizen amka"+savedCitizen.getAMKA());
        return "redirect:/AdministratorController/AdministratorPage";
    }

    @GetMapping("/AdministratorAddUser/veterinaryForm")
    public String addVeterinaryForm(Veterinary veterinary, Model model){
        return "admin_add_veterinary";
    }

    @RequestMapping(value = "/AdministratorAddUser/veterinarySave", method = { RequestMethod.GET, RequestMethod.POST })
    public String addVeterinarySave(Veterinary veterinary, Model model){
        model.addAttribute("veterinary", veterinary);
        Veterinary savedVeterinary = veterinaryRepository.save(veterinary);
        System.out.println("Veterinary amka"+savedVeterinary.getAMKA());
        return "redirect:/AdministratorController/AdministratorPage";
    }


    @GetMapping("/AdministratorAddUser/municipalEmployeeForm")
    public String addMunicipalEmployeeForm(MunicipalEmployee municipalEmployee, Model model){
        return "admin_add_municipalEmployee";
    }

    @RequestMapping(value = "/AdministratorAddUser/municipalEmployeeSave", method = { RequestMethod.GET, RequestMethod.POST })
    public String addMunicipalEmployeeSave(MunicipalEmployee municipalEmployee, Model model){
        model.addAttribute("municipalEmployee", municipalEmployee);
        MunicipalEmployee savedMunicipalEmployee = municipalEmployeeRepository.save(municipalEmployee);
        System.out.println("municipalEmployee amka"+savedMunicipalEmployee.getAMKA());
        return "redirect:/AdministratorController/AdministratorPage";
    }

    @RequestMapping(value = "/AdministratorModificationPage/Citizen/{AMKA}", method = { RequestMethod.GET, RequestMethod.POST })
    public String showEditFormCitizen(@PathVariable("AMKA") Integer AMKA, Model model){
        Optional<Citizen> citizen = citizenRepository.findById(AMKA);
        model.addAttribute("citizen", citizen);
        return "admin_add_citizen";
    }

    @RequestMapping(value = "/AdministratorModificationPage/Veterinary/{AMKA}", method = { RequestMethod.GET, RequestMethod.POST })
    public String showEditFormVeterinary(@PathVariable("AMKA") Integer AMKA, Model model) {
        Optional<Veterinary> veterinary = veterinaryRepository.findById(AMKA);
        model.addAttribute("veterinary", veterinary);
        return "admin_add_veterinary";
    }

    @RequestMapping(value = "/AdministratorModificationPage/MunicipalEmployee/{AMKA}", method = { RequestMethod.GET, RequestMethod.POST })
    public String showEditFormMunicipalEmployee(@PathVariable("AMKA") Integer AMKA, Model model) {
        Optional<MunicipalEmployee> municipalEmployee = municipalEmployeeRepository.findById(AMKA);
        model.addAttribute("municipalEmployee", municipalEmployee);
        return "admin_add_municipalEmployee";
    }

    @GetMapping("/ShowCitizens")
    public String showCitizenList(Model model){
        List<Citizen> listCitizen = citizenRepository.findAll();
        model.addAttribute("listCitizen", listCitizen);
        return "admin_show_citizens";
    }

    @GetMapping("/ShowVeterinary")
    public String showVeterinaryList(Model model){
        List<Veterinary> listVeterinary = veterinaryRepository.findAll();
        model.addAttribute("listVeterinary", listVeterinary);
        return "Admin_show_veterinaries";
    }

    @GetMapping("/ShowMunicipalEmployees")
    public String showMunicipalEmployeeList(Model model){
        List<MunicipalEmployee> listMunicipalEmployee = municipalEmployeeRepository.findAll();
        model.addAttribute("listMunicipalEmployee", listMunicipalEmployee);
        return "Admin_show_municipalEmployees";
    }


}