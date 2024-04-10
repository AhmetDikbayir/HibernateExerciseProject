package school;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {

    public static void main(String[] args) {

        Teacher teac3 = new Teacher(1004, "Veli", "Can", "Physics");

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Teacher.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //session.save(teac3);
//        session.delete(teac3);
//        Teacher teacher = session.get(Teacher.class, 1004);
//        session.delete(teacher);
//        Teacher teacherToDelete = new Teacher();
//        teacherToDelete.setId(1001);
//
//        session.delete(teacherToDelete);

        try (Session session1 = sf.openSession()) {
            // Begin transaction for session 1
            Transaction transaction1 = session1.beginTransaction();

            // Load a Teacher object with ID 1004
            Teacher teacher1 = session1.get(Teacher.class, 1004);
            System.out.println("Teacher 1 Name: " + teacher1.getName());

            // Commit transaction for session 1
            transaction1.commit();
        }

        // Open session 2
        try (Session session2 = sf.openSession()) {
            // Begin transaction for session 2
            Transaction transaction2 = session2.beginTransaction();

            // Load the same Teacher object with ID 1004 again
            Teacher teacher2 = session2.get(Teacher.class, 1004);
            System.out.println("Teacher 2 Name: " + teacher2.getLastname());

            // Commit transaction for session 2
            transaction2.commit();
        }


        tx.commit();
        session.close();
        sf.close();

    }
}