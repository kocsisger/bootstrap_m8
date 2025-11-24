package en.unideb.inf.bootstrapspring_m8.controller;

import en.unideb.inf.bootstrapspring_m8.model.Person;
import en.unideb.inf.bootstrapspring_m8.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("")
    public String showHomepage(){
        return "index";
    }

    @GetMapping("/persons")
    public String getAllPersons(Model model){
        List<Person> personsList = personRepository.findAll();
        model.addAttribute("personsList", personsList);
        return "persons";
    }

    @GetMapping("/persons/new")
    public String newPerson(Model model){
        model.addAttribute("newPerson", new Person());
        model.addAttribute("pageTitle", "new");
        return "newPersonForm";
    }

    @GetMapping("/persons/edit/{id}")
    String editPerson(@PathVariable Long id, Model model) {
        Optional<Person> personToEdit = personRepository.findById(id);
        if (personToEdit.isPresent()) {
            model.addAttribute("newPerson", personToEdit.get());
            model.addAttribute("pageTitle", "Edit person with id " + id);
            return "newPersonForm";
        }
        return "redirect:/persons";
    }



    @PostMapping("/persons/save")
    String savePerson(Person person){
        personRepository.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/persons/delete/{id}")
    String deletePerson(@PathVariable Long id){
        Person personToDelete = personRepository.findById(id).get();
        if (personToDelete!=null)
            personRepository.delete(personToDelete);
        return "redirect:/persons";
    }
}
