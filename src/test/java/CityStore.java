import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class CityStore {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();

    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    public City create(City city) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(city);
        session.getTransaction().commit();
        session.close();
        return city;
    }

    public List<City> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List<City> result = session.createQuery("from City").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public City replace(City city) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.update(city);
        session.getTransaction().commit();
        session.close();
        return city;
    }

    public void delete(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        City city = new City();
        city.setId(id);
        session.delete(city);
        session.getTransaction().commit();
        session.close();
    }

    public City findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        City city = session.get(City.class, id);
        session.getTransaction().commit();
        session.close();
        return city;
    }

    public List<City> findByName(String name) {
        Session session = sf.openSession();
        session.beginTransaction();
        List<City> list = session.createQuery("from City where name = :name").setParameter("name", name).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }



}