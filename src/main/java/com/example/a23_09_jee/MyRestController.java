package com.example.a23_09_jee;

import com.example.a23_09_jee.beans.StudentBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyRestController {

    /* -------------------------------- */
    // GET
    /* -------------------------------- */

    //http://localhost:8080/test
    @GetMapping("/test")
    public String testMethode() {
        System.out.println("/test");

        return "helloWorld";
    }

    //http://localhost:8080/getStudent
    @GetMapping("/getStudent")
    public StudentBean getStudent() {
        System.out.println("/getStudent");

        StudentBean studentBean = new StudentBean("toto", 12);
        return studentBean;
    }

    //http://localhost:8080/createStudent?nom=bob&note=12
    @GetMapping("/createStudent")
    public StudentBean createStudent(@RequestParam(value = "nom", defaultValue = "") String p1, int note) {
        //p1 contiendra bob
        //note contiendra 12
        System.out.println("/createStudent : p1=" + p1 + " note=" + note);

        return new StudentBean(p1, note);
    }

    //http://localhost:8080/max?p1=5&p2=6
    @GetMapping("/max")
    public Integer max(String p1, String p2) {
        //p1 contiendra bob
        //note contiendra 12
        System.out.println("/max : p1=" + p1 + " p2=" + p2);

        Integer parsep1 = null;
        Integer parsep2 = null;

        try {
            parsep1 = Integer.parseInt(p1);
        } catch (Exception e) {

        }

        try {
            parsep2 = Integer.parseInt(p2);
        } catch (Exception e) {

        }

        if (parsep1 == null) {
            return parsep2;
        } else if (parsep2 == null) {
            return parsep1;
        }


        return Math.max(parsep1, parsep2);
    }

    /* -------------------------------- */
    // POST
    /* -------------------------------- */

    //http://localhost:8080/receiveStudent
    //Json Attendu : {"name": "toto", "note": 12}
    @PostMapping("/receiveStudent")
    public void receiveStudent(@RequestBody StudentBean student) {
        System.out.println("/receiveStudent : " + student.getName() + " : " + student.getNote());

        //traitement, mettre en base…
        //Retourner d'autres données

    }

    //http://localhost:8080/increment
    //Json Attendu : {"name": "toto", "note": 12}
    @PostMapping("/increment")
    public StudentBean increment(@RequestBody StudentBean student) {
        System.out.println("/increment : " + student.getName() + " : " + student.getNote());

        //traitement, mettre en base…
        student.setNote(student.getNote() + 1);
        student.increment();
        //Retourner d'autres données
        return student;
    }
}
