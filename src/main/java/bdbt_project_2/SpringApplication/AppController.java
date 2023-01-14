package bdbt_project_2.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

        registry.addViewController("/view_club").setViewName("view_club");
        registry.addViewController("/new_club").setViewName("new_club");
        registry.addViewController("/edit_club").setViewName("edit_club");

        registry.addViewController("/view_adres").setViewName("view_adres");
        registry.addViewController("/new_adres").setViewName("new_adres");
        registry.addViewController("/edit_adres").setViewName("edit_adres");

        registry.addViewController("/view_poczta").setViewName("view_poczta");
        registry.addViewController("/new_poczta").setViewName("new_poczta");
        registry.addViewController("/edit_poczta").setViewName("edit_poczta");
    }

    @Controller
    public static class DashboardController {

        @RequestMapping
                ("/main"
                )
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMIN")) {
                return "redirect:/main_admin";
            } else if
            (request.isUserInRole
                            ("USER")) {
                return "redirect:/main_user";
            } else {
                return "redirect:/index";
            }
        }


        @RequestMapping(value = {"/main_admin"})
        public String showAdminPage(Model model) {
            return "admin/main_admin";
        }

        @RequestMapping(value = {"/main_user"})
        public String showUserPage(Model model) {
            return "user/main_user";
        }


        // KLUB!!!
        @Autowired
        private KlubDAO dao_klub;


        @RequestMapping(value = {"/view_club"}, method = RequestMethod.GET)
        public String viewHomePage(Model model) {
            List<Klub> listKlub = dao_klub.list();
            model.addAttribute("listKlub", listKlub);
            return "view_club";
        }


        @RequestMapping("/new_club")
        public String showNewForm(Model model) {
            Klub klub = new Klub();
            model.addAttribute("klub", klub);
            return "new_club";
        }

        @RequestMapping(value = "/save_club", method = RequestMethod.POST)
        public String save(@ModelAttribute("klub") Klub klub) {
            dao_klub.save(klub);

            return "redirect:/view_club";
        }

        @RequestMapping("/edit_club/{ID_klubu}")
        public ModelAndView showEditForm(@PathVariable(name = "ID_klubu") int ID_klubu) {
            ModelAndView mav = new ModelAndView("/edit_club");
            Klub klub = dao_klub.get(ID_klubu);
            mav.addObject("klub", klub);
            return mav;
        }

        @RequestMapping(value = "/update_club", method = RequestMethod.POST)
        public String update(@ModelAttribute("klub") Klub klub) {
            dao_klub.update(klub);
            return "redirect:/view_club";
        }

        @RequestMapping("/delete_club/{ID_klubu}")
        public String delete_klub(@PathVariable(name = "ID_klubu") int ID_klubu) {
            dao_klub.delete(ID_klubu);
            return "redirect:/view_club";
        }


        // ADRES!!!
        @Autowired
        private AdresDAO dao_adres;

        @RequestMapping("/view_adres")
        public String viewHomePage_adres(Model model){
            List<Adres> listAdres = dao_adres.list();
            model.addAttribute("listAdres", listAdres);
            return "view_adres";
    }

        @RequestMapping("/new_adres")
        public String showNewForm_adres(Model model){
            Adres adres = new Adres();
            model.addAttribute("adres", adres);
            return "new_adres";
        }

        @RequestMapping(value = "/save_adres", method = RequestMethod.POST)
        public String save_adres(@ModelAttribute("adres") Adres adres) {
            dao_adres.save(adres);

            return "redirect:/view_adres";
        }

        @RequestMapping("/edit_adres/{ID_adresu}")
        public ModelAndView showEditForm_adres(@PathVariable(name = "ID_adresu") int ID_adresu) {
            ModelAndView mav = new ModelAndView("edit_adres");
            Adres adres = dao_adres.get(ID_adresu);
            mav.addObject("adres", adres);
            return mav;
        }


        @RequestMapping(value = "/update_adres", method = RequestMethod.POST)
        public String update_adres(@ModelAttribute("adres") Adres adres) {
            dao_adres.update(adres);
            return "redirect:/view_adres";
        }

        @RequestMapping("/delete_adres/{ID_adresu}")
        public String delete_adres(@PathVariable(name = "ID_adresu") int ID_adresu) {
            dao_adres.delete(ID_adresu);
            return "redirect:/view_adres";
        }


        //POCZTA!!!
        @Autowired
        private PocztaDAO dao_poczta;

        @RequestMapping("/view_poczta")
        public String viewHomePage_poczta(Model model){
            List<Poczta> listPoczta = dao_poczta.list();
            model.addAttribute("listPoczta", listPoczta);
            return "view_poczta";
        }


        @RequestMapping("/new_poczta")
        public String showNewForm_poczta(Model model){
            Poczta poczta = new Poczta();
            model.addAttribute("poczta", poczta);
            return "new_poczta";
        }
        @RequestMapping(value = "/save_poczta", method = RequestMethod.POST)
        public String save_poczta(@ModelAttribute("poczta") Poczta poczta) {
            dao_poczta.save(poczta);

            return "redirect:/view_poczta";
        }


        @RequestMapping("/edit_poczta/{ID_poczty}")
        public ModelAndView showEditForm_poczta(@PathVariable(name = "ID_poczty") int ID_poczty) {
            ModelAndView mav = new ModelAndView("/edit_poczta");
            Poczta poczta = dao_poczta.get(ID_poczty);
            mav.addObject("poczta", poczta);
            return mav;
        }

        @RequestMapping(value = "/update_poczta", method = RequestMethod.POST)
        public String update_poczta(@ModelAttribute("poczta") Poczta poczta) {
            dao_poczta.update(poczta);
            return "redirect:/view_poczta";
        }

        @RequestMapping("/delete_poczta/{ID_poczty}")
        public String delete_poczta(@PathVariable(name = "ID_poczty") int ID_poczty) {
            dao_poczta.delete(ID_poczty);
            return "redirect:/view_poczta";
        }
    }
}


