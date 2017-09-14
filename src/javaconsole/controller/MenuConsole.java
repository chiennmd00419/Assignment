/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.controller;

import java.util.Scanner;
import javaconsole.filehandle.FileHandle;

/**
 *
 * @author chien
 */
public class MenuConsole {

    public static void main(String[] args) {
        MenuConsole menu = new MenuConsole();
        menu.createMenu();
    }

    public void createMenu() {
        while (true) {
            FileHandle fHandle = new FileHandle();
            System.out.println("===================");
            System.out.println("====Menu Manager===");
            System.out.println("1. Get List");
            System.out.println("2. Edit Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Export Student");
            System.out.println("6. Import Student");
            System.out.println("7. Exit");
            System.out.println("===================");
            System.out.println("Please enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            String strCh = scanner.nextLine();
            int ch = 0;
            try {
                ch = Integer.parseInt(strCh);
            } catch (java.lang.NumberFormatException e) {
                System.out.println(e.getMessage());
                System.err.println("->> Please enter a number <<-");
                continue;
            }
            StudentController studentController = new StudentController();
            if (ch == 7) {
                break;
            } else {
                switch (ch) {
                    case 1:
                        System.out.println("->> List Student <<-");
                        studentController.getlist();
                        break;
                    case 2:
                        System.out.println("->> Add Student <<-");
                        studentController.add();
                        break;
                    case 3:
                        System.out.println("->> Update Student <<-");
                        studentController.upDate();
                        break;
                    case 4:
                        System.out.println("->> Detela Student <<-");
                        studentController.delete();
                        break;
                    case 5:
                        System.out.println("->> Export Student <<-");
                        fHandle.exportStudent();
                        break;
                    case 6:
                        System.out.println("->> Import Student <<-");
                        fHandle.importStudent();
                        break;
                    case 7:
                        System.out.println("->> Exit succees <<-");

                    default:
                        System.out.println("->> Please enter number from 1 to 7 <<-");
                        break;

                }

            }
        }
    }
}
