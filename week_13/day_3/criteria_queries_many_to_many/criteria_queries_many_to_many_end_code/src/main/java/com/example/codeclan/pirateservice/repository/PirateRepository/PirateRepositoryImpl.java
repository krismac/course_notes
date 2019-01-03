package com.example.codeclan.pirateservice.repository.PirateRepository;

import com.example.codeclan.pirateservice.models.Pirate;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class PirateRepositoryImpl implements PirateRepositoryCustom{

    @Autowired
    EntityManager entityManager;

    // TODO: find all pirates over a certain age
    @Transactional
    public List<Pirate> findAllPiratesOverAge(int age){
        List<Pirate> results = null;
        Session session = entityManager.unwrap(Session.class);

        Criteria cr = session.createCriteria(Pirate.class);

        cr.add(Restrictions.gt("age", age));

        results = cr.list();

        return results;
    }

    // TODO: Write a query to get pirates part of raids with given loot
    @Transactional
    public List<Pirate> getAllPiratesFromRaidWithLoot(int loot){
        List<Pirate> results = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Pirate.class);

        // similar to for raid in raids
        cr.createAlias("raids", "raid");
        cr.add(Restrictions.eq("raid.loot", loot));

        results = cr.list();


        return results;
    }
}
