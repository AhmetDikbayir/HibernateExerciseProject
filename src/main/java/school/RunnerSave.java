package school;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {

    public static void main(String[] args) {

        Teacher teac3 = new Teacher(1003, "Veli", "Can", "Physics");

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Teacher.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(teac3);


        tx.commit();
        session.close();
        sf.close();

    }
}