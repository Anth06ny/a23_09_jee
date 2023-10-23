package com.example.a23_09_jee;

import com.example.a23_09_jee.beans.StudentBean;
import com.example.a23_09_jee.beans.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    //http://localhost:8080/user/login
    @GetMapping("/login") //Affiche le formulaire
    public String login(UserBean userBean) {
        System.out.println("/login");
        return "login";  //Lance studentForm.html
    }

    @PostMapping("/loginSubmit") //traite le formulaire
    public String loginSubmit(UserBean userBean, RedirectAttributes redirectAttributes) {
        System.out.println("/loginSubmit : " + userBean);

        try {

            if(userBean.getLogin() == null || userBean.getLogin().isBlank()){
                throw new Exception("Il faut un login");
            }

            //Traitement du formulaire
            //Afin d'éviter la duplication de code, redirige sur la page qui s'occupe de l'affichage
            redirectAttributes.addFlashAttribute("userBean", userBean);

            return "redirect:/user/userregister";
        }
        catch(Exception e){
            e.printStackTrace();

            redirectAttributes.addFlashAttribute("errorMessage", "Une erreur est survenue : " + e.getMessage());

            return "redirect:/user/login";
        }
    }

}
