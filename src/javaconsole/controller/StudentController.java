package javaconsole.controller;

import java.util.ArrayList;
import java.util.Scanner;
import javaconsole.entity.Student;
import javaconsole.model.StudentModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author chien
 */
public class StudentController {

    StudentModel studenModel = new StudentModel();

    public void getlist() {
        ArrayList<Student> listStudent = studenModel.getlistStudent();
      
        if (listStudent != null) {
            System.out.println(" -This is list student-");
            for (Student stu : listStudent) {
                System.out.println("->ID :" + stu.getId()
                        + "\n + Name : " + stu.getName()
                        + "\n + Email : " + stu.getEmail()
                        + "\n + Phone : " + stu.getPhone()
                );
            }
        } else {
            System.out.println("----No Student----");
        }
    }

    public void add() {
        Scanner sn = new Scanner(System.in);
        System.out.println("-Student Information :");
        System.out.println("+ Enter Full Name : ");
        String name = sn.nextLine();
        System.out.println("+ Enter Email : ");
        String email = sn.nextLine();
        System.out.println("+ Enter Phone : ");
        String phone = sn.nextLine();

        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setPhone(1);
        studenModel.addStudent(student);
    }

    public void upDate() {
        while (true) {
            System.out.println("->> Update Student <<-");
            System.out.println("->> Enter ID Student :");
            Scanner sc = new Scanner(System.in);
            String strSearch = sc.nextLine();
            int search = 0;
            try {
                search = Integer.parseInt(strSearch);
            } catch (Exception e) {
                System.out.println("->> Please Enter Number :");
                continue;
            }
            System.out.println("+ Rewrite your name: ");
            String name = sc.nextLine();
            System.out.println("+ Rewrite your email: ");
            String email = sc.nextLine();
            System.out.println("+ Rewrite your phone: ");
            String phone = sc.nextLine();

            int y = 0;
            try {

                y = Integer.parseInt(phone);
                Student student = new Student();
                student.setId(search);
                student.setName(name);
                student.setEmail(email);
                student.setPhone(y);
                studenModel.updateStudent(student);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e);
                continue;
            }

        }

    }

    public void delete() {
        while (true) {
            System.out.println("->> Detele Student <<-");
            System.out.println("- Please Enter ID Student: ");
            Scanner sc = new Scanner(System.in);
            String strSearch = sc.nextLine();
            int search = 0;
            try {
                search = Integer.parseInt(strSearch);
            } catch (NumberFormatException e) {
                System.out.println("*Please Enter A Number*");
                continue;
            }
            studenModel.deleteStudent(search);
            break;
        }
    }

}
