package com.example.codeclan.pirateservice.repository.raids;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class RaidRepositoryImpl implements RaidRepositoryCustom {

    @Autowired
    EntityManager entityManager;


}
