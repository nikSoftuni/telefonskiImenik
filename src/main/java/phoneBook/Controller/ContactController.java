package phoneBook.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import phoneBook.entity.Contact;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {

    List<Contact> kontakti;

    public ContactController() {
        this.kontakti = new ArrayList<>();
        this.kontakti.add(new Contact("Dusan","654123"));
        this.kontakti.add(new Contact("Milovan","3425432"));
        this.kontakti.add(new Contact("Petar","6476765"));

    }



    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView){

        modelAndView.setViewName("index");
        modelAndView.addObject("contacts",kontakti);
        return modelAndView;
    }
    


    @PostMapping("/")
    public String add(Contact kontakt ){
        this.kontakti.add(kontakt);
        return "redirect:/";
    }

    @PostMapping("/remove/{index}")
    public String remove(@PathVariable int index){
        if(index>=0 && index<=kontakti.size()) kontakti.remove(index);
        return "redirect:/";
    }


}
