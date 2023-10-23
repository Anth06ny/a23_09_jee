package com.example.a23_09_jee;

import com.example.a23_09_jee.beans.StudentBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller //Site web -> Ca retourne le nom du fichier HTML
public class MyController {

    //http://localhost:8080/hello
    @GetMapping("/hello")
    public String testHello(Model model){
        System.out.println("/hello");
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
