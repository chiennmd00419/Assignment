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
            if (con != null) {
                System.out.println("->> Connect Success <<-");
            } else {
                System.out.println("->> Connect Failure <<-");
            }
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
            if (con != null) {
                System.out.println("->> Connect Success <<-");
            } else {
                System.out.println("->> Connect Failure <<-");
            }
//   Statement sta = con.createStatement();
            PreparedStatement ps = con.prepareStatement(" INSERT INTO student (name,email,phone) values (?,?,?)");
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getPhone());

            if (ps.executeUpdate() > 0) {
                System.out.println("->> Insert Succes <<-");
            } else {
                System.out.println("->> Insert Failure <<-");
            }
//           StringBuilder sb = new StringBuilder();
//            sb.append(" insert into");
//            sb.append(" student");
//            sb.append(" (name, email, phone)");
//            sb.append(" values");
//            sb.append(" ('");
//            sb.append(student.getName());
//            sb.append(" ', '");
//            sb.append(student.getEmail());
//            sb.append(" ',");
//            sb.append(student.getPhone());
//            sb.append(" )");
//            sta.execute(sb.toString());

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateStudent(Student student) {
        try {
            Connection con = DAO.getConnection();
//       Statement sta = con.createStatement();
            if (con != null) {
                System.out.println("->> Connect Success <<-");
            } else {
                System.out.println("->> Connect Failure <<-");
            }
            PreparedStatement ps = con.prepareStatement(" UPDATE student Set name=?,email=?,phone=? Where id=?");
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, (int) student.getPhone());
            ps.setInt(4, (int) student.getId());

//            StringBuilder sb = new StringBuilder();
//            sb.append(" Update");
//            sb.append(" student");
//            sb.append(" Set");
//
//            sb.append(" name");
//            sb.append(" = ");
//            sb.append(" '");
//            sb.append(student.getName());
//            
//            sb.append(" ',");
//            sb.append("email");
//            sb.append(" = ");
//            sb.append(" '");
//            sb.append(student.getEmail());
//            sb.append(" ',");
//            
//            sb.append("phone");
//            sb.append(" = ");
//            
//            sb.append(student.getPhone());
//            
//            sb.append("where");
//            sb.append(" name = ");
//            sb.append("'" + student.getName() + "'");
//            sta.execute(sb.toString());
            if (ps.executeUpdate() > 0) {
                System.out.println("->> Update Succes <<-");
            } else {
                System.out.println("->> Update Failure <<-");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void deleteStudent(Integer id) {
        try {
            Connection con = DAO.getConnection();
//           Statement sta = con.createStatement();
            if (con != null) {
                System.out.println("->> Connect Success <<-");
            } else {
                System.out.println("->> Connect Failure <<-");
            }
            PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE id=?");
            ps.setInt(1, id);

//            StringBuilder sb = new StringBuilder();
//            sb.append(" DELETE FROM");
//            sb.append(" student");
//            sb.append(" wHERE");
//
//            sb.append(" id");
//            sb.append(" = ");
//            sb.append(" '");
//            sb.append(student.getName());
//            sb.append(" ',");
//            sta.execute(sb.toString());
            if (ps.executeUpdate() > 0) {
                System.out.println("->> Delete Success <<-");
            } else {
                System.out.println("->> Delete Failure <<-");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

//    public static void main() {
//        StudentModel stuModel=new StudentModel();
//        Student stu=new Student();
//        
//        stuModel.addStudent(stu);
//    }
}
