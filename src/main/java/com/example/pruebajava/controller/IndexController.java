package com.example.pruebajava.controller;

import com.example.pruebajava.models.Actor;
import com.example.pruebajava.models.Category;
import com.example.pruebajava.models.Films;
import com.example.pruebajava.services.ActorServices;
import com.example.pruebajava.services.CategoryService;
import com.example.pruebajava.services.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resources;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    ActorServices ac;
    @Autowired
    CategoryService cs;
    @Autowired
    FilmsService fs;


    @RequestMapping("/")
    public String index(Model model) {

        List<Films> filmsList = fs.findAll();
        List<Category> categoryList = cs.findAll();
        model.addAttribute("filmsList", fs.findAll());
        model.addAttribute("categoryList", cs.findAll());
        model.addAttribute("actor", ac.findAll());



    return "index.jsp";
    }

 /*   @RequestMapping("/seach")
    public String search(@RequestParam("film") String film,
                         @RequestParam("category") String category
			){
        List<Category> categoria = cs.findallCategorias(film);
        //select ordernumber,orderdate,requireddate,status from orders where customernumber = ?1
    //    model.addAttribute("findallCategorias", filmsList);

        return "index.jsp";
    }
*/

}