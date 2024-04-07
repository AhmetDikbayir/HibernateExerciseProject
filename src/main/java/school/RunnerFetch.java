package school;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Teacher.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Teacher tc = session.get(Teacher.class, 1002);
        System.out.println(tc);

        String hqlQuery = "FROM Teacher WHERE name = 'Veli'";

        List<Teacher> teacherList = session.createQuery(hqlQuery, Teacher.class).getResultList();
        System.out.println(teacherList);

        tx.commit();
        session.close();
        sf.close();
    }
}