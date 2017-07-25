import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Created by narahara on 7/25/2017.
 */
public class ManageVehicle {
    private static SessionFactory factory;

    public static void main(String args[]) {

        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        ManageVehicle mv = new ManageVehicle();
        Insurance ins1 = mv.addInsurance( 27658718, "bajaj");
        Insurance ins2 = mv.addInsurance(89920020, "wxyz");
        Vehicle v1 = mv.addVehicle( "str1", "benz", ins1);
        Vehicle v2 = mv.addVehicle("str2", "audi", ins2);
    }

    public Insurance addInsurance(double amount, String company) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer insid = null;
        Insurance insurance = null;
        try {
            tx = session.beginTransaction();
            insurance = new Insurance(amount, company);
            session.save(insurance);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null)
                tx.rollback();
            he.printStackTrace();
        } finally {
            session.close();
        }
        return insurance;
    }

    public Vehicle addVehicle(String vregno, String vmodel, Insurance insurance) {
        Session session = factory.openSession();
        Transaction tx = null;
        Vehicle vehicle = null;
        try {
            tx = session.beginTransaction();
            vehicle = new Vehicle(vregno, vmodel, insurance);
            session.save(vehicle);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null)
                tx.rollback();
            he.printStackTrace();
        } finally {
            session.close();
        }
        return vehicle;
    }

    public void listVehicles() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List vehicles=session.createQuery("FROM Vehicle").list();
            for(Iterator iterator=vehicles.iterator();iterator.hasNext();){
                Vehicle vehicle=(Vehicle)iterator.next();
                System.out.print("vid: " + vehicle.getVid());
                System.out.print("vregno: " + vehicle.getVregno());
                System.out.print("vmodel: " + vehicle.getVmodel());
               Insurance ins = vehicle.getInsurance();
                System.out.println("Insurance ");
                System.out.println("\tIID: " +  ins.getIid());
                System.out.println("\t:AMOUNT" +  ins.getAmount());
                System.out.println("\tCompany: " +  ins.getCompany());
            }
            tx.commit();

        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

    }
    public void updateEmployee(Integer vehicleID, String vmodel ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Vehicle vehicle =
                    (Vehicle) session.get(Vehicle.class, vehicleID);
            vehicle.setVmodel( vmodel );
            session.update(vehicle);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}