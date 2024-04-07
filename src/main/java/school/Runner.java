package school;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

import static school.TeacherDAO.addTeacher;
import static school.TeacherDAO.listTeacher;

public class Runner {

    public static void main(String[] args) {


        int selection = 0;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("1 ==> Add teacher \n" +
                    "2 ==> List teacher \n" +
                    "0 ==> For EXIT");
            selection = scan.nextInt();
            scan.nextLine();
            switch (selection){
                case 1 :
                    addTeacher();
                    break;
                case 2 :
                    listTeacher();
                    break;
                case 0:
                    System.out.println("Have a good day!!");
            }

        }while(selection !=0);




    }


}
