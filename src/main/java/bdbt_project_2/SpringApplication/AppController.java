package bdbt_project_2.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
public class AppController implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");

        registry.addViewController("/view_club").setViewName("index/view_club");
        registry.addViewController("/new_club").setViewName("new/new_club");
        registry.addViewController("/edit_club").setViewName("edit/edit_club");

        registry.addViewController("/view_adres").setViewName("index/view_adres");
        registry.addViewController("/new_adres").setViewName("new/new_adres");
        registry.addViewController("/edit_adres").setViewName("edit/edit_adres");

        registry.addViewController("/view_poczta").setViewName("index/view_poczta");
        registry.addViewController("/new_poczta").setViewName("new/new_poczta");
        registry.addViewController("/edit_poczta").setViewName("edit/edit_poczta");
    }

    @Controller
    public static class DashboardController
    {
        @RequestMapping
                ("/main"
                )
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if
            (request.isUserInRole
                            ("USER")) {
                return "redirect:/main_user";
            }
            else
            {
                return "redirect:/index";
            }
        }
    }

    @RequestMapping(value={"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }
    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }



    // KLUB!!!
    @Autowired
    private KlubDAO dao_klub;


    @RequestMapping("/view_club")
    public String viewHomePage(Model model){
        List<Klub> listKlub = dao_klub.list();
        model.addAttribute("listKlub", listKlub);
        return "index/view_club";
    }


    @RequestMapping("/new_club")
    public String showNewForm(Model model){
        Klub klub = new Klub();
        model.addAttribute("klub", klub);
        return "new/new_club";
    }

    @RequestMapping(value = "/save_club", method =RequestMethod.POST)
    public String save(@ModelAttribute("klub") Klub klub){
        dao_klub.save(klub);

        return "redirect:index/view_club";
    }

    @RequestMapping("/edit/{ID_klubu}")
    public ModelAndView showEditForm(@PathVariable(name = "ID_klubu") int ID_klubu) {
        ModelAndView mav = new ModelAndView("edit_form");
        Klub klub = dao_klub.get(ID_klubu);
        mav.addObject("klub", klub);
        return mav;
    }

    @RequestMapping(value = "/update_club", method = RequestMethod.POST)
    public String update(@ModelAttribute("klub") Klub klub) {
        dao_klub.update(klub);
        return "redirect:/view_club";
    }

    @RequestMapping("/delete/{ID_klubu}")
    public String delete_klub(@PathVariable(name = "ID_klubu") int ID_klubu) {
        dao_klub.delete(ID_klubu);
        return "redirect:/view_club";
    }








    // ADRES!!!
    @Autowired
    private AdresDAO dao_adres;

//    @RequestMapping("/view_adres")
//    public String viewPage(Model model){
//        List<Adres> listAdres = dao_adres.list();
//        model.addAttribute("listKlub", listAdres);
//        return "index/view_adres";
//    }
//
//    @RequestMapping("/new_adres")
//    public String showForm(Model model){
//        Adres adres = new Adres();
//        model.addAttribute("adres", adres);
//        return "new/new_adres";
//    }

    @RequestMapping(value = "/save_adres", method =RequestMethod.POST)
    public String save(@ModelAttribute("adres") Adres adres){
        dao_adres.save(adres);

        return "redirect:/view_adres";
    }

//    @RequestMapping("/edit/{ID_adresu}")
//    public ModelAndView showEditForm(@PathVariable(name = "ID_adresu") int ID_adresu) {
//        ModelAndView mav = new ModelAndView("edit_form");
//        Adres adres = dao_adres.get(ID_adresu);
//        mav.addObject("adres", adres);
//        return mav;
//    }


    @RequestMapping(value = "/update_adres", method = RequestMethod.POST)
    public String update(@ModelAttribute("adres") Adres adres) {
        dao_adres.update(adres);
        return "redirect:/view_adres";
    }

    @RequestMapping("/delete/{ID_adresu}")
    public String delete_adres(@PathVariable(name = "ID_adresu") int ID_adresu) {
        dao_adres.delete(ID_adresu);
        return "redirect:/view_adres";
    }







    //POCZTA!!!
    @Autowired
    private PocztaDAO dao_poczta;

//    @RequestMapping("/view_club")
//    public String viewPage(Model model){
//        List<Klub> listKlub = dao_klub.list();
//        model.addAttribute("listKlub", listKlub);
//        return "index/view_club";
//    }
//
//
//    @RequestMapping("/new_club")
//    public String showForm(Model model){
//        Klub klub = new Klub();
//        model.addAttribute("klub", klub);
//        return "new/new_club";
//    }
    @RequestMapping(value = "/save_poczta", method =RequestMethod.POST)
    public String save(@ModelAttribute("klub") Poczta poczta){
        dao_poczta.save(poczta);

        return "redirect:/view_poczta";
    }


//    @RequestMapping("/edit/{ID_poczty}")
//    public ModelAndView showEditForm(@PathVariable(name = "ID_poczty") int ID_poczty) {
//        ModelAndView mav = new ModelAndView("/edit_poczta");
//        Poczta poczta = dao_adres.get(ID_poczty);
//        mav.addObject("poczta", poczta);
//        return mav;
//    }

    @RequestMapping(value = "/update_poczta", method = RequestMethod.POST)
    public String update(@ModelAttribute("poczta") Poczta poczta) {
        dao_poczta.update(poczta);
        return "redirect:/view_poczta";
    }

    @RequestMapping("/delete/{ID_poczty}")
    public String delete_poczta(@PathVariable(name = "ID_poczty") int ID_poczty) {
        dao_adres.delete(ID_poczty);
        return "redirect:/view_poczta";
    }
}


