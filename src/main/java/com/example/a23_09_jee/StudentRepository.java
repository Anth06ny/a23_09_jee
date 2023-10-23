package com.example.a23_09_jee;

import com.example.a23_09_jee.beans.StudentBean;

import java.util.ArrayList;

public class StudentRepository {

    private static final ArrayList<StudentBean> list = new ArrayList<>();

//Static permet d'effectuer des actions au démarrage de l'application
//  Si besoin d'un jeu de donnée
//  static {
//        list.add(new StudentBean("toto", 12));
//        list.add(new StudentBean("toto", 18));
//        list.add(new StudentBean("tata", 12));
//        list.add(new StudentBean("tata", 14));
//   }

    //Sauvegarde un étudiant
    public static void save(StudentBean student) {
        list.add(student);
    }

    //Retourne la liste des étudiants
    public static ArrayList<StudentBean> load() {
        return list;
    }
}