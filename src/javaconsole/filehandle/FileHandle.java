/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.filehandle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javaconsole.entity.Student;
import javaconsole.model.StudentModel;

/**
 *
 * @author chien
 */
public class FileHandle {

    public void exportStudent() {

        StudentModel studentModel = new StudentModel();
        ArrayList<Student> list = studentModel.getlistStudent();
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter("StudentList.txt");
            bw = new BufferedWriter(fw);
            for (Student student : list) {
                bw.write("->>id" + student.getId());
                bw.newLine();
                bw.write("->>name" + student.getName());
                bw.newLine();
                bw.write("->>email" + student.getEmail());
                    bw.newLine();
                bw.write("->>phone" + student.getPhone());
                bw.newLine();
            }
            System.out.println("->> Export list student success <<-");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void importStudent() {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            String srr;
            fr = new FileReader("StudentList.txt");
            br = new BufferedReader(fr);
            while ((srr = br.readLine()) != null) {
                System.out.println(srr);
            }
            System.out.println("->> Import Student success <<-");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
