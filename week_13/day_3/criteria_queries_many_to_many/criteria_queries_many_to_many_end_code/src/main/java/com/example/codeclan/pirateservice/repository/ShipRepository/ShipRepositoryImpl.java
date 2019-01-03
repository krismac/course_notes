package com.example.codeclan.pirateservice.repository.ShipRepository;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Ship;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class ShipRepositoryImpl implements ShipRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Pirate> findAllPiratesForShip(Long shipId) {
        // Want to find all the pirates for a ship
        List<Pirate> results = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            // do something IO here
            // SELECT     from pirates
            Criteria cr = session.createCriteria(Pirate.class);
            //                           where ship = ship
            cr.add(Restrictions.eq("ship.id", shipId));
            cr.add(Restrictions.gt("age", 32));
            cr.add(Restrictions.lt("age", 100));
            results = cr.list();
        } catch (HibernateException ex) {
            // if that goes wrong, do this stuff
            ex.printStackTrace();
        } finally {
            // no matter what happens, always do this after!
            session.close();
        }


        return results;
    }
}
