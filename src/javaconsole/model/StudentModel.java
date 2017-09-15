/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javaconsole.entity.Student;

/**
 *
 * @author chien
 */
public class StudentModel {

    ArrayList<Student> listStudent = new ArrayList<Student>();

    public ArrayList<Student> getlistStudent() {
        try {
            Connection con = DAO.getConnection();
           
            PreparedStatement sta = con.prepareStatement("select * from student");
            ResultSet rs = sta.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getInt("phone"));
                listStudent.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listStudent;
    }

    public void addStudent(Student student) {

        try {
            Connection con = DAO.getConnection();
           
//  
            PreparedStatement ps = con.prepareStatement(" INSERT INTO student (name,email,phone) values (?,?,?)");
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getPhone());

            if (ps.executeUpdate() > 0) {
                System.out.println("->> Insert Succes <<-");
            } else {
                System.out.println("->> Insert Failure <<-");
            }
//          
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateStudent(Student student) {
        try {
            Connection con = DAO.getConnection();
//       
          
            PreparedStatement ps = con.prepareStatement(" UPDATE student Set name=?,email=?,phone=? Where id=?");
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, (int) student.getPhone());
            ps.setInt(4, (int) student.getId());

//           
            if (ps.executeUpdate() > 0) {
                System.out.println("->> Update Succes <<-");
            } else {
                System.out.println("->> Update Failure No Student<<-");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void deleteStudent(Integer id) {
        try {
            Connection con = DAO.getConnection();
//           
            
            PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE id=?");
            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {
                System.out.println("->> Delete Success <<-");
            } else {
                System.out.println("->> Delete Failure NO ID <<-");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}
