package bdbt_project_2.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    @Autowired
    private KlubDAO dao;

    @RequestMapping("/view_club")
    public String viewHomePage(Model model){
        List<Klub> listKlub = dao.list();
        model.addAttribute("listKlub", listKlub);
        return "index/view_club";
    }


    @RequestMapping("/new_club")
    public String showNewForm(Model model){
        Klub klub = new Klub();
        model.addAttribute("klub", klub);
        return "new/new_club";
    }

    @RequestMapping(value = "/save_klub", method =RequestMethod.POST)
    public String save(@ModelAttribute("klub") Klub klub){
        dao.save(klub);

        return "redirect:/view_club";
    }

//    @RequestMapping(value = "/save_adres", method =RequestMethod.POST)
//    public String save(@ModelAttribute("adres") Adres adres){
//        dao.save(adres);
//
//        return "redirect:/view_adres";
//    }
//
//    @RequestMapping(value = "/save_poczta", method =RequestMethod.POST)
//    public String save(@ModelAttribute("klub") Poczta poczta){
//        dao.save(poczta);
//
//        return "redirect:/view_poczta";
//    }
}


