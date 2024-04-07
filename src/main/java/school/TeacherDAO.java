package school;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class TeacherDAO {
    static Scanner scan = new Scanner(System.in);
    static void listTeacher() {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Teacher.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        String hqlQuery = "FROM Teacher";
        List<Teacher> teacherList = session.createQuery(hqlQuery, Teacher.class).getResultList();
        for(Teacher t : teacherList){
            System.out.println(t);
        }
        tx.commit();
        session.close();
        sf.close();
    }

    static void addTeacher() {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Teacher.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("Please enter teacher id :");
        int teacherId = scan.nextInt();
        scan.nextLine();
        System.out.println("Please enter teacher name :");
        String name = scan.nextLine();
        System.out.println("Please enter teacher lastname :");
        String lastname = scan.nextLine();
        System.out.println("Please enter teacher department :");
        String department = scan.nextLine();

        Teacher teacher = new Teacher(teacherId, name,lastname,department);
        session.save(teacher);

        tx.commit();
        session.close();
        sf.close();
    }
}
