package sg.edu.nus.iss.d13revision;
import org.springframework.stereotype.Controller;
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
