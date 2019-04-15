package fr.hoc.dap.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

//TODO col by Djer |Audit Code| Prend en compte les remarques de CheckStyle !

@Controller

public class Hello2Controller {

    @RequestMapping ("/hello2")
    
    public String hello(ModelMap model) {   
        List<String> id = new ArrayList();
        id.add("Vache");  

        model.addAttribute("Personne", id);
    return "hello";
    
    
    }
    }
    

