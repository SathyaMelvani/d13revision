package sg.edu.nus.iss.d13revision;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

import sg.edu.nus.iss.d13revision.models.Person;
import sg.edu.nus.iss.d13revision.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value; 

import org.springframework.;


@Controller
@RequestMapping(path="/person")
public class PersonController {
    private List<Person> personList = new ArrayList<Person>();

    @Autowired
    PersonService perSvc;

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;


    @RequestMapping(value={"/", "/home", "/index"}, method=RequestMethod.GET)
    public String index(Model model) {
        model.addAtrribute("message", message);

        return "index";

    }

    @RequestMapping(value="/testRetrieve", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Person> getAllPersons() {
        personList = perSvc.getPersons();

        return personList;

    } 

    @RequestMapping(value="/addPerson", method=RequestMethod.GET)
    public String showAddPersonPage(Model model) {
        PersonForm pForm = new PersonForm();
        model.addAtrribute("personForm", pForm);

        if (fName != null && fName.length() > 0 && lName != null && lName.length() > 0) {
            Person newPerson = new Person(fName, lName);
            perSvc.savePerson(newPerson);

            return "redirect:/personList";
            

        }

        model.addAttribute("errorMessage", errorMessage);


        return "addPerson";

    }

    @RequestMapping(value="/addPerson", method =RequestMethod.POST)
    public String savePerson(Model model, @ModelAttribute("personForm") PersonForm personForm) {

        return "addPerson";

    }








    @PutMapping
    public String UpdatePerson() {
        ....
    }
    @GetMapping()
    public boolean addPerson() {
        return "addPerson";
        return true;

    }

    @PostMapping(consumes = "application/www-x-form-urlencoded", produces="text/html")
    public String processAddPerson() {
        return "success";
    }


    
}
