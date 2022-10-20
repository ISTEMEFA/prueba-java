package com.example.pruebajava.controller;

import com.example.pruebajava.models.Actor;
import com.example.pruebajava.models.Category;
import com.example.pruebajava.models.FilmCategory;
import com.example.pruebajava.models.Films;
import com.example.pruebajava.services.ActorServices;
import com.example.pruebajava.services.CategoryService;
import com.example.pruebajava.services.FilmCategoryService;
import com.example.pruebajava.services.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resources;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    ActorServices ac;
    @Autowired
    CategoryService cs;
    @Autowired
    FilmsService fs;

    @Autowired
    FilmCategoryService fc;

    @RequestMapping("/")
    public String index(Model model) {



        model.addAttribute("categoryList", cs.findAll());
        List<Category> categoryList = cs.findAll();
        model.addAttribute("filmCategory", fc.findAll());
        List<FilmCategory> filmcategory = fc.findAll();


    return "index.jsp";
    }

    @RequestMapping("/seach")
    public String search(Model model,@Param("film") String films,
                         @Param("category") String category, RedirectAttributes redirectAttributes
			) {
        if (category.equals("0") && (films.isBlank())) {
            redirectAttributes.addFlashAttribute("Error", "datos ingresados errorenos");
            return "error.jsp";
        } else if (!category.equals("0") && (films.isBlank())) {
            Integer idCategoria = Integer.parseInt(category);
            List<FilmCategory> lista = fc.findFilmCategoryById(idCategoria);
            model.addAttribute("lista", lista);
            List<Category> categories = cs.findAll();
            model.addAttribute("category", categories);
            return "index.jsp";
        } else if (!category.equals("0") && (films.isBlank())) {
            String filmUpper = films.toUpperCase();
            List<Films> film=fs.findFilmBytitle(filmUpper);
            List<FilmCategory> Lista = new ArrayList<>();
            FilmCategory filmCategory=new FilmCategory();
            for(int i=0;i<film.size();i++) {
                filmCategory=(FilmCategory) fc.findbyId(film.get(i).getFilm_id());
                Lista.add(filmCategory);
            }
            List<Category> categories=cs.findAll();
            model.addAttribute("category",categories);
            model.addAttribute("lista", Lista);
            return "Index.jsp";
        }else if(!category.equals("0") && (!films.isBlank())) {
            String filmUpper=films.toUpperCase();
            Integer idCategoria=Integer.parseInt(category);
            List<Films> film=fs.findFilmBytitle(filmUpper);
            List<FilmCategory>Lista = new ArrayList<>();
            FilmCategory filmCategory=new FilmCategory();

            for(int i=0;i<film.size();i++) {
                filmCategory=fc.findbyIdAndCategory(idCategoria,film.get(i).getFilm_id());
                if(filmCategory!=null) {
                    Lista.add(filmCategory);
                }
            }
            if(!Lista.isEmpty()) {
                List<Category> categories=cs.findAll();
                model.addAttribute("categories",categories);
                model.addAttribute("lista", Lista);
                return "Index.jsp";
            }else {
                redirectAttributes.addFlashAttribute("Error", "Película no encontrada");
                return "redirect:/";
            }

        }
        return null;
    }


}


