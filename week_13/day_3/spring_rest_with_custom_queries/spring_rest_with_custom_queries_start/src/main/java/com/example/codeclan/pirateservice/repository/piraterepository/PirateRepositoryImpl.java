package com.example.codeclan.pirateservice.repository.piraterepository;

import com.example.codeclan.pirateservice.models.Pirate;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class PirateRepositoryImpl implements PirateRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Pirate> findAllPiratesOver(int age){
        List<Pirate> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr  = session.createCriteria(Pirate.class);
            cr.add(Restrictions.gt("age", age));
            results = cr.list();
        } catch(HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;

    }
}
