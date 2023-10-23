package com.example.a23_09_jee;

import com.example.a23_09_jee.beans.StudentBean;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller //Site web -> Ca retourne le nom du fichier HTML
public class MyController {

    /* -------------------------------- */
    // Formulaire
    /* -------------------------------- */
    //http://localhost:8080/form
    @GetMapping("/form") //Affiche le formulaire
    public String form(StudentBean studentBean) {
        System.out.println("/form studentBean=" + studentBean);
        studentBean.setNote(5);
        return "studentForm";  //Lance studentForm.html
    }

    @PostMapping("/formSubmit") //traite le formulaire
    public String formSubmit(StudentBean studentBean, RedirectAttributes redirectAttributes) {
        System.out.println("/formSubmit : " + studentBean.getName() + " " + studentBean.getNote());

        try {

            if(studentBean.getName() == null ||studentBean.getName().isBlank()){
                throw new Exception("Il faut un nom");
            }

            //Traitement du formulaire
            //Afin d'éviter la duplication de code, redirige sur la page qui s'occupe de l'affichage
            redirectAttributes.addFlashAttribute("student", studentBean);

            return "redirect:formResult";
        }
        catch(Exception e){
            e.printStackTrace();

            redirectAttributes.addFlashAttribute("errorMessage", "Une erreur est survenue : " + e.getMessage());

            return "redirect:form";
        }
    }

    @GetMapping("/formResult") //Affiche la page résultat
    public String formResult() {

        return "studentFormResult";  //Lance studentFormResult.html
    }

    /* -------------------------------- */
    // exo
    /* -------------------------------- */

    //http://localhost:8080/hello
    @GetMapping("/hello")
    public String testHello(Model model, HttpSession session){
        System.out.println("/hello sessionId=" + session.getId());
        //Nom du fichier HTML que l'on souhaite afficher
        ArrayList<StudentBean> liststudent = new ArrayList<>();
        liststudent.add(new StudentBean("Toto", 12));
        liststudent.add(new StudentBean("Tata", 14));



        model.addAttribute("texte", "Bonjour");
        model.addAttribute("studentBean", new StudentBean("Toto", 12));
        model.addAttribute("studentList", liststudent);

        return "welcome";
    }

    //http://localhost:8080/add?name=toto&note=5
    @GetMapping("/add")
    public String add(Model model, String name, Integer note){
        System.out.println("/add name=" + name + " note=" + note);

        StudentBean studentBean = new StudentBean(name, note);
        StudentRepository.save(studentBean);

        model.addAttribute("texte", "Ajout de");
        model.addAttribute("studentBean", studentBean);
        model.addAttribute("studentList", StudentRepository.load());

        return "welcome";
    }
}
